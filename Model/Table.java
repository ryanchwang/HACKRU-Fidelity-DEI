package Model;

import org.w3c.dom.Node;

public class Table {

    private int pot;
    private int round;
    int[] hand = new int[5];
    static Seat smallBlind = null;
    static Seat dealer = null;

    public Table(){
        this.round = round;
        this.hand = hand;
        this.smallBlind = smallBlind;
    }
    public static Seat add(Seat insert) {

        Seat temp = insert;

        if (smallBlind == null) {
            dealer = insert;
            insert.setNext(insert);
        } else {
            insert.setNext(dealer.getNext());
            dealer.setNext(insert);
            dealer = insert;
        }

        return dealer.getNext();

    }

    public int calculatePot() {
        double max = 0;
        int pot = 0; // Ensure 'pot' is initialized to zero at the start of each calculation.
        if (smallBlind == null) {
            return 0;
        }
        Seat curr = smallBlind;

        do {
            double currentBet = curr.getTotalBet();

            if (currentBet > max) {
                max = currentBet; // Update max to the current highest bet.
            }
            pot += currentBet; // Add the current bet to the pot, regardless of its value.
            curr = curr.getNext(); // Move to the next seat.
        } while (curr != smallBlind); // Ensure the loop runs for all seats once.

        return pot; // Return the total pot calculated.
    }




}

