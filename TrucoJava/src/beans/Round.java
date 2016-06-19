package beans;

/**
 * Class that represents a round of a point of the game.
 * @author Lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 * @author Dalton Lima @daltonbr
 */
public class Round {
    private boolean ended = false;
    private boolean tied = false;
    private Player winner;
    private Player startPlayer;

    /**
     * Constructor of the class
     * @param _startPlayer {PLayer}
     */
    public Round(Player _startPlayer) {
        this.setStartPlayer(_startPlayer);
    }

    /**
     * Set the start player of the round
     * @param _startPlayer {Player}
     */
    public void setStartPlayer(Player _startPlayer) {
        this.startPlayer = _startPlayer;
    }

    /**
     * Get the start player of the round
     * @return {Player}
     */
    public Player getStartPlayer() {
        return this.startPlayer;
    }

    /**
     * Set the winner of the round
     * @param _winner {Player}
     */
    public void setWinner(Player _winner) {
        this.winner = _winner;
    }

    /**
     * Get the winner of the round
     * @return {PLayer}
     */
    public Player getWinner() {
        return this.winner;
    }

    /**
     * Check if a round has ended
     * @return {Boolean}
     */
    public boolean isEnded() {
        return this.ended;
    }

    /**
     * Set the new ended status of the round
     * @param _ended {boolean}
     */
    public void setEnded(boolean _ended) {
        this.ended = _ended;
    }

    /**
     * Check is a round has tied.
     * @return {Boolean}
     */
    public boolean isTied() {
        return this.tied;
    }

    /**
     * Set the new tied status of the round
     * @param _tied {Boolean}
     */
    public void setTied(boolean _tied) {
        this.tied = _tied;
    }
}
