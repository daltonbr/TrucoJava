import beans.*;
import ui.MainView;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Bruno Vedovetto @bleandro
 * @author Lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 */
public class Application {
    public static void main(String args[]) {
        // Create the main controller
        GameController gameController = new GameController();

        MainView mainView = new MainView();
        mainView.setVisible(true);

        // Set the view and init the game
        gameController.setView(mainView);
        gameController.initGame();

        // Finish the program when the user closes the window
        mainView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                e.getWindow().dispose();
            }
        });
    }
}
