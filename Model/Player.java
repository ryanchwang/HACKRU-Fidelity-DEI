package Model;

public class Player 
{
    private String name;     
    private double balance;  

    public Player(){
        name = null;
        balance = 0;
    }
    
    private boolean isFolded;

    public void setFolded(boolean folded) 
    {
        this.isFolded = folded;
    }
    
    public boolean isFolded() 
    {
        return isFolded;
    }
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
