package Main;

import java.util.ArrayList;

public class BoardScanner {
    private int wall;
    private Board board;
    private ArrayList<Point> pointsVector;
    private int firstPlayerScore;
    private int secondPlayerScore;

    public BoardScanner(Board board) {
        this.board = board;
        this.wall = this.board.getSize();
        this.pointsVector = new ArrayList<Point>();
        this.firstPlayerScore = 2;
        this.secondPlayerScore = 2;
    }

    /**
     * Scanning our board cell by cell using 8 sub functions and by the color it gets
     *
     * @param color - an Integer that represent the color
     */
    public void scanBoard(int color) {
        // Going over each cell in the board
        for (int i = 1; i < this.wall + 1; i++) {
            for (int j = 1; j < this.wall + 1; j++) {
                // Checking for moves in all directions based on the disks location
                if (this.board.cellMatrix[i][j].getColor() == color) {
                    if (i > 1) {
                        this.checkUp(i - 1, j);
                    }
                    if (i < this.wall) {
                        this.checkDown(i + 1, j);
                    }
                    if (j > 1) {
                        this.checkLeft(i, j - 1);
                    }
                    if (j < this.wall) {
                        this.checkRight(i, j + 1);
                    }
                    if ((i > 1) && (j > 1)) {
                        this.checkUpLeft(i - 1, j - 1);
                    }
                    if ((i > 1) && (j < this.wall)) {
                        this.checkUpRight(i - 1, j + 1);
                    }
                    if ((i < this.wall) && (j > 1)) {
                        this.checkDownLeft(i + 1, j - 1);
                    }
                    if ((i < this.wall) && (j < this.wall)) {
                        this.checkDownRight(i + 1, j + 1);
                    }
                }
            }
        }
    }

    /**
     * Get the amount of disks on the board based on the color
     *
     * @param color -an Integer that represent the color
     * @return -an Integer that disks score on the board
     */
    public int getDisksScore(int color) {
        int score = 0;
        for (int i = 1; i < this.wall + 1; i++) {
            for (int j = 1; j < this.wall + 1; j++) {
                if (this.board.cellMatrix[i][j].getColor() == color) {
                    // Counting up each desired color disk
                    score++;
                }
            }
        }
        return score;
    }

    /**
     * Return whether or not a player has any moves to play
     *
     * @param color --an Integer that represent the color
     * @return - a bool- true if it has moves, false if not
     */
    public boolean hasMoves(int color) {
        scanBoard(color);
        return !this.pointsVector.isEmpty();
    }

    /**
     * Return whether or not a given move is valid to play
     *
     * @param row -an Integer that represent the row
     * @param col -an Integer that represent the col
     * @return - a bool- true if is valid, false if not
     */
    public boolean isValidMove(int row, int col) {
        // Going over all of our vector points
        for (int i = 0; i < this.pointsVector.size(); i++) {
            // Checking if the input move is valid
            if ((this.pointsVector.get(i).getX() == row) && (this.pointsVector.get(i).getY() == col)) {
                return true;
            }
        }
        // Returning false if a move is not valid
        return false;
    }

    /**
     * Return whether or not a move is in our moves list
     *
     * @param row     -an Integer that represent the row
     * @param col     -an Integer that represent the col
     * @param counter -an Integer that represent the counter of the move
     * @return -a bool- true if its already exist, false if not
     */
    private boolean isInVector(int row, int col, int counter) {
        for (int i = 0; i < this.pointsVector.size(); i++) {
            // Comparing our points
            if ((this.pointsVector.get(i).getX() == row) && (this.pointsVector.get(i).getY() == col)) {
                this.pointsVector.get(i).increaseGrade(counter);
                return true;
            }
        }
        return false;
    }

    /**
     * Checking up for possible moves
     *
     * @param row - an Integer that reresent the row
     * @param col - an Integer that reresent the col
     */
    private void checkUp(int row, int col) {
        int counter = 0;
        // Getting our flipped color to look for
        int flipped = this.board.cellMatrix[row + 1][col].getFlip();
        // Traveling up while we haven'tencounteredd a wall or a opposite color disk
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && row > 1) {
            row--;
            counter++;
            // Lastly checking the point which we stopped making sure it's a valid point
            if ((this.board.cellMatrix[row][col].getColor() == PlayerNumber.empty) && !(this.isInVector(row, col, counter))) {
                Point po = new Point(row, col);
                // Updating its grade flip
                po.increaseGrade(counter);
                pointsVector.add(po);
            }
        }
    }

    /**
     * Checking down for possible moves
     *
     * @param row - an Integer that reresent the row
     * @param col - an Integer that reresent the col
     */
    private void checkDown(int row, int col) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row - 1][col].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && row < this.wall) {
            row++;
            counter++;
            if ((this.board.cellMatrix[row][col].getColor() == PlayerNumber.empty) && !(this.isInVector(row, col, counter))) {
                Point po = new Point(row, col);
                po.increaseGrade(counter);
                pointsVector.add(po);
            }
        }
    }

    /**
     * Checking left for possible moves
     *
     * @param row - an Integer that reresent the row
     * @param col - an Integer that reresent the col
     */
    private void checkLeft(int row, int col) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row][col + 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && col > 1) {
            col--;
            counter++;
            if ((this.board.cellMatrix[row][col].getColor() == PlayerNumber.empty) && !(this.isInVector(row, col, counter))) {
                Point po = new Point(row, col);
                po.increaseGrade(counter);
                pointsVector.add(po);
            }
        }
    }

    /**
     * Checking right for possible moves
     *
     * @param row - an Integer that reresent the row
     * @param col - an Integer that reresent the col
     */
    private void checkRight(int row, int col) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row][col - 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && col < this.wall) {
            col++;
            counter++;
            if ((this.board.cellMatrix[row][col].getColor() == PlayerNumber.empty) && !(this.isInVector(row, col, counter))) {
                Point po = new Point(row, col);
                po.increaseGrade(counter);
                pointsVector.add(po);
            }
        }
    }

    /**
     * Checking up and left diagonally for possible moves
     *
     * @param row - an Integer that reresent the row
     * @param col - an Integer that reresent the col
     */
    private void checkUpLeft(int row, int col) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row + 1][col + 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && (row > 1) && (col > 1)) {
            row--;
            col--;
            counter++;
            if ((this.board.cellMatrix[row][col].getColor() == PlayerNumber.empty) && !(this.isInVector(row, col, counter))) {
                Point po = new Point(row, col);
                po.increaseGrade(counter);
                pointsVector.add(po);
            }
        }
    }

    /**
     * Checking up and right diagonally for possible moves
     *
     * @param row - an Integer that reresent the row
     * @param col - an Integer that reresent the col
     */
    private void checkUpRight(int row, int col) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row + 1][col - 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && (row > 1) && (col < this.wall)) {
            row--;
            col++;
            counter++;
            if ((this.board.cellMatrix[row][col].getColor() == PlayerNumber.empty) && !(this.isInVector(row, col, counter))) {
                Point po = new Point(row, col);
                po.increaseGrade(counter);
                pointsVector.add(po);
            }
        }
    }

    /**
     * Checking down and left diagonally for possible moves
     *
     * @param row - an Integer that reresent the row
     * @param col - an Integer that reresent the col
     */
    private void checkDownLeft(int row, int col) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row - 1][col + 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && (row < this.wall) && (col > 1)) {
            row++;
            col--;
            counter++;
            if ((this.board.cellMatrix[row][col].getColor() == PlayerNumber.empty) && !(this.isInVector(row, col, counter))) {
                Point po = new Point(row, col);
                po.increaseGrade(counter);
                pointsVector.add(po);
            }
        }
    }

    /**
     * Checking down and right diagonally for possible moves
     *
     * @param row - an Integer that reresent the row
     * @param col - an Integer that reresent the col
     */
    private void checkDownRight(int row, int col) {
        int counter = 0;
        int flipped = this.board.cellMatrix[row - 1][col - 1].getFlip();
        while ((this.board.cellMatrix[row][col].getColor() == flipped) && (row < this.wall) && (col < this.wall)) {
            row++;
            col++;
            counter++;
            if ((this.board.cellMatrix[row][col].getColor() == PlayerNumber.empty) && !(this.isInVector(row, col, counter))) {
                Point po = new Point(row, col);
                po.increaseGrade(counter);
                pointsVector.add(po);
            }
        }
    }

    /**
     * Freeing our lastest scans moves list
     */
    public void freeMovesList() {
        this.pointsVector.clear();
    }

    /**
     * Getter for our moves list
     *
     * @return - moves list
     */
    public ArrayList<Point> getPointsVector() {
        return this.pointsVector;
    }

    public Cell[][] getBoardMatrix() {
        return this.board.cellMatrix;
    }

    public int getBoardSize() {
        return this.board.getSize();
    }
}
