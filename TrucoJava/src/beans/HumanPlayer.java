package beans;

/**
 * Class to represent a human player.
 * @author Dalton Lima @daltonbr
 * @author lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 */
public class HumanPlayer extends Player {

    /**
     * Constructor of the class
     */
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void chooseCard() {
        // Here, we must order the main thread to wait until the player
        // has clicked on a card
    }
}
