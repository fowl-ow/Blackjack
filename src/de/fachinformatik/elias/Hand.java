package de.fachinformatik.elias;

import java.util.ArrayList;

public class Hand {

    //highValue treats one single Ace as 11 (Default Ace=1)
    private int value;
    private int highValue;
    private boolean highEnabled;
    private ArrayList<Card> hand = new ArrayList<>();

    public Hand() {}

    public int getAces() {
        return nrAces;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getValue() {
        return value;
    }

    public int getHighValue() {
        return highValue;
    }

    public void updateValues() {
        value = 0;
        for (Card c: hand) {
            value += c.getValue();
        }
        highValue = value;
        if (highEnabled) highValue += 10;
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
        if (card.getValue() == 1 && !highEnabled) highEnabled = true;
        hand.add(card);
        updateValues();
    }

    public void clear() {
        hand.clear();
        value = 0;
        highValue = 0;
        highEnabled = false;
    }
}