public class ConsoleBoardDisplayer implements IBoardDisplayer {
    
    public void display(Board board) {
        int n = board.getSize();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                Symbol symbol = board.getSymbol(i, j);
                System.out.print(symbol == null ? " " : symbol);
                if (j<n-1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i<n-1) {
                for (int k=0; k<n; k++) {
                    System.out.print("---");
                    if (k<n-1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }
}
