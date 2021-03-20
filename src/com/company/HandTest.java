package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    @Test
    void constructorWorks() {
        Hand hand = new Hand();
        assertTrue(hand.getHand().isEmpty());
    }

    @Test
    void addCardWorks() {
        Hand hand = new Hand();
        Card card = new Card(Suit.SPADES,Rank.ACE);
        hand.addCard(card);
        assertEquals(Arrays.toString(hand.getHandAsStringArray()),"["+card.toString()+"]");
    }

    @Test
    void clearWorks() {
        Hand hand = new Hand();
        Card card = new Card(Suit.SPADES,Rank.ACE);
        hand.addCard(card);
        hand.clear();
        assertTrue(hand.getHand().isEmpty());
    }

}