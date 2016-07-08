package rc.unesp.br.beans;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Class to represent one card of the game.
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 * @author lucas Pinheiro @lucaspin
 */
public class Card implements Comparable<Card> {
    public static final String BACK_CARD_IMAGE_SOURCE = "/rc/unesp/br/resources/cardBack_red3.png";
    static final String IMAGE_BASE_URI = "/rc/unesp/br/resources/";

    private Suit suit;
    private Rank rank;
    private boolean manilha;
    private String imageSource;

    /**
     * Constructor of the class
     * @param _rank {Rank}
     * @param _suit {Suit}
     * @param _manilha {Boolean}
     */
    public Card(Rank _rank, Suit _suit, boolean _manilha){
        setSuit(_suit);
        setRank(_rank);
        setManilha(_manilha);
        this.setImageSource(IMAGE_BASE_URI + this.toString() + ".png");
    }

    /**
     * Get the image source for a card
     * @return {String}
     */
    public String getImageSource() {
        return this.imageSource;
    }

    /**
     * Set the image source for a card
     * @param _imageSource {String}
     */
    public void setImageSource(String _imageSource) {
        this.imageSource = _imageSource;
    }

    /**
     * Check if a card is manilha
     * @return {Boolean}
     */
    public boolean isManilha() {
        return manilha;
    }

    /**
     * Set the image source for the standard Back Card
     */
    public void setBackCardImageSource() {this.imageSource = BACK_CARD_IMAGE_SOURCE;}

    /**
     * Set if a card is a manilha
     * @param manilha {Boolean}
     */
    public void setManilha(boolean manilha) {
        this.manilha = manilha;
    }

    /**
     * Return the suit of the card
     * @return {Suit}
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Set the suit of the card
     * @param suit {Suit}
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Return the rank of the card
     * @return {Rank}
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Set the rank of the card
     * @param rank {Rank}
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString(){
        return getRank().getValue() + getSuit().getValue();
    }

    /**
     * Checks if a card is stronger than another
     * @param _anotherCard {Card}
     * @return {Boolean}
     */
    public boolean isStrongerThan(Card _anotherCard){
        // THIS card IS Manilha but anotherCard ISN'T
        if(this.isManilha() && !_anotherCard.isManilha())
            return true;

        // THIS card ISN'T Manilha but anotherCard IS
        if(!this.isManilha() && _anotherCard.isManilha())
            return false;

        // BOTH cards are Manilha
        // So I just compare their suits
        if(this.isManilha() && _anotherCard.isManilha())
            return (this.getSuit().compareTo(_anotherCard.getSuit()) > 0);

        // If the code gets here, None of the cards are Manilha
        // So I just compare their ranks
        return (this.getRank().compareTo(_anotherCard.getRank()) > 0);
    }

    static public Card getFacedDownCard() {
        Card card = new Card(Rank.Ace, Suit.CLUBS, false);
        card.setBackCardImageSource();
        return card;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (!Card.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        //final Card thisCard = (Card) this;
        final Card anotherCard = (Card) obj;
        return (!this.isStrongerThan(anotherCard) && !anotherCard.isStrongerThan(this));
    }

    @Override
    public int compareTo(Card _anotherCard){
        return this.isStrongerThan(_anotherCard) ? 1 : -1;
    }

}
