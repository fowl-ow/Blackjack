defmodule Blackjack.Client do
  use GenServer

  # Client

  def start_link(socket) do
    GenServer.start_link(__MODULE__, socket)
  end

  # Server

  def init(socket) do
    {:ok} = GenServer.call(Blackjack.Server, {:set_owner, socket, self()})
    {:ok, []}
  end

  def handle_info({:tcp, socket, data}, state) do
    state = [data | state]
    :gen_tcp.send(socket, state)
    {:ok, state}
  end
end
