package com.company;
import java.util.List;
/**
 * Created by jy412 on 3/30/17.
 */
public class Deck {
    /**
     * cards contains all the cards in the deck.
     */
    private List<Card> cards;

    /**
     * size is the number of not-yet-dealt cards.
     * Cards are dealt from the top (highest index) down.
     * The next card to be dealt is at size - 1.
     */
    private int size;


    /**
     * Creates a new <code>Deck</code> instance.<BR>
     * It pairs each element of ranks with each element of suits,
     * and produces one of the corresponding card.
     * @param ranks is an array containing all of the card ranks.
     * @param suits is an array containing all of the card suits.
     * @param values is an array containing all of the card point values.
     */
    public Deck(String[] ranks, String[] suits, int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        String rank2;
        String suits2;
        String rank [] = new String[52];
        String suit [] = new String[52];
        int value [] = new int[52];
        for(int a2 = 0; a2 < 52; a2++)
        {
            if((a2+1) % 13 == 1)
                rank2 = "ace";
            else if((a2+1) % 13 == 11)
                rank2 = "jack";
            else if((a2+1) % 13 == 12)
                rank2 = "queen";
            else if((a2+1) % 13 == 0)
                rank2 = "king";
            else
                rank2 = Integer.toString((a2+1) % 13);

            if(a2 < 13)
                suits2 = "clubs";
            else if(a2 < 26)
                suits2 = "diamonds";
            else if(a2 < 39)
                suits2 = "hearts";
            else
                suits2 = "spade";

            rank[a2] = rank2;
            suit[a2] = suits2;
            value[a2] = ((a2+1) % 13);
        }

    }


    /**
     * Determines if this deck is empty (no undealt cards).
     * @return true if this deck is empty, false otherwise.
     */
    public boolean isEmpty() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        if(Deck.size == 0)
            return true;
        else
            return false;
    }

    /**
     * Accesses the number of undealt cards in this deck.
     * @return the number of undealt cards in this deck.
     */
    public int size() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */


    }

    /**
     * Randomly permute the given collection of cards
     * and reset the size to represent the entire deck.
     */
    public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
        for(int a = size - 1; a >= 0; a-- )
        {
            int j = (int)(Math.random()* a);
            Card b = cards.get(j);
            cards.set(j, cards.get(a));
            cards.set(a, b);
        }

    }

    /**
     * Deals a card from this deck.
     * @return the card just dealt, or null if all the cards have been
     *         previously dealt.
     */
    public Card deal() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
    }

    /**
     * Generates and returns a string representation of this deck.
     * @return a string representation of this deck.
     */
    @Override
    public String toString() {
        String rtn = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            rtn = rtn + cards.get(k);
            if (k != 0) {
                rtn = rtn + ", ";
            }
            if ((size - k) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\nDealt cards: \n";
        for (int k = cards.size() - 1; k >= size; k--) {
            rtn = rtn + cards.get(k);
            if (k != size) {
                rtn = rtn + ", ";
            }
            if ((k - cards.size()) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\n";
        return rtn;
    }
}
