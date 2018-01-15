package Main;

/**
 * Simple listener interface for notifying user mouse clicks.
 */
public interface Listener {

    /**
     * A user has clicked his mouse on the given cell.
     *
     * @param row - the cells row.
     * @param col - the cells column.
     */
    void clickMade(int row, int col);
}
