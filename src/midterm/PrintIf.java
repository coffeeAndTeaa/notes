package midterm;

public class PrintIf {
    public void allIF(int n) {
        StringBuilder sb = new StringBuilder();
        helper(sb, 0, 0, n);
    }

    public void helper(StringBuilder sb, int left, int right, int n) {
        // base case
        if (left == n && right == n) {
            printAnswer(sb);
            return;
        }
        if (left < n) {
            sb.append('{');
            helper(sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append('}');
            helper(sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void printAnswer(StringBuilder sb) {
        int space = 0;
        StringBuilder myBuilder = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '{') {
                int j = 0;
                while (j < space) {
                    myBuilder.append(' ');
                    j++;
                }
                myBuilder.append("if { \n");
                space += 2;
            } else {
                int j = 0;
                space -= 2;
                while (j < space) {
                    myBuilder.append((' '));
                    j++;
                }
                myBuilder.append("} \n");
            }
        }
        String answer = myBuilder.toString();
        System.out.println(answer);
    }

    public static void main(String[] args) {
        PrintIf my = new PrintIf();
        my.allIF(2);
    }
}
