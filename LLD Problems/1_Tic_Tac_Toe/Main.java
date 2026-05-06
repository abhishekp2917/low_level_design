import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        IBoardDisplayer displayer = BoardDisplayerFactory.get(BoardDisplayerFactory.BoardDisplayerType.CONSOLE);
        GameManager gameManager = new GameManager();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // Create multiple games
        for (int i=1; i<=3; i++) {
            int gameId = i;
            executor.submit(() -> runGame(gameManager, displayer, gameId));
        }

        executor.shutdown();
    }

    private static void runGame(GameManager gameManager, IBoardDisplayer displayer, int gameId) {
        Player p1 = gameManager.createPlayer("P" + gameId + "_A", Symbol.O);
        Player p2 = gameManager.createPlayer("P" + gameId + "_B", Symbol.X);
        Game game = gameManager.createGame(3, List.of(p1, p2));
        Random rand = new Random();

        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            Player current = game.getCurrentPlayer();

            try {
                int row = rand.nextInt(3);
                int col = rand.nextInt(3);
                gameManager.makeMove(game.getId(), current.getId(), row, col);

                // avoid interleaved prints
                synchronized (System.out) { 
                    System.out.println("\nGame " + gameId + " Move by " + current.getName());
                    displayer.display(game.getBoard());
                }

                // simulate delay
                Thread.sleep(200); 

            } 
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Something went wrong. Please try again.");
            }
        }

        synchronized (System.out) {
            System.out.println("\n=== Game " + gameId + " Finished ===");
            displayer.display(game.getBoard());
            if (game.getStatus()==GameStatus.FINISHED) {
                System.out.println("Winner: " + game.getWinner().getName());
            } else {
                System.out.println("Game Draw");
            }
        }
    }
}