public class CellPrint implements Print{
    private int color;
    public CellPrint(int color) {
        this.color=color;
    }

    /**
     * Print our cells color
     */
    public void print() {
        if (this.color == CellColor.firstPlayer) {
            System.out.print( "X");
        } else if (this.color == CellColor.secondPlayer) {
            System.out.print( "O");
        } else {
            System.out.print( " ");
        }
    }
}
