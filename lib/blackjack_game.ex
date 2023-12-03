defmodule Blackjack.Game do
  use GenServer

  # Client side

  def start_link(pid) do
    GenServer.start_link(__MODULE__, pid)
  end

  # Server side

  def init(pid) do
    id = register()
    {:ok, {id, pid}}
  end

  def register() do
    random_hex =
      for _ <- 1..8, do: :rand.uniform(16) |> Integer.to_string(16)

    random_hex = random_hex |> Enum.join("") |> String.upcase()

    case Blackjack.Registry.register_game(self(), random_hex) do
      :ok -> random_hex
      _ -> register()
    end
  end
end
