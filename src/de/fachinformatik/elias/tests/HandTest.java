package de.fachinformatik.elias.tests;

import de.fachinformatik.elias.Card;
import de.fachinformatik.elias.Hand;
import de.fachinformatik.elias.Rank;
import de.fachinformatik.elias.Suit;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    @Test
    void constructorWorks() {
        Hand hand = new Hand();
        assertTrue(hand.getHand().isEmpty());
        assertFalse(hand.getHighEnabled());
    }

    @Test
    void addCardWorksWithAce() {
        Hand hand = new Hand();
        Card card = new Card(Suit.SPADES, Rank.ACE);
        hand.addCard(card);
        assertEquals(Arrays.toString(hand.getHandAsStringArray()),"["+card.toString()+"]");
        assertTrue(hand.getHighEnabled());

    }

    @Test
    void addCardWorks() {
        Hand hand = new Hand();
        Card card = new Card(Suit.SPADES, Rank.TEN);
        hand.addCard(card);
        assertEquals(Arrays.toString(hand.getHandAsStringArray()),"["+card.toString()+"]");
    }

    @Test
    void updateValuesWorks() {
        Hand hand = new Hand();
        Card card = new Card(Suit.SPADES,Rank.TEN);
        hand.addCard(card);
        assertEquals(10,hand.getValue());
        assertEquals(10,hand.getHighValue());
    }

    @Test
    void updateValuesWorksWithAce() {
        Hand hand = new Hand();
        Card card = new Card(Suit.SPADES,Rank.ACE);
        hand.addCard(card);
        assertEquals(1,hand.getValue());
        assertEquals(11,hand.getHighValue());
    }

    @Test
    void clearWorks() {
        Hand hand = new Hand();
        Card card = new Card(Suit.SPADES,Rank.ACE);
        hand.addCard(card);
        assertEquals(card,hand.getHand().get(0));
        hand.clear();
        assertTrue(hand.getHand().isEmpty());
    }
}