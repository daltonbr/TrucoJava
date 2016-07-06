package ui;

import beans.Card;
import beans.GameController;

import javax.swing.*;
import java.util.List;

/**
 * @author Lucas Pinheiro @lucaspin
 * @author Dalton lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public class MainView extends JFrame {
    static final int MINIMUM_HEIGHT = 550;
    static final int MINIMUM_WIDTH = 680;

    public GamePanel gamePanel;

    /**
     * Constructor of the class.
     */
    public MainView() {
        super("Truco");

        // Set the initial options for the frame
        this.initMainViewOpts();

        // Create the panels
        this.gamePanel = new GamePanel();
        this.setSize(MainView.MINIMUM_WIDTH, MainView.MINIMUM_HEIGHT);

        // Add the panel to the frame
        this.getContentPane().add(this.gamePanel);
    }

    /**
     * Set the initial frame options
     */
    private void initMainViewOpts() {
        this.setSize(MainView.MINIMUM_WIDTH, MainView.MINIMUM_HEIGHT);
        this.setResizable(true);

        // Center the frame
        this.setLocationRelativeTo(null);
    }

    public void setCardsOnTopPanel(List<Card> cards) {
        this.gamePanel.bottomPlayerPanel.setCards(cards);
        this.revalidate();
        this.repaint();
    }

    public void setCardsOnBottomPanel(List<Card> cards) {
        this.gamePanel.topPlayerPanel.setCards(cards);
        this.revalidate();
        this.repaint();
    }

    public void setBottomPanelController(GameController controller) {
        this.gamePanel.bottomPlayerPanel.setController(controller);
    }
}
