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

    public static void main(String[] args) {
        System.out.println(dfs(12));
    }
}
