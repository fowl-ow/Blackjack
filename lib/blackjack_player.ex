defmodule Blackjack.Player do
  use GenServer

  # Client side

  def start_link(name) do
    GenServer.start_link(__MODULE__, name)
  end

  def start_n_players(n) do
    if n == 0 do
      :ok
    else
      Blackjack.Player.start_link("#{n}")
      start_n_players(n - 1)
    end
  end

  # Server side

  def init(name) do
    case register(name) do
      :ok -> {:ok, name}
      :error -> :error
    end
  end

  def register(name) do
    case Blackjack.Registry.register_player(self(), name) do
      :ok -> :ok
      _ -> :error
    end
  end
end
