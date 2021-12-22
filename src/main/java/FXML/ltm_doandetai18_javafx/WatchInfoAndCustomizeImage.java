package FXML.ltm_doandetai18_javafx;

import DTO.Review_DTO;
import Support.SupportTool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class WatchInfoAndCustomizeImage implements Initializable {

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
    private Button btnCompress;

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
    private TextField txtPercentCompress;


    @FXML
    private Hyperlink hyperBeforeImage;

    @FXML
    private Label lblAfterSize;

    @FXML
    private Label lblBeforSize;

    @FXML
    private Hyperlink HyperAfterImage;

    @FXML
    private ImageView imageviewAfterCompress;

    @FXML
    private ImageView imageviewBeforeCompress;

   // private String imgURL=HomeController.imageUrl;
    private String imgURL="https://resmush.it/assets/images/jpg_example_original.jpg";
    private List<String> infoCompress =new ArrayList<>();
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
    void ClickToOnvisibleNenAnh(ActionEvent event) throws IOException, ClassNotFoundException {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtPercentCompress.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtPercentCompress.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public void ClickToCompressImage(ActionEvent event) throws IOException, ClassNotFoundException {

        String qlty= txtPercentCompress.getText();
        //ghi
        if(!qlty.isBlank()) {
            HashMap<String, String> mapinfoCompress = new HashMap<>();
            mapinfoCompress.put("imgURL", imgURL);
            mapinfoCompress.put("qlty", qlty);
            System.out.println(mapinfoCompress);
            HashMap<String, HashMap<String, String>> input = new HashMap<>();

            input.put("6", mapinfoCompress);
            System.out.println(input);
            SupportTool.getOutputClient().writeObject(input);

            //doc
            Object output = SupportTool.getInputClient().readObject();
            List<String> infoCompress = (List<String>) output;
            System.out.println(output);

            lblAfterSize.setText(infoCompress.get(2));
            lblBeforSize.setText(infoCompress.get(1));
            HyperAfterImage.setText(infoCompress.get(0));
            imageviewBeforeCompress.setImage(new Image(imgURL));
            imageviewAfterCompress.setImage(new Image(infoCompress.get(0)));



        }
        else
            Start.alertInf("Bạn chưa nhập thông tin");
    }


    public void ClickToSaveImage(ActionEvent event) {
        SupportTool.CreateWebviewBrowser(HyperAfterImage.getText());
    }
}
