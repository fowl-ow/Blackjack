defmodule Blackjack.Deck do
  use GenServer
  @moduledoc """
  Documentation for `Blackjack.Deck`.
  """


  # Client

  def start_link(amount) when is_integer(amount) do
    GenServer.start_link(__MODULE__, amount)
  end

  def draw(pid, deck) do
    GenServer.call(pid, {:draw, deck})
  end

  # Server (callbacks)

  @imp true
  def init(amount) do
    {:ok, create_deck(amount)}
  end

  @imp true
  def handle_call(:draw, _from, deck) do
    [ card | rest ] = deck
    {:reply, card, rest}
  end

  @doc """
  Creates a deck of cards.

  ## Examples

      iex> Blackjack.Deck.create_deck(1)

  """
  def create_deck(amount) do
    cards = for suit <- [:spades, :hearts, :diamonds, :clubs],
      value <- 2..14,
      do: {suit, value}
    Enum.shuffle(Enum.take(cards, amount * 52))
  end
end
