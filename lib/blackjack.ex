defmodule Blackjack do
  @moduledoc """
  Documentation for `Blackjack`.
  """

  @doc """
  Hello world.

  ## Examples

      iex> Blackjack.hello()
      :world

  """
  def hello do
    :world
  end
end

defmodule Blackjack.Deck do
  @moduledoc """
  Documentation for `Blackjack.Deck`.
  """

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
