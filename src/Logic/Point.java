package Logic;

public class Point {
    private int x;
    private int y;
    private int grade;

    /**
     * Constructor for our point class.
     *
     * @param x - an Integer that represent the X position
     * @param y - an Integer that represent the Y position
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.grade = 0;
    }

    /**
     * Getter for our points row
     *
     * @return - an Integer, the row position
     */
    public int getX() {
        return this.x;
    }


    /**
     * Getter for our points col
     *
     * @return - an Integer, the col position
     */
    public int getY() {
        return this.y;
    }
    

    /**
     * Increasing our points graded by num
     *
     * @param num - an Integer that we increse the points grade with
     */
    public void increaseGrade(int num) {
        this.grade += num;
    }
}
