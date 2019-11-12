import P1.*;
import P2.*;

//Dient zum start der Aufgaben
public class Main {


  public static void main(String[] args) {

    char[] a = {'a','b'};
    char[] a2 = {'a','b'};

    Benutzer b = new Benutzer("123",a);
    Benutzer c = new Benutzer("123",a2);
    System.out.println(b.equals2(c));
  }

  // erzeugt ein Pascal’sches Dreieck der tieft depth
  private static void aufgabe1() {
    final int depth = 10;
    int[][] pd = new int[depth][];
    for (int r = 0; r < depth; r++) {
      pd[r] = new int[r + 1];
      pd[r][0] = 1;
      pd[r][r] =1;
      for (int c = 1; c < r; c++) {
        pd[r][c] = pd[r - 1][c - 1] + pd[r - 1][c];

      }
    }

    for (int r = 0; r < depth; r++) {
      for (int c = 0; c <= r; c++) {
        System.out.print(pd[r][c] + " ");
      }
      System.out.println();
    }
  }

  //tests für die Aufgabe 2
  private static void aufgabe2() {
    KreisVererb k = new KreisVererb(1,2,3);
    System.out.println(k);
    k.move(5,5);
    System.out.println(k);
    KreisVererb k2 = new KreisVererb(6,7,3);
    System.out.println(k.equals(k2));



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

  //erzeugt ein Array gefüllt mir 4 Formen und berechnet den gesamten Flächeninhalt
  public static void aufgabe3() {
    Form[] fs = new Form[4];
    fs[0] = new Rechteck(5, 5);
    fs[1] = new Rechteck(3, 3);
    fs[2] = new KreisAgg(1, 1, 1);
    fs[3] = new KreisAgg(1, 1, 1);
    double sum = 0;
    for (Form f : fs) {
      System.out.println(f);
      sum += f.flaechenInhalt();
    }
    System.out.printf("Gesamt Fläche: %.2f\n ", sum);
  }
}
