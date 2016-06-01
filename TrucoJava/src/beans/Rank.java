package beans;

/**
 * Created by Bruno on 07/05/2016.
 */
public enum Rank {
    Four, Five, Six, Seven, Queen, Jacks, King, Ace, Two, Three;

    @Override
    public String toString() {
        switch (this){
            case Four: return "4";
            case Five: return "5";
            case Six: return "6";
            case Seven: return "7";
            case Queen: return "Q";
            case Jacks: return "J";
            case King: return "K";
            case Ace: return "A";
            case Two: return "2";
            case Three: return "3";
        }

        return "ERROR";
    }
}
