package TP6.Exo3;

import TP6.Exo3.ClickHandler;
import TP6.Exo3.DragHandler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Paint extends Application {
    private Scene mainScene;

    private BorderPane mainPane;
    private DrawingPane drawingPane;
    private Pane buttonsPane;

    private Button clearButton;

    private void initPanels() {
        drawingPane = new DrawingPane();                                // Creates another panel for DRAWING
        drawingPane.setBackground(
                new Background(
                        new BackgroundFill(Color.GRAY,
                                new CornerRadii(0), new Insets(0))));
        buttonsPane = new TilePane();
        mainPane.setCenter(drawingPane);
        mainPane.setBottom(buttonsPane);
    }


    private void initButtons(){
        clearButton = new Button();								    // Creates a button
        clearButton.setText("Effacer");								// Sets the text present on the button
        buttonsPane.getChildren().add(clearButton);								// Adds the button to the appropriate panel

        clearButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                drawingPane.clearCurves();
            }
        }));
    }


    private void initListeners(){
        drawingPane.setOnMouseDragged(new DragHandler(drawingPane));					// Specifies the DRAWING panel must listen to the MOUSE actions
        // drawingPane.setOnMouseClicked(new ClickHandler(drawingPane));
        ClickHandler cl = new ClickHandler(drawingPane);
        drawingPane.setOnMousePressed(cl);
        drawingPane.setOnMouseReleased(cl);
    }

    public void start(Stage stage) throws Exception {
        mainPane = new BorderPane();                    // Creates a MAIN panel with a BorderLayout
        mainScene = new Scene(mainPane);
        stage.setScene(mainScene);


        initPanels();
        initButtons();
        initListeners();

        stage.show();
    }

    public static void test(){
        launch();
    }

}

