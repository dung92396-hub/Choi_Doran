package java_stream;

import java.util.*;

public class Main {
    static void testArrayStream() {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        // tong cac phan tu, identity: gia tri khoi tao, (a, b) la gia tri tiep theo trong mang
        int sum = arr.stream().reduce(0, (a, b) -> a + b);
//        int sum = arr.stream().reduce(0, Integer::sum); co the viet dang nay cho gon

        // tich cac phan tu
        int mul = arr.stream().reduce(1, (a, b) -> a * b);


        // tong cac phan tu le
        int sumOfEven = arr.stream().filter(e -> e % 2 == 0).reduce(0, Integer::sum);

        System.out.println(sum);
        System.out.println(mul);
        System.out.println(sumOfEven);
    }

    public static void main(String[] args) {
        testArrayStream();
    }
}
