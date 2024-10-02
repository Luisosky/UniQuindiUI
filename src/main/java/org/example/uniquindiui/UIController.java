package org.example.uniquindiui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.event.ActionEvent;

public class UIController {
    private boolean bloqueando = false;

    @FXML
    private VBox sidebar;
    @FXML
    private ImageView iconoView;
    @FXML
    private Button botonBloqueo;
    private Timeline expandir;
    private Timeline contraer;

    @FXML
    public void initialize() {
        expandir = new Timeline(
                new KeyFrame(Duration.millis(300), new KeyValue(sidebar.prefWidthProperty(), 200))
        );

        contraer = new Timeline(
                new KeyFrame(Duration.millis(300), new KeyValue(sidebar.prefWidthProperty(), 0))
        );

        sidebar.getStyleClass().add("sidebar");
        botonBloqueo.getStyleClass().add("button-icon");

        sidebar.setOnMouseEntered(event -> expandir.play());
        sidebar.setOnMouseExited(event -> contraer.play());
    }

    @FXML
    void bloquearAnima(ActionEvent event) {
        bloqueando = !bloqueando;
        if (bloqueando) {
            expandir.stop();
            contraer.stop();
            sidebar.setOnMouseEntered(null);
            sidebar.setOnMouseExited(null);
        } else {
            sidebar.setOnMouseEntered(e -> expandir.play());
            sidebar.setOnMouseExited(e -> contraer.play());
        }
    }
}