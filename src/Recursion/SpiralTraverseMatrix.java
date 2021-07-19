package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverseMatrix {
    public static List<Integer> spiralTraverse(int[][] input) {
        List<Integer> answer = new ArrayList<>();
        int rowSize = input.length;
        int colSize = input[0].length;
        helper(input, 0, 0, rowSize, colSize, answer);
        return answer;
    }

    private static void helper(int[][] input, int rowOffset, int colOffset, int rowSize, int colSize, List<Integer> answer) {
        if (rowSize == 0 || colSize == 0) {
            return;
        }

        if (rowSize == 1) {
            for (int i = colOffset; i < colSize + colOffset; i++) {
                answer.add(input[rowOffset][i]);
            }
            return;
        }

        if (colSize == 1) {
            for (int i = rowOffset; i < rowOffset + rowSize; i++) {
                answer.add(input[i][colOffset]);
            }
            return;
        }

        for (int i = colOffset; i < colOffset + colSize - 1; i++) {
            answer.add(input[rowOffset][i]);
        }

        for (int i = rowOffset; i < rowOffset + rowSize - 1; i++) {
            answer.add(input[i][colOffset + colSize - 1]);
        }

        for (int i = colOffset + colSize - 1; i > colOffset; i--) {
            answer.add(input[rowOffset + rowSize - 1][i]);
        }

        for (int i = rowOffset + rowSize - 1; i > rowOffset; i--) {
            answer.add(input[i][colOffset]);
        }

        helper(input, rowOffset + 1, colOffset + 1, rowSize - 2, colSize - 2, answer);
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{ {1,  2,  3,  4},

                {5,  6,  7,  8},

                {9, 10, 11, 12} };
        List<Integer> answer;
        answer = spiralTraverse(test);
        System.out.println(answer);
    }
}
