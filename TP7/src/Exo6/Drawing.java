package Exo6;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;

public class Drawing extends Pane implements Iterable<Shape> {

    ArrayList<Shape> shapes;

    public Drawing(){
        super();
        shapes = new ArrayList<Shape>();
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (Shape c : shapes){
                    c.update();
                }
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

    }

    /**
     * Ajoute une forme ou dessin et redessine
     */
    public void addShape(Shape s) {
        shapes.add(s);
        this.getChildren().add(s.getShape());
    }

    /**
     * Enlève toutes les formes et les redessine.
     */

    public void clear() {
        shapes.clear();
        this.getChildren().clear();
    }

    @Override
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }


}
