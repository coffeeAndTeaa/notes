package string;

public class LongestSubarrayContainsOnly1s {
    public int longestConsecutiveOnes(int[] nums, int k) {
        int slow = 0;
        int fast = 0;
        int max = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                if (k > 0){
                    k--;
                } else {
                    while (nums[slow] != 0) {
                        slow++;
                    }
                    slow++;
                }
            }
            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubarrayContainsOnly1s test = new LongestSubarrayContainsOnly1s();
        int tmp = test.longestConsecutiveOnes(new int[] {1, 0, 1, 0, 1, 1}, 2);
        System.out.println(tmp);
    }
}
