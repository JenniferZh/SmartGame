public class Board {
    private int[][] board;
    private final int width = 11;
    private final int height = 5;

    public Board(int[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }

    public boolean isValidPoint(int x, int y) {
        if (x >= 0 && x < height && y >=0 && y < width) return true;
        return false;
    }

    public boolean isValidPoint(Point p) {
        return isValidPoint(p.getX(), p.getY());
    }

    /**
     * find a random left-up corner of a board
     * @return left-up corner Point of a board
     */
    public Point getCorner() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isCorner = true;
                if (board[i][j] != 0) continue;
                if (isValidPoint(i-1, j) && board[i-1][j] == 0) isCorner = false;
                if (isValidPoint(i, j-1) && board[i][j-1] == 0) isCorner = false;
                if (isCorner) return new Point(i, j);
            }
        }
        return null;
    }
}
