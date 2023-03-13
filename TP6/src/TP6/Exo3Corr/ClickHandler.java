package TP6.Exo3Corr;

import TP6.Exo3.DrawingPane;
import TP6.Exo3.Point;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class ClickHandler implements EventHandler<MouseEvent> {
    private DrawingPane dp;

    public ClickHandler(DrawingPane dp){
        this.dp = dp;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED){
            Point p = new Point(event.getX(), event.getY());
            dp.startCurve(p);
        }
        if (event.getEventType() == MouseEvent.MOUSE_RELEASED){
            Point p = new Point(event.getX(), event.getY());
            dp.endCurve(p);
        }

    }
}