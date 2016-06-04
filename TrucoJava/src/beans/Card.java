package beans;

/**
 * Class to represent one card of the game.
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 * @author lucas Pinheiro @lucaspin
 */
public class Card implements Comparable<Card> {
    private Suit suit;
    private Rank rank;
    private boolean manilha;

    public Card(Rank _rank, Suit _suit, boolean _manilha){
        setSuit(_suit);
        setRank(_rank);
        setManilha(_manilha);
    }

    public boolean isManilha() {
        return manilha;
    }

    public void setManilha(boolean manilha) {
        this.manilha = manilha;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString(){
        return getRank().getValue() + getSuit().getValue() + isManilha();
    }

    public boolean isStrongerThan(Card _anotherCard){
        //THIS card IS Manilha but anotherCard ISNT
        if(this.isManilha() && !_anotherCard.isManilha())
            return true;
        //THIS card ISNT Manilha but anotherCard IS
        if(!this.isManilha() && _anotherCard.isManilha())
            return false;

        //BOTH cards are Manilha
        //So I just compare their suits
        if(this.isManilha() && _anotherCard.isManilha())
            return (this.getSuit().compareTo(_anotherCard.getSuit()) > 0);

        //If the code gets here, None of the cards are Manilha
        //So I just compare their ranks
        return (this.getRank().compareTo(_anotherCard.getRank()) > 0);
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
