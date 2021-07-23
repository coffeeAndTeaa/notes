package bitOperation;

public class DifferentBitsBetweenTwoNumbers {
    public static int solution(int x, int y) {
        // 1 ^ 1 = 0 ;  0 ^ 1 = 1  ; 0 ^ 0 = 1 当进行 exclusive or 不相等的会为1
        x ^= y;
        int count = 0;
        while (x != 0) {
            count += x & 1;
            x >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 38;
        String x1 = Integer.toBinaryString(x);
        String y1 = Integer.toBinaryString(y);
        System.out.println(x1);
        System.out.println(y1);
        System.out.println(solution(x, y));
    }
}
