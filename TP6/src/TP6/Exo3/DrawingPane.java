package TP6.Exo3;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class DrawingPane extends Pane {

    private Curve currentCurve;

    public void startCurve(Point p){
        // Note : on instancie ici cet objet sans qu'il y ait besoin de constructeur
        currentCurve = new Curve();
        currentCurve.addPoint(p);
    }

    public void continueCurve(Point p){
        currentCurve.addPoint(p);
    }

    public void endCurve(Point p){
        currentCurve.addPoint(p);
        drawCurve();
        currentCurve = null;
    }

    public void clearCurves(){
        this.getChildren().clear();
    }

    private void drawCurve() {
        ArrayList<Point> points = currentCurve.getPointsList();
        Line l = null;
        for (int i=0; i<points.size(); i++){
            l = new Line(points.get(i).getX(), points.get(i).getY(),
                    points.get(i+1).getY(), points.get(i+1).getY());
                    // Ligne moins comprise : ok --> Exemple
            //In JavaFX, the scene graph objects, such as lines, circles, and rectangles are derived classes of the Shape class.
            //The following code creates a line with a start point (100, 10) and end point (10, 110) using constructor.
            //Line line = new Line(100, 10,   10,   110);
            getChildren().add(l);
        }
        currentCurve = null;
    }

}
