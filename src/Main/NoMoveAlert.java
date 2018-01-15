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

public class NoMoveAlert {
    private Button okButton;

    public static void display() {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("No Moves :(");

        Label label = new Label();
        label.setText("No Possible Moves!\n Play passes back to the other player");

        Button okButton = new Button("Ok");
        okButton.setOnAction(e -> { window.close(); });

        VBox layout = new VBox();
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}