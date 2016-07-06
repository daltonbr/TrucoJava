package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for the bottom panel of the application.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public class BottomPlayerPanel extends JPanel {
    private List<JButton> cards = new ArrayList<>();

    /**
     * Constructor of the class
     */
    public BottomPlayerPanel() {
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
    public void setCards(List<beans.Card> cards) {
        this.removeOldCardsFromPanel();

        for (beans.Card card : cards) {
            JButton newCardButton = new JButton();
            newCardButton.setText(card.toString());
            newCardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO: choose card clicked
                }
            });

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
        this.setPreferredSize(new Dimension(GamePanel.DEFAULT_PANEL_WIDTH, GamePanel.DEFAULT_PANEL_HEIGHT));
        this.setBackground(Color.WHITE);
    }
}