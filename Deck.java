public class Deck {
    public static final int NUMBER_SUITS = 4;
    public static final int NUMBER_CARDS_IN_SUIT = 13;
    public Card[] theDeck;
    private int index;

    public Deck() {
        this.index = 0;
        this.theDeck  = new Card[52];
        int tempVar = 0;
        for (int suit = 0; suit < NUMBER_SUITS; suit++) {
            for (int cardValue = 0; cardValue < NUMBER_CARDS_IN_SUIT; cardValue++) {
                Card thisCard = new Card(cardValue, suit);
                theDeck[tempVar] = thisCard;
                tempVar ++;
            }
        }
    }

    public Card drawACard() {
        this.index ++;
        return this.theDeck[this.index - 1];
    }

    public Boolean isEmpty() {
        if (this.index == 51) {
            return true;
        }
        return false; 
    }

    public void shufflDeck(Deck inputDeck) {
        Card[] orderedCards = inputDeck.theDeck;
        Card[] shuffledCards = new Card[52];
        int range = 51 - 0 + 1;
        //Boolean checklist = false;
        //while (!checklist) {
            int randomPosition;
            for (int i = 0; i < shuffledCards.length; i++) {
                randomPosition = (int) ( Math.random()*range)+0;
                while (null == orderedCards[randomPosition]) {
                    randomPosition = (int) ( Math.random()*range)+0;
                }
                shuffledCards[i] = orderedCards[randomPosition];
                orderedCards[randomPosition] = null;
            }
        //}
        inputDeck.theDeck = shuffledCards;
    }
    
    // public Card cardAtPosition(int position) {
    //     return theDeck[position];
    // }

    // public void setCardDeck (int position, Card ca) {
    //     theDeck[position] = ca;
    // }

    public String toString() {
        String tmp = "There are " + (theDeck.length - index) + " cards remaining";
         for (int i = 0; i < theDeck.length - index; i++) {
             tmp += "\n deck[" + i + "]=" + theDeck[i].toString();        
         }
        return tmp;
    }

    public int getIndex() {
        return index;
    }
}
