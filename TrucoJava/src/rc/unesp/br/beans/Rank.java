package rc.unesp.br.beans;

/**
 * Enum to hold the rank values for a card.
 * @author lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 */
public enum Rank {
    Four("4"),
    Five("5"),
    Six("6"),
    Seven("7"),
    Queen("Q"),
    Jack("J"),
    King("K"),
    Ace("A"),
    Two("2"),
    Three("3");

    private String value;

    Rank(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public Rank getNext() {
        return this.ordinal() < Rank.values().length - 1
                ? Rank.values()[this.ordinal() + 1]
                : Four;
    }

}
