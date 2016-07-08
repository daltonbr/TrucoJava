package rc.unesp.br.ui;

import rc.unesp.br.beans.Card;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Class for the top panel of the application.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public class TopPlayerPanel extends JPanel {
    private List<JButton> cards = new ArrayList<>();
    private Color backgroundColor = new Color(0, 120, 0);

    /**
     * Constructor of the class
     */
    TopPlayerPanel() {
        super();
        this.setInitialOpts();
    }

    private void removeOldCardsFromPanel() {
        for (JButton buttonCard : this.cards) {
            this.remove(buttonCard);
        }

        this.cards.clear();
    }

    // TODO: put this code in a common place
    public void setCards(List<Card> cards) {
        this.removeOldCardsFromPanel();

        for (Card card : cards) {
            CardButton newCardButton = new CardButton(card, true);
            this.cards.add(newCardButton);
        }

        this.addNewCardsToPanel();
    }

    private void addNewCardsToPanel() {
        for (JButton cardButton : this.cards) {
            this.add(cardButton);
        }
    }

    private void setInitialOpts() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(GamePanel.DEFAULT_PANEL_WIDTH, GamePanel.DEFAULT_PANEL_HEIGHT));
        this.setBackground(backgroundColor);
    }
}
