package Logic;

import GUI.SettingsReader;
import javafx.scene.paint.Color;

public class Cell {
    private int playerNum;

    /**
     * Our constructor initalzing it as an empty cell by default
     */
    Cell() {
        this.playerNum = PlayerNumber.empty;
    }

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
     * Change the cells color
     *
     * @param playerNum - an Integer that represent the player number
     */
    public void changePlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    /**
     * Flip the cell disk - changing its color
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