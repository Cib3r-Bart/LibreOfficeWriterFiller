package es.jrcastle.libof;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LibOffApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibOffApp.class.getResource("libOff-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("LibreOfficeTest");
        scene.getStylesheets().add(Objects.requireNonNull(LibOffApp.class.getResource("Style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}