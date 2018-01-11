public class Board {
    private int size;
    public Cell[][] cellMatrix;

    public Board(int size) {
        this.size=size;
        // Initialize our cellMatrix
        cellMatrix = new Cell [size+1][size+1];
        for(int i=0;i<size+1;i++){
            for(int j=0;j<size+1;j++) {
                cellMatrix[i][j] = new Cell();
            }
        }

        // Placing our four initials disks
        cellMatrix[size / 2][size / 2].changeColor(CellColor.secondPlayer);
        cellMatrix[(size / 2) + 1][(size / 2) + 1].changeColor(CellColor.secondPlayer);
        cellMatrix[(size / 2) + 1][size / 2].changeColor(CellColor.firstPlayer);
        cellMatrix[size / 2][(size / 2) + 1].changeColor(CellColor.firstPlayer);
    }

    /**
     * Getter for our boards size
     * @return - an Integer that represent the size of the board
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Add a single cell to the board
     * @param row - an Integer that represent the row
     * @param col - an Integer that represent the col
     * @param color - an Integer that represent the color
     */
    public void addCell(int row, int col, int color) {
        cellMatrix[row][col].changeColor(color);
    }
}
