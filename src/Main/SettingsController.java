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
        //READ FROM FILE
        sliderBoardSize.setValue(8);
        player1Color.setValue(Color.BLUE);
        player2Color.setValue(Color.BLACK);
    }

    @FXML
    public void saveSettings() {
        //FILE BLAH BLAH WRITE TO FILE PATH
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }
}
