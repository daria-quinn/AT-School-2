package Homework14;

/**
 * Описание фильма – название и рейтинг.
 */
public class Movie {

    private final String title;   // название фильма
    private final double rating;  // рейтинг (например, 8.7)

    public Movie(String title, double rating) {
        this.title  = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("%s (%.1f)", title, rating);
    }
}
