package Main;

public class CellPrint implements Print {
    private int color;

    public CellPrint(int color) {
        this.color = color;
    }

    /**
     * Main.Print our cells color
     */
    public void print() {
        if (this.color == PlayerNumber.firstPlayer) {
            System.out.print("X");
        } else if (this.color == PlayerNumber.secondPlayer) {
            System.out.print("O");
        } else {
            System.out.print(" ");
        }
    }
}
