public class KreisVererb extends Point {
    private int r;

    KreisVererb(KreisVererb k) {
        super(k.getLocation());
    }

    KreisVererb(int x, int y, int r) {
        super(x,y);
        this.r = r;
    }
}
