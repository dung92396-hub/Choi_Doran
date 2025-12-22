package Netflix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public final class FilmsParser {
    private FilmsParser() {}

    public static List<Film> parse(InputStream in) throws IOException {
        List<Film> result = new ArrayList<>();
        if (in == null) return result;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue; // skip comments
                try {
                    Film f = parseLine(line);
                    if (f != null) result.add(f);
                } catch (Exception ex) {
                    // skip bad line but continue
                    System.err.println("Cannot parse line " + lineNo + ": " + line + " => " + ex.getMessage());
                }
            }
        }
        return result;
    }

    // Format:
    // MOVIE|code|name|stars|score10|releaseDate(yyyy-MM-dd)|genre|age|country|duration(HH:mm[:ss])
    // SERIES|code|name|stars|score10|releaseDate|genre|age|country|episodes=n,date,score,duration; n,date,score,duration; ...
    private static Film parseLine(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 10) throw new IllegalArgumentException("not enough fields");
        String type = parts[0].trim();
        String code = parts[1].trim();
        String name = parts[2].trim();
        double stars = Double.parseDouble(parts[3].trim());
        double score10 = Double.parseDouble(parts[4].trim());
        LocalDate release = LocalDate.parse(parts[5].trim());
        Genre genre = Genre.valueOf(parts[6].trim());
        int age = Integer.parseInt(parts[7].trim());
        Country country = Country.valueOf(parts[8].trim());
        if ("MOVIE".equalsIgnoreCase(type)) {
            LocalTime duration = LocalTime.parse(parts[9].trim());
            return new Movie(name, code, stars, score10, release, genre, age, country, duration);
        } else if ("SERIES".equalsIgnoreCase(type)) {
            Series s = new Series(name, code, stars, score10, release, genre, age, country);
            String epsField = parts[9].trim();
            String epStr = epsField.startsWith("episodes=") ? epsField.substring("episodes=".length()) : epsField;
            if (!epStr.isEmpty()) {
                String[] eps = epStr.split(";");
                for (String e : eps) {
                    e = e.trim();
                    if (e.isEmpty()) continue;
                    // each episode: n,date,score,duration
                    String[] f = e.split(",");
                    if (f.length != 4) continue;
                    int n = Integer.parseInt(f[0].trim());
                    LocalDate d = LocalDate.parse(f[1].trim());
                    double sc = Double.parseDouble(f[2].trim());
                    LocalTime du = LocalTime.parse(f[3].trim());
                    s.addEpisode(new Episode(n, d, sc, du));
                }
            }
            return s;
        } else {
            throw new IllegalArgumentException("unknown type: " + type);
        }
    }
}
