package beans;

/**
 * Created by Bruno on 07/05/2016.
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
        return getRank().toString() + getSuit().toString();
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
    public int compareTo(Card _anotherCard){
        return this.isStrongerThan(_anotherCard) ? 1 : -1;
    }

}
