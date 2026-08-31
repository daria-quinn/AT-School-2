package Homework14;

import java.util.Comparator;

/**
 * Сравнивает фильмы по возрастанию рейтинга.
 */
public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o1.getRating(), o2.getRating());
    }
}
