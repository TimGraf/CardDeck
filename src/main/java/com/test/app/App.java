package com.test.app;

import com.test.app.models.Card;
import com.test.app.models.Deck;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Deck deck = Deck.GenerateDeck();

        System.out.println("New Deck");

        for (Card card: deck.getCards()) {
            System.out.println(card.toString());
        }

        deck.shuffle();

        System.out.println("Shuffled Deck");

        for (Card card: deck.getCards()) {
            System.out.println(card.toString());
        }
    }
}
