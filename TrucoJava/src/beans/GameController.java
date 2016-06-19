package beans;

import ui.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

/**
 * @author Bruno Vedovetto @bleandro
 * @author Lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 */
public class GameController {
    private boolean ended = false;
    private List<Player> players;
    private Deck deck;

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
        // TODO: create players
        // TODO: create deck
        // TODO: create the points
        // TODO: start game loop
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
