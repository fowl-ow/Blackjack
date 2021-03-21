package de.fachinformatik.elias.tests;

import de.fachinformatik.elias.Card;
import de.fachinformatik.elias.Rank;
import de.fachinformatik.elias.Suit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void constructorWorks() {
        Card card = new Card(Suit.SPADES, Rank.ACE);
        assertEquals(card.getRank(),Rank.ACE);
        assertEquals(card.getSuit(),Suit.SPADES);
        assertEquals(card.getValue(),1);
    }

    @Test
    public void toStringWorks() {
        Card card = new Card(Suit.SPADES,Rank.ACE);
        String actualCardString = card.toString();
        String testString = Rank.ACE.toString() + " of " + Suit.SPADES.toString();
        assertEquals(actualCardString,testString);
    }
}