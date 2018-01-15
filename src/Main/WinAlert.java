package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class WinAlert {
    private Button okButton;

    public static void display(String message) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("You Win!");

        Label label = new Label();
        label.setText(message);

        Button okButton = new Button("Ok");
        okButton.setOnAction(e -> { window.close(); });

        VBox layout = new VBox();
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}