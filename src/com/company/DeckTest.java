package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    int nrDecks = 1;

    @Test
    void constructorWorks() {
        Deck deck = new Deck();
        Card card = new Card(Suit.SPADES,Rank.ACE);
        assertEquals(deck.getDeck().size(),52);
        assertEquals(deck.getDeck().get(0).toString(),card.toString());
    }

    @Test
    void addDeckWorks() {
        Deck deck = new Deck();
        deck.addDeck(nrDecks);
        assertTrue(deck.getDeck().size()==52+nrDecks*52);
    }

    @Test
    void drawWorks() {
        Deck deck = new Deck();
        Card card1 = deck.getDeck().get(0);
        Card card2 = deck.draw();
        assertEquals(card1.toString(),card2.toString());
        assertEquals(deck.getDeck().size(),51);


    }

    @Test
    void getDeckAsStringArrayWorks() {
        Deck deck = new Deck();
        String[] deckArray = deck.getDeckAsStringArray();
        assertEquals(deckArray.length,52);
    }
}