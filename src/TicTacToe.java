import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);
        Player player1 = getPlayerFromKeyboard(input, 1);
        Player player2 = getPlayerFromKeyboard(input, 2);
        Player currentPlayer = player1;
        Board board = new Board();
        System.out.println(board);

        while (!gameOver) {
            System.out.println("[" + currentPlayer.getSymbol() + "] " + currentPlayer.getName());
            int row = readRowFromKeyboard(input);
            int col = readColFromKeyboard(input);
            board.shoot(row, col, currentPlayer);
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }

    public static Player getPlayerFromKeyboard(Scanner input, int turn) {
        String symbol, name, aiAnswer;
        boolean ai;
        if (turn == 1) {
            symbol = "X";
        } else {
            symbol = "O";
        }
        System.out.println("Enter your name:");
        name = input.next();
        System.out.println("Are you an AI? (Y/N)");
        aiAnswer = input.next().toUpperCase();
        if (aiAnswer.equals("Y")) {
            ai = true;
        } else {
            ai = false;
        }
        return new Player(name, ai, symbol);
    }
}
