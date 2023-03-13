package TP6.Exo1;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld1 extends Application {

    private Parent createContent(){
        BorderPane borderPane = new BorderPane();
        Button clear = new Button("Clear");
        TextField field = new TextField("Please write here");
        Text myText = new Text("Hello");
        borderPane.setTop(myText);
        borderPane.setCenter(field);
        borderPane.setBottom(clear);
        return borderPane;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
