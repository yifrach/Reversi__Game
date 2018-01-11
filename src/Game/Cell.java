package Game;

public class Cell {
    private int color;

    /**
     * Initalzing it as an empty cell as default
     */
    public Cell() {
        this.color= CellColor.empty;
    }

    /**
     * Getter for our cells color
     * @return - an Integer that represent the color og the cell
     */
    public int getColor() {
        return this.color;
    }


    /**
     * Change the cells color to color
     * @param newColor - an Integer that represent the newColor
     */
    public void changeColor(int newColor) {
        this.color = newColor;
    }

    /**
     * Flip the cell disk - changing its color
     */
    public void flip() {
        if (this.color == CellColor.firstPlayer) {
            this.color = CellColor.secondPlayer;
        } else if (this.color == CellColor.secondPlayer) {
            this.color = CellColor.firstPlayer;
        }
    }

    /**
     * Getter for our cells opposite color
     * @return - an Integer that represent the opposit color
     */
    public int getFlip() {
        if (this.color == CellColor.firstPlayer) {
            return CellColor.secondPlayer;
        } else if (this.color == CellColor.secondPlayer) {
            return CellColor.firstPlayer;
        } else {
            return CellColor.empty;
        }
    }

}
