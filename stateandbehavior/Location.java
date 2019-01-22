package stateandbehavior;

public class Location {
  /*
    up() - beveger figuren en rute opp
    down() - beveger figuren en rute ned
    left() - beveger figuren en rute til venstre
    right() - beveger figuren en rute til høyre
    getX() - returnerer x-posisjonen til figuren
    getY()  - returnerer y-posisjonen til figuren
  */

    double x;
    double y;

    public void up() {
        y -= 1;
    }
    public void down() {
        y += 1;
    }
    public void left() {
        x -= 1;
    }
    public void right() {
        x += 1;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public String toString(){
        return "X er: " + x + " og y er: " + y;
    }
    public static void main(String[] args) {
        Location location = new Location();
        System.out.println(location);


    }
}