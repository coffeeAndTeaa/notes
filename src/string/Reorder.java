package string;

public class Reorder {
    public int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    // 0  1  2  3  4  5
    // 1  2  3  4  5  6
    // l  lm    m  rm  r

    // 1  3  2  5  4  6
    // 1  4  5  2  3  6


    // 4  5  2  3
    // l
    //

    // 1, 4, 2, 5, 3, 6
    private void reorder(int[] array, int left, int right) {
        int length = right - left + 1;

        if (length <= 2) {
            return;
        }
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }
}
