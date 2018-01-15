package Main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.io.FileReader;
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SettingsReader.readSettings("gameSettings.txt");
        this.sliderBoardSize.setValue(SettingsReader.getBoardSize());
        this.player1Color.setValue(SettingsReader.getP1Color());
        this.player2Color.setValue(SettingsReader.getP2Color());
    }

    @FXML
    public void saveSettings() {
        try {
            FileWriter fileWriter = new FileWriter("gameSettings.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("BoardSize: " + this.sliderBoardSize.getValue() + "\n");
            bufferedWriter.write("P1Color: " + this.player1Color.getValue() + "\n");
            bufferedWriter.write("P2Color: " + this.player2Color.getValue() + "\n");

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error with settings file");
        }
        Stage stage = (Stage) saveButton.getScene().getWindow();

        stage.close();
    }
}

