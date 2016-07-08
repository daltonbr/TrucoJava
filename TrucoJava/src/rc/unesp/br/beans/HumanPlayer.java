package rc.unesp.br.beans;

/**
 * Class to represent a human player.
 * @author Dalton Lima @daltonbr
 * @author lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 */
public class HumanPlayer extends Player {
    private Boolean choosingCard = false;

    /**
     * Constructor of the class
     */
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void chooseCard() {
        // Here, we must order the main thread to wait until the player
        // has clicked on a card, choosing it
        this.setChoosingCard(true);

        //Waits while the User is choosing the card
        while (this.isChoosingCard()) {
            try {
                new Thread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setChoosingCard(boolean _choosingCard) {
        this.choosingCard = _choosingCard;
    }

    public Boolean isChoosingCard() {
        return this.choosingCard;
    }

}
