package com.test.app.models;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Deck {
    private List<Card> cards = new ArrayList<Card>();

    public static Deck GenerateDeck() {
        Deck deck = new Deck();

        for (Suite suite: Suite.values()) {
            for (Rank rank: Rank.values()) {
                deck.cards.add(new Card(suite, rank));
            }
        }

        return deck;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public List<Card> shuffle() {
        Collections.shuffle(this.cards);

        return this.cards;
    }

    public List<Card> cut(int index) throws IllegalArgumentException {

        if ((index < 1) && (index > this.cards.size() - 1)) {
            throw new IllegalArgumentException("Index parameter is zero based and must be greater than 1 and less than " + (this.cards.size() - 1));
        }

        List<Card> cutCards = new ArrayList<Card>();
        List<Card> top      = this.cards.subList(0, index);
        List<Card> bottom   = this.cards.subList(index, this.cards.size());

        cutCards.addAll(bottom);
        cutCards.addAll(top);
        cards.clear();

        this.cards.addAll(cutCards);

        return this.cards;
    }

    public Card deal() {
        Card card = this.cards.get(0);

        this.cards.remove(0);

        return card;
    }

    public Card turnOver() {
        return this.cards.get(0);
    }

    public int findCard(Card card) {
        return this.cards.indexOf(card);
    }

    public List<Card> newOrder() {
        cards.clear();

        for (Suite suite: Suite.values()) {
            for (Rank rank: Rank.values()) {
                cards.add(new Card(suite, rank));
            }
        }

        return this.cards;
    }
}