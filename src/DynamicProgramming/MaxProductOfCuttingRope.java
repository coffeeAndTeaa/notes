package DynamicProgramming;

public class MaxProductOfCuttingRope {
//    public int maxProduct(int length) {
//        System.out.println(dfs(3));
//    }

    private static int dfs(int length) {
        if (length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 1; i < length; i++) {
             max = Math.max(i * dfs(length - i), max);
        }
        return Math.max(max, length);
    }

    private static int dp(int length) {
        // base case
        if (length == 1) {
            return length;
        }
        int[] cache = new int[length + 1]; // cache[i] stands for the max product in length i
        cache[1] = 1;
        for (int i = 2; i <= length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(Math.max(j, cache[j])*(i - j), max);
            }
            cache[i] = max;
        }
        return cache[length];
    }

    public static void main(String[] args) {
        System.out.println(dfs(12));
        System.out.println(dp(12));
    }
}
