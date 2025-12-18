import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    String name;
    int year;

    public Main(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Main{");
        sb.append("name='").append(name).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {  return name; }

    public int getYear() { return year; }

    public static void main(String[] args) {
        List<Main> users = new ArrayList<>();
        users.add(new Main("Phuc", 2005));
        users.add(new Main("Dang", 2005));
        users.add(new Main("Phat", 2005));
        users.add(new Main("Huy", 2006));
        users.add(new Main("A", 2006));

        Set<Main> set = new TreeSet<>(Comparator.comparing(Main::getName).thenComparingInt(Main::getYear));
        set.addAll(users);
        System.out.println(set);
    }
}
