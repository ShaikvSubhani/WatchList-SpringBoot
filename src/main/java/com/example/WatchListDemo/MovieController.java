package com.example.WatchListDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody  Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("added successfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director)
    {
        movieService.addMovieAndDirector(movie,director);
        return new ResponseEntity<>("added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<String> getMovieByName(@PathVariable  String movie)
    {
         movieService.getMovie(movie);
         return  new ResponseEntity<>("added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<String> getDirectorByName(@PathVariable String director)
    {
         movieService.getDirector(director);
        return new ResponseEntity<>("added Successfully",HttpStatus.CREATED);

    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<String> getMoviesByDirectorName(@PathVariable String director)
    {
        movieService.getListOfMovieByDirectorName(director);
        return new ResponseEntity<>("added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<String> findAllMovies()
    {
         movieService.getListOfAllMovies();
        return new ResponseEntity<>("added successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director") String director)
    {
        movieService.deleteDirector(director);
        return new ResponseEntity<>("added successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirector();
        return new ResponseEntity<>("added successfully",HttpStatus.CREATED);
    }

}
