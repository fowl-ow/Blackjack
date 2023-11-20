defmodule Blackjack.Player do
  use GenServer

  # Client

  def start_link(name) do
    GenServer.start_link(__MODULE__, name)
  end

  # Server (callbacks)

  def init(name) do
    {:ok, %{name: name, connection: nil}}
  end

  def handle_call({:set_connection, connection}, _from, state) do
    {:reply, :ok, %{state | connection: connection}}
  end

  def handle_call(:get_connection, _from, state) do
    {:reply, state.connection, state}
  end

  def handle_call(:get_name, _from, state) do
    {:reply, state.name, state}
  end
end
