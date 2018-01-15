package Main;

public interface Notifier {
    void addListener(Listener listen);
    void removeListener(Listener listen);
    void madeMove(int row, int col);
}
