package Support;


import DTO.Actor_DTO;
import DTO.MovieSearchResult_DTO;
import DTO.Review_DTO;
import DTO.VatThe_DTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

public class SupportTool {
    private static ObjectInputStream inclient = null;
    private static ObjectOutputStream outclient = null;

    public static ObjectInputStream getInputClient()
    {
        return inclient;
    }
    public static ObjectOutputStream getOutputClient()
    {
        return outclient;
    }

    public static void InitializeInputClient(Socket s) throws IOException {

            inclient =new ObjectInputStream(s.getInputStream());

    }

    public static void InitializeOutputClient(Socket s) throws IOException {

            outclient =new ObjectOutputStream(s.getOutputStream());
    }
    public static ObservableList<MovieSearchResult_DTO> convertListDTOtoObservableListMovie(List<MovieSearchResult_DTO> list)
    {
        ObservableList<MovieSearchResult_DTO> movieModels = FXCollections.observableArrayList();
        for (MovieSearchResult_DTO dto: list
             ) {
            movieModels.add(new MovieSearchResult_DTO(dto.getID(), dto.getTitle(), dto.getImg(), dto.getDirector(), dto.getStars(), dto.getRating()));
       //     System.out.println(dto.getImg());
        }
        return  movieModels;
    }

    public static ObservableList<String> convertListDTOtoObservableListActors(List<Actor_DTO> list)
    {
        ObservableList<String> actor_dtos = FXCollections.observableArrayList();
        for (Actor_DTO dto: list
        ) {
            actor_dtos.add(dto.getName());
            //     System.out.println(dto.getImg());
        }
        return  actor_dtos;
    }


    public static ObservableList<Review_DTO> convertListDTOtoObservableListReviews(List<Review_DTO> list)
    {
        ObservableList<Review_DTO> review_dtos = FXCollections.observableArrayList();
        for (Review_DTO dto: list
        ) {
            review_dtos.add(new Review_DTO(dto.getUsername(), dto.getDate(), dto.getRate(), dto.getTitle(), dto.getContent()));
            //     System.out.println(dto.getImg());
        }
        return  review_dtos;
    }

    public static ObservableList<String> convertListDTOtoObservableListSimilarImg(List<String> list)
    {
        ObservableList<String> similarImgs = FXCollections.observableArrayList();
        for (String similarImg: list
        ) {
            similarImgs.add(similarImg);
            //     System.out.println(dto.getImg());
        }
        return similarImgs;
    }

    public static ObservableList<VatThe_DTO> convertHashMaptoObservableListRecogImg(LinkedHashMap<String, Double> mapVatThe)
    {
        String object=""; Double objectpercent=0.0;
        ObservableList<VatThe_DTO> recogImgs = FXCollections.observableArrayList();
        List<VatThe_DTO> vatThe_dtos = new ArrayList<>();
        for(Map.Entry entry : mapVatThe.entrySet())
        {
             object = (String) entry.getKey();
             objectpercent= (Double) entry.getValue();
             VatThe_DTO vatThe_dto = new VatThe_DTO(object,objectpercent);
             vatThe_dtos.add(vatThe_dto);
        }
        for (VatThe_DTO dto : vatThe_dtos)
        {
            recogImgs.add(new VatThe_DTO(dto.getObject(), dto.getPercentObject()));

        }
//        for (LinkedHashMap<String, Double> recogImg:Img
//        ) {
//            recogImgs.add(recogImg);
//            //     System.out.println(dto.getImg());
//        }
        return recogImgs;
    }

    public static void CreateWebviewBrowser(String url,File file, String typeFileName)
    {
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(url));
        Button button = new Button();
        button.setText("Tải ảnh xuống");
        button.setMaxWidth(200);
        button.setMaxHeight(100);

        // Tải một trang HTML từ url.
        webEngine.load(url);
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.getChildren().addAll(browser,button);



        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Anh");
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(500);

        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){

            @Override
            public void handle(WindowEvent event) {
                webEngine.load(null);
            }
        });
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HashMap<String, String> mapinfoSave = new HashMap<>();
                mapinfoSave.put("imgURL", url);
                mapinfoSave.put("typeFileName", typeFileName);
                mapinfoSave.put("pathFile", file.getAbsolutePath());


                System.out.println(mapinfoSave);
                HashMap<String, HashMap<String, String>> input = new HashMap<>();
                input.put("11", mapinfoSave);
                System.out.println(input);

                try {
                    SupportTool.getOutputClient().writeObject(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //doc
                Object output = null;
                try {
                    output = SupportTool.getInputClient().readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                String Message = "";
                Message = (String) output;
                System.out.println(output);
            }
        });
    }
    public static String getImgExtension(File file){
        String fileName = file.getName();
        return  fileName.substring(fileName.lastIndexOf(".") + 1, file.getName().length());

    }

    public static void SaveFile(String url,File file, String typeFileName)
    {
        HashMap<String, String> mapinfoSave = new HashMap<>();
        mapinfoSave.put("imgURL", url);
        mapinfoSave.put("typeFileName", typeFileName);
        mapinfoSave.put("pathFile", file.getAbsolutePath());


        System.out.println(mapinfoSave);
        HashMap<String, HashMap<String, String>> input = new HashMap<>();
        input.put("11", mapinfoSave);
        System.out.println(input);

        try {
            SupportTool.getOutputClient().writeObject(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //doc
        Object output = null;
        try {
            output = SupportTool.getInputClient().readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String Message = "";
        Message = (String) output;
        System.out.println(output);
    }
}
