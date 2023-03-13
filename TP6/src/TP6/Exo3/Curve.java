package TP6.Exo3;

import java.util.ArrayList;

public class Curve {
    private ArrayList<Point> points = new ArrayList<Point>();

    public void addPoint(Point p){
        points.add(p);
    }

    public ArrayList<Point> getPointsList() {
        return points;
    }
}
