package Logic;

import javafx.scene.paint.Color;

public class Player {
    private int playerNum;
    private Color color;
    private int score;

    /**
     * Constructor for our player class.
     *
     * @param playerNum - whether he's the first or second player.
     * @param color     - the player color.
     */
    public Player(int playerNum, Color color) {
        this.playerNum = playerNum;
        this.color = color;
        // Each players initial score will always be 2
        this.score = 2;
    }

    /**
     * Getter for our players score
     *
     * @return - an Integer  that represent the color of the player
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Updating our players score to updatedScore
     *
     * @param updatedScore - an Integer that repersent the update score
     */
    public void updateScore(int updatedScore) {
        this.score = updatedScore;
    }

    /**
     * Getter for our players color
     *
     * @return - an Integer that represent the color of the player
     */
    public int getPlayerNum() {
        return this.playerNum;
    }

    /**
     * Getter for our players color
     *
     * @return
     */
    public Color getPlayerColor() {
        return this.color;
    }
}
