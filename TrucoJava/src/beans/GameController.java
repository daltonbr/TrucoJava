package beans;

import ui.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Vedovetto @bleandro
 * @author Lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 */
public class GameController {
    private boolean ended = false;
    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();

    /**
     * Constructor of the class
     */
    public GameController() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView mainView = new MainView();
                mainView.setVisible(true);
                mainView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        e.getWindow().dispose();
                    }
                });
            }
        });

        this.initGame();
    }

    /**
     * Initializes the game
     */
    private void initGame() {
        // Create the players. Initially, this will be just two
        HumanPlayer player1 = new HumanPlayer("player1", this.deck.drawRandomCards(3));
        CPUPlayer player2 = new CPUPlayer("CPU player", this.deck.drawRandomCards(3));
        this.players.add(player1);
        this.players.add(player2);
        this.initGameLoop();
    }

    private void initGameLoop() {
        while (!this.isEnded()) {
            Point point = new Point(this.players);
            // TODO: do the rest of the game flow here
        }
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
