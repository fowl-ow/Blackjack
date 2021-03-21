package de.fachinformatik.elias.tests;

import de.fachinformatik.elias.Card;
import de.fachinformatik.elias.Deck;
import de.fachinformatik.elias.Rank;
import de.fachinformatik.elias.Suit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    int nrDecks = 1;

    @Test
    void constructorWorks() {
        Deck deck = new Deck();
        Card card = new Card(Suit.SPADES, Rank.ACE);
        assertEquals(deck.getDeck().size(),52);
        assertEquals(deck.getDeck().get(0).toString(),card.toString());
    }

    @Test
    void addDeckWorks() {
        Deck deck = new Deck();
        deck.addDeck(nrDecks);
        assertEquals(52 + nrDecks * 52, deck.getDeck().size());
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