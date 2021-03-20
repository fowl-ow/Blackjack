package com.company;

public class Card {

    private Suit suit;
    private Rank rank;
    private int value;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        switch (rank) {
            case ACE -> value = 1;
            case TWO -> value = 2;
            case THREE -> value = 3;
            case FOUR -> value = 4;
            case FIVE -> value = 5;
            case SIX -> value = 6;
            case SEVEN -> value = 7;
            case EIGHT -> value = 8;
            case NINE -> value = 9;
            case TEN, JACK, KING, QUEEN -> value = 10;
        }
    }

    public int getValue() {
        return value;
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