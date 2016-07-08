package rc.unesp.br.beans;

/**
 * Class to represent a player of the game.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public abstract class Player {
    private String name;
    private Hand hand;
    private Card currentChosenCard;
    private int gameScore = 0;
    private int roundScore = 0;

    /**
     * Constructor of the class
     * @param name {String} the name of the player
     */
    public Player(String name) {
        this.setName(name);
    }

    /**
     * Set the new player's score
     * @param newScore {int}
     */
    public void setGameScore(int newScore) {
        this.gameScore = newScore;
    }

    /**
     * Get the current player's score
     * @return {int}
     */
    public int getGameScore() {
        return this.gameScore;
    }

    /**
     * Increase the player's game score by one
     */
    public void increaseGameScore(int increment) {
        this.gameScore += increment;
    }

    /**
     * Increase the player's round score by one
     */
    public void increaseRoundScore() {
        this.roundScore++;
    }

    /**
     * Get the player's round score
     * @return {int}
     */
    public int getRoundScore() {
        return this.roundScore;
    }

    /**
     * Set the round score
     * @param newScore {int}
     */
    public void setRoundScore(int newScore) {
        this.roundScore = newScore;
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
     * Get the current chosen card by a player
     * @return {Card}
     */
    public Card getCurrentChosenCard() {
        return this.currentChosenCard;
    }

    /**
     * Set the current chosen card by a player
     * @param _card {Card}
     */
    public void setCurrentChosenCard(Card _card) {
        this.currentChosenCard = _card;
    }

    /**
     * Get the current cards from the player's hand
     * @return {Hand}
     */
    public Hand getHand() {
        return this.hand;
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
        // TODO
    }

    /**
     * Reset the player's round score to zero
     */
    public void resetRoundScore() {
        this.roundScore = 0;
    }

    /**
     * Method invoked when a player must choose a card.
     */
    abstract public void chooseCard();
}
