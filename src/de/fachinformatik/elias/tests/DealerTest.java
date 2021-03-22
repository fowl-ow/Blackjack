package de.fachinformatik.elias.tests;

import de.fachinformatik.elias.Dealer;
import de.fachinformatik.elias.Deck;
import de.fachinformatik.elias.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealerTest {



    @Test
    void drawCardWorks() {
        Dealer dealer = new Dealer();
        Deck deck = new Deck();
        dealer.drawCard(deck);
        assertEquals(deck.getDeck().size(), 51);
        assertEquals(dealer.getHand().getHand().size(), 1);
    }
}