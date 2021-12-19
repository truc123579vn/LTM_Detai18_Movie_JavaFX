package FXML.ltm_doandetai18_javafx;

import Model.ReviewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TuongTuListViewCell  extends ListCell<String> {
    @FXML
    private AnchorPane anchTuongTu;

    @FXML
    private ImageView imgTuongTu;

    private FXMLLoader mLLoader;



    @Override
    protected void updateItem(String imgUrl, boolean empty) {
        super.updateItem(imgUrl, empty);

        if(empty || imgUrl == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ListCellAnhTuongTu.fxml"));
                mLLoader.setController(this);
                System.out.println(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            imgTuongTu.setImage(new Image(imgUrl));


            setText(null);
            setGraphic(anchTuongTu);
        }

    }
}
