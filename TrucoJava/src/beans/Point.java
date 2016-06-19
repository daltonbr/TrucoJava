package beans;

import java.util.List;

/**
 * Class that represents a point ("tento") of the game.
 * @author Lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 * @author Dalton Lima @daltonbr
 */
public class Point {
    private List<Round> rounds;
    private Player dealer;
    private Player winner;
    private PointValue pointValue;

    /**
     * Constructor of the class
     */
    public Point(Player _dealer) {
        this.setDealer(_dealer);
        this.setPointValue(PointValue.ONE);
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
