package FXML.ltm_doandetai18_javafx;


import DTO.MovieSearchResult_DTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MovieListViewCell extends ListCell<MovieSearchResult_DTO> {
    @FXML
    private AnchorPane anchPane;

    @FXML
    private Label label1;
    @FXML
    private ImageView imgMovie;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(MovieSearchResult_DTO movie, boolean empty) {
        super.updateItem(movie, empty);

        if(empty || movie == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellMovie.fxml"));
                mLLoader.setController(this);
                System.out.println(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            label1.setText(String.valueOf(movie.getTitle()));
            imgMovie.setImage(new Image( movie.getImg()));

            setText(null);
            setGraphic(anchPane);
        }

    }
}