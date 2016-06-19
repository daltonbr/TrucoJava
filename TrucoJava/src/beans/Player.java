package beans;

import java.util.List;

/**
 * Class to represent a player of the game.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public abstract class Player {
    private String name;
    private Hand hand;

    /**
     * Constructor of the class
     * @param name {String} the name of the player
     */
    public Player(String name) {
        this.setName(name);
    }

    /**
     * Set the player's name
     * @param name {String} the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the player's name
     * @return name {String}
     */
    public String getName() {
        return name;
    }

    /**
     * Set the player's hand
     * @param h {Hand} the new player's hand
     */
    public void setHand(Hand h) {
        this.hand = h;
    }

    /**
     * Get the current cards from the player's hand
     * @return {List<Card>}
     */
    public List<Card> getHand() {
        return this.hand.getCards();
    }

    /**
     * Used when a player wants to call truco
     */
    public void callTruco() {
        // TODO
    }

    /**
     * Called when a player accepts a truco call
     */
    public void acceptTruco() {
        // TODO
    }

    /**
     * Called when a player declines a truco call
     */
    public void fold() {

    }

    /**
     * Method invoked when a player must choose a card.
     */
    abstract public void chooseCard();
}
