package Main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jdk.internal.cmm.SystemResourcePressureImpl;

import java.io.*;

public class SettingsController {
    private
    @FXML
    Slider sliderBoardSize;
    @FXML
    ColorPicker player1Color;
    @FXML
    ColorPicker player2Color;
    @FXML
    Button saveButton;

    @FXML
    public void initialize() {
        String[] line;
        if (new File("gameSettings.txt").exists()) {
            try {
                FileReader fileReader = new FileReader("gameSettings.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                line = bufferedReader.readLine().split(" ");
                this.sliderBoardSize.setValue(Double.parseDouble(line[1]));
                line = bufferedReader.readLine().split(" ");
                player1Color.setValue(Color.BLACK);
                line = bufferedReader.readLine().split(" ");
                player2Color.setValue(Color.GREEN);

                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error with settings file");
            }
        } else {
            sliderBoardSize.setValue(8);
            player1Color.setValue(Color.BLACK);
            player2Color.setValue(Color.WHITE);
        }
    }

    @FXML
    public void saveSettings() {
        String line = null;
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

