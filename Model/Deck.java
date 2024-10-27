package Model;

public class Deck{
    private int numCards;
    private Card[] deck;


public Deck (int numCards){
    this.numCards = numCards;
    this.deck = new Card[numCards];
}
}

