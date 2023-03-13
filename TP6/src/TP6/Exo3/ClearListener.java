package TP6.Exo3;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClearListener implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;

    public ClearListener(DrawingPane drawingPane){
        this.drawingPane = drawingPane;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        drawingPane.clearCurves();
    }
}
