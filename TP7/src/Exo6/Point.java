package Exo6;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(double v) {
        x = v;
    }

    public void setY(double v) {
        this.y = v;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point p) {
        // double d =  Math.sqrt(Math.pow((x.getValue()-p.x.getValue()), 2) + Math.pow((y.getValue() - p.y.getValue()), 2));
        double d =  Math.sqrt(Math.pow((x-p.x), 2) + Math.pow((y - p.y), 2));
        return d;
    }
}
