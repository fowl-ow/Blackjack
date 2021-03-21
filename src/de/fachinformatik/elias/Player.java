package de.fachinformatik.elias;

public class Player {

    private final String name;
    private Hand hand = new Hand();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void drawCard(Deck deck) {
        hand.addCard(deck.draw());
    }
}