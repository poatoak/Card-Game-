public class Board {
public Deck deck;
public Player[] players = new Player[2];
private int playerCurrent = 0; 
public Card[] cardsOnBoard = new Card[52];
    public Board() {
        deck = new Deck();
        deck.shufflDeck(deck);
        players[0] = new Player(0);
        players[1] = new Player(1);
        for(int i = 0; i < 7; i++) {
            Card c = deck.drawACard();
            players[playerCurrent].addCard(c);
            changePlayer();
            c = deck.drawACard();
            players[playerCurrent].addCard(c);
            changePlayer();
        }
        for(int i = 51; i > 47; i--) {
            cardsOnBoard[i] = deck.drawACard();
        }
    }

    public void changePlayer() {
        if(this.playerCurrent == 0) {
            this.playerCurrent = 1;
        }else{
            this.playerCurrent = 0;
        }
    }

    public int getCurrentPlayer() {
        return playerCurrent;
    }

/*    public Card playComputerCard(){
    // Ξερή // collect all
     if (cardsOnBoard[51] != null && cardsOnBoard[50] == null) {
        System.out.println("here 1");
        int bestCardPosition = players[playerCurrent].hasCard(cardsOnBoard[51]);
        if (bestCardPosition != -1) {
            Card cardToPlay = players[1].getCard(bestCardPosition);
            System.out.println("AI playing card: " + cardToPlay);
            players[playerCurrent].setScore(10.0);
            cardsOnBoard[51] = null;
            return cardToPlay;
        }
     }
    //Normal    
    if (cardsOnBoard[51] != null) {
        System.out.println("here 2");
            int positionInCardsOnBoard = 0;
            int z = 51;
            while (cardsOnBoard[z] != null) {
                positionInCardsOnBoard = z;
                z--;
            }

        Card cardToPlay = null;
        if (players[playerCurrent].hasCard(cardsOnBoard[positionInCardsOnBoard]) != -1 ) {
            cardToPlay = players[1].getCard(players[1].hasCard(cardsOnBoard[positionInCardsOnBoard]));
        }else {
            Card jackCard = new Card(11,1);
            if (players[playerCurrent].hasCard(jackCard) != -1){
                cardToPlay = players[1].getCard(players[1].hasCard(jackCard));
            }
        }
        System.out.println("AI playing card: " + cardToPlay);
        if (cardToPlay != null) {   
            for (int i = positionInCardsOnBoard; i < cardsOnBoard.length; i++) {
                if (cardsOnBoard[i].getCardNumber() < 8) {
                    players[1].setScore(0.5);
                    cardsOnBoard[i] = null;
                }else {
                    players[1].setScore(1.0);
                    cardsOnBoard[i] = null;
                }
            }
            return cardToPlay;  
        } 
    }
        
        int range = 6 - 0 + 1;
        int res = (int) ( Math.random()*range)+0;
        Card cardToPlay = players[1].getCard(res);
        while (cardToPlay == null) {
                res = (int) ( Math.random()*range)+0;
                cardToPlay = players[1].getCard(res);
        }
        return cardToPlay;
}*/

    public int determineCard(Card cardToPlayFor) {
        //System.out.println(cardToPlayFor);
        if (cardToPlayFor != null) {
            //finds a card
            if (players[playerCurrent].findCard(cardToPlayFor) != -1) {
                return players[playerCurrent].findCard(cardToPlayFor);
            }
        }
        // places random card
        int range = 5 - 0 + 1;
        int res = (int) ( Math.random()*range)+0;
        Card cardToPlay = players[playerCurrent].hand[res];
        while (cardToPlay == null) {
                res = (int) ( Math.random()*range)+0;
                cardToPlay = players[1].getCard(res);
        }
        return res;
}

    public void playCard(int positionInHand) {
        Card d = players[playerCurrent].getCard(positionInHand);
        Card c = deck.drawACard();
        players[playerCurrent].addCard(c);
        if (topCard() != null) {
            if (d.getCardNumber() == topCard().getCardNumber() || d.getCardNumber() == 11) {
                for (int i = 51; i >= topCardPosition(); i--) {
                    //calculates score and makes the cards on board null
                    calculateScore(cardsOnBoard[i]);
                    cardsOnBoard[i] = null;
                }
                //sets card to be empty
                return;
            }
        }
        //slaps card on top

        cardsOnBoard[topCardPosition() - 1] = d;
        //System.out.println("Board:" + this);
    }

    public void calculateScore (Card input) {
        if (topCardPosition() == cardsOnBoard.length) {
            players[playerCurrent].setScore(10.00);
        } else {
            if (input.getCardNumber() < 8) {
                players[playerCurrent].setScore(0.5);
            } else {
                players[playerCurrent].setScore(1.00);
            }
        }
    }

 /*   public void playCardForHuman(Card playerCardThatThePlayerInputedFromTheirHand) {
        // if player played a Jack
        Card jackCard = new Card(11, 1);
        if (jackCard.getCardNumber() == playerCardThatThePlayerInputedFromTheirHand.getCardNumber()) {
            for (int i = 0; i < cardsOnBoard.length; i++) {
                if (cardsOnBoard[i] != null) {
                    if (cardsOnBoard[i].getCardNumber() <= 7) {
                        players[playerCurrent].setScore(0.5);;
                    }else{
                        players[playerCurrent].setScore(1.0);
                    }
                }
                cardsOnBoard[i] = null;
            }
            return;
        }
        // determine index of top card
        int position = 0;
        for (int i = 0; i < cardsOnBoard.length; i++) {
            if (cardsOnBoard[i] != null) {
                position = i;
                break;
            }
        }
        // check if top card matches player card
        if (cardsOnBoard[position].getCardNumber() == playerCardThatThePlayerInputedFromTheirHand.getCardNumber()) {
            // if only one card on the board, it's Xeri
            if (position == cardsOnBoard.length) {
                players[playerCurrent].setScore(10.00);
                cardsOnBoard[cardsOnBoard.length] = null;
            } else {
                // collect all cards on board
                for (int i = position; i < cardsOnBoard.length; i++) {
                    if (cardsOnBoard[i].getCardNumber() <= 7) {
                        players[playerCurrent].setScore(0.5);;
                    }else{
                        players[playerCurrent].setScore(1.0);
                    }
                    cardsOnBoard[i] = null;
                }
            }
            return;
        }

        // adds the card to the top of the deck 
        cardsOnBoard[position - 1] = playerCardThatThePlayerInputedFromTheirHand;
    }*/

    public Player[] getPlayer(){
        return players;
    }

    public String printCardsOnBoard() {
        String tmp = "";
        for (int i = 51; i > topCardPosition() -1; i--) {
            if (null != cardsOnBoard[i]) {
                tmp += " [" + i + "]=" + cardsOnBoard[i].toString();
            }
        }
        return tmp;
    }

    public String toString(){
        String whatToPrint = "__________________________\n";
        whatToPrint += "|    The Top Card Is     |\n|" + centerTopCard() + "|\n|                        |\n| The Number of cards is |\n|           " + numberOfSpaces() + "            |\n";
        whatToPrint += "|________________________|\n   You Have these Cards\n" + players[playerCurrent].printHand();
        return whatToPrint;
    }

    public Card topCard() {
        Card tempVar = null;
        for (int i = 0; i < cardsOnBoard.length; i++) {
            if (cardsOnBoard[i] != null) {
                tempVar = cardsOnBoard[i];
                break;
            }
        }
        return tempVar;
}

    public int topCardPosition() {
        for (int i = 0; i < cardsOnBoard.length; i++) {
            if (cardsOnBoard[i] != null) {
                return i;
            }
        }
        return 52;
    }

    public Boolean isPlayerAI(){
        if (playerCurrent == 1) {
            return true;
        }
        return false;
    }

    public String centerTopCard() {
        if (topCard() != null) {
            String whatToPrint = "";
            int temp = topCard().toString().length();
            if (temp % 2 != 1) {
                for (int i = 0; i < (24 - temp)/2; i++) {
                    whatToPrint += " ";
                }
                whatToPrint += topCard();
                for (int i = 0; i < (24 - temp)/2; i++) {
                    whatToPrint += " ";
                }
            } else {
                for (int i = 0; i < (24 - temp)/2; i++) {
                    whatToPrint += " ";
                }
                whatToPrint += topCard();
                for (int i = 0; i < (24 - temp)/2 + 1; i++) {
                    whatToPrint += " ";
                } 
            }
            return whatToPrint;
        }
        return "     No Card On Top     ";
    }

    public String whoWon(){
        if (players[1].getScore() > players[0].getScore()) {
            return "Player 2 is the winner by " + (players[1].getScore() - players[0].getScore()) + " points!!";
        }
        return "Player 1 is the winner by " + (players[0].getScore() - players[1].getScore()) +" points!!";
    }

    public String numberOfSpaces(){
        if (topCardPosition() - 1 < 9) {
            return (52 - topCardPosition()) + " ";
        }
        return (52 - topCardPosition()) + "";
    }

    public String toStringInfo() {
        String whatToPrint = "";
        whatToPrint += deck.toString();
        whatToPrint += players[0].toString();
        whatToPrint += players[1].toString();
        whatToPrint += this.toString();
        return whatToPrint;
    }
}
