package FXML.ltm_doandetai18_javafx;

import DTO.Review_DTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReviewListViewCell  extends ListCell<Review_DTO> {

        @FXML
        private Label lblReviewAuthor;

        @FXML
        private Label lblReviewTitle;

        @FXML
        private TextArea txtAreaReviewContent;
        private FXMLLoader mLLoader;
        @FXML
        private AnchorPane anchReview;


        @Override
        protected void updateItem(Review_DTO reviewModel, boolean empty) {
               super.updateItem(reviewModel, empty);

                if(empty || reviewModel == null) {

                        setText(null);
                        setGraphic(null);

                } else {
                        if (mLLoader == null) {
                                mLLoader = new FXMLLoader(getClass().getResource("ListCellReview.fxml"));
                                mLLoader.setController(this);
                                System.out.println(this);

                                try {
                                        mLLoader.load();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }

                        }

                        lblReviewAuthor.setText(String.valueOf(reviewModel.getUsername()));
                        lblReviewTitle.setText(String.valueOf(reviewModel.getTitle()));
                        txtAreaReviewContent.setWrapText(true);
                        txtAreaReviewContent.setText(String.valueOf(reviewModel.getContent()));


                        setText(null);
                        setGraphic(anchReview);
                }

        }

}
