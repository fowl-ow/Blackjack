defmodule Blackjack.Server do
  use GenServer

  # Client

  def start_link(port) do
    GenServer.start_link(__MODULE__, port, name: __MODULE__)
  end

  # Server
  
  def init(port) do
    {:ok, socket} =
      :gen_tcp.listen(port, [:binary, packet: :line, active: false, reuseaddr: true])
    {:ok, socket}

    {:ok, client} = :gen_tcp.accept(socket)
    Blackjack.Player.start_link(client)
    {:ok, socket}
  end
end

defmodule Blackjack.PlayerSupervisor do
  use DynamicSupervisor

  def start_link() do
    DynamicSupervisor.start_link(__MODULE__, :ok, name: __MODULE__)
  end

  def init(_arg) do
    children = [
      {DynamicSupervisor, name: __MODULE__, strategy: :one_for_one}
    ]

    Supervisor.start_link(children, strategy: :one_for_one)
  end
end

defmodule Blackjack.Player do
    use GenServer

    # Client

    def start_link(socket) do

    end

    # Server

    def init(socket) do
      {:ok, socket} = :gen_tcp.controlling_process(socket, self())
      {:ok, %{socket: socket}}
    end

    def handle_info({:tcp, socket, data}, state) do
    end

    defp via_tuple(socket) do
      {:via, :gen_server, {__MODULE__, socket}}
    end
end

  # def accept(port) do
  #   {:ok, socket} =
  #     :gen_tcp.listen(port, [:binary, packet: :line, active: false, reuseaddr: true])
  #
  #   loop_acceptor(socket)
  # end
  #
  # defp loop_acceptor(socket) do
  #   {:ok, client} = :gen_tcp.accept(socket)
  #   serve(client)
  #   loop_acceptor(socket)
  # end
  #
  # defp serve(socket) do
  #   socket
  #   |> read_line()
  #   |> write_line(socket)
  #
  #   serve(socket)
  # end
  #
  # defp read_line(socket) do
  #   {:ok, data} = :gen_tcp.recv(socket, 0)
  #   data
  # end
  #
  # defp write_line(data, socket) do
  #   :gen_tcp.send(socket, data)
  # end
