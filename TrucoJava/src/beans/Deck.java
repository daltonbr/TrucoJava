package beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created on 6/1/16 by:
 * Dalton Lima         github.com/daltonbr
 * Lucas Pinheiro      github.com/lucaspin
 * Bruno Vedovetto     github.com/bleandro
 */

public class Deck {
    private ArrayList<Card> deck;
    private Random randomGenerator;

    public Deck() {
        deck = new ArrayList<Card>();
        randomGenerator = new Random();
        //Create new cards
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit, false);
                deck.add(card);
            }
        }
    }

    public ArrayList<Card> getDeck() { return deck; }

    public void setDeck(ArrayList<Card> _deck) { this.deck = _deck; }

    /* return a random card from the Deck */
    public Card getRandomCard() {
        if (this.getDeck().size() == 0) {
            // TODO implement Exception
        }
        int index = randomGenerator.nextInt(deck.size());
        Card card = deck.get(index);
        System.out.println("Card Picked: " + card.toString());
        deck.remove(index);
        return card;
    }

    /* return n random cards from the Deck */
    public ArrayList<Card> getRandomCards(int _numberOfCardsToDraw) {
        if (this.getDeck().size() < _numberOfCardsToDraw) {
            // TODO implement Exception
        }
        ArrayList<Card> cardArray = new ArrayList<>();
        for (int i = 0; i < _numberOfCardsToDraw; i++){
            int index = randomGenerator.nextInt(deck.size());
            Card card = deck.get(index);
            cardArray.add(card);
            deck.remove(index);
        }
        return cardArray;
    }

    /* return the first card from the Deck */
    public Card getTopCard() {
        if (this.getDeck().size() == 0) {
            // TODO implement Exception
        }
        Card card = deck.get(0);
        deck.remove(0);
        System.out.println("Card Picked: " + card.toString());
        return card;
    }

    /* return the first n cards from the Deck */
    public ArrayList<Card> getTopCards(int _numberOfCardsToDraw) {
        if (this.getDeck().size() < _numberOfCardsToDraw) {
            // TODO implement Exception
        }
        ArrayList<Card> cardArray = new ArrayList<>();
        for (int i = 0; i < _numberOfCardsToDraw; i++){
            Card card = deck.get(0);
            cardArray.add(card);
            deck.remove(0);
        }
        return cardArray;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    /* same as the constructor */
    public void resetDeck() {
        this.deck = new ArrayList<Card>();
        randomGenerator = new Random();
        //Create new cards
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit, false);
                deck.add(card);
            }
        }
    }
}
