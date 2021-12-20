package Support;

import DTO.MovieModel;
import DTO.MovieSearchResult_DTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

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
    public static ObservableList<MovieModel> convertListDTOtoListMovieModel(List<MovieSearchResult_DTO> list)
    {
        ObservableList<MovieModel> movieModels = FXCollections.observableArrayList();
        for (MovieSearchResult_DTO dto: list
             ) {
            movieModels.add(new MovieModel(dto.getTitle(), dto.getImg()));
       //     System.out.println(dto.getImg());
        }
        return  movieModels;
    }
}
