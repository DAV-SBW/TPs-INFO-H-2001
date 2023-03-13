package TP6.Exo3;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DragHandler implements EventHandler<MouseEvent> {

    private DrawingPane dp;

    public DragHandler(DrawingPane dp){
        this.dp = dp;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Point p = new Point(mouseEvent.getX(),mouseEvent.getY());
        dp.continueCurve(p);
        //System.out.println(mouseEvent.getEventType());
    }
}

