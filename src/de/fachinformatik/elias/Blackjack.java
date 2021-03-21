package de.fachinformatik.elias;

import java.util.Scanner;

public class Blackjack {

    private int wait = 1;
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scan;
    private String input;
    private int count = 2;
    private String yes = "yes";
    private String no = "no";

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
        player.getHand().getHand().clear();
        dealer.getHand().getHand().clear();
        try {setupRound();} catch (InterruptedException e) {e.printStackTrace();}
        if (checkIfContinue()) {
            showDealerInitStatus();
            showPlayerStatus();
            playerDraw();
            showDealer2ndCard();
            dealerDraw();
        } else askPlayAgain();
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

    private void showPlayerStatus() {
        System.out.println("You're hand is valued at: " + player.getHand().getValue());
    }

    private void showDealerInitStatus() {
        System.out.println("The dealer has got at minimum " + dealer.getHand().getHand().get(0).getValue()+".");
    }

    private void showDealerStatus() {
        System.out.println("The dealers hand is valued at: " + dealer.getHand().getValue());
    }

    private void showDealer2ndCard() {
        System.out.println("The dealers covered card is a " + dealer.getHand().getHand().get(1)+".");
        System.out.println("The dealers hand is valued at " + dealer.getHand().getValue());
    }

    private boolean checkIfContinue() {
        if (player.getHand().getValue() == 21) {
            System.out.println("Congrats, you've won :D");
            askPlayAgain();
            return false;
        } else if (player.getHand().getValue() > 21) {
            if (player.getHand().getAces() > 0) {
                player.getHand().updateValue();
                System.out.println("Your ace counts as 1 since otherwise your hand would be above 21.");
                showPlayerStatus();
                checkIfContinue();
            } else if (player.getHand().getValue() > 21) {
                System.out.println("You've lost D:");
                askPlayAgain();
                return false;
            } else return true;
        }
        return true;
    }

    private void playerDraw() {
        System.out.println("Would you like to draw another card? yes/no");
        input = scan.next();
        if (input.equalsIgnoreCase(yes)) {
            player.drawCard(deck);
            System.out.println("You've drawn the "+player.getHand().getHand().get(count)+".");
            count++;
            showPlayerStatus();
            if (checkIfContinue()) {
            playerDraw();
            } else return;
        }
    }

    private void dealerDraw() {
        if (dealer.getHand().getValue()>21) {
            dealer.getHand().updateValue();
        } else if (dealer.getHand().getValue()==21) {
            System.out.println("The dealer won.");
            askPlayAgain();
        } else if (dealer.getHand().getValue()>player.getHand().getValue()) {
            System.out.println("The dealer won.");
            askPlayAgain();
        } else {
            System.out.println("The dealer draws another card.");
            dealer.drawCard(deck);
            System.out.println("The dealer has drawn the "+dealer.getHand().getHand().get(2)+".");
            showDealerStatus();
            showPlayerStatus();
        }
        dealerDraw();
    }

    private void askPlayAgain() {
        System.out.println("Would you like to play again? yes/no: ");
        String answer = scan.next();
        if (answer.equalsIgnoreCase(yes)) playRound();
        else if (answer.equalsIgnoreCase(no)) System.exit(0);
    }

}