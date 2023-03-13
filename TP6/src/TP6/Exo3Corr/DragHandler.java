package TP6.Exo3Corr;

import TP6.Exo3.DrawingPane;
import TP6.Exo3.Point;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DragHandler implements EventHandler<MouseEvent> {

    private DrawingPane dp;

    public DragHandler(DrawingPane dp){
        this.dp = dp;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        Point p = new Point(mouseEvent.getX(), mouseEvent.getY());
        dp.continueCurve(p);
    }
}
