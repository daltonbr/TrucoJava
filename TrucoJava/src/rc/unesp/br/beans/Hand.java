package rc.unesp.br.beans;

import java.util.List;

/**
 * Class to represent a player's hand.
 * @author Dalton Lima @daltonbr
 * @author lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 */
public class Hand {
    private List<Card> cards;

    /**
     * Constructor of the class
     */
    public Hand(List<Card> _cards) {
        this.cards = _cards;
    }

    /**
     * Add a card to the player's hand
     * @param _card {Card} - the card to add
     */
    public void addCard(Card _card) {
        if (_card != null)
            this.cards.add(_card);
    }

    /**
     * Draw a card from the hand, by its index, removing it.
     * @param _index {int} - the index of the card to draw
     * @return {Card}
     * @throws IndexOutOfBoundsException
     */
    public Card drawCard(int _index) throws IndexOutOfBoundsException {
        Card card = this.cards.get(_index);
        this.cards.remove(_index);
        return card;
    }

    /**
     * Draw the next card of the hand
     * @return {Card}
     */
    public Card drawNextCard() {
        return this.cards.remove(0);
    }

    /**
     * Get the current cards of the hand.
     * @return {List<Card>}
     */
    public List<Card> getCards() {
        return this.cards;
    }

    /**
     * Get the current size of the player's hand
     * @return {int}
     */
    public int getHandSize() {
        return cards.size();
    }

    /**
     * Get a card by its index.
     * Similar to drawCard, but it does not remove the card from the hand.
     * @param _position {int} - the index of the card
     * @return {Card}
     * @throws IndexOutOfBoundsException
     */
    public Card getCard(int _position) throws IndexOutOfBoundsException {
        return cards.get(_position);
    }

    /**
     * Reset the player's hand
     */
    public void resetHand() {
        this.cards.clear();
    }
}
