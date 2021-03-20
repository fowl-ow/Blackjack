package com.company;

import java.util.Scanner;

public class Blackjack {

    Deck deck = new Deck(true);
    Hand dealerHand = new Hand();
    Hand playerHand = new Hand();
    Scanner scan = new Scanner(System.in);
    String input = "notEmpty";

    public void Blackjack() {}

    public void start() {
        welcomeMessage();
        input = takeInput();
        String start = "start";
        String exit = "exit";
        if (input.equals(start)); {
            System.out.println("fuck off");
            playRound();
        }
        if (input.equals(exit)) {
            System.out.println("fuck you");
            System.exit(0);
        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("Type 'start' to begin,");
        System.out.println("or type 'exit' to stop, playing.");
    }

    public String takeInput() {
        return scan.nextLine();
    }

    public void playerDraw() {
        playerHand.addCard(deck.draw());
    }

    public void dealerDraw() {
        dealerHand.addCard(deck.draw());
    }

    public void playRound() {
        playerDraw();
        System.out.println("You received a "+playerHand.getHand().get(0).toString());
        dealerDraw();
        System.out.println("The dealer received a "+dealerHand.getHand().get(0).toString());

    }

















}
