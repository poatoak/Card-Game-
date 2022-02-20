import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(testWhoWon());
//        testBoardCreator();
        Scanner scnr = new Scanner(System.in);
        Board board = new Board();
        while(!board.deck.isEmpty()) {
                if (board.isPlayerAI()) {
                    board.playCard(board.determineCard(board.topCard()));
                } else {
                    System.out.println(board.toString());
                    System.out.println("It is your turn, what card in your hand would you like to play (insert a nmumber)");
                    int cardToPlayFromPlayer = scnr.nextInt() - 1;
                    board.playCard(cardToPlayFromPlayer);
                }
                //System.out.println("after play: hand: " +  board.players[board.getCurrentPlayer()].printHand());
                board.changePlayer();
        }
        System.out.print(board.whoWon());
        scnr.close();
    }

    public static Boolean testPlayCard() {
        Board boardTwo = new Board();
        Card card = boardTwo.players[boardTwo.getCurrentPlayer()].hand[6];
        boardTwo.playCard(6);
        return card !=  boardTwo.players[boardTwo.getCurrentPlayer()].hand[6];
    }
    public static void testTopCard() {
        Board boardTwo = new Board();
        System.out.print(boardTwo.topCard());
    }
    public static void testCenterTopCard() {
        Board boardTwo = new Board();
        System.out.println(boardTwo.centerTopCard());
    }
    public static String testWhoWon() {
        Board boardTwo = new Board();
        return boardTwo.whoWon();
    }
    public static String testToStringBoard(){
        Board boardTwo = new Board();
        return boardTwo.toString();
    }
    public static Double testCalculateScore(){
        Board boardTwo = new Board();
        System.out.print(boardTwo.deck.theDeck[3]);
        boardTwo.calculateScore(boardTwo.deck.theDeck[3]);
        return boardTwo.players[boardTwo.getCurrentPlayer()].getScore();
    }
    public static int testDetermineCard(Card card){
    Board boardTwo = new Board();
    System.out.print(boardTwo.players[1].printHand());
    return boardTwo.determineCard(card);
    }
    public static String testPrintCardsOnBoard() {
    Board boardTwo = new Board();
    System.out.print(boardTwo.toString());
    return boardTwo.printCardsOnBoard();
    }
    public static Boolean testIsPlayerAI() {
    Board boardTwo = new Board();
    System.out.print(boardTwo.getCurrentPlayer());
    return boardTwo.isPlayerAI();
    }
    public static Boolean testGetCurrentPlayer() {
    Board boardTwo = new Board();
    return boardTwo.getCurrentPlayer() == 0;
    }
    public static String testNumberOfSpaces() {
    Board boardTwo = new Board();
    return boardTwo.numberOfSpaces() + boardTwo.toString();
    }
    public static Boolean testChangePlayer() {
    Board boardTwo = new Board();
    boardTwo.changePlayer();
    return boardTwo.getCurrentPlayer() == 1;
    }
    public static Player[] testGetPlayer() {
    Board boardTwo = new Board();
    return boardTwo.getPlayer();
    }
    public static Boolean testTopCardPosition() {
    Board boardTwo = new Board();
    return boardTwo.topCardPosition() == 48;
    }
    public static void testBoardCreator() {
    Board boardTwo = new Board();
    System.out.print(boardTwo.toStringInfo());
    }
}