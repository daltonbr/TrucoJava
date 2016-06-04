package beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Class to represent the deck of cards of the game.
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 * @author lucas Pinheiro @lucaspin
 */
public class Deck {
    private ArrayList<Card> cards;
    private Random randomGenerator = new Random();

    public Deck() {
        cards = new ArrayList<>();
        //Create new cards
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit, false);
                cards.add(card);
            }
        }
    }

    public ArrayList<Card> getCards() { return cards; }

    public void setCards(ArrayList<Card> _deck) { this.cards = _deck; }

    /* return (and remove) a random card from the Deck */
    public Card drawRandomCard() {
        int index = randomGenerator.nextInt(cards.size());
        Card card = cards.get(index);
        System.out.println("Card Picked: " + card.toString());
        cards.remove(index);
        return card;
    }

    /* return n random cards from the Deck */
    public ArrayList<Card> drawRandomCards(int _numberOfCardsToDraw) {
        ArrayList<Card> cardArray = new ArrayList<>();
        for (int i = 0; i < _numberOfCardsToDraw; i++){
            int index = randomGenerator.nextInt(cards.size());
            Card card = cards.get(index);
            cardArray.add(card);
            cards.remove(index);
        }
        return cardArray;
    }

    /* return (and remove) the first card from the Deck */
    public Card drawTopCard() {
        Card card = cards.get(0);
        cards.remove(0);
        System.out.println("Card Picked: " + card.toString());
        return card;
    }

    /* return (and remove) the first n cards from the Deck */
    public ArrayList<Card> drawTopCards(int _numberOfCardsToDraw) {
        ArrayList<Card> cardArray = new ArrayList<>();
        for (int i = 0; i < _numberOfCardsToDraw; i++){
            Card card = cards.get(0);
            cardArray.add(card);
            cards.remove(0);
        }
        return cardArray;
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public void resetDeck() {
        this.cards.clear();
        //Create new cards
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit, false);
                cards.add(card);
            }
        }
    }
}
