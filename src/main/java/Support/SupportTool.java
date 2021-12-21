package Support;


import DTO.Actor_DTO;
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
    public static ObservableList<MovieSearchResult_DTO> convertListDTOtoListMovieModel(List<MovieSearchResult_DTO> list)
    {
        ObservableList<MovieSearchResult_DTO> movieModels = FXCollections.observableArrayList();
        for (MovieSearchResult_DTO dto: list
             ) {
            movieModels.add(new MovieSearchResult_DTO(dto.getID(), dto.getTitle(), dto.getImg(), dto.getDirector(), dto.getStars(), dto.getRating()));
       //     System.out.println(dto.getImg());
        }
        return  movieModels;
    }

    public static ObservableList<String> convertListDTOtoObservableList(List<Actor_DTO> list)
    {
        ObservableList<String> actor_dtos = FXCollections.observableArrayList();



        for (Actor_DTO dto: list
        ) {
            actor_dtos.add(dto.getName());
            //     System.out.println(dto.getImg());
        }
        return  actor_dtos;
    }
}
