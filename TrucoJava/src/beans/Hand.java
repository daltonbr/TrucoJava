package beans;

import java.util.ArrayList;

/**
 * Created on 6/1/16 by:
 * Dalton Lima         github.com/daltonbr
 * Lucas Pinheiro      github.com/lucaspin
 * Bruno Vedovetto     github.com/bleandro
 */

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void addCard(Card _card) {
        if (_card != null)
            hand.add(_card);
    }

    public void showHand() {
        for(int i = 0; i < hand.size(); i++){
            System.out.println(hand.get(i));
        }

    }
    public int getHandSize() {
        return hand.size();
    }

    public Card getCard(int _position) {
        if (_position >= 0 && _position < hand.size())
            return (Card)hand.get(_position);
        else
            return null;
    }
}
