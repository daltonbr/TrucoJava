package rc.unesp.br.beans;

/**
 * Enum to hold the suit values for a card.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public enum Suit {
    DIAMONDS("d"),
    SPADES("s"),
    HEARTS("h"),
    CLUBS("c");

    private String value;

    Suit(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
