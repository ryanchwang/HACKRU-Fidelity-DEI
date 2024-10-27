package Model;
public class Seat {
    private Player player;
    private boolean fold;
    private Hand hand;
    private double totalBet;
    private double currentBet;
    private Seat next;

    public Seat(){
        this.player = null;
        fold = false;
        hand = null;
        totalBet = 0;
        currentBet = 0;
        next = null;
    }

    public void setNext(Seat next){
        this.next = next;
    }

    public Seat getNext(){
        return next;
    }

    public void setPlayer(Player player){
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

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public Hand getHand(){
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
            currentBet += bet;
            return true;
        }
    }

    public void setCurrentBet(double bet){
        // in case it is useful somehow
        currentBet = bet;
    }

    public void addCurrentBet(double bet){
        // Most likely won't use, but just in case it's useful for you
        currentBet += bet;
    }

    public double getCurrentBet(){
        return currentBet;
    }

    public void setTotalBet(double bet){
        // Most likely won't use either
        totalBet = bet;
    }

    public void addTotalBet(double bet){
        totalBet += bet;
    }

    public double getTotalBet(){
        return totalBet;
    }

    private void printMessage(String message){
        System.out.println(message);
    }

}
