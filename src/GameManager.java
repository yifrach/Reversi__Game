public class GameManager {
    private int wall;
    private Board board;
    private BoardScanner scanner;
    private Flip flip;

    /**
     * The constructor of the class
     * @param scanner - a BoardScanner
     * @param board - a Board
     */
    public GameManager(BoardScanner scanner, Board board) {
        this.scanner=scanner;
        this.board=board;
        this.wall=this.board.getSize();
        this.flip = new Flip(board);
    }

    /**
     * Play a single turn of desired color for a player that it got
     * @param player - a Player that we want to play a turn with
     * @return - a Point that represent of we played a turn or not
     */
    public Point playOneTurn(Player player) {
        // First freeing our previous turns moves list
        scanner.freeMovesList();
        // If the player has any moves
        if (scanner.hasMoves(player.getColor())) {
            Point p=player.playTurn(board);
            // Adding the cell to the board
            if(p.getX()>0) {
                board.addCell(p.getX(), p.getY(), player.getColor());
                // Flipping the board according to the added cell
                this.flip.flipBoard(p.getX(), p.getY(), player.getColor());
            }
            scanner.freeMovesList();
            return p;
        } else {
            player.passTurn();
            return new Point(-1,-1);
        }
    }
}
