package Model;
public class Seat {
    private Player person;
    private boolean fold;
    private Card[] hand;
    private double bets;

    public Seat(){
        this.person = null;
        fold = false;
        hand = null;
        bets = 0;
    }

    public void setPerson(Player person){
        this.person = person;
    }

    public void setHand(Card first, Card second){
        hand = new Card[2];
        hand[0] = first;
        hand[1] = second;
    }

}
