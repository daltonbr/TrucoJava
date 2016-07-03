package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Class that represents a point ("tento") of the game.
 * @author Lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 * @author Dalton Lima @daltonbr
 */
public class Point {
    static final int EARLY_WIN_ROUND_SCORE = 2;

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

            // TODO: add logic to treat tie cases and others
            while (it.hasNext() && !this.isEnded()) {
                /* We order the players in the order they should play in the next round.
                   In order to do this, we must get the winner from the last round,
                   and set it as the first one of the list. For the first round, we just
                   pass the players as they come. Also, we just do this reordering if the round
                   is not the first one.
                 */
                if (it.nextIndex() != 0) {
                    int previousIndex = it.previousIndex();
                    Round previousRound = this.rounds.get(previousIndex);
                    playersInOrder = this.orderPlayers(playersInOrder, previousRound.getWinner());
                }

                Round nextRound = it.next();
                nextRound.setPlayersInOrder(playersInOrder);
                nextRound.initRound();

                Player nextRoundWinner = nextRound.getWinner();

                /* Check if some player's has won this point by
                   winning two rounds in a row */
                if (nextRoundWinner.getRoundScore() == EARLY_WIN_ROUND_SCORE) {
                    this.setWinner(nextRoundWinner);
                    this.setEnded(true);
                }
            }

            // We end the point when all round has been played
            this.setEnded(true);
        }
    }

    /**
     * Order the players setting the last round winner as the
     * start player of the next round.
     * @param players {List<Player>}
     * @param firstPlayer {Player}
     * @return {List<Player>}
     */
    private List<Player> orderPlayers(List<Player> players, Player firstPlayer) {
        List<Player> newPlayers = new ArrayList<>();
        newPlayers.add(firstPlayer);
        ListIterator<Player> it = players.listIterator();

        if (it.hasNext()) {
            Player nextPlayer = it.next();
            if (nextPlayer.getName().equals(firstPlayer.getName())) {
                it.remove();
            } else {
                newPlayers.add(nextPlayer);
            }
        }

        return newPlayers;
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
