package P1;

//Objekt, dass ein rechteck darstellen soll. Gespannt zwischen 2 Punkten
public class Rechteck implements Form {
  public Point p1, p2;

  public Rechteck() {
    this(new Point(0, 0), new Point(0, 0));
  }

  public Rechteck(int breite, int hoehe) {
    this(new Point(0, 0), breite, hoehe);
  }

  public Rechteck(Point p1, int breite, int hoehe) {
    this.p1 = p1;
    p2 = new Point(p1.x + breite, p1.y + hoehe);
  }

  public Rechteck(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  //gibt den Flächeninhalt des Objekts zurück
  public double flaechenInhalt() {
    return Math.abs(p1.x - p2.x) * Math.abs(p1.y - p2.y);
  }

  //Prüft, ob der übergebene P1.Point die gleichen werte hat
  public boolean equals(Rechteck r) {
    return this.p1.equals(r.p1) && this.p2.equals(r.p2);
  }

  //gibt einen neuen P1.KreisAgg mit den gleichen Parametern zurück
  public Rechteck clone() {
    return new Rechteck(this.p1, this.p2);

  }

  //Erstellt einen String, der die werte des Objekts aufzählt
  public String toString() {
    return "(x1=" + this.p1.x + ",y1=" + this.p1.y + "x2=" + this.p2.x + ",y2=" + this.p2.y + ")";
  }
}
