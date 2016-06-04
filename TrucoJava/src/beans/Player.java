package beans;

/**
 * Class to represent a player of the game.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public class Player {
    private String name;
    private Hand hand;

    public Player() {
        this.hand = null;
        this.name = "UnnamedPlayer";
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

    public void setHand(Hand h) { this.hand = h; }

    public void getHand() { hand.showHand(); }
}
