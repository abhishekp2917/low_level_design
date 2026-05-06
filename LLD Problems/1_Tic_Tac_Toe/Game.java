import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class Game {

    private static final AtomicLong incrementer = new AtomicLong();
    private final long id;
    private final Board board;
    private final List<Player> players;
    private int currPlayerIdx;
    private Player playerTurn;
    private Player winner;
    private GameStatus status;
    private final ReentrantLock lock = new ReentrantLock();
    private final IWinningStrategy winningStrategy;

    private Game(Board board, List<Player> players, IWinningStrategy winningStrategy) {
        this.id = generateId();
        this.board = board;
        this.players = List.copyOf(players);
        this.currPlayerIdx = 0;
        this.playerTurn = this.players.get(this.currPlayerIdx);
        this.status = GameStatus.IN_PROGRESS;
        this.winningStrategy = winningStrategy;
    }

    public long getId() { return this.id; }

    public Board getBoard() { return this.board; }

    public Player getCurrentPlayer() { return this.playerTurn; }

    public Player getWinner() { return this.winner; }

    public GameStatus getStatus() { return this.status; }

    public void makeMove(Move move) {
        if(move==null || move.getPlayer()==null || move.getPlayer().getSymbol()==null) {
            throw new IllegalArgumentException("Invalid move.");
        }
        Player player = move.getPlayer();
        int col = move.getCol();
        int row = move.getRow();
        lock.lock();
        try{
            if(this.status!=GameStatus.IN_PROGRESS) {
                throw new IllegalStateException("Game is already finished.");
            }
            if(!players.contains(player)) {
                throw new IllegalStateException("Player doesn't belong to this game.");
            }
            if(!player.equals(this.playerTurn)) {
                throw new IllegalStateException("Player turn is invalid.");
            }
            this.board.setSymbol(row, col, player.getSymbol());
            if(hasWon(move)) {
                this.status = GameStatus.FINISHED;
                this.winner = this.playerTurn;
                return;
            }
            else if(hasDrawn()) {
                this.status = GameStatus.DRAW;
                return;
            }
            advanceTurn();
        }
        finally{
            lock.unlock();
        }
    }

    private boolean hasWon(Move move) {
        return this.winningStrategy.hasWon(board, move);
    }

    private boolean hasDrawn() {
        int n = this.board.getSize();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (this.board.getSymbol(i, j)==null) {
                    return false;
                }
            }
        }
        return true;
    }

    private static long generateId() {
        return incrementer.incrementAndGet();
    }

    private void advanceTurn() {
        this.currPlayerIdx = (this.currPlayerIdx+1)%this.players.size();
        this.playerTurn = this.players.get(this.currPlayerIdx);
    }

    public static GameBuilder builder() {
        return new Game.GameBuilder();
    }

    public static class GameBuilder {

        private Board board;
        private List<Player> players;
        private IWinningStrategy winningStrategy;

        public GameBuilder board(Board board) {
            this.board = board;
            return this;
        }

        public GameBuilder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder winningStrategy(IWinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Game build() {
            if(this.players==null || this.players.size()<2) {
                throw new IllegalArgumentException("Minimum 2 player is required to play the game.");
            }
            if(this.board==null) {
                throw new IllegalArgumentException("Game board is required to play the game.");
            }
            if(this.winningStrategy==null) {
                throw new IllegalArgumentException("Can't create game without any winning rules.");
            }
            return new Game(this.board, this.players, this.winningStrategy);
        } 
    }
}
