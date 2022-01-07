package ru.netology.manager;

import ru.netology.domain.Movie;

public class MoviesManager {

    private Movie [] movies = new Movie[0];
    private int limitMovie;

    public MoviesManager () {
        this.limitMovie = 10;
    }

    public MoviesManager (int limitMovie) {
        this.limitMovie = limitMovie;
    }

    public void add (Movie movie) {
        int length = movies.length + 1;
        Movie [] tmp = new Movie [length];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies [i];
        }
        tmp [tmp.length-1] = movie;
        movies = tmp;
        
    }

    public Movie [] showAll () {
        int resultLength;
        if (movies.length >= limitMovie) {
            resultLength = limitMovie;
        }
        else {
            resultLength = movies.length;
        }
        Movie [] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result [i] = movies [movies.length - i - 1];
        }
        return result;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

}

