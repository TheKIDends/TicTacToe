public class Board {
    private Cell[][] board;

    /**
     * Constructor.
     */
    Board() {
        board = new Cell[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = new Cell();
            }
        }
    }

    /**
     * Get cell.
     */
    public CellStatus getCell(int x, int y) {
        return board[x][y].getStatus();
    }

    /**
     * Place mark.
     */
    public boolean tick(int x, int y, CellStatus status) {
        if (x < 0 || x > 2) {
            return false;
        }
        if (y < 0 || y > 2) {
            return false;
        }

        if (board[x][y].getStatus() != CellStatus.EMPTY) {
            return false;
        }

        board[x][y].setStatus(status);
        return true;
    }

    /**
     * Show board.
     */
    public void show() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                switch (board[i][j].getStatus()) {
                    case O -> System.out.print("[O]");
                    case X -> System.out.print("[X]");
                    default -> System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}
