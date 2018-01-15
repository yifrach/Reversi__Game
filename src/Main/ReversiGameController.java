package Main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.xml.stream.Location;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable, Notifier {
    @FXML
    private HBox root;
    @FXML
    private Label currentPlayer;
    @FXML
    private Label p1Score;
    @FXML
    private Label p2Score;
    private ReversiBoardController reversiBoard;
    private ArrayList<Listener> listeners = new ArrayList<>();
    private Player p1;
    private Player p2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SettingsReader.readSettings("gameSettings.txt");
        Board board = new Board(SettingsReader.getBoardSize());
        this.p1 = new Player(1, SettingsReader.getP1Color());
        this.p2 = new Player(2, SettingsReader.getP2Color());
        BoardScanner scanner = new BoardScanner(board);
        GameManager manager = new GameManager(scanner, board, this.p1, this.p2);
        this.reversiBoard = new ReversiBoardController(scanner);
        this.addListener(manager);
        this.reversiBoard.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            Point point = converter(e.getX(), e.getY());
            this.madeMove(point.getX(), point.getY());
        });

        root.getChildren().add(0, reversiBoard);
        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            double boardNewWidth = newValue.doubleValue() - 160;
            reversiBoard.setPrefWidth(boardNewWidth);
            reversiBoard.draw();
        });
        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            reversiBoard.setPrefHeight(newValue.doubleValue());
            reversiBoard.draw();
        });
        this.p1Score.setText("Player 1 Score: " + this.p1.getScore());
        this.p2Score.setText("Player 2 Score: " + this.p2.getScore());
    }


    private Point converter(double x, double y) {
        int col = (int) (x / (reversiBoard.getPrefWidth() / reversiBoard.getBoardSize()));
        int row = (int) (y / (reversiBoard.getPrefHeight() / reversiBoard.getBoardSize()));
        return new Point(row + 1, col + 1);
    }

    @FXML
    public void settingsWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
            Parent settingsRoot = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Reversi Main.Game Settings");
            stage.setScene(new Scene(settingsRoot));
            stage.show();
        } catch (Exception e) {
            System.out.println("Cannot open file");
        }
    }

    @FXML
    public void restartGame(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReversiGame.fxml"));
            Parent reversiGame = fxmlLoader.load();
            Scene scene = new Scene(reversiGame);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exitApp() {
        Platform.exit();
    }

    @Override
    public void addListener(Listener listen) {
        this.listeners.add(listen);
    }

    @Override
    public void removeListener(Listener listen) {
        this.listeners.remove(listen);
    }

    @Override
    public void madeMove(int row, int col) {
        for (Listener listener : this.listeners) {
            listener.clickMade(row, col);
        }
        this.reversiBoard.draw();
        this.currentPlayer.setText("Current player:");
        this.p1Score.setText("Player 1 Score: " + this.p1.getScore());
        this.p2Score.setText("Player 2 Score: " + this.p2.getScore());
    }
}
