import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player1 = getPlayerFromKeyboard(input, 1);
        Player player2 = getPlayerFromKeyboard(input, 2);
        Player currentPlayer = player1;
        Board board = new Board();
        System.out.println(board);
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
