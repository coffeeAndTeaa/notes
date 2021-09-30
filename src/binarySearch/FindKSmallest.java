package binarySearch;

public class FindKSmallest {

    public static void main(String[] args) {
        int[] left = {-1, 1, 2, 3, 4, 5};
        int[] right = {1, 3, 5, 7, 10};

        System.out.println(findKth(left, right, 7));
    }

    public static int findKth(int[] left, int[] right, int k) {
        return findKth(left, 0, right, 0, k);
    }

    public static int findKth(int[] left, int leftStart, int[] right, int rightStart, int k) {
        // base case
        if (left.length == leftStart) {
            return right[rightStart + k - 1];
        }

        if (right.length == rightStart) {
            return left[leftStart + k - 1];
        }

        if (k == 1) {
            return Math.min(left[leftStart], right[rightStart]);
        }

        int leftNext = leftStart + k / 2 - 1;
        int rightNext = rightStart + k / 2 - 1;

        int leftValue = leftNext >= left.length ? Integer.MAX_VALUE : left[leftNext];
        int rightValue = rightNext >= right.length ? Integer.MAX_VALUE : right[rightNext];

        if (leftValue >= rightValue) {
            return findKth(left, leftStart, right, rightNext + 1, k - k / 2);
        } else {
            return findKth(left, leftNext + 1, right, rightStart, k - k / 2);
        }
    }
}
