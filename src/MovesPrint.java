public class MovesPrint implements Print{

    private BoardScanner scanner;
    private Print printPoint;
    private Print cellPrint;

    public MovesPrint(BoardScanner scanner, int color) {
        this.scanner=scanner;
        this.printPoint=new PointPrint(new Point(0,0));
        this.cellPrint=new CellPrint(color);
    }

    /**
     * Print the players availble moves based on the last board scan
     */
    public void print() {
        System.out.print("Player ");
        this.cellPrint.print();
        System.out.print(", it's your move.\n");
        System.out.print("Your possible moves are: ");
        for (int i = 0; i < this.scanner.getPointsVector().size(); i++) {
            this.printPoint=new PointPrint(this.scanner.getPointsVector().get(i));
            this.printPoint.print();
        }
        System.out.print("\n");
        System.out.print("Please enter your move row col: ");
    }
}
