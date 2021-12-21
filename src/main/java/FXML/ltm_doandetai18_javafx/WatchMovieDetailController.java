package FXML.ltm_doandetai18_javafx;


import DTO.Actor_DTO;
import DTO.Movie_DTO;
import DTO.Review_DTO;
import Support.SupportTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;

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
    private ListView<Review_DTO> listviewReviews;
    @FXML
    private TextArea txtAreaPlot;
    @FXML
    private ListView<String> listviewActors;
    private ObservableList <Review_DTO> observableListReview;
    private Parent root;

    Movie_DTO movie_dto = HomeController.movie_dto;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grpMovie.setVisible(true);
        grpReviews.setVisible(false);
        setMovieInfo(movie_dto);


    }

    public void setMovieInfo(Movie_DTO movie_dto)
    {
        lblTitleMovie.setText(movie_dto.getTitle());
        imgDetailMovie.setImage(new Image(movie_dto.getImage()));
        lblRatingMovie.setText("Điểm: " +movie_dto.getImDbRating());
        lblTypeMovie.setText("Thể loại: " +movie_dto.getType());

        txtAreaPlot.setWrapText(true);
        txtAreaPlot.setText(movie_dto.getPlot());


        List<Actor_DTO> actorDtos = movie_dto.getActors();
        listviewActors.setItems(SupportTool.convertListDTOtoObservableListActors(actorDtos));
    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        Start.setRoot("Home");

    }


    @FXML
    public void ClickToShowReviews(ActionEvent event) throws IOException, ClassNotFoundException {
        grpReviews.setVisible(true);
        grpMovie.setVisible(false);
        observableListReview = FXCollections.observableArrayList();

        SupportTool.getOutputClient().writeObject("3-"+movie_dto.getID());
        Object output = SupportTool.getInputClient().readObject();
       List<Review_DTO> review_dtos = (List<Review_DTO>) output;


        listviewReviews.setItems(SupportTool.convertListDTOtoObservableListReviews(review_dtos));
        listviewReviews.setCellFactory(e -> new ReviewListViewCell());

    }

    @FXML
    public void ClickToShowMovie(ActionEvent event) {
        grpReviews.setVisible(false);
        grpMovie.setVisible(true);


    }

    public void ClickToSeeTrailer(ActionEvent event) throws IOException, ClassNotFoundException {
        SupportTool.getOutputClient().writeObject("4-"+movie_dto.getID());
        Object output = SupportTool.getInputClient().readObject();

        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        String url = (String)output;

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
        stage.setWidth(700);
        stage.setHeight(350);

        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

            @Override
            public void handle(WindowEvent event) {
                webEngine.load(null);
            }
        });

    }
}
