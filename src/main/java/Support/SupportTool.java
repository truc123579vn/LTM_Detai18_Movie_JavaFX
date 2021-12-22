package Support;


import DTO.Actor_DTO;
import DTO.MovieSearchResult_DTO;
import DTO.Review_DTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class SupportTool {
    private static ObjectInputStream inclient = null;
    private static ObjectOutputStream outclient = null;

    public static ObjectInputStream getInputClient()
    {
        return inclient;
    }
    public static ObjectOutputStream getOutputClient()
    {
        return outclient;
    }

    public static void InitializeInputClient(Socket s) throws IOException {

            inclient =new ObjectInputStream(s.getInputStream());

    }

    public static void InitializeOutputClient(Socket s) throws IOException {

            outclient =new ObjectOutputStream(s.getOutputStream());
    }
    public static ObservableList<MovieSearchResult_DTO> convertListDTOtoObservableListMovie(List<MovieSearchResult_DTO> list)
    {
        ObservableList<MovieSearchResult_DTO> movieModels = FXCollections.observableArrayList();
        for (MovieSearchResult_DTO dto: list
             ) {
            movieModels.add(new MovieSearchResult_DTO(dto.getID(), dto.getTitle(), dto.getImg(), dto.getDirector(), dto.getStars(), dto.getRating()));
       //     System.out.println(dto.getImg());
        }
        return  movieModels;
    }

    public static ObservableList<String> convertListDTOtoObservableListActors(List<Actor_DTO> list)
    {
        ObservableList<String> actor_dtos = FXCollections.observableArrayList();
        for (Actor_DTO dto: list
        ) {
            actor_dtos.add(dto.getName());
            //     System.out.println(dto.getImg());
        }
        return  actor_dtos;
    }


    public static ObservableList<Review_DTO> convertListDTOtoObservableListReviews(List<Review_DTO> list)
    {
        ObservableList<Review_DTO> review_dtos = FXCollections.observableArrayList();
        for (Review_DTO dto: list
        ) {
            review_dtos.add(new Review_DTO(dto.getUsername(), dto.getDate(), dto.getRate(), dto.getTitle(), dto.getContent()));
            //     System.out.println(dto.getImg());
        }
        return  review_dtos;
    }

    public static void CreateWebviewBrowser(String url)
    {
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();


        // Tải một trang HTML từ url.
        webEngine.load(url);
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.getChildren().addAll(browser);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Anh");
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(500);

        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

            @Override
            public void handle(WindowEvent event) {
                webEngine.load(null);
            }
        });
    }

}
