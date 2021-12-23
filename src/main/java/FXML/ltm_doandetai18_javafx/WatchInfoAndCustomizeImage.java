package FXML.ltm_doandetai18_javafx;

import DTO.VatThe_DTO;
import Support.SupportTool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class WatchInfoAndCustomizeImage implements Initializable {
    @FXML
    private Hyperlink HyperAfterCompressImage;

    @FXML
    private Hyperlink HyperAfterConvertType;

    @FXML
    private Hyperlink HyperAfterEditImage;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnChangeImage;

    @FXML
    private Button btnCompress;

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
    private CheckBox checkboxGrayScale;

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
    private Hyperlink hyperBeforeImage;

    @FXML
    private ImageView imageviewAfterCompress;

    @FXML
    private ImageView imageviewAfterConvert;

    @FXML
    private ImageView imageviewAfterEdt;

    @FXML
    private ImageView imageviewBeforeCompress;

    @FXML
    private ImageView imageviewBeforeConvert;

    @FXML
    private ImageView imageviewBeforeEdit;

    @FXML
    private Label lblMainObject;
    @FXML
    private Label lblAfterConverImageType;

    @FXML
    private Label lblAfterSize;

    @FXML
    private Label lblBeforSize;

    @FXML
    private Label lblBeforeConverImageType;

    @FXML
    private Text lblTitlePage;

    @FXML
    private ListView<String> listviewTuongTu;

    @FXML
    private ListView<VatThe_DTO> listviewVatThe;

    @FXML
    private RadioButton rbtnBound;

    @FXML
    private RadioButton rbtnCover;

    @FXML
    private RadioButton rbtnCrop;

    @FXML
    private RadioButton rbtnFit;

    @FXML
    private RadioButton rbtnJpg;

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
    private ToggleGroup tgChangeImage;

    @FXML
    private ToggleGroup tgConvertType;

    @FXML
    private TextField txtHeightImage;

    @FXML
    private TextField txtPercentCompress;

    @FXML
    private TextField txtWidthImage;


    private String imgURL = HomeController.imageUrl;
    private File file = HomeController.file;
    //private String imgURL="https://resmush.it/assets/images/jpg_example_original.jpg";

    private ObservableList<String> observablelistimg;
    private ObservableList<VatThe_DTO> observablerecoglist;
    String afterCompressImage="";
    String afterEditImage="";
    String afterConverTypeImage="";



    @FXML
    void Back(ActionEvent event) throws IOException {
        Start.setRoot("Home");
    }


    @FXML
    void ClickToOnVisibleAnhTuongTu(ActionEvent event) throws IOException, ClassNotFoundException {
        grpImageTuongTu.setVisible(true);
        grpImageChuyenAnh.setVisible(false);
        grpImageDinhDang.setVisible(false);
        grpImageNenAnh.setVisible(false);
        grpImageNhanDien.setVisible(false);
        observablelistimg = FXCollections.observableArrayList();
        HashMap<String, Object> input = new HashMap<>();
        input.put("9", imgURL);
        System.out.println(input);
        SupportTool.getOutputClient().writeObject(input);
        Object output = SupportTool.getInputClient().readObject();
        List<String> list = (List<String>) output;
        listviewTuongTu.setItems(SupportTool.convertListDTOtoObservableListSimilarImg(list));
        listviewTuongTu.setCellFactory(e -> new TuongTuListViewCell());
    }


    @FXML
    void ClickToOnVisibleNhanDien(ActionEvent event) throws IOException, ClassNotFoundException {
        grpImageTuongTu.setVisible(false);
        grpImageChuyenAnh.setVisible(false);
        grpImageDinhDang.setVisible(false);
        grpImageNenAnh.setVisible(false);
        grpImageNhanDien.setVisible(true);
        observablelistimg = FXCollections.observableArrayList();
        HashMap<String, Object> input = new HashMap<>();
        input.put("10", imgURL);
        System.out.println(input);
        //ghi
        SupportTool.getOutputClient().writeObject(input);

        //doc
        Object output = SupportTool.getInputClient().readObject();
        System.out.println(output);
        LinkedHashMap<String, Double> mapVatThe = (LinkedHashMap<String, Double>) output;
        listviewVatThe.setItems(SupportTool.convertHashMaptoObservableListRecogImg(mapVatThe));
        listviewVatThe.setCellFactory(e -> new NhanDienListViewCell());
        lblMainObject.setText((String) mapVatThe.keySet().toArray()[0]);
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


    public void ClickToConvertType(ActionEvent event) throws IOException, ClassNotFoundException {
        String outputType = "";

        if (rbtnpdf.isSelected())
            outputType = rbtnpdf.getText();
        if (rbtnpdfa.isSelected())
            outputType = rbtnpdfa.getText();
        if (rbtnpng.isSelected())
            outputType = rbtnpng.getText();
        if (rbtnsvg.isSelected())
            outputType = rbtnsvg.getText();
        if (rbtnJpg.isSelected())
            outputType = rbtnJpg.getText();
        if (rbtntiff.isSelected())
            outputType = rbtntiff.getText();

        System.out.println(outputType);

        //ghi
        HashMap<String, String> mapinfoConvert = new HashMap<>();
        HashMap<String, HashMap<String, String>> input = new HashMap<>();
        mapinfoConvert.put("imgURL", imgURL);
        mapinfoConvert.put("inputType", SupportTool.getImgExtension(file));
        mapinfoConvert.put("outputType", outputType);
        System.out.println(mapinfoConvert);

        input.put("7", mapinfoConvert);
        System.out.println(input);
        SupportTool.getOutputClient().writeObject(input);

        //doc
        Object output = SupportTool.getInputClient().readObject();
        String convertImg = (String) output;

        System.out.println(output);

        lblBeforeConverImageType.setText(SupportTool.getImgExtension(file));
        lblAfterConverImageType.setText(outputType);
        //HyperAfterImage.setText(infoCompress.get(0));
        imageviewBeforeConvert.setImage(new Image(imgURL));
        imageviewAfterConvert.setImage(new Image(convertImg));

        afterConverTypeImage=convertImg;
    }

    public void ClickToChangeImage(ActionEvent event) throws IOException, ClassNotFoundException {
        String resizeType = "";
        Integer gray = 0;
        if (rbtnBound.isSelected())
            resizeType = rbtnBound.getText();
        if (rbtnCover.isSelected())
            resizeType = rbtnCover.getText();
        if (rbtnCrop.isSelected())
            resizeType = rbtnCrop.getText();
        if (rbtnFit.isSelected())
            resizeType = rbtnFit.getText();
        System.out.println(resizeType);

        if (checkboxGrayScale.isSelected())
            gray = 1;
        else
            gray = 0;
        if (txtHeightImage.getText().isBlank() || txtWidthImage.getText().isBlank()) {
            Start.alertInf("bạn phải nhập chiều rộng, chiểu cao");
        } else {
            if (Integer.valueOf(txtWidthImage.getText()) < 10 || Integer.valueOf(txtHeightImage.getText()) < 10) {
                Start.alertInf("Chiểu rộng và chiều cao phải lớn hơn 10");
            } else {
                //ghi
                HashMap<String, String> mapinfoEdits = new HashMap<>();
                mapinfoEdits.put("imgURL", imgURL);
                mapinfoEdits.put("gray", String.valueOf(gray));
                mapinfoEdits.put("width", txtWidthImage.getText());
                mapinfoEdits.put("height", txtHeightImage.getText());
                mapinfoEdits.put("resizeType",resizeType);

                System.out.println(mapinfoEdits);
                HashMap<String, HashMap<String, String>> input = new HashMap<>();
                input.put("8", mapinfoEdits);
                System.out.println(input);

                SupportTool.getOutputClient().writeObject(input);

                //doc
                Object output = SupportTool.getInputClient().readObject();
                String editImage = "";
                editImage = (String) output;
                System.out.println(output);


                imageviewAfterEdt.setImage(new Image(editImage));
                imageviewBeforeEdit.setImage(new Image(imgURL));
                afterEditImage=editImage;
            }
        }

//        //ghi
//        HashMap<String, String> mapinfoConvert = new HashMap<>();
//        HashMap<String, HashMap<String, String>> input = new HashMap<>();
//        mapinfoConvert.put("imgURL", imgURL);
//        mapinfoConvert.put("inputType", SupportTool.getImgExtension(file));
//        mapinfoConvert.put("outputType", outputType);
//        System.out.println(mapinfoConvert);
//
//        input.put("7", mapinfoConvert);
//        System.out.println(input);
//        SupportTool.getOutputClient().writeObject(input);
//
//        //doc
//        Object output = SupportTool.getInputClient().readObject();
//        List<String> infoCompress = new ArrayList<>();
//        infoCompress = (List<String>) output;
//        System.out.println(output);
//
//        lblAfterSize.setText(infoCompress.get(2));
//        lblBeforSize.setText(infoCompress.get(1));
//        HyperAfterImage.setText(infoCompress.get(0));
//        imageviewBeforeCompress.setImage(new Image(imgURL));
//        imageviewAfterCompress.setImage(new Image(infoCompress.get(0)));
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
        txtHeightImage.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtHeightImage.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        txtWidthImage.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtWidthImage.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public void ClickToCompressImage(ActionEvent event) throws IOException, ClassNotFoundException {

        String qlty = txtPercentCompress.getText();
        if (Integer.valueOf(qlty) > 0 && Integer.valueOf(qlty) < 100) {
            //ghi
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
            List<String> infoCompress = new ArrayList<>();
            infoCompress = (List<String>) output;
            System.out.println(output);

            lblAfterSize.setText(infoCompress.get(2));
            lblBeforSize.setText(infoCompress.get(1));
            //HyperAfterCompressImage.setText(infoCompress.get(0));
            imageviewBeforeCompress.setImage(new Image(imgURL));
            imageviewAfterCompress.setImage(new Image(infoCompress.get(0)));
            afterCompressImage=infoCompress.get(0);
        } else if (Integer.valueOf(qlty) < 0 || Integer.valueOf(qlty) > 100)
            Start.alertInf("Phần trăm phải nằm trong khoảng từ 0 - 100");
        else
            Start.alertInf("Bạn chưa nhập thông tin");
    }


    public void ClickToSaveImage(ActionEvent event) {
    }

    public void ClickToSaveCompressImage(ActionEvent event) {
        SupportTool.CreateWebviewBrowser(afterCompressImage,file,"optimizeIMG");
    }

    public void ClickToSaveConvertTypeImage(ActionEvent event) {
        SupportTool.CreateWebviewBrowser(afterCompressImage,file,"convertIMG");
    }

    public void ClickToSaveEditImage(ActionEvent event) {
        SupportTool.CreateWebviewBrowser(afterEditImage,file,"editIMG");

    }
}
