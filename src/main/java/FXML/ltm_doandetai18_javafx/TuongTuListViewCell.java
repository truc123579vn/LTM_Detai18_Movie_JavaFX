package FXML.ltm_doandetai18_javafx;

import Support.SupportTool;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;

public class TuongTuListViewCell  extends ListCell<String> {
    @FXML
    private AnchorPane anchTuongTu;
    @FXML
    private Button btnSaveSimilarImage;
    @FXML
    private ImageView imgTuongTu;

    private File file = HomeController.file;
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
            btnSaveSimilarImage.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SupportTool.SaveFile(imgUrl,file,"similarIMG");
                }
            });

            setText(null);
            setGraphic(anchTuongTu);
        }

    }
}
