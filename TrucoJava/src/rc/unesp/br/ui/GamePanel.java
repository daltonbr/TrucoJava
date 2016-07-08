package rc.unesp.br.ui;

import java.awt.*;
import javax.swing.*;

/**
 * Class for the main panel of the application.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public class GamePanel extends JPanel {
    static final int DEFAULT_PANEL_WIDTH = 300;
    static final int DEFAULT_PANEL_HEIGHT = 150;

    public BottomPlayerPanel bottomPlayerPanel;
    public TopPlayerPanel topPlayerPanel;
    public ScorePanel scorePanel;
    public ButtonPanel buttonPanel;
    public MiddlePanel middlePanel;

    // This variable is responsible for holding the layout options
    private GridBagConstraints constraints = new GridBagConstraints();

    /**
     * Constructor of the class
     */
    public GamePanel() {
        this.setInitialOpts();
        this.createTopPlayerPanel();
        this.createBottomPlayerPanel();
        this.createMiddlePanel();
        this.createScorePanel();
        this.createButtonPanel();
    }

    /**
     * Set the initial options for this GamePanel
     */
    private void setInitialOpts() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#006611"));
    }

    /**
     * Create the button panel
     */
    private void createButtonPanel() {
        this.buttonPanel = new ButtonPanel();

        // Set the layout options
        this.constraints.gridx = 4;
        this.constraints.gridy = 2;
        this.constraints.anchor = GridBagConstraints.SOUTHEAST;

        this.add(this.buttonPanel, this.constraints);
    }

    /**
     * Create the middle panel
     */
    private void createMiddlePanel() {
        this.middlePanel = new MiddlePanel();

        // Set the layout options
        this.constraints.gridx = 0;
        this.constraints.gridwidth = 3;
        this.constraints.gridy = 1;
        this.constraints.anchor = GridBagConstraints.CENTER;

        this.add(this.middlePanel, this.constraints);
    }

    /**
     * Create the score panel
     */
    private void createScorePanel() {
        this.scorePanel = new ScorePanel();

        // Set the layout options
        this.constraints.gridx = 4;
        this.constraints.gridwidth = 1;
        this.constraints.gridy = 0;
        this.constraints.anchor = GridBagConstraints.NORTHEAST;

        this.add(this.scorePanel, this.constraints);
    }

    /**
     * Create the top player panel
     */
    private void createTopPlayerPanel() {
        this.topPlayerPanel = new TopPlayerPanel();

        // Set the layout options
        this.constraints.insets = new Insets(10, 10, 10, 10);
        this.constraints.gridx = 0;
        this.constraints.gridwidth = 3;
        this.constraints.gridy = 0;
        this.constraints.anchor = GridBagConstraints.NORTH;

        this.add(this.topPlayerPanel, this.constraints);
    }

    /**
     * Create the bottom player panel
     */
    private void createBottomPlayerPanel() {
        this.bottomPlayerPanel = new BottomPlayerPanel();

        // Set the layout options
        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        this.constraints.anchor = GridBagConstraints.SOUTH;

        this.add(this.bottomPlayerPanel, this.constraints);
    }
}
