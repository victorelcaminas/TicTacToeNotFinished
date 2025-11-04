import java.util.Scanner;

public class PlayerAI extends Player {

    public PlayerAI(String name, String symbol) {
        super(name, symbol);
    }


    public void shoot(Scanner input, Board board) {
        // First rule. If AI can win, then win
        if (applyRule1(board)) return;
        // Second rule. If AI can't win, then block other player.
        if (applyRule2(board)) return;
        // 3rd rule. Center position
        if (applyRule3(board)) return;
        // 4th rule. Random position
        randomShoot(board);
    }

    private boolean applyRule3(Board board) {
        // 3rd rule. Center position
        if (board.shoot(2, 2, getSymbol())) {
            return true;
        }
        return false;
    }

    private boolean applyRule2(Board board) {
        // Second rule. If AI can't win, then block other player.
        String otherPlayerSymbol;
        if (getSymbol().equals(Player.PLAYER1_SYMBOL)) {
            otherPlayerSymbol = Player.PLAYER2_SYMBOL;
        } else {
            otherPlayerSymbol = Player.PLAYER1_SYMBOL;
        }
        for (int row = 1; row <= Board.NUM_ROWS_COLS; row++) {
            for (int col = 1; col <= Board.NUM_ROWS_COLS; col++) {
                if (board.shoot(row, col, otherPlayerSymbol)) {
                    if (board.wins(otherPlayerSymbol)) {
                        board.empty(row, col);
                        board.shoot(row, col, getSymbol());
                        return true;
                    } else {
                        board.empty(row, col);
                    }
                }
            }
        }
        return false;
    }

    private boolean applyRule1(Board board) {
        // First rule. If AI can win, then win
        for (int row = 1; row <= Board.NUM_ROWS_COLS; row++) {
            for (int col = 1; col <= Board.NUM_ROWS_COLS; col++) {
                if (board.shoot(row, col, getSymbol())) {
                    if (board.wins(getSymbol())) {
                        return true;
                    } else {
                        board.empty(row, col);
                    }
                }
            }
        }
        return false;
    }

    private void randomShoot(Board board) {
        // 4th rule. Random position
        int row = 0, col = 0;
        do {
            row = (int) (Math.random() * Board.NUM_ROWS_COLS) + 1;
            col = (int) (Math.random() * Board.NUM_ROWS_COLS) + 1;
        } while (!board.isEmpty(row, col));
        board.shoot(row, col, getSymbol());
    }
}
