package de.fachinformatik.elias;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        for (Suit s: Suit.values()) {
            for (Rank r: Rank.values()) {
                Card card = new Card(s,r);
                deck.add(card);
            }
        }
    }

    public Deck(boolean shuffle) {
        this();
        if (shuffle) shuffle();
    }

    public Deck(int nrDecks) {
        this();
        addDeck(nrDecks-1);
    }

    public Deck(boolean shuffle, int nrDecks) {
        this();
        addDeck(nrDecks-1);
        if (shuffle) shuffle();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void addDeck(int count) {
        for (int i = 0; i < count; i++) {
            for (Suit s: Suit.values()) {
                for (Rank r : Rank.values()) {
                    Card card = new Card(s, r);
                    deck.add(card);
                }
            }
        }
    }

    public Card draw() {
        if (deck.size() == 0) {
            System.out.println("Deck is empty, taking the card from a new Deck.");
            addDeck(1);
            shuffle();
        }
            Card card = deck.get(0);
            deck.remove(0);
            return card;
    }

    public String[] getDeckAsStringArray() {
        int i = 0;
        String[] returnDeck = new String[deck.size()];
        for (Card c: deck) {
            returnDeck[i] = c.toString();
            i++;
        }
        return returnDeck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void clear() {
        deck.clear();
    }

}