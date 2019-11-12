package P1;

//Ein Objekt, dasss einen Punkt darstellen soll (Druch zwei koordinaten
public class Point {
  int x, y;

  public Point() {
  }

  public Point(Point p) {
    this.x = p.x;
    this.y = p.y;
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  //return einen neuen P1.Point, mit den kleichen koordinaten
  public Point getLocation() {
    return new Point(this.x, this.y);
  }

  //setzte die koordinaten des Points
  public void setLocation(Point p) {
    this.x = p.x;
    this.y = p.y;
  }

  //setze die koordinaten des Points
  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }

  //bewegt die koordinaten des Points um die übergebenen werte
  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  //Prüft, ob der übergebene P1.Point die gleichen werte hat
  public boolean equals(Point p) {
    return this.x == p.x && this.y == p.y;
  }

  //Erstellt einen String, der die werte des Objekts aufzählt
  public String toString() {
    return "(" + this.x + "," + this.y + ")";
  }
}
