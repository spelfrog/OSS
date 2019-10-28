public class KreisAgg implements Form {
    public Point point;
    public double r;

    KreisAgg() {
        this(0, 0, 0);
    }

    KreisAgg(int x, int y, double r) {
        this(new Point(x, y), r);
    }

    KreisAgg(Point p, double r) {
        this.point = p;
        this.r = r;
    }

    public double flaechenInhalt() {
        return Math.PI * this.r * this.r;
    }

    public KreisAgg clone() {
        return new KreisAgg(this.point.x, this.point.y, this.r);
    }

    public boolean equals(KreisAgg k) {
        return this.point.equals(k.point) && this.r == k.r;
    }

    public String toString() {
        return "(x=" + this.point.x + ",y=" + this.point.y + ",r=" + this.r + ")";
    }
}
