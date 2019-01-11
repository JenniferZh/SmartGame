import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Piece {
    public int id;
    private Set<Point> locates;
    private boolean isSymmetry;

    public Piece(int[][] piece, int id, boolean isSymmetry) {
        this.id = id;
        this.locates = new HashSet<Point>();
        for (int i = 0; i < piece.length; i++) {
            Point p = new Point(piece[i][0], piece[i][1]);
            locates.add(p);
        }
        this.isSymmetry = isSymmetry;
    }

    public Piece(Piece piece, Set<Point> points) {
        this.id = piece.id;
        this.locates = points;
        this.isSymmetry = piece.isSymmetry;
    }

    public Set<Point> getLocates() {
        return locates;
    }

    public List<Point> getLeftUps() {
        List<Point> result = new ArrayList<Point>();
        for (Point p: locates) {
            if (!locates.contains(new Point(p.getX()-1, p.getY())) && !locates.contains(new Point(p.getX(), p.getY()-1)))
                result.add(p);
        }
        return result;
    }

    public void formatWithGivenPoint(Point p) {
        if (p.getX() == 0 && p.getY() == 0) return;
        int offsetX = 0 - p.getX();
        int offsetY = 0 - p.getY();
        for (Point piecePoint: locates) {
            piecePoint.setX(piecePoint.getX()+offsetX);
            piecePoint.setY(piecePoint.getY()+offsetY);
        }
    }

    public void print() {
        for (Point p: locates) p.print();
    }

    public Piece[] getAllDirections() {
        Piece[] result;
        if (isSymmetry) {
            result = new Piece[4];
            result[0] = this;
            result[1] = degree90();
            result[2] = degree180();
            result[3] = degree270();
        } else {
            result = new Piece[8];
            result[0] = this;
            result[1] = degree90();
            result[2] = degree180();
            result[3] = degree270();
            result[4] = mirror();
            result[5] = degree90mirror();
            result[6] = degree180mirror();
            result[7] = degree270mirror();
        }
        return result;
    }

    private Piece mirror() {
        Set<Point> points = new HashSet<Point>();
        for (Point p: locates) {
            points.add(new Point(p.getY(), p.getX()));
        }
        return new Piece(this, points);
    }

    private Piece degree90() {
        Set<Point> points = new HashSet<Point>();
        for (Point p: locates) {
            points.add(new Point(p.getY(), -p.getX()));
        }
        return new Piece(this, points);
    }

    private Piece degree90mirror() {
        Set<Point> points = new HashSet<Point>();
        for (Point p: locates) {
            points.add(new Point(p.getX(), -p.getY()));
        }
        return new Piece(this, points);
    }

    private Piece degree180() {
        Set<Point> points = new HashSet<Point>();
        for (Point p: locates) {
            points.add(new Point(-p.getX(), -p.getY()));
        }
        return new Piece(this, points);
    }

    private Piece degree180mirror() {
        Set<Point> points = new HashSet<Point>();
        for (Point p: locates) {
            points.add(new Point(-p.getY(), -p.getX()));
        }
        return new Piece(this, points);
    }

    private Piece degree270() {
        Set<Point> points = new HashSet<Point>();
        for (Point p: locates) {
            points.add(new Point(-p.getY(), p.getX()));
        }
        return new Piece(this, points);
    }

    private Piece degree270mirror() {
        Set<Point> points = new HashSet<Point>();
        for (Point p: locates) {
            points.add(new Point(-p.getX(), p.getY()));
        }
        return new Piece(this, points);
    }
}
