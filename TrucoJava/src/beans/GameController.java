package beans;

import ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Vedovetto @bleandro
 * @author Lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 */
public class GameController {
    static final int EARLY_WIN_ROUND_SCORE = 2;
    static final int WIN_GAME_SCORE = 12;

    private MainView view;
    private boolean ended = false;
    private Player winner;
    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();

    /**
     * Initializes the game
     */
    public void initGame() {
        // Create the players. Initially, this will be just two
        HumanPlayer player1 = new HumanPlayer("player1", this.deck.drawRandomCards(3));
        CPUPlayer player2 = new CPUPlayer("CPU player", this.deck.drawRandomCards(3));
        this.players.add(player1);
        this.players.add(player2);
        this.initGameLoop();
    }

    /**
     * Get the reference to the view layer
     * @return {MainView}
     */
    public MainView getView() {
        return this.view;
    }

    /**
     * Set the reference to the view layer.
     * @param view {MainView}
     */
    public void setView(MainView view) {
        this.view = view;
    }

    private void initGameLoop() {
        while (!this.isEnded()) {
            Point point = new Point(this.players);

            // Check if the game has ended
            Player pointWinner = point.getWinner();
            if (pointWinner.getGameScore() == WIN_GAME_SCORE) {
                this.setWinner(pointWinner);
                this.setEnded(true);
            }
        }
    }

    /**
     * Set the game winner player
     * @param _winner {Player}
     */
    public void setWinner(Player _winner) {
        this.winner = _winner;
    }

    /**
     * Set the new status of the game
     * @param ended {Boolean}
     */
    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    /**
     * Check if the game has ended
     * @return ended {Boolean}
     */
    public boolean isEnded() {
        return this.ended;
    }
}
