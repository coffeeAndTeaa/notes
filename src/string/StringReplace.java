package string;

import java.util.HashSet;

public class StringReplace {

    public static HashSet<Integer> findMatchHead(String m, String n){
        char[] arrayM = m.toCharArray();
        char[] arrayN = n.toCharArray();
        HashSet<Integer> answer = new HashSet<>();
        for (int i = 0; i < arrayM.length - arrayN.length + 1; i++) {
            int count = 0;
            for (int j = i; j < i + arrayN.length; j++) {
                if (arrayM[j] != arrayN[j - i]) {
                    break;
                }
                count++;
            }
            if (count == arrayN.length) {
                answer.add(i);
            }
        }
        return answer;
    }

    public static String replaceToShort( char[] input, char[] change, char[] origin, HashSet<Integer> answer) {
        int i = 0;
        int j = 0;

        while (j < input.length) {
            if (answer.contains(j)) {
                int count = 0;
                while (count < change.length) {
                    input[i++] = change[count++];
                }
                j += origin.length;
            } else {
                input[i++] = input[j++];
            }
        }
        return new String(input, 0, i);
    }

    public static HashSet<Integer> findMatchTail(String m, String n){
        char[] arrayM = m.toCharArray();
        char[] arrayN = n.toCharArray();
        HashSet<Integer> answer = new HashSet<>();
        for (int i = 0; i < arrayM.length - arrayN.length + 1; i++) {
            int count = 0;
            for (int j = i; j < i + arrayN.length; j++) {
                if (arrayM[j] != arrayN[j - i]) {
                    break;
                }
                count++;
            }
            if (count == arrayN.length) {
                answer.add(i + arrayN.length - 1);
            }
        }
        return answer;
    }

    public static String replaceToLong(char[] input, char[] change, char[] origin, HashSet<Integer> answer) {
        char[] result = new char[input.length + answer.size()*(change.length - origin.length)];
        int j = input.length - 1;
        int k = result.length - 1;
        while (j >= 0) {
            if (answer.contains(j)) {
                j -= origin.length;
                int count = change.length - 1;
                while (count >= 0) {
                    result[k--] = change[count--];
                }
            } else {
                result[k--] = input[j--];
            }
        }
        return new String(result, k+1, result.length );
    }

    public static void main(String[] args) {
        char[] input = new char[] {'a', 'b', 'c', 'd', 'e', 'b', 'c', 'd' , 'm'};
        char[] target = new char[] {'x','x'};
        char[] replace = new char[] {'b','c','d'};
        char[] target2 = new char[] {'1', '2', '3', '4'};
//        HashSet<Integer> answer = findMatchHead(new String(input), new String(replace));
        HashSet<Integer> answer2 = findMatchTail(new String(input), new String(replace));
//        System.out.println(answer);
        System.out.println(answer2);
//        String ans = replaceToShort(input, target, replace, answer);
        String ans2 = replaceToLong(input, target2, replace, answer2);
//        System.out.println(ans);
        System.out.println(ans2);
    }
}
