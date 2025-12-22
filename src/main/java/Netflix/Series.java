package Netflix;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Series extends Film {
    private final List<Episode> episodes = new ArrayList<>();

    public Series(String name, String code, double starRating, double score10, LocalDate releaseDate,
                  Genre genre, int ageRequired, Country country) {
        super(name, code, starRating, score10, releaseDate, genre, ageRequired, country);
    }

    public List<Episode> getEpisodes() { return Collections.unmodifiableList(episodes); }

    public void addEpisode(Episode e) { if (e != null) episodes.add(e); }

    @Override
    public String type() { return "SERIES"; }

    @Override
    public String toString() {
        return super.toString() + String.format(" episodes=%d", episodes.size());
    }
}

