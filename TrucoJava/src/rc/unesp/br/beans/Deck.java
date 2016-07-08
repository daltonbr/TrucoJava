package rc.unesp.br.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Class to represent the deck of cards of the game.
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 * @author lucas Pinheiro @lucaspin
 */
public class Deck {
    private List<Card> cards = new ArrayList<>();
    private Random randomGenerator = new Random();

    public Deck() {
        // Create new cards
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit, false);
                this.cards.add(card);
            }
        }
    }

    public List<Card> getCards() { return cards; }

    public void setCards(ArrayList<Card> _deck) { this.cards = _deck; }

    /**
     * Return and remove a random card from the deck
     * @return {Card}
     */
    public Card drawRandomCard() {
        int index = this.randomGenerator.nextInt(cards.size());
        Card card = this.cards.get(index);
        //System.out.println("Card Picked: " + card.toString());
        cards.remove(index);
        return card;
    }

    /**
     * Return _numberOfCardsToDraw and remove them from the deck
     * @param _numberOfCardsToDraw {int}
     * @return {List<Card>}
     */
    public List<Card> drawRandomCards(int _numberOfCardsToDraw) {
        List<Card> cardArray = new ArrayList<>();
        for (int i = 0; i < _numberOfCardsToDraw; i++){
            int index = this.randomGenerator.nextInt(this.cards.size());
            Card card = this.cards.get(index);
            cardArray.add(card);
            this.cards.remove(index);
        }
        return cardArray;
    }

    /**
     * Return and remove the first card from the deck
     * @return {Card}
     */
    public Card drawTopCard() {
        Card card = this.cards.get(0);
        cards.remove(0);
        System.out.println("Card Picked: " + card.toString());
        return card;
    }

    /**
     * Return and remove the first n cards from the Deck
     * @param _numberOfCardsToDraw {int}
     * @return {List<Card>}
     */
    public List<Card> drawTopCards(int _numberOfCardsToDraw) {
        List<Card> cardArray = new ArrayList<>();
        for (int i = 0; i < _numberOfCardsToDraw; i++){
            Card card = this.cards.get(0);
            cardArray.add(card);
            this.cards.remove(0);
        }
        return cardArray;
    }

    /**
     * Shuffle the deck
     */
    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    /**
     * Reset the deck
     */
    public void resetDeck() {
        this.cards.clear();
        //Create new cards
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit, false);
                this.cards.add(card);
            }
        }
    }
}
