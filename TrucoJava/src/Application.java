import rc.unesp.br.controllers.GameController;
import rc.unesp.br.ui.MainView;

import javax.swing.*;
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
        mainView.setBottomPanelController(gameController);
        mainView.setVisible(true);

        // Finish the program when the user closes the window
        mainView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                e.getWindow().dispose();
                System.exit(0);
            }
        });

        // Set the view and init the game
        gameController.setView(mainView);
        gameController.initGame();

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to play again?",
                                                         "End Game", JOptionPane.YES_NO_OPTION);

        while (dialogResult == JOptionPane.YES_OPTION) {
            gameController.resetGame();
            dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to play again?",
                                                         "End Game", JOptionPane.YES_NO_OPTION);
        }

        mainView.dispatchEvent(new WindowEvent(mainView, WindowEvent.WINDOW_CLOSING));
    }
}
