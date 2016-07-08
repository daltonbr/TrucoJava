package rc.unesp.br.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the view section of the app.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public class MiddlePanel extends JPanel {
    // TODO: Investigate which is the best component to hold the cards

    /**
     * Constructor of the class
     */
    MiddlePanel() {
        super();
        this.setInitialOpts();
    }

    private void setInitialOpts() {
        this.setPreferredSize(new Dimension(GamePanel.DEFAULT_PANEL_WIDTH, GamePanel.DEFAULT_PANEL_HEIGHT));
        this.setBackground(Color.CYAN);
    }
}