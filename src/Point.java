public class Point {
    private int x;
    private int y;
    private int grade;

    /**
     * The constructor of the class
     * @param x - an Integer that reopresent the X position
     * @param y - an Integer that reopresent the Y position
     */
    public Point(int x, int y) {
        this.x=x;
        this.y=y;
        this.grade=0;
    }

    /**
     * Getter for our points row
     * @return - an Integer, the row position
     */
    public int getX() {
        return this.x;
    }


    /**
     * Getter for our points col
     * @return - an Integer, the col position
     */
    public int getY() {
        return this.y;
    }

    /**
     * Getter for our points grade - number of flips it will make
     * @return - an Integer, number of flips it will make
     */
    public int getGrade() {
        return this.grade;
    }

    /**
     * Increasing our points graded by num
     * @param num - an Integer that we increse the points grade with
     */
    public void increaseGrade(int num) {
        this.grade += num;
    }
}
