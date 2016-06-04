package beans;

import ui.*;
import java.awt.event.*;

/**
 * @author Bruno Vedovetto @bleandro
 * @author Lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 */
public class GameController {

    /**
     * Constructor of the class
     */
    public GameController() {
        MainView mainView = new MainView();
        mainView.setVisible(true);
        this.setWindowClosingHandler(mainView);
    }

    /**
     * Sets the handler for when the window closes
     * @param mainView {MainView} the main frame of the application
     */
    private void setWindowClosingHandler(MainView mainView) {
        mainView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                e.getWindow().dispose();
            }
        });
    }
}
