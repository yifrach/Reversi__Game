package Main;

import javafx.scene.paint.Color;

public class GameManager implements Listener {
    private Board board;
    private BoardScanner scanner;
    private Flip flip;
    private int currentPlayer;
    private Player player1;
    private Player player2;

    /**
     * Constructor for our game manager.
     *
     * @param scanner - the boards scanner.
     * @param board - the game board.
     * @param player1 - our first player.
     * @param player2 - our second player.
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
     * Play a single turn of the game placing a single validated disk
     * on the board, flipping appropriate disks
     *
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

    /**
     * Responding to a players turn in current cell.
     *
     * @param row - the cells row.
     * @param col - the cells column.
     */
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
        // Lastly updating both player scores
        this.player1.updateScore(scanner.getDisksScore(1));
        this.player2.updateScore(scanner.getDisksScore(2));
    }

    /**
     * Getter for the first players score.
     *
     * @return - the first players score.
     */
    public int getP1Score() {
        return this.player1.getScore();
    }

    /**
     * Getter for the second players score.
     *
     * @return - the second players score.
     */
    public int getP2Score() {
        return this.player2.getScore();
    }

    /**
     * Getter for our current players color.
     *
     * @return - our current players color.
     */
    public Color getCurrentPlayerColor() {
        if (this.currentPlayer == 1) {
            return this.player1.getPlayerColor();
        } else {
            return this.player2.getPlayerColor();
        }
    }

}
