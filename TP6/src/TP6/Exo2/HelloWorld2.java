package TP6.Exo2;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld2 extends Application {

    private Parent createContent(){
        BorderPane borderPane = new BorderPane();
        TextArea field = new TextArea("Enter tour text here");
        Text myText1 = new Text("Ceci est le Texte du dessus");
        Text myText2 = new Text("J'ai mis mon texte là pour faire chier");
        borderPane.setTop(field);
        borderPane.setCenter(myText2);
        borderPane.setBottom(CreateButtonPane(field));
        return borderPane;
    }

    private Parent CreateButtonPane(TextArea ta){
        TilePane pane = new TilePane();
        // Tile pane met les éléments les uns à la suite des autres
        Button clear = new Button("clear");
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
