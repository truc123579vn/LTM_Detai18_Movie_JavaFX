package FXML.ltm_doandetai18_javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
public class NhanDienListViewCell extends ListCell<HashMap<String,Double>> {
    @FXML
    private AnchorPane anchNhanDien;

    @FXML
    private Label lblImageObject;

    @FXML
    private Label lblImagePercent;

    private FXMLLoader mLLoader;


    @Override
    protected void updateItem(HashMap<String, Double> recogimg, boolean empty) {
        super.updateItem(recogimg, empty);

        if (empty || recogimg == null) {

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
            for(Map.Entry entry : recogimg.entrySet()){
                lblImageObject.setText(String.valueOf(entry.getKey()));
                lblImagePercent.setText(String.valueOf(entry.getValue()));
        }


            setText(null);
            setGraphic(anchNhanDien);
        }
    }
}
