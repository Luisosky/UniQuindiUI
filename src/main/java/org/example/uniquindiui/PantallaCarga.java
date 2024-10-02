package org.example.uniquindiui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PantallaCarga extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();


        Rectangle contenedor = new Rectangle(200, 300);
        contenedor.setFill(Color.TRANSPARENT);
        contenedor.setStroke(Color.DARKGRAY);


        Rectangle liquido = new Rectangle(200, 0);
        liquido.setFill(Color.DODGERBLUE);


        Label loadingLabel = new Label("Cargando...");

        root.getChildren().addAll(contenedor, liquido, loadingLabel);

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Cargando");
        stage.show();


        Timeline fillTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(liquido.heightProperty(), 0)),
                new KeyFrame(Duration.seconds(3), new KeyValue(liquido.heightProperty(), 300))
        );


        fillTimeline.play();


        fillTimeline.setOnFinished(event -> {
            try {
                new UIApp().start(new Stage());
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
