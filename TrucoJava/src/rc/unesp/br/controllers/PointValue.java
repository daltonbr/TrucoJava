package rc.unesp.br.controllers;

/**
 * Class that represents a round of a point of the game.
 * @author Lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 * @author Dalton Lima @daltonbr
 */
public enum PointValue {
    ONE(1),
    THREE(3),
    SIX(6),
    NINE(9),
    TWELVE(12);

    private int value;

    PointValue(int _value) {
        this.value = _value;
    }

    public int getValue() {
        return this.value;
    }
}
