import java.util.Scanner;

enum GameStatus {
    NOT_OVER,
    DRAW,
    X_WIN,
    O_WIN
}

enum CellStatus {
    EMPTY,
    O,
    X
}

public class Game {
    private static final Board board = new Board();

    /**
     * Constructor.
     */
    Game() {
    }

    /**
     * Game status.
     */
    private static GameStatus gameStatus() {
        for (int i = 0; i < 3; ++i) {
            if (board.getCell(i, 0) == board.getCell(i, 1) && board.getCell(i, 1) == board.getCell(i, 2)) {
                if (board.getCell(i, 0) == CellStatus.X) {
                    return GameStatus.X_WIN;
                }
                if (board.getCell(i, 0) == CellStatus.O) {
                    return GameStatus.O_WIN;
                }
            }

            if (board.getCell(0, i) == board.getCell(1, i) && board.getCell(1, i) == board.getCell(2, i)) {
                if (board.getCell(0, i) == CellStatus.X) {
                    return GameStatus.X_WIN;
                }
                if (board.getCell(0, i) == CellStatus.O) {
                    return GameStatus.O_WIN;
                }
            }
        }

        if (board.getCell(0, 0) == board.getCell(1, 1) && board.getCell(1, 1) == board.getCell(2, 2)) {
            if (board.getCell(1, 1) == CellStatus.X) {
                return GameStatus.X_WIN;
            }
            if (board.getCell(1, 1) == CellStatus.O) {
                return GameStatus.O_WIN;
            }
        }

        if (board.getCell(0, 2) == board.getCell(1, 1) && board.getCell(1, 1) == board.getCell(2, 0)) {
            if (board.getCell(1, 1) == CellStatus.X) {
                return GameStatus.X_WIN;
            }
            if (board.getCell(1, 1) == CellStatus.O) {
                return GameStatus.O_WIN;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board.getCell(i, j) != CellStatus.EMPTY) {
                    ++cnt;
                }
            }
        }
        if (cnt == 9) {
            return GameStatus.DRAW;
        }
        return GameStatus.NOT_OVER;
    }

    /**
     * Swap turn.
     */
    private static CellStatus swapTurn(CellStatus turn) {
        if (turn == CellStatus.X) {
            return CellStatus.O;
        } else {
            return CellStatus.X;
        }
    }

    /**
     * Main.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellStatus turn = CellStatus.X;

        System.out.println("Tic-tac-toe");
        System.out.println("Start game!!!");
        while (gameStatus() == GameStatus.NOT_OVER) {
            if (turn == CellStatus.X) {
                System.out.println("X turn");
            } else {
                System.out.println("O turn");
            }
            while (true) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                --x;
                --y;
                if (board.tick(x, y, turn)) {
                    break;
                } else {
                    System.out.println("Invalid! Try again.");
                }
            }
            board.show();
            turn = swapTurn(turn);
        }

        switch (gameStatus()) {
            case X_WIN -> System.out.println("Game over!!! Player X is the winner.");
            case O_WIN -> System.out.println("Game over!!! Player O is the winner.");
            default -> System.out.println("Game over!!! Draw.");
        }
    }
}