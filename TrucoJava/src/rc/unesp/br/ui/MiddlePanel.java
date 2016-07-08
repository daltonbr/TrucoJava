package rc.unesp.br.ui;

import rc.unesp.br.beans.Card;
import rc.unesp.br.controllers.GameController;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Class for the view section of the app.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public class MiddlePanel extends JPanel {
    // TODO: Investigate which is the best component to hold the cards
    private java.util.List<JButton> cards = new ArrayList<>();
    private GameController controller;
    private Color backgroundColor = new Color(0, 120, 0);


    /**
     * Constructor of the class
     */
    MiddlePanel() {
        super();
        this.setInitialOpts();
    }

    private void setInitialOpts() {
        this.setPreferredSize(new Dimension(GamePanel.DEFAULT_PANEL_WIDTH, GamePanel.DEFAULT_PANEL_HEIGHT));
        this.setBackground(backgroundColor);
    }

    public void setCards(List<Card> cards) {
        this.removeOldCardsFromPanel();

        for (Card card : cards) {
            CardButton newCardButton = new CardButton(card, false);
            newCardButton.setRank(card.getRank());
            newCardButton.setSuit(card.getSuit());
            newCardButton.setManilha(card.isManilha());

//            newCardButton.addActionListener(e -> {
//                CardButton cardButtonClicked = (CardButton) e.getSource();
//                cardButtonClicked.setEnabled(false);
//                this.controller.setChosenCardForHumanPlayer(cardButtonClicked.getSuit(),
//                        cardButtonClicked.getRank(),
//                        cardButtonClicked.isManilha());
//            });

            this.cards.add(newCardButton);
        }

        this.addNewCardsToPanel();
    }


    private void removeOldCardsFromPanel() {
        for (JButton buttonCard : this.cards) {
            this.remove(buttonCard);
        }

        this.cards.clear();
    }

    private void addNewCardsToPanel() {
        for (JButton cardButton : this.cards) {
            this.add(cardButton);
        }
    }
}