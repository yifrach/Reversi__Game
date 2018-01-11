public class BoardPrint implements Print{
    private Board board;
    private Print cellPrint;

    /**
     * Constructor, get a Board
     * @param board- getting a Board
     */
    public BoardPrint(Board board) {
        this.board=board;
    }

     /**
     * Printing the board at its current state
     */
    public void print() {
        String line = "----";
        System.out.print("\n");
        for (int i = 0; i < this.board.getSize() + 1; i++) {
            for (int j = 0; j < this.board.getSize() + 1; j++) {
                if ((i == 0) && (j == 0)) {
                    System.out.print("  ");
                } else if ((i == 0) && (j != 0)) {
                    System.out.print(j);
                } else if ((i != 0) && (j == 0)) {
                    System.out.print(" "+i);
                } else {
                    this.cellPrint=new CellPrint(this.board.cellMatrix[i][j].getColor());
                    this.cellPrint.print();
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
            for (int j = 0; j < this.board.getSize() + 1; j++) {
                System.out.print(line);
            }
            System.out.print("\n");
        }
    }
}