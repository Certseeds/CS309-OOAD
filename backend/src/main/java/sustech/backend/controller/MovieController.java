package sustech.backend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sustech.backend.model.Movie;
import sustech.backend.model.MovieDo;
import sustech.backend.model.TitleDo;
import sustech.backend.repository.MovieRepository;

import javax.annotation.Resource;

import java.util.List;

@RestController
public class MovieController {
    @Resource
    MovieRepository movieRepository;

    @GetMapping("/movie")
    public List<Movie> getAllMovie() {
        return movieRepository.findBy();
    }

    @GetMapping("/movie/{date}/{movieHall}")
    public List<Movie> getMovieByDateAndMovieHall(@PathVariable("date") String date,
                                                  @PathVariable("movieHall") String movieHall) {
        System.out.println(date + " " + movieHall);
        return movieRepository.findByDateAndMovieHall(date, movieHall);
    }

    @PostMapping("/movie")
    public Movie addMovie(@RequestBody MovieDo movieDo) {
        System.out.println(movieDo);
        System.out.println(movieRepository.existsByTitle(movieDo.getTitle()));
        System.out.println(movieDo.getTitle());
        if (!movieRepository.existsByTitle(movieDo.getTitle())) {
            System.out.println("do not exist");
            movieRepository.save(new Movie(movieDo));
            return movieRepository.findByTitle(movieDo.getTitle());
        } else {
            System.out.println("exist");
            return new Movie(-1L);
        }
    }

    @DeleteMapping("/movie")
    public String deleteMovie(@RequestBody TitleDo titleDo) {
        if (movieRepository.existsByTitle(titleDo.getTitle())) {
            movieRepository.deleteByTitle(titleDo.getTitle());
            return "200";
        } else {
            return "404";
        }
    }

    @PutMapping("/movie")
    public Movie updateMovie(@RequestBody Movie movie) {
        if (movieRepository.existsById(movie.getAutoId())) {
            movieRepository.save(movie);
        }
        return movieRepository.findById(movie.getAutoId()).orElse(movie);
    }
}
