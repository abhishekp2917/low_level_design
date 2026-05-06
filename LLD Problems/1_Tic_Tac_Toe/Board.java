public class Board {
    
    private final int size;
    private final Symbol[][] grid;

    Board(int size) {
        if(size<=0) {
            throw new IllegalArgumentException("Board dimensions must be > 0.");
        }
        this.size = size;
        this.grid = new Symbol[size][size];
    }

    public int getSize() { return this.size; }

    public void setSymbol(int row, int col, Symbol symbol) {
        if(!isValidMove(row, col)) {
           throw new IllegalArgumentException("Invalid move.");
        }
        this.grid[row][col] = symbol;
    }

    public Symbol getSymbol(int row, int col) {
        if(!isWithinBoundary(row, col)) {
            throw new IllegalArgumentException("Requested [row, col] is out of board boundary.");
        } 
        return this.grid[row][col];
    }

    private boolean isValidMove(int row, int col) {
        return (isWithinBoundary(row, col) && this.grid[row][col]==null);
    }

    private boolean isWithinBoundary(int row, int col) {
        return (row>=0 && row<this.size && col>=0 && col<this.size);
    }
}
