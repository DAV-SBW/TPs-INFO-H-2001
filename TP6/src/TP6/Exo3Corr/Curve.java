package TP6.Exo3Corr;


import java.util.ArrayList;
import java.util.List;
import TP6.Exo3.Point;


public class Curve {
    private ArrayList<Point> points = new ArrayList<Point>();

    public void addPoint(Point p){
        points.add(p);
    }

    public ArrayList<Point> getPointsList(){
        return points;
    }
}
