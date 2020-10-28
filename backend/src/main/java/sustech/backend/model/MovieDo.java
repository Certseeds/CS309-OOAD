package sustech.backend.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieDo implements Serializable {
    private static final long serialVersionUID = 1148517200L;
    private String title;
    private String date;
    private String startTime;
    private String duration;
    private String movieHall;
    private String price;
    private String type;

    public MovieDo() {
    }

    public MovieDo(Movie movie) {
        this.title = movie.getTitle();
        this.date = movie.getDate();
        this.startTime = movie.getStartTime();
        this.duration = movie.getDuration();
        this.movieHall = movie.getMovieHall();
        this.price = movie.getPrice();
        this.type = movie.getType();
    }
}
