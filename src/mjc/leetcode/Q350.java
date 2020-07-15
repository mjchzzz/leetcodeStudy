package mjc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 */

public class Q350 {
    public static void main(String[] args) {
        Q350 q350 = new Q350();
        int[] res = q350.intersect(new int[]{1,2,3,2}, new int[]{2,3,4,2});
        for (int n : res) {
            System.out.println(n);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        int[] result = new int[nums1.length];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            Integer count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
        }
        int index = 0;
        for (int num : nums2) {
            int count = countMap.getOrDefault(num, 0);
            if (count>0) {
                result[index++] = num;
                countMap.put(num, count - 1);
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }
}
