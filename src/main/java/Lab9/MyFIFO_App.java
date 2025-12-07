package Lab9;

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

    }

    public static void main(String[] args) {
        stutter(new PriorityQueue<>(List.of(1, 2, 3, 4)));
    }
}
