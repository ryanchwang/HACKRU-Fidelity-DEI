package Model;
public class Seat {
    private Player player;
    private boolean fold;
    private Card[] hand;
    private double totalBet;

    public Seat(){
        this.player = null;
        fold = false;
        hand = null;
        totalBet = 0;
    }

    public void setPerson(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public void fold(){
        fold = true;
    }

    public boolean getFold(){
        return fold;
    }

    public void setHand(Card first, Card second){
        hand = new Card[2];
        hand[0] = first;
        hand[1] = second;
    }

    public Card[] getHand(){
        return hand;
    }

    public boolean placeBet(double bet){
        double playerBalance = player.getBalance();
        if (playerBalance < bet){
            printMessage("Insufficient funds");
            return false;
        }
        else{
            playerBalance -= bet;
            printMessage("Placed bet");
            player.setBalance(playerBalance);
            totalBet += bet;
            return true;
        }
    }

    private void printMessage(String message){
        System.out.println(message);
    }

}
