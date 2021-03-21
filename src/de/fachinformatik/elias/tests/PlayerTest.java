package de.fachinformatik.elias.tests;

import de.fachinformatik.elias.Deck;
import de.fachinformatik.elias.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void constructorWorks() {
        Player player = new Player("test");
        assertEquals(player.getName(),"test");
    }

    @Test
    void drawCardWorks() {
        Player player = new Player("test");
        Deck deck = new Deck();
        player.drawCard(deck);
        assertEquals(deck.getDeck().size(),51);
        assertEquals(player.getHand().getHand().size(),1);
    }
}