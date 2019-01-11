import java.util.HashSet;

public class Point {
    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void print() {
        System.out.println(x+" "+y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Point))
            return false;
        if (obj == this)
            return true;
        return this.getX() == ((Point) obj).getX() && this.getY() == ((Point) obj).getY();
    }

    public int hashCode() {
        return x*17+y;
    }

    public static void main(String[] args) {
        HashSet<Point> test = new HashSet<Point>();
        test.add(new Point(1,2));
        System.out.println(test.contains(new Point(1,2)));
        System.out.println(test.contains(new Point(2,2)));
    }
}
