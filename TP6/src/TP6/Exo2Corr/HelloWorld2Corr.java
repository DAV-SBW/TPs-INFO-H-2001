package TP6.Exo2Corr;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld2Corr extends Application {

    private Parent createContent() {
        BorderPane borderPane = new BorderPane();
        TextArea field = new TextArea("Enter your text here");
        Text myText = new Text("J'ai mis mon texte là pour faire chier");
        borderPane.setTop(field);
        borderPane.setCenter(myText);

        borderPane.setBottom(createBoutonPane(field));

        return borderPane;
    }

    private Parent createBoutonPane(TextArea ta){
        // Pourquoi on crée un new TilePane ? pour contenir les boutons en fait
        TilePane pane = new TilePane();
        Button clear = new Button("Clear");
        clear.setOnMouseClicked(new ClearListener(ta));
        pane.getChildren().add(clear);

        Button test = new Button("Test");
        test.setOnMouseClicked(new TestListener(ta));
        pane.getChildren().add(test);
        return pane;
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

