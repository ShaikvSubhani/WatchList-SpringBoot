package com.example.WatchListDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie)
    {
        movieRepository.saveMovie(movie);
    }

    public void addDirector(Director director)
    {
        movieRepository.saveDirector(director);
    }

    public void addMovieAndDirector(String movie,String director)
    {
        movieRepository.saveMovieAndDirector(movie,director);
    }

    public Movie getMovie(String movie)
    {
       return movieRepository.getMovie(movie);
    }

    public Director getDirector(String director)
    {
        return movieRepository.getDirector(director);
    }

    public List<String> getListOfMovieByDirectorName(String director)
    {
       return movieRepository.getListOfMovieByDirectorName(director);
    }

    public List<String> getListOfAllMovies()
    {
         return movieRepository.getListOfAllMovies();
    }

    public void deleteDirector(String director)
    {
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirector()
    {
        movieRepository.deleteAllDirector();
    }

}
