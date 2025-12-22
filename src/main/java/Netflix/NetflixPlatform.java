package Netflix;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NetflixPlatform {
    private final String name;                 // tên nền tảng
    private final List<Film> films = new ArrayList<>(); // danh sách các phim trình chiếu

    public NetflixPlatform(String name) { this.name = name; }

    public String getName() { return name; }

    public List<Film> getFilms() { return Collections.unmodifiableList(films); }

    public void addFilm(Film f) { if (f != null) films.add(f); }

    public void addAll(Collection<? extends Film> list) { if (list != null) films.addAll(list); }

    public static String header() {
        return "| TYPE   | CODE     | NAME                           | GENRE      | COUNTRY    | STARS | SCORE | AGE | RELEASE   |";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Platform: ").append(name).append(System.lineSeparator());
        sb.append(header()).append(System.lineSeparator());
        for (Film f : films) sb.append(f).append(System.lineSeparator());
        return sb.toString();
    }

    // ================== 20 phương thức rỗng: hãy viết logic theo yêu cầu trong comment ==================

    // 1) YÊU CẦU: Lọc danh sách phim theo thể loại (genre) và trả về danh sách mới, sắp xếp theo ngày phát hành tăng dần
    public List<Film> filterByGenre(Genre genre) {
        return this.films
                .stream()
                .filter(film -> film.getGenre().equals(genre))
                .toList();
    }

    // 2) YÊU CẦU: Tìm phim theo mã (code) trả về Optional<Film>
    public Optional<Film> findByCode(String code) {
        // TODO: implement
        return this.films
                .stream()
                .filter(film -> film.getCode().equals(code))
                .findFirst();
    }

    // 3) YÊU CẦU: Lọc phim có điểm score10 >= minScore, trả về danh sách mới, sắp xếp theo score10 giảm dần, rồi theo tên
    public List<Film> filterByScore(double minScore) {
        return this.films
                .stream()
                .filter(film -> film.getScore10() >= minScore)
                .sorted(Comparator.comparing(Film::getScore10, Comparator.reverseOrder()).thenComparing(Film::getName))
                .toList();
    }

    // 4) YÊU CẦU: Dùng HashMap group theo quốc gia -> danh sách phim của quốc gia đó
    public Map<Country, List<Film>> groupByCountry() {
        return this.films
                .stream()
                .collect(Collectors.groupingBy(Film::getCountry));
    }

    // 5) YÊU CẦU: Dùng TreeMap group theo năm phát hành -> số lượng phim trong năm đó (sắp xếp theo năm tăng dần)
    public Map<Integer, Long> countByYear() {
        return this.films
                .stream()
                .collect(Collectors.groupingBy(
                        Film::getReleaseYear,
                        TreeMap::new,
                        Collectors.counting()
                ));
    }

    // 6) YÊU CẦU: Trả về Set<String> gồm tất cả mã phim (code) duy nhất (dùng HashSet)
    public Set<String> uniqueCodes() {
        return this.films
                .stream()
                .map(Film::getCode)
                .collect(Collectors.toSet());
    }

    // 7) YÊU CẦU: Trả về TreeSet<String> gồm tên phim duy nhất, sắp xếp theo tự nhiên (alphabet)
    public Set<String> uniqueNamesSorted() {
        return this.films
                .stream()
                .map(Film::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    // 8) YÊU CẦU: Dùng TreeMap<Genre, Double> tính điểm trung bình (score10) theo thể loại, làm tròn 2 chữ số
    public Map<Genre, Double> averageScoreByGenre() {
        return null;
    }

    // 9) YÊU CẦU: Tìm top N phim có score10 cao nhất, nếu bằng điểm thì ưu tiên ngày phát hành gần đây hơn
    public List<Film> topNByScore(int n) {
        return films
                .stream()
                .sorted(Comparator
                        .comparing(Film::getScore10)
                        .thenComparing(Film::getReleaseDate))
                .limit(n)
                .toList();
    }

    // 10) YÊU CẦU: Trả về Map<String, Film> ánh xạ code -> Film (nếu trùng code thì lấy phim có score10 cao hơn)
    public Map<String, Film> mapByCodePreferHigherScore() {
        // TODO: implement using merge logic
        return new HashMap<>();
    }

    // 11) YÊU CẦU: Tìm tất cả SERIES có ít nhất k tập phát hành trước 1 ngày bất kỳ (tham số date)
    public List<Series> seriesWithAtLeastKEpisodesBefore(java.time.LocalDate date, int k) {
        // TODO: implement
        return Collections.emptyList();
    }

    // 12) YÊU CẦU: Dùng HashMap<Country, Set<Genre>>: mỗi quốc gia -> set các thể loại đã sản xuất
    public Map<Country, Set<Genre>> genresProducedByCountry() {
        return new HashMap<>();
    }

    // 13) YÊU CẦU: Trả về TreeSet<Film> sắp xếp theo (score10 giảm dần, rồi theo name tăng) - gợi ý dùng Comparator
    public Set<Film> asSortedSetByScoreThenName() {
        return films
                .stream()
                .collect(
                        Collectors.toCollection(() -> new TreeSet<>(
                                Comparator
                                        .comparing(Film::getScore10, Comparator.reverseOrder()).thenComparing(Film::getName)))
                );
    }

    // 14) YÊU CẦU: Dùng TreeMap<Genre, List<Film>> sắp xếp key theo Genre tự nhiên, value là danh sách phim trong từng genre sắp xếp theo tên
    public Map<Genre, List<Film>> filmsByGenreSortedByName() {
        // TODO: implement using TreeMap
        return new TreeMap<>();
    }

    // 15) YÊU CẦU: Trả về Map<Boolean, List<Film>> partition theo điều kiện: tuổi yêu cầu >= 18
    public Map<Boolean, List<Film>> partitionAdultRequired() {
        // TODO: implement
        return new HashMap<>();
    }

    // 16) YÊU CẦU: Tìm tất cả Movie có thời lượng trong khoảng [min, max] (LocalTime)
    public List<Movie> moviesByDurationBetween(java.time.LocalTime min, java.time.LocalTime max) {
        // TODO: implement
        return Collections.emptyList();
    }

    // 17) YÊU CẦU: Trả về Map<Integer, Set<String>>: tuổi yêu cầu -> set mã phim
    public Map<Integer, Set<String>> codesByAgeRequired() {
        // TODO: implement
        return new HashMap<>();
    }

    // 18) YÊU CẦU: Trả về danh sách mới gồm các phim phát hành trong khoảng [from, to], sắp xếp theo quốc gia, rồi theo ngày phát hành
    public List<Film> releasedBetween(java.time.LocalDate from, java.time.LocalDate to) {
        // TODO: implement
        return Collections.emptyList();
    }

    // 19) YÊU CẦU: Dùng HashMap<Country, Long> đếm số Movie theo từng quốc gia (bỏ qua Series)
    public Map<Country, Long> countMoviesByCountry() {
        // TODO: implement
        return new HashMap<>();
    }

    // 20) YÊU CẦU: Tạo TreeMap<String, Film> key = name (không phân biệt hoa thường), value = Film có ngày phát hành mới nhất cho mỗi name
    public Map<String, Film> latestFilmByNameIgnoreCase() {
        // TODO: implement using TreeMap with String.CASE_INSENSITIVE_ORDER
        return new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }
}

