import java.util.ArrayList;
import java.util.List;

public class Piece {
    public int id;
    private List<Point> locates;

    public Piece(int[][] piece, int id) {
        this.id = id;
        this.locates = new ArrayList<Point>();
        for (int i = 0; i < piece.length; i++) {
            Point p = new Point(piece[i][0], piece[i][1]);
            locates.add(p);
        }
    }

    public List<Point> getLocates() {
        return locates;
    }

    public Piece degree90() {

    }
}
