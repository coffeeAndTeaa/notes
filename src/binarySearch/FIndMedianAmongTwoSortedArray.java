package binarySearch;

public class FIndMedianAmongTwoSortedArray {

    public static void main(String[] args) {
        int[] left = {-1 , 0, 1, 2, 3};  // -1, 0, 1, 1, 2, 2, 3, 3
        int[] right = {1, 2, 3};
        System.out.println(findMedian(left, right));
    }

    public static double findMedian(int[] left, int[] right) {
        int total = left.length + right.length;
        if ( total % 2 == 0 ) {
            return ((double)(findKth(left, 0, right, 0, total / 2)) +findKth(left, 0, right, 0, total / 2 + 1)) / 2;
        } else {
            return (double) findKth(left, 0, right, 0, total / 2 + 1);
        }
    }

    // flag == true the total length is odd, else the total length is even
    public static int findKth(int[] left, int leftStart, int[] right, int rightStart, int k) {
        // base case
        if (leftStart == left.length) {
           return right[rightStart + k - 1];
        }

        if (rightStart == right.length) {
            return left[leftStart + k - 1];
        }

        if (k == 1) {
            return Math.min(left[leftStart], right[rightStart]);
        }

        int leftNext = leftStart + k / 2 - 1;
        int rightNext = rightStart + k / 2 - 1;

        int currentLeft = leftNext >= left.length ? Integer.MAX_VALUE : left[leftNext];
        int currentRight = rightNext >= right.length ? Integer.MAX_VALUE : right[rightNext];

        if (currentLeft <= currentRight) {
            // we need to throw everything in currentLeft
            return findKth(left, leftNext + 1, right, rightStart, k - k / 2);
        } else {
            return findKth(left, leftStart, right, rightNext + 1, k - k / 2);
        }
    }
}
