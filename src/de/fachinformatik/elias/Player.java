package de.fachinformatik.elias;

import java.util.Locale;

public class Player {

    private final String name;
    private Hand hand = new Hand();

    public Player(String name) {
        this.name = titleCaseName(name);
    }

    public String getName() {
        return name;
    }

    public String titleCaseName(String name) {
        String result = "";
        name = name.toLowerCase(Locale.ROOT);
        String[] tempArr = name.split("");
        tempArr[0] = tempArr[0].toUpperCase(Locale.ROOT);
        for (String s : tempArr) result += s;
        return result;
    }

    public Hand getHand() {
        return hand;
    }

    public void drawCard(Deck deck) {
        hand.addCard(deck.draw());
    }
}