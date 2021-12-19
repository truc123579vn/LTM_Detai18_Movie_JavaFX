package FXML.ltm_doandetai18_javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {
    public static Scene scene;

    public Start() {
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Home"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Bao cao de tai 18");
        stage.show();
    }
    public static void setRoot(String fxml) throws IOException {

        scene.setRoot(loadFXML(fxml));

    }

    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }


}
