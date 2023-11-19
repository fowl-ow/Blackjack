defmodule BlackjackTest do
  use ExUnit.Case
  doctest Blackjack

  test "greets the world" do
    assert Blackjack.hello() == :world
  end
end

defmodule BlackjackDeckTest do
  use ExUnit.Case 
  doctest Blackjack.Deck

  def deck(deck, amount) do
    Enum.flat_map(deck, fn card -> List.duplicate(card, amount) end)
  end

  test "creates a deck out of 1 to 99 decks" do
    Enum.each(1..99, fn amount ->
    assert Enum.map(Blackjack.Deck.create_deck(amount), fn card ->
        card in deck(single_deck(), amount) end)
    end)
  end

  def single_deck() do
    [{:spades, 2}, {:spades, 3}, {:spades, 4}, {:spades, 5}, {:spades, 6}, {:spades, 7}, {:spades, 8}, {:spades, 9}, {:spades, 10}, {:spades, 11}, {:spades, 12}, {:spades, 13}, {:spades, 14}, {:hearts, 2}, {:hearts, 3}, {:hearts, 4}, {:hearts, 5}, {:hearts, 6}, {:hearts, 7}, {:hearts, 8}, {:hearts, 9}, {:hearts, 10}, {:hearts, 11}, {:hearts, 12}, {:hearts, 13}, {:hearts, 14}, {:diamonds, 2}, {:diamonds, 3}, {:diamonds, 4}, {:diamonds, 5}, {:diamonds, 6}, {:diamonds, 7}, {:diamonds, 8}, {:diamonds, 9}, {:diamonds, 10}, {:diamonds, 11}, {:diamonds, 12}, {:diamonds, 13}, {:diamonds, 14}, {:clubs, 2}, {:clubs, 3}, {:clubs, 4}, {:clubs, 5}, {:clubs, 6}, {:clubs, 7}, {:clubs, 8}, {:clubs, 9}, {:clubs, 10}, {:clubs, 11}, {:clubs, 12}, {:clubs, 13}, {:clubs, 14}, {:spades, 2}, {:spades, 3}, {:spades, 4}, {:spades, 5}, {:spades, 6}, {:spades, 7}, {:spades, 8}, {:spades, 9}, {:spades, 10}, {:spades, 11}, {:spades, 12}, {:spades, 13}, {:spades, 14}, {:hearts, 2}, {:hearts, 3}, {:hearts, 4}, {:hearts, 5}, {:hearts, 6}, {:hearts, 7}, {:hearts, 8}, {:hearts, 9}, {:hearts, 10}, {:hearts, 11}, {:hearts, 12}, {:hearts, 13}, {:hearts, 14}]
  end
end
