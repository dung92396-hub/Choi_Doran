package Netflix;

import java.time.LocalDate;
import java.time.LocalTime;

public class Episode {
    private int number;                // tập thứ mấy
    private LocalDate releaseDate;     // thời gian phát hành tập
    private double score10;            // điểm đánh giá thang 10
    private LocalTime duration;        // thời gian chiếu

    public Episode(int number, LocalDate releaseDate, double score10, LocalTime duration) {
        this.number = number;
        this.releaseDate = releaseDate;
        this.score10 = score10;
        this.duration = duration;
    }

    public int getNumber() { return number; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public double getScore10() { return score10; }
    public LocalTime getDuration() { return duration; }

    @Override
    public String toString() {
        return String.format("#%d (%s, %.2f/10, %s)", number, releaseDate, score10, duration);
    }
}

