package dfs;

public class TwoSubsetWIthMinDifference {
    private double minDiff = Double.MAX_VALUE;
    private int ans;
    public int minDifference(int[] array) {
        int cache;
        int sum = getSum(array);
        double target = (double)sum / 2;
        dfs(0, array, 0, target);
        int temp = sum - ans;
        return Math.abs(temp - ans);
    }

    private void dfs(int index, int[] array, int cache, double target) {
        // base case
        if (index == array.length) {
            return;
        }
        if (minDiff > Math.abs((double)cache - target)) {
            ans = cache;
            minDiff = Math.abs((double)cache - target);
        }

        dfs(index + 1, array, cache + array[index], target);
        dfs(index + 1, array, cache, target);
    }

    private int getSum(int[] array) {
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        TwoSubsetWIthMinDifference test = new TwoSubsetWIthMinDifference();
        test.minDifference(new int[]{-2,-9,-3,-1,-1});
    }
}
