public class DefaultWinningStrategy implements IWinningStrategy {
    
    public boolean hasWon(Board board, Move move) {
        Player playerTurn = move.getPlayer();
        Symbol s = playerTurn.getSymbol();
        int n = board.getSize();
        for (int i=0; i<n; i++) {
            boolean row = true, col = true;
            for (int j=0; j<n; j++) {
                if (board.getSymbol(i, j) != s) row = false;
                if (board.getSymbol(j, i) != s) col = false;
            }
            if (row || col) return true;
        }
        boolean d1 = true, d2 = true;
        for (int i=0; i<n; i++) {
            if (board.getSymbol(i, i)!=s) d1 = false;
            if (board.getSymbol(i, n-1-i)!=s) d2 = false;
        }
        return d1 || d2;
    }
}
