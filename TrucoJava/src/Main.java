import beans.Card;
import beans.Rank;
import beans.Suit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Bruno on 07/05/2016.
 */
public class Main {
    public static void main(String args[]){
        ArrayList<Card> deck = new ArrayList<>();

        Card vira = new Card(Rank.Jacks, Suit.Clubs, false);

        //Create new cards
        for (Rank rank: Rank.values()) {
            for (Suit suit: Suit.values()) {
                Card card = new Card(rank, suit, (vira.getRank() == Rank.Three && rank == Rank.Four) || (rank.ordinal() == vira.getRank().ordinal()+1) );
                deck.add(card);
            }
        }

        Collections.shuffle(deck);

        //Print not sorted
        System.out.println(deck);

        System.out.println();
        System.out.println();

        //Sort
        deck.sort(null);

        //Print sorted
        System.out.println(deck);

        System.out.println();
        System.out.println();

        Card card1 = new Card(Rank.Three, Suit.Diamonds, false);
        Card card2 = new Card(Rank.Three, Suit.Diamonds, false);
        Card card3 = new Card(Rank.Three, Suit.Clubs, false);

        //These prints cannot be executed
        //A card cannot be considered stronger than other simply by its suit if it's not a manilha
        if (card1.isStrongerThan(card2))
            System.out.println("1st ERRO - Card1 is Stronger!");
        if (card2.isStrongerThan(card1))
            System.out.println("1st ERRO - Card2 is Stronger!");

        if (card1.isStrongerThan(card3))
            System.out.println("2nd ERRO - Card1 is Stronger!");
        if (card3.isStrongerThan(card1))
            System.out.println("2nd ERRO - Card3 is Stronger!");
    }
}
