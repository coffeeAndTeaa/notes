package binarySearch;

public class FindPeak {

    // given an array first ascending and then descending find peak in O(logn) time
    public static void main(String[] args) {
        int[] test = {5, 4, 3, 2, 1};
        int index = findPeak(test);
        System.out.println(test[index]);
    }

    public static int findPeak(int[] array) {
        // corner case
        if (array == null || array.length == 0 || array.length == 2) {
            return -1;
        }

        if (array.length == 1) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid + 1] > array[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return array[left] > array[right] ? left : right;

    }

    //   2  4   5  3  1
    //   l
    //                r
    //         m

}
