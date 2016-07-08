package rc.unesp.br.beans;

/**
 * Class to represent a CPU player
 * @author Dalton Lima @daltonbr
 * @author lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 */
public class CPUPlayer extends Player {

    /**
     * Constructor of the class
     * @param name {String}
     */
    public CPUPlayer(String name) {
        super(name);
    }

    @Override
    public void chooseCard() {
        // Here, we just apply a sequential method to choose a card.
        // Initially, we just get the first card there
        this.setCurrentChosenCard(this.getHand().drawNextCard());
    }
}
