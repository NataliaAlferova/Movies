package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MoviesManagerTest {
    int limitMovie = 10;

    Movie titanic = new Movie (123, "Titanic", "url1", "drama");
    Movie homeAlone = new Movie (543, "Home Alone", "url2", "komedy");
    Movie elki = new Movie (298, "Elki", "url3", "komedy");
    Movie taxi = new Movie (190, "Taxi", "url4", "komedy");
    Movie terminator = new Movie (765, "Terminator", "url5", "action");
    Movie admiral = new Movie (761, "Admiral", "url6", "drama");
    Movie transformers = new Movie (834, "Transformers", "url7", "action");
    Movie starwars = new Movie (023, "Star Wars", "url8", "action");
    Movie kislorod = new Movie (276, "Kislorod", "url9", "action");
    Movie djoker = new Movie (909, "Djoker", "ur10", "action");
    Movie luka = new Movie (112, "Luka", "url11", "cartoon");

    @Test
    public void shouldAddToEmpty () {
        MoviesManager moviesManager = new MoviesManager();
        moviesManager.add(elki);

        Movie [] expected = {elki};
        Movie [] actual = moviesManager.getMovies();

        assertArrayEquals( expected, actual);
    }
    
    @Test
    public void shouldAddToOneElement () {
        MoviesManager moviesManager = new MoviesManager();
        moviesManager.setMovies(new Movie [] {elki});

        moviesManager.add(titanic);

        Movie [] expected = {elki, titanic};
        Movie [] actual = moviesManager.getMovies();

        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldAddToAnyElement () {
        MoviesManager moviesManager = new MoviesManager();
        moviesManager.setMovies(new Movie [] {elki, terminator, taxi, luka});

        moviesManager.add(titanic);

        Movie [] expected = {elki, terminator, taxi, luka, titanic};
        Movie [] actual = moviesManager.getMovies();

        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldShowWhenMoreLimit () {
        MoviesManager moviesManagerDefault = new MoviesManager(limitMovie);
        moviesManagerDefault.setMovies(new Movie [] {titanic, homeAlone, elki, taxi, terminator, admiral,
                transformers, starwars, kislorod, djoker, luka});

        Movie [] expected = {luka, djoker, kislorod, starwars, transformers, admiral, terminator, taxi,
                            elki, homeAlone};
        Movie [] actual = moviesManagerDefault.showAll();

        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldShowWhenEqualsLimit () {
        MoviesManager moviesManagerDefault = new MoviesManager(limitMovie);
        moviesManagerDefault.setMovies(new Movie [] {homeAlone, elki, taxi, terminator, admiral,
                transformers, starwars, kislorod, djoker, luka});

        Movie [] expected = {luka, djoker, kislorod, starwars, transformers, admiral, terminator, taxi,
                elki, homeAlone};
        Movie [] actual = moviesManagerDefault.showAll();

        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldShowWhenLessLimit () {
        MoviesManager moviesManagerDefault = new MoviesManager(limitMovie);
        moviesManagerDefault.setMovies(new Movie [] {homeAlone, elki, taxi, terminator, admiral,
                transformers, starwars, kislorod, djoker});

        Movie [] expected = {djoker, kislorod, starwars, transformers, admiral, terminator, taxi,
                elki, homeAlone};
        Movie [] actual = moviesManagerDefault.showAll();

        assertArrayEquals (expected, actual);
    }
}

