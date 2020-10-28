package sustech.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * @author nanos
 */
@Entity
@Data
@Table(name = "movie_table")
public class Movie implements Serializable {
    private static final long serialVersionUID = 1148517201L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_Id", nullable = false)
    private Long autoId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "date_in", nullable = false)
    private String date;
    @Column(name = "start_time", nullable = false)
    private String startTime;
    @Column(name = "duration", nullable = false)
    private String duration;
    @Column(name = "movie_hall", nullable = false)
    private String movieHall;
    @Column(name = "price", nullable = false)
    private String price;
    @Column(name = "type", nullable = false)
    private String type;


    public Movie() {
    }

    public Movie(Long autoId) {
        this.autoId = autoId;
    }

    public Movie(MovieDo movie) {
        this.title = movie.getTitle();
        this.date = movie.getDate();
        this.startTime = movie.getStartTime();
        this.duration = movie.getDuration();
        this.movieHall = movie.getMovieHall();
        this.price = movie.getPrice();
        this.type = movie.getType();
    }
}