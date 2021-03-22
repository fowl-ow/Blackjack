package de.fachinformatik.elias;

import java.util.Locale;
import java.util.Scanner;

public class Blackjack {

    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scan;

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
        System.out.println("Hi " + player.getName() + ".");
    }

    private void playRound() {
        player.clearHand();
        dealer.clearHand();
        setupRound();
        if (!checkPlayerHit()) {
            playerTurn();
            showDealer2ndCard();
            dealerTurn();
            }
        }

    private void setupRound() {
        System.out.println("Let's begin!");
        delay();
        playerDraw();
        dealerDraw();
        playerDraw();
        dealerDrawCovered();
        showPlayerHandValue();
        showDealerInitHandValue();
    }

    private void playerTurn() {
        System.out.println("Would you like to draw another card?");
        if (playerDecision()) {
            playerDraw();
            showPlayerHandValue();
            checkPlayerHit();
            checkPlayerBust();
            playerTurn();
        }
        System.out.println("Okay");
        delay();
    }

    private void dealerTurn() {
        showDealerHandValue();
        if (checkDealerHit()) dealerWins();
        else if (checkDealerBust()) dealerLoses();
        else if (checkDealerAbovePlayer()) dealerWins();
        dealerDraw();
        dealerTurn();
    }

    private boolean checkPlayerHit() {
        if (player.getValue() == 21) playerWins();
        return false;
    }

    private boolean checkDealerAbovePlayer() {
        return dealer.getValue() > player.getValue();
    }

    private boolean checkPlayerBust() {
        if (player.getHand().getCorrectValue() > 21) playerLoses();
        return false;
    }

    private boolean checkDealerHit() {
        if (dealer.getValue() == 21) dealerWins();
        return false;
    }

    private boolean checkDealerBust() {
        if (dealer.getValue() > 21) dealerLoses();
        return false;
    }

    private void playerDraw() {
        player.drawCard(deck);
        System.out.println("You've drawn the " + player.getLastDrawn() + ".");
        delay();
    }

    private void dealerDraw() {
        dealer.drawCard(deck);
        System.out.println("The dealer has drawn the " + dealer.getLastDrawn() + ".");
        delay();
    }

    private void dealerDrawCovered() {
        dealer.drawCard(deck);
        System.out.println("The dealer has drawn a 2nd covered card.");
        delay();
    }

    private void playerWins() {
        System.out.println("Congrats, you've won :D");
        delay();
        askPlayAgain();
    }

    private void playerLoses() {
        System.out.println("You've lost :c");
        delay();
        askPlayAgain();
    }

    private void dealerWins() {
        System.out.println("Dealer wins D: better luck next time!");
        delay();
        askPlayAgain();
    }

    private void dealerLoses() {
        System.out.println("The dealer is above 21, so you won :D");
        delay();
        askPlayAgain();
    }

    private void askPlayAgain() {
        System.out.println("Would you like to play again?\n");
        boolean b = playerDecision();
        if (b) playRound();
        else if (!b) {
            System.out.println("Okay, thanks for playing!");
            System.exit(0);
        }
    }

    private boolean playerDecision() {
        String input = scan.next();
        if (affirmative(input)) return true;
        else if (negative(input)) return false;
        else {
            System.out.println("I didn't quite get that... ");
            playerDecision();
            return false;
        }
    }

    private void showPlayerHandValue() {
        System.out.println("You're hand is valued at: " + player.getHand().getCorrectValue());
        delay();
    }

    private void showDealerInitHandValue() {
        System.out.println("The dealer has got at minimum " + dealer.getHand().getHand().get(0).getValue() + ".");
        delay();
    }

    private void showDealerHandValue() {
        System.out.println("The dealers hand is valued at: " + dealer.getHand().getCorrectValue());
        delay();
    }

    private void showDealer2ndCard() {
        System.out.println("The dealers covered card is a " + dealer.getHand().getHand().get(1) + ".");
        delay();
    }

    private boolean affirmative(String input) {
        String inp = input.toLowerCase(Locale.ROOT);
        for (String s: yes) {
            if (inp.contains(s)) return true;
        } return false;
    }

    private boolean negative(String input) {
        String inp = input.toLowerCase(Locale.ROOT);
        for (String s: no) {
            if (inp.contains(s)) return true;
        } return false;
    }

    String[] yes = { "why not", "yep", "aye", "yeah", "yea", "affirmative", "yup", "aye","ay", "accept", "certainly", "surely", "ja",
            "sirree", "oui", "ya", "sure", "yah", "yeh", "allright", "si", "of course", "positive", "OK ", " O.K.", "okay",
            "ye", "rather", "yis", "agree", "siree", "by all means", "da", "absolutely", "you bet", "agreeable", "nod",
            "affirm", "i", "nay", "positively", "yer", "please", "monosyllable", "mu", "yea–sayer", "ay", "yus",
            "yea or nay", "half", "definitely", "yay", "idea", "maybe", "yes-man", "pickthank", "logic", "bit", "flag",
            "be my guest", "OK", "right", "langue d'oc", "in the affirmative", "unequivocal", "have no idea", "yes",
            "indeed", "be my guest", "no problem", "yebo", "I don’t see why not", "polar", "very much so", "open question",
            "acceptance", "approve", "injurious", "may", "sound", "percontation", "naturally", "affirmation", "absotively" };

    String[] no = { "no","nothing", "nobody", "nope", "Np", "dead", "none", "extinct", "nowhere", "bottomless", "loveless",
            "nd", "spaceless", "gone", "only", "viewless", "disused", "dateless", "spineless", "voiceless", "toothless",
            "pitiless", "fatherless", "no one", "na", "deceased", "nix", "waterless", "nay", "nonpareil", "trackless",
            "void", "out", "tasteless", "nae", "nah", "noes", "valueless", "matchless", "stateless", "whatever",
            "silent", "vacant", "hairless", "nothing", "otiose","lifeless", "NG","spiritless" };

    private void delay() {
        try { Thread.sleep(2000); }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}