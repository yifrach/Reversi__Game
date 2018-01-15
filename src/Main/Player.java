package Main;

import javafx.scene.paint.Color;

import java.util.Scanner;

public class Player {
    private int playerNum;
    private Color color;
    private int score;
    private Print movesPrint;

    /**
     * The constructor of the class
     */
    public Player(int playerNum, Color color) {
        this.playerNum = playerNum;
        this.color = color;
        this.score = 2;
    }

    /**
     * Getter for our players score
     *
     * @return - an Integer  that represent the color of the player
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Updating our players score to updatedScore
     *
     * @param updatedScore - an Integer that repersent the update score
     */
    public void updateScore(int updatedScore) {
        this.score = updatedScore;
    }

    /**
     * Getter for our players color
     *
     * @return - an Integer that represent the color of the player
     */
    public int getPlayerNum() {
        return this.playerNum;
    }

//    /**
//     * Setter for our players color
//     *
//     * @param newColor - an Integer that represent the new color of the player
//     */
//    public void setColor(int newColor) {
//        this.color = newColor;
//    }

    public Color getPlayerColor() {
        return this.color;
    }
    /**
     * The method get a Main.Board, get a move from the user and return a Main.Point
     *
     * @param board - a variable from type Main.Board
     * @return - a Main.Point that represent the player move
     */
    public Point playTurn(Board board) {
        Scanner rowAndCol;
        BoardScanner scanner = new BoardScanner(board);
        this.movesPrint = new MovesPrint(scanner, this.playerNum);
        scanner.scanBoard(this.playerNum);
        // We'll print them to the screen asking for an input
        movesPrint.print();
        rowAndCol = new Scanner(System.in);
        return new Point(rowAndCol.nextInt(), rowAndCol.nextInt());
    }

    /**
     * The method pass the turn of the player
     *
     * @return - a Main.Point that represent that the user had no move.
     */
    public Point passTurn() {
        // If the player has no moves we'll inform him passing the turn back
        String str = "No possible moves! Play passes back to the other player.\n\n";
        StringPrint stringPrint = new StringPrint(str);
        stringPrint.print();
        return new Point(-1, -1);
    }
}
