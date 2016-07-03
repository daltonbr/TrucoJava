package beans;

import java.util.List;
import java.util.ListIterator;

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
    private List<Player> playersInOrder;

    /**
     * Set the order of the players in this round
     * @param _playersInOrder {List<Player>}
     */
    public void setPlayersInOrder(List<Player> _playersInOrder) {
        this.playersInOrder = _playersInOrder;
    }

    /**
     * Return and remove the next player to play on the ruond
     * @return {Player}
     */
    private Player getNextPlayer() {
        ListIterator<Player> it = this.playersInOrder.listIterator();
        Player nextPlayer = null;

        if (it.hasNext()) {
            nextPlayer = it.next();
            it.remove();
        }

        return nextPlayer;
    }

    /**
     * Init the round flow
     */
    public void initRound() {
        while (!this.isEnded()) {
            Player nextPlayer = this.getNextPlayer();

            if (nextPlayer != null) {
                nextPlayer.chooseCard();
                // TODO: implement the rest of the round flow
            }
        }
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
