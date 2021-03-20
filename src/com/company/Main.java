package com.company;

public class Main {

    public static void main(String[] args) {

        Card card1 = new Card(Suit.SPADES,Rank.ACE);
        System.out.println("Card: "+card1.getRank()+" of "+card1.getSuit());


        Deck deck = new Deck(true,1);
        String[] deckArr = deck.getDeckAsStringArray();
        System.out.println(deck.getDeck().size()/52);
        }
    }