
public class Main {


    public static void main(String[] args) {
        aufgabe1();
        aufgabe2();
        aufgabe3();

    }

    private static void aufgabe1() {
        final int depth = 10;
        int[][] pd = new int[depth][];
        for (int r = 0; r < depth; r++) {
            pd[r] = new int[r + 1];
            for (int c = 0; c <= r; c++) {
                if (c == 0 || c == r) {
                    pd[r][c] = 1;
                } else {
                    pd[r][c] = pd[r - 1][c - 1] + pd[r - 1][c];
                }
            }
        }
        for (int r = 0; r < depth; r++) {
            for (int c = 0; c <= r; c++) {
                System.out.print(pd[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void aufgabe2() {
        Point p1 = new Point(0, 10);
        System.out.println(p1);
        p1.move(5, 5);
        System.out.println(p1);
        p1.setLocation(99, 15);
        System.out.println(p1);
        Point p2 = p1.getLocation();
        System.out.println(p2);
        System.out.println(p1.equals(p2));
        p2.move(1, 1);
        System.out.println(p2);

    }
    public static void aufgabe3() {
        Form[] fs = new Form[4];
        fs[0] = new KreisAgg(2, 3, 4);
        fs[1] = new Rechteck(5, 3);
        fs[2] = new KreisAgg(new Point(1, 1), 10);
        fs[3] = new Rechteck(new Point(), new Point(1, 2));
        double sum = 0;
        for (Form f : fs) {
            System.out.println(f);
            sum += f.flaechenInhalt();
        }
        System.out.printf("Gesamt Fläche: %.2f\n ", sum);
    }
}
