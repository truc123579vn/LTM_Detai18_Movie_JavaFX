package FXML.ltm_doandetai18_javafx;

import DTO.MovieSearchResult_DTO;
import DTO.Movie_DTO;
import Support.SupportTool;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class HomeController implements Initializable {
    public static String inputMovie;
    @FXML
    private ListView<MovieSearchResult_DTO> listViewMovies;
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

    @FXML
    private ImageView imgUploadFile;

    @FXML
    private Button btnUploadImage;

    @FXML
    private Button btnNavigateImageControl;

    private ObservableList<MovieSearchResult_DTO> observableListMovie;

    public static Movie_DTO movie_dto;

    private Stage stage;

    private Parent root;
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
        btnNavigateImageControl.setVisible(false);
        grpMovie.setVisible(true);

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





    @FXML
    void ClickToShowResulstSearch(ActionEvent event) throws IOException, ClassNotFoundException {
        String searchName= txtMovieName.getText();

        if(searchName.isBlank())
            Start.alertInf("Không được để trống");
        else
        {
            observableListMovie = FXCollections.observableArrayList();
            SupportTool.getOutputClient().writeObject("1-" + searchName);
            Object output = SupportTool.getInputClient().readObject();

            List<MovieSearchResult_DTO> list = (List<MovieSearchResult_DTO>) output;
            listViewMovies.setItems(SupportTool.convertListDTOtoObservableListMovie(list));
            listViewMovies.setCellFactory(e -> new MovieListViewCell());
        }
        }

    public void ClickToOnVisibleMovie(ActionEvent event) {
        grpMovie.setVisible(true);
        grpImage.setVisible(false);
    }

    public void ClickToOnVisibleImage(ActionEvent event) {
        grpImage.setVisible(true);
        grpMovie.setVisible(false);
    }

    public void ClickItemToNavigateMovie(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if (listViewMovies.hasProperties() == true) {
            System.out.println("clicked on " + listViewMovies.getSelectionModel().getSelectedItem());
           String inputMovieTitle = listViewMovies.getSelectionModel().getSelectedItem().getID();
            //System.out.println(inputMovieTitle);
            SupportTool.getOutputClient().writeObject("2-"+inputMovieTitle);
            Object output = SupportTool.getInputClient().readObject();
             movie_dto = (Movie_DTO) output;
            System.out.println(movie_dto.getID());

            Start.setRoot("WatchMovieDetail");

        }

    }

    public void ClickToUploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.setInitialDirectory(new File("./src/main/resources/image"));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File file = fileChooser.showOpenDialog(stage);

        if (file !=null)
        {
            Image image = new Image(file.toURI().toString(),361,175,false,true);
            imgUploadFile.setImage(image);
            btnNavigateImageControl.setVisible(true);
           // String imgDirectory=file.getAbsolutePath();
            System.out.println(file.getAbsolutePath());
            System.out.println(file.toURI().toString());
            System.out.println(file.getName());
        }
        else System.out.println("file is not invalid");
        // return directoryFile;
    }

    public void ClickToNavigateImageControl(ActionEvent event) throws IOException {
        Start.setRoot("WatchInfoAndCustomizeImage");
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
