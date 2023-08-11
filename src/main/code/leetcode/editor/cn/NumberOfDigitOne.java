// Given an integer n, count the total number of digit 1 appearing in all non-
// negative integers less than or equal to n.
//
// 
// Example 1: 
//
// 
// Input: n = 13
// Output: 6
// 
//
// Example 2: 
//
// 
// Input: n = 0
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// 👍 522 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;233
 * <p>
 * Name：Number of Digit One
 *
 * @author Yuri
 * @since 2023-07-07 15:34:26
 */


public class NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
        System.out.println(solution.countDigitOne(13));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 数位dp模板题
        int[][] dp;
        char[] s;
        int m;

        public int countDigitOne(int n) {
            s = String.valueOf(n).toCharArray();
            m = s.length;
            dp = new int[m][m];
            for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
            return dfs(0, 0, true);
        }

        private int dfs(int i, int cnt, boolean limit) {
            if (i == m) return cnt;
            if (!limit && dp[i][cnt] >= 0) return dp[i][cnt];
            int res = 0;
            for (int j = 0, top; j <= (top = limit ? s[i] - '0' : 9); j++)
                res += dfs(i + 1, cnt + (j == 1 ? 1 : 0), limit && j == top);
            if (!limit) dp[i][cnt] = res;
            return res;
        }

        // 贪心：推导每个位置1出现的次数
        public int countDigitOne_greed(int n) {
            int cnt = 0;
            long p = 1;
            while (n / p > 0) {
                cnt += n / p * (p / 10);
                cnt += Math.min(p / 10, Math.max(0, n % p - p / 10 + 1));
                p *= 10;
            }
            cnt += Math.min(p / 10, n % p + 1 - p / 10);
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
