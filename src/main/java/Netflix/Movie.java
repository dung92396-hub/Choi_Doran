package Netflix;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movie extends Film {
    private LocalTime duration; // thời gian chiếu

    public Movie(String name, String code, double starRating, double score10, LocalDate releaseDate,
                 Genre genre, int ageRequired, Country country, LocalTime duration) {
        super(name, code, starRating, score10, releaseDate, genre, ageRequired, country);
        this.duration = duration;
    }

    public boolean isBetween(LocalTime min, LocalTime max) {
        return duration.isAfter(min) && duration.isBefore(max);
    }

    public LocalTime getDuration() { return duration; }

    @Override
    public String type() { return "MOVIE"; }

    @Override
    public String toString() {
        // append duration at the end
        return super.toString() + String.format(" duration=%s", duration);
    }
}

