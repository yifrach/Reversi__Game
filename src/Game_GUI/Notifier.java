package Game_GUI;

import Logic.Listener;

/**
 * Basic notifier interface for our listener design pattern.
 */
public interface Notifier {

    /**
     * Adding a listener.
     *
     * @param listen - our listener to add.
     */
    void addListener(Listener listen);

    /**
     * Removing a listener.
     *
     * @param listen - listener to remove.
     */
    void removeListener(Listener listen);

    /**
     * Notifying all interesed that a move has been made.
     *
     * @param row - the moves row.
     * @param col - the moves column.
     */
    void madeMove(int row, int col);
}
