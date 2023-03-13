package TP5.Exo1Corr;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MultiEditor extends Application implements Observer {

    private TextField myText;
    private Document shareDoc;
    private Button createEditor;
    private BorderPane bPane;
    private Stage stage;


    public MultiEditor(){
        this(new Document());
    }


    public MultiEditor(Document doc) {
        shareDoc = doc;
        doc.attach(this);
        buildUI();
        setButtonListener();
        setTextListener();
    }


    private void buildUI() {
        stage = new Stage();
        bPane = new BorderPane();
        stage.setTitle("Multi-editor");

        myText = new TextField("Enter text here");
        bPane.setTop(myText);
        createEditor = new Button("Create new");
        bPane.setBottom(createEditor);

        Scene scene = new Scene(bPane);
        stage.setScene(scene);
        stage.show();
        System.out.println("new editor should be visible");
    }


    private void setButtonListener(){
        createEditor.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("Hello World");
                new MultiEditor(shareDoc);
            }
        }));
    }

    private void setTextListener() {
        myText.setOnKeyTyped((new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
               shareDoc.setText(myText.getText());
            }
        }));
    }

    public void update(String newText) {
        if(!newText.equals(myText.getText())) {
            this.myText.setText(newText);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) { }

}
