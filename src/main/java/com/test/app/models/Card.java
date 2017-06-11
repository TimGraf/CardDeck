package com.test.app.models;

public class Card extends Object {
    private Suite suite;
    private Rank rank;

    public Card(Suite suite, Rank rank) {
        this.suite = suite;
        this.rank  = rank;
    }

    public Suite getSuite() {
        return this.suite;
    }

    public Rank getRank() {
        return this.rank;
    }

    public String toString() {
        return "Suite: " + this.suite.name() + " : Rank: " + this.rank.name();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Card)) return false;
        
        Card card = (Card) o;

        return (this.suite == card.getSuite()) && (this.rank == card.getRank());
    }

    @Override
    public int hashCode() {
        int hash1 = this.suite.hashCode();
        int hash2 = this.rank.hashCode();

        return 31 * hash1 + hash2;
    }
}