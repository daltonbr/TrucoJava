package rc.unesp.br.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the panel that will hold all the action buttons.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public class ButtonPanel extends JPanel {
    private JButton callTruco;
    private JButton foldButton;
    private Color backgroundColor = new Color(32, 120, 85);

    /**
     * Constructor of the class
     */
    ButtonPanel() {
        super();
        this.setInitialOpts();
        this.createCallTrucoButton();
        this.createFoldButton();
    }

    private void setInitialOpts() {
        this.setPreferredSize(new Dimension(GamePanel.DEFAULT_PANEL_WIDTH, GamePanel.DEFAULT_PANEL_HEIGHT));
        this.setBackground(backgroundColor);
    }

    /**
     * Create the call truco button
     */
    private void createCallTrucoButton() {
        this.callTruco = new JButton("Truco");
        this.setCallTrucoButtonOpts();
    }

    /**
     * Create the fold button
     */
    private void createFoldButton() {
        this.foldButton = new JButton("Fold");
        this.setFoldButtonOpts();
    }

    /**
     * Set the fold button layout options
     */
    private void setFoldButtonOpts() {
        // TODO
    }

    /**
     * Set the call truco button layout options
     */
    private void setCallTrucoButtonOpts() {
        // TODO
    }
}
