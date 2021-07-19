package bitOperation;

public class Main {
    public static void main(String[] args) {
        int x = 0b00100;
        // get its 2 bit (start from 0);
        int b3 = (x >> 2) & 1;
        System.out.println(b3);
    }
}
