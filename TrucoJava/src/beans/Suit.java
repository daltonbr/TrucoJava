package beans;

import org.jetbrains.annotations.Contract;

/**
 * Created by Bruno on 07/05/2016.
 */
public enum Suit {
    Diamonds, Spades, Hearths, Clubs;

    @Override
    public String toString(){
        switch (this){
            case Diamonds: return "♦";
            case Spades: return "♠";
            case Hearths: return "♥";
            case Clubs: return "♣";
        }

        return "ERROR";
    }
}
