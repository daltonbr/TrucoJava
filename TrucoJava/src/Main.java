import beans.Card;
import beans.Rank;
import beans.Suit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Bruno on 07/05/2016.
 */
public class Main {
    public static void main(String args[]) {
        ArrayList<Card> deck = new ArrayList<>();

        Card vira = new Card(Rank.Jacks, Suit.Clubs, false);

        //Create new cards
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit, (vira.getRank() == Rank.Three && rank == Rank.Four) ||
                        (rank.ordinal() == vira.getRank().ordinal() + 1));
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
        Card card2 = new Card(Rank.Three, Suit.Spades, false);
        Card card3 = new Card(Rank.Three, Suit.Clubs, false);

        // Comparing if cards that are equivalent (in case when the cards aren' "vira"s
        if (!card1.isStrongerThan(card2) && (!card2.isStrongerThan(card1))) {
            System.out.println("Card1 and Card2 are Equivalent!");
        }

        // Clean way to compare
        if (card1.equals(card2)) {
            System.out.println("Card1 and Card2 are Equivalent! Equivalent again!");
        }
        if (card2.equals(card1)) {
            System.out.println("Card2 and Card1 are Equivalent!");
        }

        if (card2.equals(card3)) {
            System.out.println("Card2 and Card3 are Equivalent!");
        }

        // When comparing for cards that are equivalent (equals in context of the game)
        // These way of compare is not good;
        if (card2.isStrongerThan(card1))
            System.out.println("1st ERRO - Card2 is Stronger!");

        if (card1.isStrongerThan(card3))
            System.out.println("2nd ERRO - Card1 is Stronger!");
        if (card3.isStrongerThan(card1))
            System.out.println("2nd ERRO - Card3 is Stronger!");
    }
}
