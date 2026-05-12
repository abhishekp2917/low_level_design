import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GameManager {

    private final ConcurrentHashMap<Long, Game> registeredGames;
    private final ConcurrentHashMap<Long, Player> registeredPlayers;

    public GameManager() {
        this.registeredGames = new ConcurrentHashMap<>();
        this.registeredPlayers = new ConcurrentHashMap<>();
    }

    public Game getGame(long gameId) {
        return registeredGames.get(gameId);
    }

    public Player getPlayer(long playerId) {
        return registeredPlayers.get(playerId);
    }

    public Player createPlayer(String name, Symbol symbol) {
        if(name==null || name.trim().length()==0) {
            throw new IllegalArgumentException("Player name is invalid.");
        }
        if(symbol==null) {
            throw new IllegalArgumentException("Player symbol is missing.");
        }
        Player player = Player.builder()
                .name(name)
                .symbol(symbol)
                .build();
        registeredPlayers.put(player.getId(), player);
        return player;
    }

    public Game createGame(int boardSize, List<Player> players) {
        if(players==null || players.size()<2) {
            throw new IllegalArgumentException("Minimum 2 player is required to play the game.");
        }
        if(boardSize<=0) {
            throw new IllegalArgumentException("Game board size must be > 0.");
        }
        Set<Long> playerIds = new HashSet<>();
        Set<Symbol> playerSymbols = new HashSet<>(); 
        for(Player player : players) {
            if (player == null) {
                throw new IllegalArgumentException("Player cannot be null.");
            }
            if (player.getId() <= 0) {
                throw new IllegalArgumentException("Invalid player ID.");
            }
            if(!registeredPlayers.containsKey(player.getId())) {
                throw new IllegalArgumentException("Player is not registered.");
            }
            if(player.getSymbol()==null) {
                throw new IllegalArgumentException("Player symbol cannot be null.");
            }
            if(!playerIds.add(player.getId())) {
                throw new IllegalArgumentException("Duplicate players are not allowed.");
            }
            if(!playerSymbols.add(player.getSymbol())) {
                throw new IllegalArgumentException("All the players symbol should be unique.");
            }
        }
        Game game = Game.builder()
                .board(new Board(boardSize))
                .players(players)
                .winningStrategy(new DefaultWinningStrategy())
                .build();
        registeredGames.put(game.getId(), game);
        return game;
    }

    public void makeMove(long gameId, long playerId, int row, int col) {
        if(!registeredGames.containsKey(gameId)) {
            throw new IllegalArgumentException("Invalid game Id.");
        }
        if(!registeredPlayers.containsKey(playerId)) {
            throw new IllegalArgumentException("Invalid player Id.");
        }
        Game game = registeredGames.get(gameId);
        Player player = registeredPlayers.get(playerId);
        Move move = new Move(row, col, player);
        Command command = new MakeMoveCommand(game, move);
        game.executeCommand(command);
    }

    public void undoMove(long gameId) {
        if(!registeredGames.containsKey(gameId)) {
            throw new IllegalArgumentException("Invalid game Id.");
        }
        Game game = registeredGames.get(gameId);
        game.undo();
    }
}
