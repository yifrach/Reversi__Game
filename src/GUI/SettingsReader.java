package GUI;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SettingsReader {
    public static Slider sliderBoardSize = new Slider();
    public static ColorPicker player1Color = new ColorPicker();
    public static ColorPicker player2Color = new ColorPicker();

    /**
     * Static function for reading our game settings file.
     *
     * @param path - the game settings relative path.
     */
    public static void readSettings(String path) {
        String[] line;
        File file = new File(path);
        // If the file exists we'll read it.
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                line = bufferedReader.readLine().split(" ");
                sliderBoardSize.setValue(Double.parseDouble(line[1]));
                line = bufferedReader.readLine().split(" ");
                player1Color.setValue(Color.valueOf(line[1]));
                line = bufferedReader.readLine().split(" ");
                player2Color.setValue(Color.valueOf(line[1]));
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error with settings file");
            }
        } else {
            // Otherwise setting these default values.
            sliderBoardSize.setValue(8);
            player1Color.setValue(Color.BLACK);
            player2Color.setValue(Color.WHITE);
        }
    }

    /**
     * Static Getter for our game settings board size.
     *
     * @return - the saved board size.
     */
    public static int getBoardSize() {
        return (int) sliderBoardSize.getValue();
    }

    /**
     * Static Getter for our game settings player 1 color.
     *
     * @return - player 1's color.
     */
    public static Color getP1Color() {
        return player1Color.getValue();
    }

    /**
     * Static Getter for our game settings player 2 color.
     *
     * @return - player 2's color.
     */
    public static Color getP2Color() {
        return player2Color.getValue();
    }

}

