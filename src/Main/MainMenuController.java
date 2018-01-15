package Main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    /**
     * Starting our game, opening our game within the same window.
     */
    protected void startGame(ActionEvent event) {
        try {
            // Loading our game fxml and displaying it
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReversiGame.fxml"));
            Parent reversiGame = fxmlLoader.load();
            Scene scene = new Scene(reversiGame);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    /**
     * Opening our settings window.
     */
    protected void settingsWindow() {
        try {
            // Loading our settings fxml displaying it in a new window
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
            Parent settingsRoot = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Reversi Game Settings");
            stage.setScene(new Scene(settingsRoot));
            // Making sure our user deals with the settings before starting the game
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    /**
     * Exiting our app.
     */
    public void exitApp() {
        Platform.exit();
    }
}
