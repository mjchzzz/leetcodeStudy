package mjc.leetcode;

/**
 * @author jianchaomeng
 * @time 2020/7/25 025 17:33
 */
public class Q41 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,1}));
    }

    /**
     * O(n) time and O(n) space.
     * @param nums
     * @return
     */
    public static int firstMissingPositiveV1(int[] nums) {
        int[] count = new int[nums.length];
        for(int n : nums) {
            if (n <= nums.length && n > 0) {
                count[n-1] ++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                return i + 1;
            }
        }
        return count.length + 1;
    }

    /**
     *  O(n) time and O(1) space.
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > nums.length || cur <= 0 || cur == i+1) continue;
            nums[i] = nums[cur - 1];
            nums[cur - 1] = cur;
            if (nums[i] != nums[cur-1]) {
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
