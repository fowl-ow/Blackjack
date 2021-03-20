package com.company;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        String temp;
        temp = rank.toString();
        temp += " of ";
        temp += suit.toString();
        return temp;
    }
}