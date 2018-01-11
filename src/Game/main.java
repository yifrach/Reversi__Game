package Game;

public class main {
    /**
     * Main function for running our game
     * @return - an Integer in the end of the run
     */
    public static void main(String[] args) {
        Game game= new Game();
        // Initializing it and playing
        game.initialize();
        game.playGame();
    }
}
