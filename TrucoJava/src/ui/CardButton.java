package ui;

import beans.Rank;
import beans.Suit;

import javax.swing.*;

/**
 * Class for the bottom panel of the application.
 * @author lucas Pinheiro @lucaspin
 */
public class CardButton extends JButton {
    private Rank rank;
    private Suit suit;
    private boolean manilha;

    /**
     * Constructor of the class
     * @param name {String}
     */
    CardButton(String name) {
        super(name);
        this.setFocusable(false);
    }

    public void setRank(Rank _rank) {
        this.rank = _rank;
    }

    public void setSuit(Suit _suit) {
        this.suit = _suit;
    }

    public void setManilha(boolean _b) {
        this.manilha = _b;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public boolean isManilha() {
        return this.manilha;
    }
}
