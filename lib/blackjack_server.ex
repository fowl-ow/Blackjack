defmodule Blackjack.Server do
  use GenServer

  # Client

  def start_link() do
    GenServer.start_link(__MODULE__, 4040, name: __MODULE__)
  end

  # Server

  def init(port) do
    {:ok, socket} =
      :gen_tcp.listen(port, [:binary, packet: :line, active: false, reuseaddr: true])

    loop_acceptor(socket)
    {:ok, socket}
  end

  defp loop_acceptor(socket) do
    {:ok, client} = :gen_tcp.accept(socket)
    {:ok, pid} = Blackjack.Client.start_link(client)
    :ok = :gen_tcp.controlling_process(client, pid)
    GenServer.cast(pid, {:start, client})
    loop_acceptor(socket)
  end
end
