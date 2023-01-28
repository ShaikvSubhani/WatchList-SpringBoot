package com.example.WatchListDemo;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private Map<String,Movie> movieMap;
    private Map<String,Director> directorMap;
    private Map<String, List<String>> moviedirectorMap;
    //pair is director name and list of movie names

    public MovieRepository()
    {
        movieMap=new HashMap<>();
        directorMap=new HashMap<>();
        moviedirectorMap=new HashMap<>();
    }

    //1> to add movie
    public void saveMovie(Movie movie)
    {
        movieMap.put(movie.getName(),movie);
    }

    //2>to add director
    public void saveDirector(Director director)
    {
        directorMap.put(director.getName(), director);
    }

    //3>pair movie and director
    public void saveMovieAndDirector(String movie,String director)
    {
        if(movieMap.containsKey(movie) && directorMap.containsKey(director))
        {
            List<String> currentMovieByDirector=new ArrayList<>();
            if(directorMap.containsKey(director))
                currentMovieByDirector=moviedirectorMap.get(director);

            currentMovieByDirector.add(movie);

            moviedirectorMap.put(director,currentMovieByDirector);
        }
    }

    //4> get movie by name
    public Movie getMovie(String movie)
    {
                return movieMap.get(movie);
    }

    //5>get director by name;
    public Director getDirector(String director)
    {
        return directorMap.get(director);
    }

    //6>get list of movie names from given director name
    public List<String> getListOfMovieByDirectorName(String director)
    {
        List<String> mlist=new ArrayList<>();
        if(moviedirectorMap.containsKey(director))
        mlist=moviedirectorMap.get(director);

        return mlist;
    }

    //7>get list of all movies
    public List<String> getListOfAllMovies()
    {
        return new ArrayList<>(movieMap.keySet());
    }

    //8>delete a director and its movies from the records
    public void deleteDirector(String director)
    {
        List<String> m=new ArrayList<>();
        if(moviedirectorMap.containsKey(director)) {
            m = moviedirectorMap.get(director);

            for(String mov:m)
            {
                if(movieMap.containsKey(mov))
                {
                    movieMap.remove(mov);
                }
            }

            moviedirectorMap.remove(director);

        }

        if(directorMap.containsKey(director))
            directorMap.remove(director);
    }

    //9>deleting all the directors
    public void deleteAllDirector(){

        HashSet<String> moviesSet = new HashSet<String>();

        //Deleting the director's map
        directorMap = new HashMap<>();

        //Finding out all the movies by all the directors combined
        for(String director: moviedirectorMap.keySet()){

            //Iterating in the list of movies by a director.
            for(String movie: moviedirectorMap.get(director)){
                moviesSet.add(movie);
            }
        }

        //Deleting the movie from the movieDb.
        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
        //clearing the pair.
        moviedirectorMap = new HashMap<>();
    }
}
