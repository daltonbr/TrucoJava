import beans.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Bruno on 07/05/2016.
 */
public class Main {
    public static void main(String args[]) {
        Deck testDeck = new Deck();
        Hand testHand = new Hand();
        testDeck.shuffleDeck();

        //add 3 cards
        testHand.addCard(testDeck.getTopCard());
        testHand.addCard(testDeck.getTopCard());
        testHand.addCard(testDeck.getTopCard());

        testHand.showHand();

        //Drawing and setting the manilha (maybe a method to do this?)
        Card vira = testDeck.getTopCard();
        vira.setManilha(true);
        System.out.println("The choosen manilha is: " + vira.toString());

        System.out.println();
//        //Sort
//        deck.sort(null);
//
//        //Print sorted
//        System.out.println(deck);
//
//        System.out.println();

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

        // When comparing{984ca8a9-5383-42a7-a38b-8f90dee91056} for cards that are equivalent (equals in context of the game)
        // These way of compare is not good;
        if (card2.isStrongerThan(card1))
            System.out.println("1st ERRO - Card2 is Stronger!");

        if (card1.isStrongerThan(card3))
            System.out.println("2nd ERRO - Card1 is Stronger!");
        if (card3.isStrongerThan(card1))
            System.out.println("2nd ERRO - Card3 is Stronger!");
    }
}
