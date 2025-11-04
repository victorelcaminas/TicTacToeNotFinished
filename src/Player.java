import java.util.Scanner;

public class Player {
    public static final String PLAYER1_SYMBOL = "X";
    public static final String PLAYER2_SYMBOL = "O";
    private String name;
    private String symbol; // X or O

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void shoot(Scanner input, Board board) {
        int row = 0;
        int col = 0;
        do {
            do {
                System.out.print("Enter row (1 - " + Board.NUM_ROWS_COLS + "): ");
                row = getRowOrCol(input);
            } while (row < 1 || row > Board.NUM_ROWS_COLS);
            do {
                System.out.print("Enter column (1 - " + Board.NUM_ROWS_COLS + "): ");
                col = getRowOrCol(input);
            } while (col < 1 || col > Board.NUM_ROWS_COLS);
        } while (!board.shoot(row, col, getSymbol()));
    }

    private static int getRowOrCol(Scanner input) {
        int rowOrCol;
        String s = input.next();
        s = s.replaceAll("[^\\d]", "");
        rowOrCol = Integer.parseInt(s);
        return rowOrCol;
    }

    @Override
    public String toString() {
        return name + " - Symbol: " + symbol + " " + ((this instanceof PlayerAI) ? "(AI)" : "");
    }
}
