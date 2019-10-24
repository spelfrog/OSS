public class Main {

    public static void main(String[] args) {
        aufgabe1();
    }

    private static void aufgabe1() {
        int depth = 10;
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

}
