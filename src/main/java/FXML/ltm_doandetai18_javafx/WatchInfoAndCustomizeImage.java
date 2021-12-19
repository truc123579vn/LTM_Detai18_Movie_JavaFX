package FXML.ltm_doandetai18_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.io.IOException;

public class WatchInfoAndCustomizeImage {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnChangeImage;

    @FXML
    private Button btnConvertType;

    @FXML
    private Button btnImageAnhTuongTu;

    @FXML
    private Button btnImageChuyenAnh;

    @FXML
    private Button btnImageDinhDang;

    @FXML
    private Button btnImageNenAnh;

    @FXML
    private Button btnImageVatThe;

    @FXML
    private Group grpImageChuyenAnh;

    @FXML
    private Group grpImageDinhDang;

    @FXML
    private Group grpImageNenAnh;

    @FXML
    private Group grpImageNhanDien;

    @FXML
    private Group grpImageTuongTu;

    @FXML
    private Text lblTitlePage;

    @FXML
    private RadioButton rbtnBound;

    @FXML
    private RadioButton rbtnCompress;

    @FXML
    private RadioButton rbtnCover;

    @FXML
    private RadioButton rbtnCrop;

    @FXML
    private RadioButton rbtnFit;

    @FXML
    private RadioButton rbtngif;

    @FXML
    private RadioButton rbtnpdf;

    @FXML
    private RadioButton rbtnpdfa;

    @FXML
    private RadioButton rbtnpng;

    @FXML
    private RadioButton rbtnsvg;

    @FXML
    private RadioButton rbtntiff;

    @FXML
    private RadioButton rbtnwatermark;

    @FXML
    private ToggleGroup tgChangeImage;

    @FXML
    private ToggleGroup tgConvertType;


    @FXML
    void Back(ActionEvent event) throws IOException {
            Start.setRoot("Home");
    }

    @FXML
    void ClickToOnVisibleAnhTuongTu(ActionEvent event) {
        grpImageTuongTu.setVisible(true);
        grpImageChuyenAnh.setVisible(false);
        grpImageDinhDang.setVisible(false);
        grpImageNenAnh.setVisible(false);
        grpImageNhanDien.setVisible(false);

    }

    @FXML
    void ClickToOnVisibleNhanDien(ActionEvent event) {
        grpImageTuongTu.setVisible(false);
        grpImageChuyenAnh.setVisible(false);
        grpImageDinhDang.setVisible(false);
        grpImageNenAnh.setVisible(false);
        grpImageNhanDien.setVisible(true);
    }

    @FXML
    void ClickToOnvisibleChuyenAnh(ActionEvent event) {
        grpImageTuongTu.setVisible(false);
        grpImageChuyenAnh.setVisible(true);
        grpImageDinhDang.setVisible(false);
        grpImageNenAnh.setVisible(false);
        grpImageNhanDien.setVisible(false);
    }

    @FXML
    void ClickToOnvisibleDinhDang(ActionEvent event) {
        grpImageTuongTu.setVisible(false);
        grpImageChuyenAnh.setVisible(false);
        grpImageDinhDang.setVisible(true);
        grpImageNenAnh.setVisible(false);
        grpImageNhanDien.setVisible(false);
    }

    @FXML
    void ClickToOnvisibleNenAnh(ActionEvent event) {
        grpImageTuongTu.setVisible(false);
        grpImageChuyenAnh.setVisible(false);
        grpImageDinhDang.setVisible(false);
        grpImageNenAnh.setVisible(true);
        grpImageNhanDien.setVisible(false);
    }


    public void ClickToConvertType(ActionEvent event) {
        String text="";
        if(rbtngif.isSelected())
            text=rbtngif.getText();
        if(rbtnpdf.isSelected())
            text=rbtnpdf.getText();
        if(rbtnpdfa.isSelected())
            text=rbtnpdfa.getText();
        if(rbtnpng.isSelected())
            text=rbtnpng.getText();
        if(rbtnsvg.isSelected())
            text=rbtnsvg.getText();
        if(rbtnCompress.isSelected())
            text=rbtnCompress.getText();
        if(rbtntiff.isSelected())
            text=rbtntiff.getText();
        if(rbtnwatermark.isSelected())
            text=rbtnwatermark.getText();
        System.out.println(text);
    }

    public void ClickToChangeImage(ActionEvent event) {
        String text="";
        if(rbtnBound.isSelected())
            text=rbtnBound.getText();
        if(rbtnCover.isSelected())
            text=rbtnCover.getText();
        if(rbtnCrop.isSelected())
            text=rbtnCrop.getText();
        if(rbtnFit.isSelected())
            text=rbtnFit.getText();
        System.out.println(text);
    }
}
