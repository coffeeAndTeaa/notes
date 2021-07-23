package bitOperation;

public class DetermineWhetherANumberIsPowerOf2 {
    public static boolean solution (int x) {
        return (x > 0 && (x & (x - 1)) == 0);
    }


    public static void main(String[] args) {
        int i = 4;
        System.out.println(solution(i));
        int j = 3;
        System.out.println(solution(j));
    }
}

