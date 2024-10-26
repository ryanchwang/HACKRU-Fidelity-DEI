package Model;
import java.util.ArrayList;

public class Function {
    public void dealHand(ArrayList<Player> players, Deck deck) 
    {
        for (Player player : players) 
        {
            player.setHand(new Card[]{deck.drawCard(), deck.drawCard()});
        }
    }
    public Player compareHand(Player player1, Player player2) 
    {
        int handValue1 = evaluateHand(player1.getHand());
        int handValue2 = evaluateHand(player2.getHand());
        if( handValue1>handValue2)
        {
            return player1;
        }
        else if(handValue2>handValue1)
        {
            return player2;
        }
        else
        {return null;}
    }

    private int evaluateHand(Card[] hand)
    {
        int value1 = hand[0].getValue();
        int value2 = hand[1].getValue();
        return value1 + value2;
    }

    public void fold(Player player)
    {
        System.out.println(player.getName() + " has folded.");
        player.setFolded(true);

    }

    public void raise(Player player, double amount) 
    {
        if (player.getBalance() >= amount) 
        {
            player.setBalance(player.getBalance() - amount);
            System.out.println(player.getName() + " raises $" + amount);
        } 
        else 
        {
            System.out.println("Insufficient balance to raise.");
        }
    }

    public void call(Player player, double amountToCall)
    {
        if (player.getBalance() >= amountToCall) 
        {
            player.setBalance(player.getBalance() - amountToCall);
            System.out.println(player.getName() + " calls $" + amountToCall);
        } 
        else 
        {
            System.out.println("Insufficient balance to call.");
        }
    }

    public void check(Player player)
    {
        System.out.println(player.getName() + "checks.")
    }

    public void leave(Player player, ArrayList<Player> players)
    {
        System.out.println(player.getName() + " has left the game.");
        players.remove(player);
    }
}
