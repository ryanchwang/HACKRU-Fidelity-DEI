package Model;

public class Card {
    private int suit;
    private int value;

    public Card(int suit, int value)
    {
        this.suit = suit;
        this.value = value;
    }
    public int getSuit()
    {
        return suit;
    }
    public void setSuit(int suit)
    {
        this.suit = suit;
    }
    public int getValue()
    {
        return value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    public String toString()
    {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        return values[value] + " of " + suits[suit];
    }
}
