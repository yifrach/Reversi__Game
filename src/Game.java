import java.util.Scanner;

public class Game {
    private Board board;
    private BoardScanner scanner;
    private GameManager manager;
    private Player player1;
    private Player player2;
    private Print boardPrint;
    private Print stringPrint;

    /**
    * The constructor of the class
    */
    Game() {}

    /**
     * The method initialize- choose a mode and initialize by this mode
     */
    void initialize() {
        initializePlayers();
        String str="Enter the size of the board: ";
        this.stringPrint= new StringPrint(str);
        this.stringPrint.print();
        // the size of the board
        Scanner size= new Scanner(System.in);
        this.board = new Board(size.nextInt());
        this.scanner = new BoardScanner(board);
        this.manager = new GameManager(scanner, board);
        this.boardPrint=new BoardPrint(board);
    }

    /**
     * The method initialize the players by the mode that the user want
     */
    void initializePlayers() {
        String str="WELCOME TO REVERSI!\n\n";
        this.stringPrint=new StringPrint(str);
        this.stringPrint.print();
        this.player1 = new Player();
        this.player1.setColor(CellColor.firstPlayer);
        this.player2 = new Player();
        this.player2.setColor(CellColor.secondPlayer);
    }

    /**
     * The method play the game by the mode that the user had chosen
     */
    void playGame() {
        String str;
        //playing the game while each player has a possible move
        playHuman();
        //lastly printing the board
        this.boardPrint.print();
        //announcing the winner
        int p1score = scanner.getDisksScore(CellColor.secondPlayer);
        this.player1.updateScore(p1score);
        int p2score = scanner.getDisksScore(CellColor.firstPlayer);
        this.player2.updateScore(p2score);
        if (this.player2.getScore() > this.player1.getScore()) {
            str="Player X is the winner with \n" + this.player2.getScore() + " disks!\nCongratulations!\n";
        } else {
            str="Player O is the winner with \n" + this.player1.getScore() + " disks!\nCongratulations!\n";
        }
        this.stringPrint=new StringPrint(str);
        this.stringPrint.print();
    }

    /**
     * The method play the game by the mode of human against human
     */
    void playHuman() {
        boolean blackPlayed = false;
        while (this.scanner.hasMoves(CellColor.firstPlayer) || this.scanner.hasMoves(CellColor.secondPlayer)) {
            this.boardPrint.print();
            if (blackPlayed) {
                this.manager.playOneTurn(player2);
                blackPlayed = false;
            } else {
                this.manager.playOneTurn(player1);
                blackPlayed = true;
            }
        }
    }

}
