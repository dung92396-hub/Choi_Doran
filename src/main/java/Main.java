import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class Main {

    public char nextGreaterLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int idx = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (letters[middle] > target) {
                idx = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return idx > 0 ? letters[idx] : letters[0];
    }


    public int findNegativeIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < 0) {
                left = middle + 1;
            } else {
                idx = middle;
                right = middle - 1;
            }
        }
        return idx;
    }


    public static void main(String[] args) {
        Predicate<Integer> pred1 = (value) -> value % 2 == 0;
        Predicate<Integer> pred2 = (value) -> value >= 5;
        Predicate<Integer> mergePred = pred1.and(pred2);
        List<Integer> nums = new ArrayList<>(List.of(8, 2, 1, 5, 3, 9, 11, 4));
        nums = nums.stream()
                .filter(value -> mergePred.test(value))
                .toList();
//        System.out.println(nums);
        List<Predicate<Integer>> preds = new ArrayList<>();
        preds.add((value) -> value % 2 == 0);
        preds.add((value) -> value >= 5);
        preds.add((value) -> (value + 1) % 3 == 0);

        Predicate<Integer> ps = preds.get(0).and(preds.get(1).and(preds.get(2)));
        Predicate<Integer> ps2 = preds.get(0).and(preds.get(1)).and(preds.get(2));


//        nen su dung cac bien the cua predicate de tranh unboxing tu dong (anh huong nhe den hieu suat)
        IntPredicate intPred = (value) -> value % 2 == 0;
        LongPredicate longPred = (value) -> value - 1 == 7;

//        su dung optional<t> de xu li exception gon gang
//        stream lambda xu li nhanh logic

        System.out.println(Objects.equals(1, 2));
        Optional<Integer> option;

    }
}
