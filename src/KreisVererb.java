public class KreisVererb extends Point {
    private int r;
    KreisVererb() {}


    KreisVererb(KreisVererb k) {
        super(k.getLocation());
        this.r = k.r;

    }

    KreisVererb(int x, int y, int r) {
        // super ermöglicht den Java Konstruktor der Oberklasse zu verwenden
        super(x,y);
        this.r = r;
    }

    public boolean equals(KreisVererb k) {
       return (this.x == k.x && this.y == k.y && this.r == k.r);
    }

    public String toString() {
        return "{" + "x=" + x + ",y=" + y + ",r=" + r + '}';
    }
}
