package rc.unesp.br.ui;

import rc.unesp.br.beans.Card;
import rc.unesp.br.beans.Rank;
import rc.unesp.br.beans.Suit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
     * @param card {String}
     * @param faceDown {Boolean}
     */
    CardButton(Card card, boolean faceDown) {
        super(card.toString());
        this.setFocusable(false);
        try {

            String source;

            if (!faceDown) {
                source = card.getImageSource();
            } else {
                source = Card.BACK_CARD_IMAGE_SOURCE;
            }

            Image cardImage = ImageIO.read(getClass().getResource(source));
            Image scaledImage = cardImage.getScaledInstance(70, 100, Image.SCALE_SMOOTH);
            super.setIcon(new ImageIcon(scaledImage));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // half size
        //super.setPreferredSize(new Dimension(70,95));
        super.setBorder(null);
        super.setText(null);

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
