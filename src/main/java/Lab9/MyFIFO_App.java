package Lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyFIFO_App {
    public static <E> void stutter(Queue<E> input) {
        while (!input.isEmpty()) {
            System.out.print(input.peek() + ", " + input.peek() + ", ");
            input.remove();
        }
    }

    public static <E> void mirror(Queue<E> input) {
        List<E> arr = new ArrayList<>();
        while (!input.isEmpty()) {
            arr.add(input.poll());
        }
        List<E> re = arr.reversed();
        arr.addAll(re);
        System.out.println(arr.toString());
    }

    public static void main(String[] args) {
        stutter(new PriorityQueue<>(List.of(1, 2, 3, 4, 5)));
        mirror(new PriorityQueue<>(List.of(1, 2, 3, 4)));
    }

}
