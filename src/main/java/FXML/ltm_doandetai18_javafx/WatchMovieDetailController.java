package FXML.ltm_doandetai18_javafx;


import DTO.Actor_DTO;
import DTO.Movie_DTO;
import DTO.ReviewModel;
import Support.SupportTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class WatchMovieDetailController implements Initializable {
    @FXML
    private Button btnBack;

    @FXML
    private Button btnWatchMovieInfo;

    @FXML
    private Button btnWatchMovieReviews;

    @FXML
    private Group grpMovie;

    @FXML
    private Group grpReviews;

    @FXML
    private Label lblTitleMovie;
    @FXML
    private ImageView imgDetailMovie;

    @FXML
    private Label lblPlotSummary;

    @FXML
    private Label lblRatingMovie;

    @FXML
    private Text lblTitlePage;

    @FXML
    private Label lblTypeMovie;

    @FXML
    private Button btnWatchMovieTrailer;

    @FXML
    private ListView<ReviewModel> listviewReviews;
    @FXML
    private TextArea txtAreaPlot;
    @FXML
    private ListView<String> listviewActors;
    private ObservableList <ReviewModel> observableListReview;
    private Parent root;
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grpMovie.setVisible(true);
        grpReviews.setVisible(false);
        Movie_DTO movie_dto = HomeController.movie_dto;
        setMovieInfo(movie_dto);


    }

    public void setMovieInfo(Movie_DTO movie_dto)
    {
        lblTitleMovie.setText(movie_dto.getTitle());
        imgDetailMovie.setImage(new Image(movie_dto.getImage()));
        lblRatingMovie.setText("Điểm: " +movie_dto.getImDbRating());
        lblTypeMovie.setText("Thể loại: " +movie_dto.getType());


        txtAreaPlot.setText(movie_dto.getPlot());


        List<Actor_DTO> actorDtos = movie_dto.getActors();
        listviewActors.setItems(SupportTool.convertListDTOtoObservableList(actorDtos));
    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        Start.setRoot("Home");

    }

    public void ClickToBack(MouseEvent mouseEvent) {
    }
    @FXML
    public void ClickToShowReviews(ActionEvent event) throws IOException, ClassNotFoundException {
        grpReviews.setVisible(true);
        grpMovie.setVisible(false);
        observableListReview = FXCollections.observableArrayList();

//        SupportTool.getOutputClient().writeObject("3-"+movie_dto.getID());
//        Object output = SupportTool.getInputClient().readObject();
//        movie_dto = (Movie_DTO) output;
//        System.out.println(movie_dto.getID());

        observableListReview.addAll(
                new ReviewModel("The best 1","Ilove see fairy tail","Truc"),
                new ReviewModel("The best 2","Fairy tail is my second family","Trien Vinh"),
                new ReviewModel("The best 3 ","Fairy tail is the best movie to see","The Vinh")
        );
        listviewReviews.setItems(observableListReview);
        listviewReviews.setCellFactory(e -> new ReviewListViewCell());

    }

    @FXML
    public void ClickToShowMovie(ActionEvent event) {
        grpReviews.setVisible(false);
        grpMovie.setVisible(true);


    }

    public void ClickToSeeTrailer(ActionEvent event) {


        String url = "https://imdb-video.media-imdb.com/vi4282494745/1434659607842-pgv4ql-1563460842767.mp4?Expires=1639646826&Signature=jB1oPXCf3LBhA124HBR2F2bHwGcjffNcWLro4P2xowldmXCMzUsweRcDi-AyrcibF7pTwKaM4G54TilumSuwe3ccJPLSgp34GHQw9etQBuhL6vgicAE8Xbu6Fogtq71As0Wy~CfuLDiDVEDw9yFHNJUWmNSafls6k7hgHdNJQb~fmkK2FWzi00yny0PN1qPYrKOlbGvLbYmmj9AsLuEfQ1Nrf1ZRJO4gyZY6ZHJpsIJ-UHNY3uzCuUbjHZHXgJAWqlIJv5NdYatehR5WBTr9~P38WYqHz37xb9XXwwIeCCYg99pGpzsFnSfDDODSdFwQu8v-mUMYiHV2nFAtUdNt0g__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA";

        // Tải một trang HTML từ url.
        webEngine.load(url);
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.getChildren().addAll(browser);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("JavaFX WebView (o7planning.org)");
        stage.setScene(scene);
        stage.setWidth(450);
        stage.setHeight(300);

        stage.show();
    }
}
