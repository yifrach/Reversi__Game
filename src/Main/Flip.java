package Main;

public class Flip {
    private Board board;
    private int wall;

    /**
     * The constructor of the class
     *
     * @param board - a Main.Board
     */
    public Flip(Board board) {
        this.board = board;
        this.wall = this.board.getSize();
    }

    /**
     * Main.Flip the board given the disks position and color using 8 sub functions
     *
     * @param row   - an Integer that represent the row
     * @param col   - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    public void flipBoard(int row, int col, int color) {
        if (row != 1) {
            this.flipUp(row - 1, col, color);
        }
        if (row != this.wall) {
            this.flipDown(row + 1, col, color);
        }
        if (col != 1) {
            this.flipLeft(row, col - 1, color);
        }
        if (col != this.wall) {
            this.flipRight(row, col + 1, color);
        }
        if ((row != 1) && (col != 1)) {
            this.flipUpLeft(row - 1, col - 1, color);
        }
        if ((row != 1) && (col != this.wall)) {
            this.flipUpRight(row - 1, col + 1, color);
        }
        if ((row != this.wall) && (col != 1)) {
            this.flipDownLeft(row + 1, col - 1, color);
        }
        if ((row != this.wall) && (col != this.wall)) {
            this.flipDownRight(row + 1, col + 1, color);
        }
    }

    /**
     * Flipping our board up
     *
     * @param row   - an Integer that represent the row
     * @param col   - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    private void flipUp(int row, int col, int color) {
        // Reseting our counter and flipped color
        int counter = 0;
        int flipped = this.board.cellMatrix[row + 1][col].getFlip();
        // Traveling up while we havent reached a diff colored disk or a wall
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && row > 1) {
            // Counting each move up
            row--;
            counter++;
        }
        // Lastly checking if the point we reached is of the desired color
        if (this.board.cellMatrix[row][col].getColor() == color) {
            // Flipping each cell on the way back to the origin cell
            for (int i = 0; i < counter; i++) {
                row++;
                this.board.cellMatrix[row][col].flip();
            }
        }
    }

    /**
     * Flipping our board down
     *
     * @param row   - an Integer that represent the row
     * @param col   - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    private void flipDown(int row, int col, int color) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row - 1][col].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && row < wall) {
            row++;
            counter++;
        }
        if (this.board.cellMatrix[row][col].getColor() == color) {
            for (int i = 0; i < counter; i++) {
                row--;
                this.board.cellMatrix[row][col].flip();
            }
        }
    }

    /**
     * Flipping our board left
     *
     * @param row   - an Integer that represent the row
     * @param col   - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    private void flipLeft(int row, int col, int color) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row][col + 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && col > 1) {
            col--;
            counter++;
        }
        if (this.board.cellMatrix[row][col].getColor() == color) {
            for (int i = 0; i < counter; i++) {
                col++;
                this.board.cellMatrix[row][col].flip();
            }
        }
    }

    /**
     * Flipping our board right
     *
     * @param row   - an Integer that represent the row
     * @param col   - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    private void flipRight(int row, int col, int color) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row][col - 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && col < wall) {
            col++;
            counter++;
        }
        if (this.board.cellMatrix[row][col].getColor() == color) {
            for (int i = 0; i < counter; i++) {
                col--;
                this.board.cellMatrix[row][col].flip();
            }
        }
    }

    /**
     * Flipping our board up and left diagonally
     *
     * @param row   - an Integer that represent the row
     * @param col   - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    private void flipUpLeft(int row, int col, int color) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row + 1][col + 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && (row > 1) && (col > 1)) {
            row--;
            col--;
            counter++;
        }
        if (this.board.cellMatrix[row][col].getColor() == color) {
            for (int i = 0; i < counter; i++) {
                row++;
                col++;
                this.board.cellMatrix[row][col].flip();
            }
        }
    }

    /**
     * Flipping our board up and right diagonally
     *
     * @param row   - an Integer that represent the row
     * @param col   - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    private void flipUpRight(int row, int col, int color) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row + 1][col - 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && (row > 1) && (col < wall)) {
            row--;
            col++;
            counter++;
        }
        if (this.board.cellMatrix[row][col].getColor() == color) {
            for (int i = 0; i < counter; i++) {
                row++;
                col--;
                this.board.cellMatrix[row][col].flip();
            }
        }
    }

    /**
     * Flipping our board down and left diagonally
     *
     * @param row   - an Integer that represent the row
     * @param col   - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    private void flipDownLeft(int row, int col, int color) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row - 1][col + 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && (row < wall) && (col > 1)) {
            row++;
            col--;
            counter++;
        }
        if (this.board.cellMatrix[row][col].getColor() == color) {
            for (int i = 0; i < counter; i++) {
                row--;
                col++;
                this.board.cellMatrix[row][col].flip();
            }
        }
    }

    /**
     * Flipping our board down and right diagonally
     *
     * @param row   - an Integer that represent the row
     * @param col   - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    private void flipDownRight(int row, int col, int color) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row - 1][col - 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && (row < wall) && (col < wall)) {
            row++;
            col++;
            counter++;
        }
        if (this.board.cellMatrix[row][col].getColor() == color) {
            for (int i = 0; i < counter; i++) {
                row--;
                col--;
                this.board.cellMatrix[row][col].flip();
            }
        }
    }
}
