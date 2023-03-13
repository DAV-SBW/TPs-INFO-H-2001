package TP6.Demo;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

public class ClearListener implements EventHandler {
    private TextArea ta;

    public ClearListener(TextArea ta){
        this.ta = ta;
    }
    @Override
    public void handle(Event event) {
        ta.setText("");
    }
}
