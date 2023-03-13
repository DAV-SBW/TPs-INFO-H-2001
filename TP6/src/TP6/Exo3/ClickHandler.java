package TP6.Exo3;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public class ClickHandler implements EventHandler<MouseEvent> {
    private DrawingPane dp;

    public ClickHandler(DrawingPane dp){
        this.dp = dp;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED){
            Point p = new Point(event.getX(),event.getY());
            dp.startCurve(p);
        }
        if (event.getEventType() == MouseEvent.MOUSE_RELEASED){
            Point p = new Point(event.getX(),event.getY());
            dp.endCurve(p);
        }

        //System.out.println(event.getEventType());
        //Circle circle = new Circle();

        //Setting the position of the circle
        //circle.setCenterX(event.getX());
        //circle.setCenterY(event.getY());

        //Setting the radius of the circle
        //circle.setRadius(100.0);

        //circle.setFill(Color.BLUE);
        //dp.getChildren().add(circle);

    }
}
