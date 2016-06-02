package beans;

import java.util.ArrayList;

/**
 * Created on 6/1/16 by:
 * Dalton Lima         github.com/daltonbr
 * Lucas Pinheiro      github.com/lucaspin
 * Bruno Vedovetto     github.com/bleandro
 */

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card _card) {
        if (_card != null)
            cards.add(_card);
    }

    public Card drawCard(int _index) throws IndexOutOfBoundsException {
        Card card = this.cards.get(_index);
        cards.remove(_index);
        return card;
    }

    public void showHand() {
        for(int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i));
        }
    }

    public int getHandSize() {
        return cards.size();
    }

    public Card getCard(int _position) throws IndexOutOfBoundsException {
        return cards.get(_position);
    }

    public void resetHand() {
        this.cards.clear();
    }
}
