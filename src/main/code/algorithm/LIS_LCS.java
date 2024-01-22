package algorithm;

import java.util.Arrays;
import problems.leetcode.editor.cn.LongestCommonSubsequence;
import problems.leetcode.editor.cn.LongestIncreasingSubsequence;
import problems.leetcode.editor.cn.ShortestCommonSupersequence;
import problems.leetcode.editor.cn.SortingThreeGroups;

/**
 * @author Yuri
 * @since 2024/1/22 17:18
 */


public class LIS_LCS {

    /**
     * LIS：最长上升子序列（Longest Increasing Subsequence），
     *
     * @see LongestIncreasingSubsequence Lc300.最长递增子序列
     * @see SortingThreeGroups Lc2826.将三个组排序
     */
    class LIS {

        /**
         * 标准做法O(n^2)
         */
        public int LIS_Normal(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++)
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
            return max + 1;
        }

        /**
         * 贪心+二分：O(nlogn)
         * <p>
         * f[i]记录的是长度为i的非递增子序列的最后一个数大小，所以所得的数组一定是单调递增的，可以采用二分判断每一个数合适的位置。
         * 相应的，该位置便是以该数为结尾的最长非递增子序列。
         */
        public int LIS_PRO(int[] nums) {
            int n = nums.length;
            int max = 0;
            int[] f = new int[n + 1];
            Arrays.fill(f, Integer.MIN_VALUE);
            for (int num : nums) {
                int l = 0, r = max + 1;
                while (l < r) {
                    int mid = (l + r) >>> 2;
                    if (f[mid] < num) l = mid + 1;
                    else r = mid;
                }
                f[r] = num;
                max = Math.max(max, r);
            }
            return max;
        }

        /**
         * 贪心+二分+原地更新：O(nlogn)
         * <p>
         */
        public int LIS_MAX(int[] nums) {
            int max = 0;
            for (int num : nums) {
                int l = -1, r = max;
                while (l + 1 < r) {
                    int mid = (l + r) >>> 1;
                    if (nums[mid] < num) l = mid;
                    else r = mid;
                }
                nums[r] = num;
                if (r == max) max++;
            }
            return max;
        }
    }

    class LCS {

        /**
         * 最长公共子序列（Longest Common Subsequence）
         *
         * 求长度dp用Int数组
         *
         * @see LongestCommonSubsequence Lc1143.最长公共子序列
         */
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return dp[m][n];
        }

        /**
         * 最短公共超序列
         *
         * @see ShortestCommonSupersequence Lc1092.最短公共超序列
         */
        public String shortestCommonSupersequence(String str1, String str2) {
            return "";
        }
    }
}
