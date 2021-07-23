package DynamicProgramming;

public class Fibonacci {
    public static int get(int x) {
        int[] cache = new int [x + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= x; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[x];
    }

    public static void main(String[] args) {
        System.out.println(get(3));
    }
}
