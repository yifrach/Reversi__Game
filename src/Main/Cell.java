package Main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cell {
    private int playerNum;
    private Color color;

    /**
     * Initalzing it as an empty cell as default
     */
    public Cell() { this.playerNum = PlayerNumber.empty; }

    /**
     * Getter for our cells color
     *
     * @return - an Integer that represent the color og the cell
     */
    public int getColor() {
        return this.playerNum;
    }

    public Color getActualColor() {
        if (this.playerNum == PlayerNumber.firstPlayer) {
            return SettingsReader.getP1Color();
        } else {
            return SettingsReader.getP2Color();
        }
    }

    /**
     * Change the cells color to color
     *
     * @param playerNum - an Integer that represent the newColor
     */
    public void changePlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    /**
     * Main.Flip the cell disk - changing its color
     */
    public void flip() {
        if (this.playerNum == PlayerNumber.firstPlayer) {
            this.playerNum = PlayerNumber.secondPlayer;
        } else if (this.playerNum == PlayerNumber.secondPlayer) {
            this.playerNum = PlayerNumber.firstPlayer;
        }
    }

    /**
     * Getter for our cells opposite color
     *
     * @return - an Integer that represent the opposit color
     */
    public int getFlip() {
        if (this.playerNum == PlayerNumber.firstPlayer) {
            return PlayerNumber.secondPlayer;
        } else if (this.playerNum == PlayerNumber.secondPlayer) {
            return PlayerNumber.firstPlayer;
        } else {
            return PlayerNumber.empty;
        }
    }
}