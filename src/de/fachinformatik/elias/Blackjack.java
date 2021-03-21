package de.fachinformatik.elias;

import java.util.Arrays;
import java.util.Scanner;

public class Blackjack {

    private int wait = 500;
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scan;
    private String input;

    public Blackjack() {
        dealer = new Dealer();
        deck = new Deck(true);
        scan = new Scanner(System.in);
        initPlayer();
        playRound();
    }

    private void initPlayer() {
        System.out.println("Please enter your name: ");
        player = new Player(scan.next());
        System.out.println("Hi "+player.getName()+".");
    }

    private void playRound() {
        try {setupRound();} catch (InterruptedException e) {e.printStackTrace();}
        showStatus();
        checkStatus();
    }

    private void checkStatus() {
        if (player.getHand().getValue()==21) System.out.println("Congrats, you've won :D");
        else if (player.getHand().getValue()>21) player.getHand().updateValue();
        else if (player.getHand().getValue()>21) player.getHand().updateValue();
        else if (player.getHand().getValue()>21) player.getHand().updateValue();
        else if (player.getHand().getValue()>21) player.getHand().updateValue();
        else if (player.getHand().getValue()>21) System.out.println("You've lost D:");


    }

    private void showStatus() {
        System.out.println("You're hand is valued at: " + player.getHand().getValue());
    }


        private void setupRound() throws InterruptedException {
            System.out.println("Let's begin!");
            Thread.sleep(wait);
            player.drawCard(deck);
            System.out.println("You've drawn the "+player.getHand().getHand().get(0)+".");
            Thread.sleep(wait);
            dealer.drawCard(deck);
            System.out.println("The dealer has drawn the "+dealer.getHand().getHand().get(0)+".");
            Thread.sleep(wait);
            player.drawCard(deck);
            System.out.println("You've drawn the  "+player.getHand().getHand().get(1)+".");
            Thread.sleep(wait);
            dealer.drawCard(deck);
            System.out.println("The dealer has drawn a covered 2nd card.");
            Thread.sleep(wait);
        }

    private void playerTurn() {
        System.out.println("You've got: "+Arrays.toString(player.getHand().getHandAsStringArray()));

    }
}