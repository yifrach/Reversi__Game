package Main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReversiGameController extends MainMenuController implements Initializable, Notifier {
    @FXML
    private HBox root;
    @FXML
    private Circle currentPlayer;
    @FXML
    private Label p1Score;
    @FXML
    private Label p2Score;

    private ReversiBoardController reversiBoard;
    private GameManager manager;
    private ArrayList<Listener> listeners = new ArrayList<>();

    @Override
    /**
     * Initialzing our main GUI game
     */
    public void initialize(URL location, ResourceBundle resources) {
        // Setting up the game according to the users settings
        SettingsReader.readSettings("gameSettings.txt");
        Board board = new Board(SettingsReader.getBoardSize());
        Player p1 = new Player(1, SettingsReader.getP1Color());
        Player p2 = new Player(2, SettingsReader.getP2Color());
        BoardScanner scanner = new BoardScanner(board);
        this.manager = new GameManager(scanner, board, p1, p2);
        // Creating our GUI board within the game
        this.reversiBoard = new ReversiBoardController(scanner);
        this.addListener(this.manager);
        // Adding an event listener for each mouse click
        this.reversiBoard.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            // Converting it based on the click location
            Point point = converter(e.getX(), e.getY());
            // Sending it to the game manager
            this.madeMove(point.getX(), point.getY());
        });
        // Setting our GUI board to be dynamic
        root.getChildren().add(0, reversiBoard);
        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            double boardNewWidth = newValue.doubleValue() - 200;
            reversiBoard.setPrefWidth(boardNewWidth);
            reversiBoard.draw();
        });
        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            reversiBoard.setPrefHeight(newValue.doubleValue());
            reversiBoard.draw();
        });
        // Lastly displaying the players initial stats
        this.currentPlayer.setFill(p1.getPlayerColor());
        this.currentPlayer.setStrokeWidth(1);
        this.p1Score.setText("Player 1 Score: " + p1.getScore());
        this.p2Score.setText("Player 2 Score: " + p2.getScore());
    }

    /**
     * Converting our mouse click into a move.
     *
     * @param x - the clicks X position on screen.
     * @param y - the clocks Y position on screen.
     * @return - the corresponding Point on the board.
     */
    private Point converter(double x, double y) {
        int col = (int) (x / (reversiBoard.getPrefWidth() / reversiBoard.getBoardSize()));
        int row = (int) (y / (reversiBoard.getPrefHeight() / reversiBoard.getBoardSize()));
        return new Point(row + 1, col + 1);
    }

    @Override
    /**
     * Adding a listener.
     */
    public void addListener(Listener listen) {
        this.listeners.add(listen);
    }

    @Override
    /**
     * Removing a listener.
     */
    public void removeListener(Listener listen) {
        this.listeners.remove(listen);
    }

    @Override
    /**
     * Notyfing a move has been made.
     */
    public void madeMove(int row, int col) {
        for (Listener listener : this.listeners) {
            listener.clickMade(row, col);
        }
        // Redrawing the board based on the move
        this.reversiBoard.draw();
        // Displaying the game stats
        this.currentPlayer.setFill(this.manager.getCurrentPlayerColor());
        this.p1Score.setText("Player 1 Score: " + this.manager.getP1Score());
        this.p2Score.setText("Player 2 Score: " + this.manager.getP2Score());
    }
}
