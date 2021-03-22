package de.fachinformatik.elias;

public final class Dealer {

    private final String name = "Dealer";
    private final Hand hand = new Hand();

    public Dealer() {}

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int getValue() {
        if (hand.getHighEnabled() && hand.getHighValue() <= 21 ) {
            return hand.getHighValue();
        } else return hand.getValue();
    }

    public Card getLastDrawn() {
        return hand.getHand().get(hand.getHand().size()-1);
    }
    public void drawCard(Deck deck) {
        hand.addCard(deck.draw());
    }

    public void clearHand() {
        hand.clear();
    }
}