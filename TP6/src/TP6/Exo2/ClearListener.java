package TP6.Exo2;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class ClearListener implements EventHandler<MouseEvent> {
    private TextArea field;

    public ClearListener(TextArea field){
        this.field = field;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        field.clear();
    }
}
