package beans;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class to represent a human player.
 * @author Dalton Lima @daltonbr
 * @author lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 */
public class HumanPlayer extends Player {
    static Thread threadObject;
    private AtomicBoolean choosingCard = new AtomicBoolean(false);

    /**
     * Constructor of the class
     */
    public HumanPlayer(String name, List<Card> cards) {
        super(name, cards);
    }

    @Override
    public void chooseCard() {
        // Here, we must order the main thread to wait until the player
        // has clicked on a card, choosing it
        this.setChoosingCard(true);

        Runnable runnable = () -> {
            if (this.isChoosingCard().get()) {
                synchronized (threadObject) {
                    try {
                        threadObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        threadObject = new Thread(runnable);
        threadObject.start();
    }

    synchronized public void setChoosingCard(boolean _choosingCard) {
        this.choosingCard.set(_choosingCard);
    }

    public AtomicBoolean isChoosingCard() {
        return this.choosingCard;
    }

}
