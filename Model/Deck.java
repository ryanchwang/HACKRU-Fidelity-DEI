package Model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Deck {
    private HashSet<Card> deck;

    public Deck(){
        deck = new HashSet<>();

        for (int i = 0; i < 52; i++){
            Card card = new Card(i/13, i%13);
            deck.add(card);
        }
    }

    public Card draw(){
        if (deck.isEmpty()){
            return null;
        }

        Card[] deckArray = deck.toArray(new Card[0]);
        int pick = (int)(Math.random()*deck.size());
        Card card = deckArray[pick];

        deck.remove(card);

        return card;
    }

    public HashSet<Card> newDeck(){
        return deck;
    }

    public void reset(){
        deck.clear();

        for (int i = 0; i < deck.size(); i++){
            Card card = new Card(i/13, i%13);
            deck.add(card);
        }

    }

}
   


