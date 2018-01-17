package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WinAlert {

    /**
     * Displaying our winner announcement once the game has ended.
     *
     * @param winner - according to which player won.
     */
    public static void display(String winner) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Congratulations!");
        //window.setMinWidth(320);

        Label headline = new Label(winner);
        Label message = new Label("You win eternal fame and a place among the gods.");
        Button okButton = new Button("Ok");
        okButton.setOnAction(e -> window.close());

        VBox layout = new VBox(15);
        layout.getChildren().addAll(headline, message, okButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

}