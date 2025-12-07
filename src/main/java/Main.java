import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(6, 3, 1, 8, 4));
        System.out.println(list.stream().max((a, b) -> a.compareTo(b)));
    }

}
