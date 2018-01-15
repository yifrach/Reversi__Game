package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {


    /**
     * Launching our app.
     *
     * @param args - none
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    /**
     * Starting our main menu window.
     */
    public void start(Stage primaryStage) {
        try {
            // Loading our main menu fxml and displaying it
            VBox root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene = new Scene(root,520,400);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Reversi");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
