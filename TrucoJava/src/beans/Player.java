package beans;

/**
 * Created on 6/1/16 by:
 * Dalton Lima         github.com/daltonbr
 * Lucas Pinheiro      github.com/lucaspin
 * Bruno Vedovetto     github.com/bleandro
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
