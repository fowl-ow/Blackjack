defmodule Blackjack.Blackjack do
  use GenServer

  @moduledoc """
  Documentation for `Blackjack.Deck`.
  """

  # Client

  def start_link() do
    GenServer.start_link(__MODULE__, [])
  end

  def draw(pid) do
    GenServer.call(pid, :draw)
  end

  # Server (callbacks)

  @imp true
  def init() do
    {:ok,
     %{
       phase: :dealing,
       deck: [],
       players: [%{name: "dealer", hand: [], won: false}]
     }}
  end

  def handle_call(:start_round, _from, state) do
    if length(state.players) == 1 do
      {:reply, :no_players, state}
    else
      new_state = dealing_phase(state)
      new_state = ace_phase(new_state)
      {:reply, {:ok, new_state}, new_state}
    end
  end

  defp add_player(state, name) do
    Map.put(state, :players, [%{name: name, hand: [], won: false} | state.players])
  end

  defp remove_player(state, name) do
    Map.put(state, :players, Enum.filter(state.players, fn player -> player.name != name end))
  end

  defp dealing_phase(state) do
    if state.phase == :dealing do
      {deck, players} = deal_cards(state.deck, state.players)
      {final_deck, final_players} = deal_cards(deck, players)
      new_state = Map.put(state, :deck, final_deck)
      new_state = Map.put(new_state, :players, final_players)
      new_state = Map.put(new_state, :phase, :ace_phase)
      {:ok, new_state}
    else
      {:error, "Not in dealing phase"}
    end
  end

  defp ace_phase(state) do
  end

  defp twenty_one?(hand) do
    get_hand_value(hand) == 21
  end

  defp get_hand_value(hand) do
    {new_hand, aces} =
      Enum.reduce(hand, {[], 0}, fn card, {current_hand, current_aces} ->
        if card.value == 14 do
          {current_hand, current_aces + 1}
        else
          {List.insert_at(current_hand, -1, card), current_aces}
        end
      end)

    new_hand_value =
      Enum.reduce(new_hand, 0, fn card, curr_val ->
        case card.value do
          11..13 -> curr_val + 10
          _ -> curr_val + card.value
        end
      end)

    calc_aces_val(new_hand_value, aces)
  end

  def calc_aces_val(value, aces) do
    list = for i <- 0..aces, do: i * 11 + (aces - i)

    list
    |> Enum.map(fn x -> x + value end)
    |> Enum.sort(fn x, y -> x < y end)
    |> Enum.reduce(0, fn x, curr_val ->
      if x <= 21 do
        x
      else
        if curr_val == 0 do
          x
        else
          curr_val
        end
      end
    end)
  end

  defp deal_cards(deck, hands) do
    {final_deck, final_hands} =
      Enum.reduce(hands, {deck, []}, fn hand, {current_deck, current_hands} ->
        {new_deck, new_hand} = deal_card(current_deck, hand)
        {new_deck, List.insert_at(current_hands, -1, new_hand)}
      end)
  end

  defp deal_card(deck, hand) do
    {card, new_deck} = draw_card(deck)
    new_hand = Map.put(hand, :hand, [card | hand.hand])
    {new_deck, new_hand}
  end

  defp draw_card(deck) do
    case deck do
      [] ->
        [card | rest] = create_deck(2)
        {card, rest}

      _ ->
        [card | rest] = deck
        {card, rest}
    end
  end

  defp create_deck(amount) do
    cards =
      for suit <- [:spades, :hearts, :diamonds, :clubs],
          value <- 2..14,
          do: {suit, value}

    Enum.shuffle(Enum.take(cards, amount * 52)) |> Enum.drop(1)
  end
end
