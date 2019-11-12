package P1;

//Eine Objekt Das dierekt von Kreis erbt und einen Kreis darstellt, durch koordinaten un einen radius
public class KreisVererb extends Point {
  private int r;

  public KreisVererb() {
  }

  public KreisVererb(KreisVererb k) {
    super(k.getLocation());
    this.r = k.r;
  }

  public KreisVererb(int x, int y, int r) {
    super(x, y);
    this.r = r;
  }

  //Prüft, ob der übergebene Kreis die gleichen werte hat
  public boolean equals(KreisVererb k) {
      return super.equals(k) && this.r == k.r;
  }

  //Erstellt einen String, der die werte des Objekts aufzählt
  public String toString() {
    return "{" + "x=" + x + ",y=" + y + ",r=" + r + '}';
  }
}
