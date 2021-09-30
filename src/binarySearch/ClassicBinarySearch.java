package binarySearch;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.ArrayList;
import java.util.List;

public class ClassicBinarySearch {

    private static int[] duplicate = {0, 1, 2, 2, 3, 3, 4, 5, 6, 7, 7};



    public static void main(String[] args) {
        int[] input = {0, 1, 2, 3, 4, 5, 6};
//        System.out.println(binarySearch(input, 3));
//        System.out.println(binarySearch(input, 7));
//        System.out.println(firstOccur(duplicate, 3));
//        System.out.println(lastOccur(duplicate, 3));

        System.out.println(closet(duplicate, 2));
    }

    public static int binarySearch(int[] input, int target) {
        // corner case
        if (input == null || input.length == 0) {
            return -1;
        }

        int left = 0;
        int right = input.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // find the first Occur of a integer in an array, may be duplicates
    public static int firstOccur(int[] input, int target) {
        // corner case
        if (input == null || input.length == 0) {
            return -1;
        }

        int left = 0;
        int right = input.length - 1;
        int mid;

        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (input[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (input[left] == target) {
            return left;
        } else if (input[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
    // 0  1  2  3  4  5
    // 0, 1, 2, 3, 3, 4
    // l
    //                 r

    public static int lastOccur(int[] input, int target) {
        // corner case
        if (input == null || input.length == 0) {
            return -1;
        }

        int left = 0;
        int right = input.length - 1;
        int mid;

        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (input[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (input[right] == target) {
            return right;
        } else if (input[left] == target) {
            return left;
        }
        return -1;
    }

    public static int insertPosition(int[] input, int target) {
        if (input == null || input.length == 0) {
            return -1;
        }

        int left = 0;
        int right = input.length - 1;
        int mid;

        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (input[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (input[left] >= target) {
            return left;
        }

        if (input[right] >= target) {
            return right;
        }

        return right + 1;
    }

    public static int closet(int[] input, int target) {
        if (input == null || input.length == 0) {
            return -1;
        }

        int left = 0;
        int right = input.length - 1;
        int mid;

        while(left < right - 1) {
            mid = left + (right - left) / 2;
            if (input[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.abs(input[left] - target) > Math.abs(input[right] - target) ? right : left;
    }

    public static void findMax(int[] array) {
        List<String> myList = new ArrayList<>();
        myList.add("hello worl");
    }
}
