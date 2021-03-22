package de.fachinformatik.elias;

import java.util.Locale;

public class Player {

    private final String name;
    private final Hand hand = new Hand();

    public Player(String name) {
        this.name = titleCaseName(name);
    }

    public String titleCaseName(String name) {
        String result = "";
        name = name.toLowerCase(Locale.ROOT);
        String[] tempArr = name.split("");
        tempArr[0] = tempArr[0].toUpperCase(Locale.ROOT);
        for (String s : tempArr) result += s;
        return result;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public Card getLastDrawn() {
        return hand.getHand().get(hand.getHand().size()-1);
    }

    public int getValue() {
        if (hand.getHighEnabled() && hand.getHighValue() <= 21 ) {
            return hand.getHighValue();
        } else return hand.getValue();
    }

    public void drawCard(Deck deck) {
        hand.addCard(deck.draw());
    }

    public void clearHand() {
        hand.clear();
    }
}