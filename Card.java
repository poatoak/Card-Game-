public class Card {
    private int cardNum;
    private int cardSuit;
    public static final String[] NUM = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] SUIT = {"Spade", "Heart", "Club", "Diamond"};


    public Card () {        
    this.cardNum = 0;
    this.cardSuit=0;
    }
    public Card (int cardNumInput, int cardSuitInput) {
        this.cardNum = cardNumInput;
        this.cardSuit = cardSuitInput;
    }

    public String getCardNum () {
        return  NUM[cardNum];
    }

    public int getCardNumber() {
        return cardNum + 1;
    }
    public void setCardNum (int cardNumInput) {
        this.cardNum = cardNumInput;
    }

    public String getCardSuit () {
        return SUIT[cardSuit];
    }
    public void setCardSuit (int cardSuitInput) {
    this.cardSuit = cardSuitInput;
    }

    public String toString () {
        return this.getCardNum() + " " + this.getCardSuit();
    }
}
