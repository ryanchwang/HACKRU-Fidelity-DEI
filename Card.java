public class main
{}
public class Card
{
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
public void setSuit()
{
    this.suit = suit;
}
public int getValue()
{
    return value;
}
public void setValue()
{
    this.value = value;
}
public String toString() 
{
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    return values[value - 2] + " of " + suits[suit];
}
}

public class Player 
{
    private String name;     
    private double balance;  

    public Player(String name, double balance) 
    {
        this.name = name;
        this.balance = balance;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void setBalance(double balance) 
    {
        this.balance = balance; 
    }

    @Override //to override parent previous toString
    public String toString() {
        return "Player: " + name + ", Balance: $" + balance;
    }
}
