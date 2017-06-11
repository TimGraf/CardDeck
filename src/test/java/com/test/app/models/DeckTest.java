package com.test.app.models;

import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DeckTest extends TestCase {

    public DeckTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(DeckTest.class);
    }

    public void testDeck() {
        Deck deck        = Deck.GenerateDeck();
        List<Card> cards = deck.getCards();

        assertEquals(52, cards.size());
        assertTrue(cards.contains(new Card(Suite.HEARTS, Rank.ACE)));
        assertTrue(cards.contains(new Card(Suite.DIAMONDS, Rank.TWO)));
        assertTrue(cards.contains(new Card(Suite.CLUBS, Rank.TEN)));
        assertTrue(cards.contains(new Card(Suite.SPADES, Rank.FIVE)));
    }

    public void testShuffle() {
        Deck deck        = Deck.GenerateDeck();
        List<Card> cards = deck.getCards();
        int index1       = cards.size() / 4;
        int index2       = (cards.size() / 4) * 3;

        Card preTop    = cards.get(0);
        Card preOther1 = cards.get(index1);
        Card preOther2 = cards.get(index2);
        Card preBottom = cards.get(cards.size() - 1);

        cards = deck.shuffle();

        Card postTop    = cards.get(0);
        Card postOther1 = cards.get(index1);
        Card postOther2 = cards.get(index2);
        Card postBottom = cards.get(cards.size() - 1);

        boolean shuffled = (!preTop.equals(postTop)) || (!preOther1.equals(postOther1)) || (!preOther2.equals(postOther2)) || (!preBottom.equals(postBottom));

        assertTrue(shuffled);
    }

    public void testCut() {
        Deck deck        = Deck.GenerateDeck();
        List<Card> cards = deck.getCards();
        int cutIndex     = cards.size() / 2;

        Card aboveCut = cards.get(cutIndex - 1);
        Card belowCut = cards.get(cutIndex);

        cards = deck.cut(cutIndex);

        Card postTop    = cards.get(0);
        Card postBottom = cards.get(cards.size() - 1);

        assertEquals(52, cards.size());
        assertEquals(aboveCut, postBottom);
        assertEquals(belowCut, postTop);
    }

    public void testDeal() {
        Deck deck                 = Deck.GenerateDeck();
        List<Card> allCards       = deck.getCards();
        Card topcard              = allCards.get(0);
        Card deltCard             = deck.deal();
        List<Card> remainingCards = deck.getCards();

        assertEquals(topcard, deltCard);
        assertEquals(51, remainingCards.size());
        assertFalse(remainingCards.contains(deltCard));
    }

    public void testTurnOver() {
        Deck deck        = Deck.GenerateDeck();
        Card turnedCard  = deck.turnOver();
        List<Card> cards = deck.getCards();

        assertEquals(52, cards.size());
        assertTrue(cards.contains(turnedCard));
    }

    public void testFindCard() {
        Deck deck      = Deck.GenerateDeck();
        Card findCard  = new Card(Suite.HEARTS, Rank.ACE);
        int index      = deck.findCard(findCard);
        Card foundCard = deck.getCards().get(index);

        assertEquals(foundCard, findCard);
    }

    public void testNewOrder() {
        
    }
}