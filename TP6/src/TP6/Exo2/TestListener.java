package TP6.Exo2;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class TestListener implements EventHandler<MouseEvent> {
    private TextArea ta;
    private String myText = "Test Réussi!";

    public TestListener(TextArea ta){
        this.ta = ta;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        ta.setText(myText);
    }
}
