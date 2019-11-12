package P1;

//Definiert einen Kreis, durch einen punkt mit koordinaten und einem radius
public class KreisAgg implements Form {
  public Point point;
  public double r;

  public KreisAgg() {
    this(0, 0, 0);
  }

  public KreisAgg(int x, int y, double r) {
    this(new Point(x, y), r);
  }

  public KreisAgg(Point p, double r) {
    this.point = p;
    this.r = r;
  }

  //gibt den flächeninhalt des kreises zurück
  public double flaechenInhalt() {
    return Math.PI * this.r * this.r;
  }

  //gibt einen neuen P1.KreisAgg mit den gleichen Parametern zurück
  public KreisAgg clone() {
    return new KreisAgg(this.point.x, this.point.y, this.r);
  }

  //gibt true zurück, wenn das übergebene element, die gleichen werte hat, wie das aktuelle
  public boolean equals(KreisAgg k) {
    return this.point.equals(k.point) && this.r == k.r;
  }

  //Erstellt einen String, der die werte des Objekts aufzählt
  public String toString() {
    return "(x=" + this.point.x + ",y=" + this.point.y + ",r=" + this.r + ")";
  }
}
