public class Board {
    private String[][] matrix;
    public static final String EMPTY = "·";
    public static final int NUM_ROWS_COLS = 3;

    public Board() {
       matrix = new String[NUM_ROWS_COLS][NUM_ROWS_COLS];
       for (int row = 0; row < matrix.length; row++) {
           for (int col = 0; col < matrix[0].length; col++) {
               matrix[row][col] = EMPTY;
           }
       }
    }

    public boolean shoot(int row, int col, String symbol) {
        if (matrix[row - 1][col - 1].equals(EMPTY)) {
            matrix[row - 1][col - 1] = symbol;
            return true;
        } else {
            return false;
        }
    }

    public boolean draws() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals(EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "  ";
        for (int i = 1; i <= matrix[0].length; i++) {
            s += i + " ";
        }
        s += "\n";
        for (int row = 0; row < matrix.length; row++) {
            s += (row + 1) + " ";
            for (int col = 0; col < matrix[0].length; col++) {
                s += matrix[row][col] + " ";
            }
            s += "\n";
        }
        return s;
    }

    public boolean isEmpty(int row, int col) {
        return matrix[row - 1][col - 1].equals(EMPTY);
    }

    public boolean wins(String symbol) {
        if (winsRow(symbol)) return true;
        if (winsColumn(symbol)) return true;
        if (winsDiagonal(symbol)) return true;
        if (winsInvertedDiagonal(symbol)) return true;
        return false;
    }

    private boolean winsInvertedDiagonal(String symbol) {
        int symbolCounter = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][matrix.length - 1 - row].equals(symbol)) {
                symbolCounter++;
            }
        }
        return symbolCounter == NUM_ROWS_COLS;
    }

    private boolean winsDiagonal(String symbol) {
        int symbolCounter = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i].equals(symbol)) {
                symbolCounter++;
            }
        }
        return symbolCounter == NUM_ROWS_COLS;
    }

    private boolean winsColumn(String symbol) {
        int symbolCounter;
        for (int col = 0; col < matrix[0].length; col++) {
            symbolCounter = 0;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col].equals(symbol)) {
                    symbolCounter++;
                }
            }
            if (symbolCounter == NUM_ROWS_COLS) {
                return true;
            }
        }
        return false;
    }

    private boolean winsRow(String symbol) {
        int symbolCounter;
        for (int row = 0; row < matrix.length; row++) {
            symbolCounter = 0;
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals(symbol)) {
                    symbolCounter++;
                }
            }
            if (symbolCounter == NUM_ROWS_COLS) {
                return true;
            }
        }
        return false;
    }

    public void empty(int row, int col) {
        matrix[row - 1][col - 1] = EMPTY;
    }
}
