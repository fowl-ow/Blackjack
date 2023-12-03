defmodule Blackjack.Registry do
  use GenServer

  # Client side

  def start_link do
    GenServer.start_link(__MODULE__, %{}, name: __MODULE__)
  end

  def register_player(pid, name) do
    GenServer.call(__MODULE__, {:register_player, pid, name})
  end

  def register_game(pid, id) do
    GenServer.call(__MODULE__, {:register_game, pid, id})
  end

  def get() do
    GenServer.call(__MODULE__, :get)
  end

  # Server side

  def init(_opts) do
    {:ok, %{games: %{}, players: %{}}}
  end

  def handle_call({:register_player, pid, name}, _from, state) do
    if Map.has_key?(state.players, name) do
      {:reply, :error, state}
    else
      new_state = Map.put(state, :players, Map.put(state.players, name, pid))
      {:reply, :ok, new_state}
    end
  end

  def handle_call({:register_game, pid, id}, _from, state) do
    if Map.has_key?(state.games, id) do
      {:reply, :error, state}
    else
      new_state = Map.put(state, :games, Map.put(state.games, id, pid))
      {:reply, :ok, new_state}
    end
  end

  def handle_call(:get, _from, state) do
    {:reply, state, state}
  end
end
