package FXML.ltm_doandetai18_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Text lbLoi;
    @FXML
    private ScrollPane scrollPanel;
    private Button[] btn;
    private ImageView[] img;
    private Label[] lb;
    @FXML
    private ImageView imgTest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createButton(15);

        ///img from URL
        Image myImg = new Image("https://icdn.dantri.com.vn/thumb_w/660/2021/09/08/cathighqualitywallpapers1-1631079054898.jpg");
        imgTest.setImage(myImg);

    }

    @FXML
    public void dangnhap(ActionEvent event) throws IOException {
        Start.setRoot("home");

    }

    public void setError(String error) {
        lbLoi.setText("");
        lbLoi.setText(error);
    }
    public void createButton(int a){
        VBox vBox = new VBox();
        btn = new  Button[a];
        img = new ImageView[a];
        lb = new Label[a];
        for(int i=0;i<a;i++){
            btn[i] = new Button();
            btn[i].setText("Nut "+ (i+1));
            btn[i].setPrefSize(100, 50);
            btn[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    String text = ((Button) e.getSource()).getText();
                    //Start.alertInf(text);
                }
            });

            img[i] = new ImageView();
            img[i].setImage(new Image("https://m.media-amazon.com/images/M/MV5BZWM5MTE1NmItMzJiMS00MjU0LWJiZmYtMDBiYjdiNTFjODhlXkEyXkFqcGdeQXVyNjg5NDY2MDc@._V1_.jpg",160,160,false,true));


            lb[i] = new Label();
            lb[i].setText("Vi tri thu " +(i+1));
            lb[i].setTextFill(Color.BLUE);


            vBox.getChildren().add(img[i]);
            vBox.getChildren().add(lb[i]);
            vBox.getChildren().add(btn[i]);        }
        scrollPanel.setContent(vBox);
    }

}