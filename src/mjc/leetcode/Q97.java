package mjc.leetcode;

/**
 * @author jianchaomeng
 * @time 2020/7/18 018 23:11
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
public class Q97 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(isInterleaveV1("aa",
                "bbc",
                "ababc"));
        System.out.println(isInterleave("aa",
                "bbc",
                "ababc"));
        System.out.println(System.currentTimeMillis() - start);
    }


    /**
     * V1 暴力法，超时
     */
    public static boolean isInterleaveV1(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) {
            return s3.equals(s2);
        }
        if (s2 == null || s2.length() == 0) {
            return  s3.equals(s1);
        }
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        char c3 = s3.charAt(0);
        if (c1 == c3) {
            if (isInterleaveV1(s1.substring(1), s2, s3.substring(1))) {
                return true;
            }
        }
        if (c2 == c3) {
            if (isInterleaveV1(s1, s2.substring(1), s3.substring(1))) {
                return true;
            }
        }
        return false;
    }

    /**
     * V2 dp
     * 执行用时：6 ms, 在所有 Java 提交中击败了33.96%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了14.29%的用户
     */
    public static boolean isInterleaveV2(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp[0][0] = true;

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    /**
     * V3 优化后dp
     * 执行用时：3 ms, 在所有 Java 提交中击败了91.76%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了14.29%的用户
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp[0][0] = true;

        for (int i = 0; i <= s1.length(); i++) {
            int count = 0;
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
                if (dp[i][j]) {
                    count++;
                }
            }
            if (count == 0) {
                return false;
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
