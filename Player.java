public class Player {
    private int id;
    public Card[] hand;
    private int numOfCards;
    private Double score;
    private static final int JACK_CARD_NUMBER_VALUE = 11;

public Player(){
    this.id = 0;
    this.numOfCards = 0;
    this.score = 0.0;
    this.hand = new Card[7];
}

public Player(int parameter){
    this();
    this.id = parameter;
}

public void getID() {
    System.out.print(this.id);
}

public void getNumOfCards() {
System.out.print(this.numOfCards);
}

public int getCardAmount() {
    return this.numOfCards;
}

public Card getCard(int position) {
    Card cardToReturn = this.hand[position];
    this.hand[position] = null;
    this.numOfCards--;
    System.out.println("getCard(): returning:" +cardToReturn);
    return cardToReturn;
}

public String printHand() {
    String whatToPrint = "";
    for (int i = 0; i < this.getHandLength(); i++) {
        if (hand[i] != null) {
                whatToPrint += (i + 1) + ". " + hand[i].toString() + " ";
        }
    }
    return whatToPrint;
}

public Double getScore() {
    return this.score;
}

public void setScore(Double inte) {
    this.score += inte;
}

public void addCard(Card card) {
    int temporaryVariable = 0;
    while (temporaryVariable <= 5 && hand[temporaryVariable] != null) {
        temporaryVariable++;
    }
    this.hand[temporaryVariable] = card;
    numOfCards++;
}

public int findCard(Card card) {
    for (int i = 0; i < this.hand.length; i++) {
        //System.out.print("\n" + this.hand[i]);
        if (hand[i] != null ) {
            if (this.hand[i].getCardNumber() == card.getCardNumber()/* || this.hand[i].getCardSuit().equals(card.getCardSuit())*/) {
                return i;
            }else {
                if (this.hand[i].getCardNumber() == JACK_CARD_NUMBER_VALUE) {
                    return i;
                }
            }
        }
    }
    return -1;
}

public int getHandLength() {
    return this.hand.length;
}

public String toString() {
String stringToReturn = "";
    if (hand.length > 0) {
        for (int i = 0; i < this.hand.length; i++) {
            if (hand[i] != null) {
            stringToReturn = hand[i].getCardNum() + "|" + hand[i].getCardSuit() + ", ";
            }
        }
        return "The player has these cards, " + stringToReturn + ", this id " + id + ", and " + numOfCards + " cards";
    }
    return "The player has no cards, this id " + id;
}
}
