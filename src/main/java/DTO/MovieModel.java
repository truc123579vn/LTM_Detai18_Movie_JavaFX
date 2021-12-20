package DTO;

import java.io.Serializable;

public class MovieModel implements Serializable {
    private String title,imageUrl;

    public MovieModel(String title, String imageUrl) {
        this.title = title;
        this.imageUrl=imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
