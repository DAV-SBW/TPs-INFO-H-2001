package TP6.Demo;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Text t = new Text("Hello World");
        // Création du parent StackPane
        Button b = new Button("Clear");
        TextArea ta = new TextArea("Please enter text here");

        BorderPane bp = new BorderPane();

        //b.setOnMouseClicked(new EventHandler<MouseEvent>() {
            //@Override
            //public void handle(MouseEvent mouseEvent) {
                // Méthode qui sera appellée quand on appuiera sur le boutton
                //ta.setText("");
            //}
        //}); Mauvaise solution car on fout toute une classe dans une autre... On est limité après...

        // Bnne solution :
        b.setOnMouseClicked(new ClearListener(ta));

        bp.setCenter(ta);
        bp.setBottom(b);
        bp.setTop(t);

        StackPane p = new StackPane(t);
        Scene s = new Scene(bp);
        stage.setScene(s);
        stage.show();
        stage.setMinHeight(100);
        stage.setMinWidth(400);
        stage.setTitle("Hello");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
