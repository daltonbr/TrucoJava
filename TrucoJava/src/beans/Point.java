package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Class that represents a point ("tento") of the game.
 * @author Lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 * @author Dalton Lima @daltonbr
 */
public class Point {
    private boolean ended = false;
    private List<Round> rounds = new ArrayList<>();
    private Player dealer;
    private Player winner;
    private PointValue pointValue;

    /**
     * Constructor of the class
     */
    public Point(List<Player> playersInOrder) {
        this.setDealer(playersInOrder.get(0));
        this.setPointValue(PointValue.ONE);
        this.initPoint(playersInOrder);
    }

    /**
     * Init a point flow
     * @param playersInOrder {List<Player>}
     */
    private void initPoint(List<Player> playersInOrder) {
        this.createRounds();

        while (!this.isEnded()) {
            ListIterator<Round> it = this.rounds.listIterator();

            // I'm assuming the point is gonna end before three rounds
            // TODO: add logic to treat tie cases and others
            if (it.hasNext()) {
                Round nextRound = it.next();
                // TODO: pass the players in the order they should play
                nextRound.setPlayersInOrder(playersInOrder);
                nextRound.initRound();
            }
        }
    }

    /**
     * Create the rounds of this point
     */
    private void createRounds() {
        for (int i = 0; i < 3; i++) {
            Round round = new Round();
            this.rounds.add(round);
        }
    }

    /**
     * Get the ended status of the point
     * @return {Boolean}
     */
    public boolean isEnded() {
        return this.ended;
    }

    /**
     * Set the ended status of the point
     * @param _ended {Boolean}
     */
    public void setEnded(boolean _ended) {
        this.ended = _ended;
    }

    /**
     * Get the round of the point
     * @return {List<Round>}
     */
    public List<Round> getRounds() {
        return this.rounds;
    }

    /**
     * Set the rounds for the point
     * @param _rounds {List<Round>}
     */
    public void setRounds(List<Round> _rounds) {
        this.rounds = _rounds;
    }

    /**
     * Get the dealer of the point
     * @return {Player}
     */
    public Player getDealer() {
        return this.dealer;
    }

    /**
     * Set the dealer of the point
     * @param _dealer {Player}
     */
    public void setDealer(Player _dealer) {
        this.dealer = _dealer;
    }

    /**
     * Get the winner of the point
     * @return {Player}
     */
    public Player getWinner() {
        return this.winner;
    }

    /**
     * Set the winner of the point
     * @param _winner {Player}
     */
    public void setWinner(Player _winner) {
        this.winner = _winner;
    }

    /**
     * Get the real value of the point
     * @return {PointValue}
     */
    public PointValue getPointValue() {
        return this.pointValue;
    }

    /**
     * Set the new real value of the point
     * @param _value {PointValue}
     */
    public void setPointValue(PointValue _value) {
        this.pointValue = _value;
    }
}
