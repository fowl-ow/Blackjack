package de.fachinformatik.elias;

import java.util.ArrayList;

public class Hand {

    private int value;
    private ArrayList<Card> hand = new ArrayList<>();

    public Hand() {}

    public int getValue() {
        return value;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String[] getHandAsStringArray() {
        int i = 0;
        String[] returnHand = new String[hand.size()];
        for (Card c: hand) {
            returnHand[i] = c.toString();
            i++;
        }
        return returnHand;
    }

    public void addCard(Card card) {
        hand.add(card);
        value += card.getValue();
    }

    public void clear() {
        hand.clear();
        value = 0;
    }

}