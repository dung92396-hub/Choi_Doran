package Netflix;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestNetflix {
    // Moved logic đọc dữ liệu (mở file films.txt) sang phương thức riêng
    private static InputStream openFilmsInput() throws Exception {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("film2.txt");
        if (in == null) in = TestNetflix.class.getResourceAsStream("/film2.txt");
        if (in == null) {
            Path p = Paths.get("src/main/resources/film2.txt");
            if (Files.exists(p)) {
                System.out.println("Loaded films from filesystem: " + p.toAbsolutePath());
                in = Files.newInputStream(p);
            }
        }
        return in;
    }

    // Helper: đọc dữ liệu từ films.txt và parse thành danh sách Film
    private static List<Film> loadFilms() throws Exception {
        try (InputStream in = openFilmsInput()) {
            if (in == null) throw new IllegalStateException("Cannot find films.txt in resources or filesystem.");
            return FilmsParser.parse(in);
        }
    }

    public static void main(String[] args) throws Exception {
        List<Film> films;
        try {
            films = loadFilms();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return;
        }
        NetflixPlatform platform = new NetflixPlatform("NetflixVN");
        platform.addAll(films);

        System.out.println(platform.filterByGenre(Genre.KHAM_PHA));
    }
}
