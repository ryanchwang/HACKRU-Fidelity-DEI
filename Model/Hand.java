package Model;

public class Hand {
    private Card[] playerCards;

    public Hand(){
        playerCards = null;
    }

    public Hand(Card card1, Card card2){
        playerCards = new Card[2];
        playerCards[0] = card1;
        playerCards[1] = card2;
    }

    
}
