package bitOperation;

public class Main {
    public static void main(String[] args) {
        int x = 0b00100;
        // get its 2 bit
        int b3 = (x >> 2) & 1;
        System.out.println(b3);
    }

    public static int getKth(int x, int k) {
        // get the kth bit of x (start from 0);
        return (x >> k) & 1;
    }

    public static int setKthTo1(int x, int k) {
        // given a number x set the kth bit to 1;
        return (x << k) | 1;
    }

    public static int setKthTo0(int x, int k) {
        // given a number x set the kth bit to 0;
        return x & (~(1 << k));
    }



}
