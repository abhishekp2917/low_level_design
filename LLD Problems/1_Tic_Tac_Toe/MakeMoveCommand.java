public class MakeMoveCommand implements Command {

    private final Game game;
    private final Move move;

    public MakeMoveCommand(Game game, Move move) {
        this.game = game;
        this.move = move;
    }

    @Override
    public void execute() {
       this.game.applyMove(move);
    }

    @Override
    public void undo() {
        this.game.revertMove(move);
    }
    
}
