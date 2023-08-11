// Given an integer n, return the number of positive integers in the range [1, n]
// that have at least one repeated digit. 
//
// 
// Example 1: 
//
// 
// Input: n = 20
// Output: 1
// Explanation: The only positive number (<= 20) with at least 1 repeated digit
// is 11.
// 
//
// Example 2: 
//
// 
// Input: n = 100
// Output: 10
// Explanation: The positive numbers (<= 100) with atleast 1 repeated digit are 1
// 1, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
// 
//
// Example 3: 
//
// 
// Input: n = 1000
// Output: 262
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// 👍 262 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1012
 * <p>
 * Name：Numbers With Repeated Digits
 *
 * @author Yuri
 * @since 2023-07-18 16:28:58
 */


public class NumbersWithRepeatedDigits {
    public static void main(String[] args) {
        Solution solution = new NumbersWithRepeatedDigits().new Solution();
        System.out.println(solution.numDupDigitsAtMostN(213123));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dp;
        char[] chars;
        int len;

        public int numDupDigitsAtMostN(int n) {
            String s = String.valueOf(n);
            len = s.length();
            chars = s.toCharArray();
            int j = (1 << 10) - 1;
            dp = new int[len][j + 1];
            for (int i = 0; i < len; i++) Arrays.fill(dp[i], -1);
            return n - dfs(0, j, true, false); // 正难则反，正着会被卡dp状态定义dp[i][j]中j没法表示重复出现这种状态
        }

        int dfs(int i, int j, boolean limit, boolean isNum) {
            if (i == len) return isNum ? 1 : 0;
            if (!limit && isNum && dp[i][j] >= 0) return dp[i][j];
            int res = 0;
            if (!isNum) res += dfs(i + 1, j, false, false); // 跳一位，等于处理了不到n位的情况
            for (int k = isNum ? 0 : 1; k <= (limit ? chars[i] - '0' : 9); k++) {
                if ((j >> k & 1) == 0) continue;
                res += dfs(i + 1, 1 << k ^ j, limit && k == chars[i] - '0', true);
            }
            if (!limit && isNum) dp[i][j] = res;
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
