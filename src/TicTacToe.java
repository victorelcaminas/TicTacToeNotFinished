import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board();
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);
        Player player1, player2, currentPlayer;
        player1 = readPlayerFromKeyboard(input, 1);
        player2 = readPlayerFromKeyboard(input, 2);
        currentPlayer = player1;
        while (!gameOver) {
            System.out.println(board);
            System.out.println(currentPlayer);
            currentPlayer.shoot(input, board);
            if (board.wins(currentPlayer.getSymbol())) {
                System.out.println(board);
                gameOver = true;
                System.out.println("You win: " + currentPlayer);
            } else {
                if (board.draws()) {
                    System.out.println(board);
                    System.out.println("It is a draw");
                    gameOver = true;
                }
            }
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }

    }

    private static Player readPlayerFromKeyboard(Scanner input, int turn) {
        Player player;
        System.out.println("Enter name: ");
        String name = input.next();
        String symbol;
        if (turn == 1) {
            symbol = Player.PLAYER1_SYMBOL;
        } else {
            symbol = Player.PLAYER2_SYMBOL;
        }
        System.out.println("Are you an AI? (Y/N)");
        String answer = input.next();
        if (answer.toUpperCase().equals("Y")) {
            player = new PlayerAI(name, symbol);
        } else {
            player = new Player(name, symbol);
        }
        return player;
    }


}
