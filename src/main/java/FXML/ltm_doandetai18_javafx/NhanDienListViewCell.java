package FXML.ltm_doandetai18_javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import javafx.fxml.FXML;
public class NhanDienListViewCell extends ListCell<String> {
    @FXML
    private AnchorPane anchNhanDien;

    @FXML
    private Label lblImageObject;

    @FXML
    private Label lblImagePercent;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(String imgUrl, boolean empty) {
        super.updateItem(imgUrl, empty);

        if (empty || imgUrl == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("listCellNhanDien.fxml"));
                mLLoader.setController(this);
                System.out.println(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            setText(null);
            setGraphic(anchNhanDien);
        }
    }
}
