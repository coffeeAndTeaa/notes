package string;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int longest(String input) {
        // corner case
        if (input.length() <= 1) {
            return input.length();
        }
        int length = input.length();
        HashSet<Character> cache = new HashSet<>();
        int max = 0;
        int begin = 0;
        int end = 0;
        while (end < length) {
            if (cache.contains(input.charAt(end))) {
                cache.remove(input.charAt(begin++));
            } else {
                max = Math.max(max,(end - begin + 1));
                cache.add(input.charAt(end++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longest("abcc"));
    }
}
