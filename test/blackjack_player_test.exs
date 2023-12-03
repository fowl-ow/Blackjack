defmodule BlackjackPlayerTest do
  use ExUnit.Case
  doctest Blackjack.Player

  setup do
    # {:ok, pid} = Blackjack.Player.start_link("Bob")}
    {:ok, pid: pid}
  end

  test "player has a name", %{pid: pid} do
    assert player.name == "Bob"
  end

  test "player has connection", %{pid: pid} do
    assert player.connection == nil
  end
end
