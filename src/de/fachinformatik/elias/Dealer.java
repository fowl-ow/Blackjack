package de.fachinformatik.elias;

public final class Dealer {

    private final String name = "Dealer";
    private Hand hand = new Hand();

    public Dealer() {}

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