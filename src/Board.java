public class Board {
    private String[][] matrix;

    public Board() {
        matrix = new String[3][3];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = "·";
            }
        }
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

    public void shoot(int row, int col, Player player) {
        
    }
}
