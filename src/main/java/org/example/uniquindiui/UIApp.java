package org.example.uniquindiui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class UIApp extends Application {

    @Override
    public void start(Stage stage) {
        try {
            URL fxmlLocation = getClass().getResource("/org/example/uniquindiui/UIApp.fxml");
            if (fxmlLocation == null) {
                throw new IOException("FXML file not found.");
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();

            URL iconLocation = getClass().getResource("/images/icon.png");
            if (iconLocation == null) {
                throw new IOException("Icon image not found.");
            }

            Image icon = new Image(iconLocation.toString());
            stage.getIcons().add(icon);

            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("/estilos.css").toExternalForm());
            stage.setTitle("UI!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Failed to load FXML file or icon image.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}