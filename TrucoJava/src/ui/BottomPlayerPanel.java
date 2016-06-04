package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the bottom panel of the application.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public class BottomPlayerPanel extends JPanel {
    // TODO: Investigate which is the best component to hold the cards

    /**
     * Constructor of the class
     */
    BottomPlayerPanel() {
        super();
        this.setInitialOpts();
    }

    private void setInitialOpts() {
        this.setPreferredSize(new Dimension(GamePanel.DEFAULT_PANEL_WIDTH, GamePanel.DEFAULT_PANEL_HEIGHT));
        this.setBackground(Color.WHITE);
    }
}