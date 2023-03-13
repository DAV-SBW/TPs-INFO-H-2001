package TP6.Exo2Corr;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class ClearListener implements EventHandler<MouseEvent> {
    private TextArea field;

    public ClearListener(TextArea field) {
        this.field = field;
    }

    @Override
    public void handle(MouseEvent event) {
        field.clear();
    }
}