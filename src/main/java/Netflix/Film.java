package Netflix;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Film {
    private String name;               // tên bộ phim
    private String code;               // mã phim
    private double starRating;         // số sao đánh giá (0-5)
    private double score10;            // điểm đánh giá trên thang 10
    private LocalDate releaseDate;     // thời gian phát hành
    private Genre genre;               // thể loại
    private int ageRequired;           // độ tuổi yêu cầu
    private Country country;           // quốc gia sản xuất

    protected Film(String name, String code, double starRating, double score10,
                   LocalDate releaseDate, Genre genre, int ageRequired, Country country) {
        this.name = name;
        this.code = code;
        this.starRating = starRating;
        this.score10 = score10;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.ageRequired = ageRequired;
        this.country = country;
    }

    public boolean isBetween(LocalDate min, LocalDate max) {
        return releaseDate.isAfter(min) && releaseDate.isBefore(max);
    }

    public String getName() { return name; }
    public String getCode() { return code; }
    public double getStarRating() { return starRating; }
    public double getScore10() { return score10; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public int getReleaseYear() { return releaseDate.getYear(); }
    public Genre getGenre() { return genre; }
    public int getAgeRequired() { return ageRequired; }
    public Country getCountry() { return country; }

    public void setStarRating(double starRating) { this.starRating = starRating; }
    public void setScore10(double score10) { this.score10 = score10; }

    public abstract String type(); // "SERIES" | "MOVIE"

    // toString theo định dạng table (1 dòng)
    @Override
    public String toString() {
        // | TYPE | CODE | NAME | GENRE | COUNTRY | STARS | SCORE10 | AGE | RELEASE |
        return String.format("| %-6s | %-8s | %-30.30s | %-10s | %-10s | %4.1f | %5.2f | %3d | %s |",
                type(), code, name, genre, country, starRating, score10, ageRequired,
                releaseDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(code, film.code);
    }

    @Override
    public int hashCode() { return Objects.hash(code); }
}

