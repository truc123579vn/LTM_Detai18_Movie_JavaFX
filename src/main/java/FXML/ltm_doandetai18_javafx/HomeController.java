package FXML.ltm_doandetai18_javafx;

import Model.MovieModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {
    public static String inputMovie;
    @FXML
    private ListView<MovieModel> listViewMovies;
    @FXML
    private Button btnCustomizeImage;

    @FXML
    private Button btnSearchMovie;

    @FXML
    private Group grpImage;

    @FXML
    private Group grpMovie;

    @FXML
    private Text lblTest;

    @FXML
    private TextField txtMovieName;

    @FXML
    private Button btnSearch;

    private ObservableList<MovieModel> observableListMovie;


    private Parent root;
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //
//        //add some Students
//        movieObservableList.addAll(
//                new MovieModel("John Doe"),
//                new MovieModel("Jane Doe"),
//                new MovieModel("Donte Dunigan"),
//                new MovieModel("Gavin Genna"),
//                new MovieModel("Darin Dear"),
//                new MovieModel("Pura Petty"),
//                new MovieModel("Herma Hines")
//        );
//        listViewMovies.setItems(movieObservableList);
//        listViewMovies.setCellFactory(movieListView -> new MovieListViewCell());
//        listViewMovies.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MovieModel>() {
//            @Override
//            public void changed(ObservableValue<? extends MovieModel> observableValue, MovieModel movie, MovieModel t1) {
//                String inputMovie = listViewMovies.getSelectionModel().getSelectedItem().getTitle();
//                lblTest.setText(inputMovie);
//            }
//        });
    }



    public ObservableList<MovieModel> ShowListMovieBySearchMovie(String name) {
        switch ( name)
        {
            case "fairy tail" :
            {
                observableListMovie.addAll(
                        new MovieModel("Fairy tail","https://m.media-amazon.com/images/M/MV5BZWM5MTE1NmItMzJiMS00MjU0LWJiZmYtMDBiYjdiNTFjODhlXkEyXkFqcGdeQXVyNjg5NDY2MDc@._V1_.jpg"),
                        new MovieModel("Fairy tail Dragon Cry","https://m.media-amazon.com/images/M/MV5BZWM5MTE1NmItMzJiMS00MjU0LWJiZmYtMDBiYjdiNTFjODhlXkEyXkFqcGdeQXVyNjg5NDY2MDc@._V1_.jpg"),
                        new MovieModel("Fairy tail Ova","https://m.media-amazon.com/images/M/MV5BZWM5MTE1NmItMzJiMS00MjU0LWJiZmYtMDBiYjdiNTFjODhlXkEyXkFqcGdeQXVyNjg5NDY2MDc@._V1_.jpg")
                );
                break;
            }
            case "naruto" :
            {
                observableListMovie.addAll(
                        new MovieModel("Naruto","https://m.media-amazon.com/images/M/MV5BMTE5NzIwMGUtYTE1MS00MDUxLTgyZjctOWVkZDAxM2M4ZWQ4XkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_.jpg"),
                        new MovieModel("Naruto Shippuden","https://m.media-amazon.com/images/M/MV5BMTE5NzIwMGUtYTE1MS00MDUxLTgyZjctOWVkZDAxM2M4ZWQ4XkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_.jpg"),
                        new MovieModel("Boruto","https://m.media-amazon.com/images/M/MV5BMTE5NzIwMGUtYTE1MS00MDUxLTgyZjctOWVkZDAxM2M4ZWQ4XkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_.jpg")
                        );
                break;
            }
        }
        return observableListMovie;
    }

    @FXML
    void ClickToShowResulstSearch(ActionEvent event) {
        String searchName= txtMovieName.getText();
        observableListMovie = FXCollections.observableArrayList();
        listViewMovies.setItems( ShowListMovieBySearchMovie(searchName));
        listViewMovies.setCellFactory(e -> new MovieListViewCell());
    }

    public void ClickToOnVisibleMovie(ActionEvent event) {
        grpMovie.setVisible(true);
        grpImage.setVisible(false);
    }

    public void ClickToOnVisibleImage(ActionEvent event) {
        grpImage.setVisible(true);
        grpMovie.setVisible(false);
    }

    public void ClickItemToNavigate(MouseEvent mouseEvent) throws IOException {
        if (listViewMovies.hasProperties() == true) {
            System.out.println("clicked on " + listViewMovies.getSelectionModel().getSelectedItem());
            inputMovie = listViewMovies.getSelectionModel().getSelectedItem().getTitle();
            Start.setRoot("WatchMovieDetail");

        }
    }

//    public void WatchTrailer()
//    {
//                String url = "https://imdb-video.media-imdb.com/vi4282494745/1434659607842-pgv4ql-1563460842767.mp4?Expires=1639646826&Signature=jB1oPXCf3LBhA124HBR2F2bHwGcjffNcWLro4P2xowldmXCMzUsweRcDi-AyrcibF7pTwKaM4G54TilumSuwe3ccJPLSgp34GHQw9etQBuhL6vgicAE8Xbu6Fogtq71As0Wy~CfuLDiDVEDw9yFHNJUWmNSafls6k7hgHdNJQb~fmkK2FWzi00yny0PN1qPYrKOlbGvLbYmmj9AsLuEfQ1Nrf1ZRJO4gyZY6ZHJpsIJ-UHNY3uzCuUbjHZHXgJAWqlIJv5NdYatehR5WBTr9~P38WYqHz37xb9XXwwIeCCYg99pGpzsFnSfDDODSdFwQu8v-mUMYiHV2nFAtUdNt0g__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA";
//
//        // Tải một trang HTML từ url.
//        webEngine.load(url);
//        VBox root = new VBox();
//        root.setPadding(new Insets(5));
//        root.setSpacing(5);
//        root.getChildren().addAll(browser);
//
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setTitle("JavaFX WebView (o7planning.org)");
//        stage.setScene(scene);
//        stage.setWidth(450);
//        stage.setHeight(300);
//
//        stage.show();
//    }

}
