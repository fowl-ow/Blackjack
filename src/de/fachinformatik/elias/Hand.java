package de.fachinformatik.elias;

import java.util.ArrayList;

public class Hand {

    private int value;
    private int nrAces;
    private ArrayList<Card> hand = new ArrayList<>();

    public Hand() {}

    public int getValue() {
        return value;
    }

    public void updateValue() {
        value = 0;
        for (Card c: hand) {
            value =+ c.getValue();
        }
        if (value > 21 && nrAces > 0) {
                value -= 10;
                nrAces--;
        }
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
        if (card.getValue() == 11) nrAces++;
        hand.add(card);
        value += card.getValue();

    }

    public void clear() {
        hand.clear();
        value = 0;
    }
}