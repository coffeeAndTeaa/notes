package midterm;

import java.util.Arrays;

public class Plalindrome {
    public int findCuts(String input){
        char[] array = input.toCharArray();
        int[] cache = new int[input.length() + 1]; // cache[i] stands for the min cut for String.subString(0, i);
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = -1;
        for (int i = 1; i <cache.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (cache[j] != Integer.MAX_VALUE && check(array, j, i-1)) {
                    min = Math.min(min, cache[j] + 1);
                }
            }
            cache[i] = min;
        }
        return cache[input.length()];
    }

    private boolean check(char[] array, int i, int j) {
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "aba";
        String t2 = "ababbbabbababa";
        Plalindrome my = new Plalindrome();
        System.out.println(my.findCuts(test));
        System.out.println(my.findCuts(t2));
    }
}
