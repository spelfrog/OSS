public class Point {
    int x, y;

    Point() {}

    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point getLocation() {
        return new Point(this.x, this.y);
    }

    public void setLocation(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean equals(Point p) {
        return this.x == p.x && this.y == p.y;
    }

    public String toString() {
    return "(" + this.x + "," + this.y + ")";
    }
}
