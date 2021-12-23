package FXML.ltm_doandetai18_javafx;

import DTO.VatThe_DTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.fxml.FXML;
public class NhanDienListViewCell extends ListCell<VatThe_DTO> {
    @FXML
    private AnchorPane anchNhanDien;

    @FXML
    private Label lblImageObject;

    @FXML
    private Label lblImagePercent;

    private FXMLLoader mLLoader;


    @Override
    protected void updateItem(VatThe_DTO recogimg, boolean empty) {
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
//            for(Map.Entry entry : recogimg.entrySet()){
//                lblImageObject.setText(String.valueOf(entry.getKey()));
//                lblImagePercent.setText(String.valueOf(entry.getValue()));
//        }
                lblImageObject.setText(String.valueOf(recogimg.getObject()));
                lblImagePercent.setText(String.valueOf(recogimg.getPercentObject()));

            setText(null);
            setGraphic(anchNhanDien);
        }
    }
}
