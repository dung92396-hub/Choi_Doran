
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
        char ch = new Main().nextGreaterLetter(
                new char[] {'x', 'x', 'y', 'y'},
                'z'
        );
        System.out.println(ch);
//        System.out.println(new Main().findNegativeIndex(
//                new int[] { -12, -7, -3, -1, 2, 4 }
//        ));
    }
}
