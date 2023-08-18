// Write a method to count the number of 2s that appear in all the numbers
// between 0 and n (inclusive).
//
// Example: 
//
// 
// Input: 25
// Output: 9
// Explanation: (2, 12, 20, 21, 22, 23, 24, 25)(Note that 22 counts for two 2s.)
//
//
// Note: 
//
// 
// n <= 10^9 
// 
//
// 👍 75 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;面试题 17.06
 * <p>
 * Name：Number Of 2s In Range LCCI
 *
 * @author Yuri
 * @since 2023-07-18 15:16:41
 */


public class NumberOf2sInRangeLcci {
    public static void main(String[] args) {
        Solution solution = new NumberOf2sInRangeLcci().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dp;
        char[] chars;
        int len;

        public int numberOf2sInRange(int n) {
            String str = String.valueOf(n);
            chars = str.toCharArray();
            len = str.length();
            dp = new int[len][len];
            for (int i = 0; i < len; i++) Arrays.fill(dp[i], -1);
            return dfs(0, 0, true);
        }

        int dfs(int i, int j, boolean limit) {
            if (i == len) return j;
            if (!limit && dp[i][j] >= 0) return dp[i][j];
            int res = 0;
            for (int k = 0; k <= (limit ? chars[i] - '0' : 9); k++)
                res += dfs(i + 1, k == 2 ? j + 1 : j, limit && k == chars[i] - '0');
            if (!limit) dp[i][j] = res;
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
