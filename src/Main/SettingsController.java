package Main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    @FXML
    private Slider sliderBoardSize;
    @FXML
    private ColorPicker player1Color;
    @FXML
    private ColorPicker player2Color;
    @FXML
    private Button saveButton;
    @FXML
    private Label warningLabel;

    @FXML
    @Override
    /**
     * Initialzing our setting window.
     */
    public void initialize(URL location, ResourceBundle resources) {
        // Reading the gameSettings file
        SettingsReader.readSettings("gameSettings.txt");
        // Defaulting the game settings appropriately
        this.sliderBoardSize.setValue(SettingsReader.getBoardSize());
        this.player1Color.setValue(SettingsReader.getP1Color());
        this.player2Color.setValue(SettingsReader.getP2Color());
    }

    @FXML
    /**
     * Saving our users settings into the file.
     */
    public void saveSettings() {
        // If both players colors not the same we'll save the settings
        if (!this.player1Color.getValue().toString().equals(this.player2Color.getValue().toString())) {
            try {
                FileWriter fileWriter = new FileWriter("gameSettings.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                // Writing the users settings
                bufferedWriter.write("BoardSize: " + this.sliderBoardSize.getValue() + "\n");
                bufferedWriter.write("P1Color: " + this.player1Color.getValue() + "\n");
                bufferedWriter.write("P2Color: " + this.player2Color.getValue() + "\n");
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Error with settings file");
            }
            // Closing the window.
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        } else {
            // Otherwise warning the user
            this.warningLabel.setText("Player's colors are the same.\nWhy would you do that!?");
        }
    }
}

