package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode36 {
    public static boolean isValidSudoku(char[][] board) {
        // set for boxes
        List<Set<Character>> boxes = new ArrayList<>();
        for (int i = 0; i < 9; i++) boxes.add(new HashSet<>());

        for (int i = 0; i < board.length; i++) {
            Set<Character> setRow = new HashSet<>();
            Set<Character> setColumn = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!setRow.add(board[i][j])) {
                        return false;
                    }
                    int boxesIndex = (i / 3) + (j / 3 * 3);
                    if (!boxes.get(boxesIndex).add(board[i][j])) {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!setColumn.add(board[j][i])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValid2(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxs = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxs[i] = new HashSet<>();


        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j <9 ; j++) {
                char val = board[i][j];
                if (val == '.') continue;

                if (!rows[i].add(val)) return false;
                if (!cols[j].add(val)) return false;

            }

        }
        return true;
    }


    public static void main(String[] args) {
        char[][] boardTrue = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] boardFalse = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] board = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},

                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},

                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(isValidSudoku(boardTrue));
        System.out.println(isValidSudoku(boardFalse));
        System.out.println(isValidSudoku(board));
        /**
         * [[".",".","4",".",".",".","6","3","."],
         * [".",".",".",".",".",".",".",".","."],
         * ["5",".",".",".",".",".",".","9","."],
         * [".",".",".","5","6",".",".",".","."],
         * ["4",".","3",".",".",".",".",".","1"],
         * [".",".",".","7",".",".",".",".","."],
         * [".",".",".","5",".",".",".",".","."],
         * [".",".",".",".",".",".",".",".","."],
         * [".",".",".",".",".",".",".",".","."]]
         */
    }
}
