import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game2d {
    private static final int[][][] piecesMap =
            {
                    {{0, 0}, {0, 1}, {0, 2}, {1, 2}, {1, 3}},
                    {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}},
                    {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 2}},
                    {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {2, 0}},
                    {{0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 1}},
                    {{0, 0}, {0, 1}, {1, 1}, {1, 2}, {2, 2}},
                    {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 1}},
                    {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {1, 0}},
                    {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
                    {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
                    {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
                    {{0, 0}, {0, 1}, {1, 0}}
            };

    private final List<Piece> pieces;
    private Board board;
    private boolean[] initUsed;
    private Board solutionBoard;

    private static final int WIDTH = 11;
    private static final int HEIGHT = 5;

    private static Board readBoard(String filePath) throws Exception{
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        int[][] boardmap = new int[5][11];
        int index = 0;

        while (sc.hasNext()) {
            int cur = sc.nextInt();
            boardmap[index/WIDTH][index%WIDTH] = cur;
            index++;
        }

        Board board = new Board(boardmap);
        return board;

    }

    private static boolean[] readInit(String filePath) throws Exception{
        boolean[] used = new boolean[piecesMap.length];
        int index = 0;

        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            used[index++] = sc.next().equals("1");
        }

        return used;
    }



    public Game2d() throws Exception{
        pieces = new ArrayList<Piece>();
        for (int i = 0; i < piecesMap.length; i++) {
            Piece piece = new Piece(piecesMap[i], i+1);
            pieces.add(piece);
        }

        this.board = readBoard("src/main/resources/board.txt");
        this.initUsed = readInit("src/main/resources/board_used.txt");

    }

    public void generateSolution() {


    }

    private void solutionHelper(Board curboard, boolean[] used) {
        if (curboard.isFull()) {
            this.solutionBoard = curboard;
            return;
        }
        Point leftUpCorner = board.getCorner();
        for (int i = 0; i < pieces.size(); i++) {
            if (used[i]) continue;
            
        }
    }

    public static void main(String[] args) throws Exception{
        Game2d game = new Game2d();
        game.board.printBoard();
        game.board.getCorner().print();
    }
}
