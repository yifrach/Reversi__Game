package Game;

public class PointPrint implements Print{
    private Point point;

    public PointPrint(Point point) {
        this.point=point;
    }

    /**
     * Print the point in (x,y) format
     */
    public void print() {
        System.out.print("(" + this.point.getX() + "," + this.point.getY() + ")");
    }
}
