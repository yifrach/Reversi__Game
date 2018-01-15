package Main;

import java.util.Scanner;

public class GameManager implements Listener {
    private Board board;
    private BoardScanner scanner;
    private Flip flip;
    private int currentPlayer;
    private Player player1;
    private Player player2;

    /**
     * The constructor of the class
     *
     * @param scanner - a Main.BoardScanner
     * @param board   - a Main.Board
     */
    public GameManager(BoardScanner scanner, Board board, Player player1, Player player2) {
        this.scanner = scanner;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.flip = new Flip(board);
        this.currentPlayer = 1;
        this.scanner.scanBoard(this.player1.getPlayerNum());
    }


    /**
     * Play a single turn of the game placing a single disk and flipping corresponding disks
     * @param row - the disks row
     * @param col - the disks column
     * @param playerNum - the players number
     */
    private void playOneTurn(int row, int col, int playerNum) {
        board.addCell(row, col, playerNum);
        // Flipping the board according to the added cell
        this.flip.flipBoard(row, col, playerNum);
        scanner.freeMovesList();
    }


    public void clickMade(int row, int col) {
        this.scanner.scanBoard(this.currentPlayer);
        // If the current player has a valid move
        if (scanner.isValidMove(row, col)) {
            // He'll play it
            this.playOneTurn(row, col, this.currentPlayer);
            // If the next player has any moves
            if (scanner.hasMoves(3 - this.currentPlayer)) {
                // Then he's the current player
                this.currentPlayer = 3 - this.currentPlayer;
            }
        }
        this.player1.updateScore(scanner.getDisksScore(1));
        this.player2.updateScore(scanner.getDisksScore(2));
    }

    //    public void clickMade(int row, int col) {
//        if (this.firstPlayerTurn) {
//            this.scanner.scanBoard(this.player1.getPlayerNum());
//            if (this.playOneTurn(row, col, this.player1)) {
//                if(this.scanner.hasMoves(this.player2.getPlayerNum())) {
//                    this.firstPlayerTurn = false;
//                } else {
//                    scanner.freeMovesList();
//                    this.scanner.scanBoard(this.player2.getPlayerNum());
//                }
//            }
//        } else {
//            this.scanner.scanBoard(this.player2.getPlayerNum());
//            if (this.playOneTurn(row, col, this.player2)) {
//                if(this.scanner.hasMoves(this.player1.getPlayerNum())) {
//                    this.firstPlayerTurn = true;
//                } else {
//                    scanner.freeMovesList();
//                    this.scanner.scanBoard(this.player2.getPlayerNum());
//                }
//            }
//        }
//        this.player1.updateScore(scanner.getDisksScore(1));
//        this.player2.updateScore(scanner.getDisksScore(2));
//    }

}
