// We call a positive integer special if all of its digits are distinct.
//
// Given a positive integer n, return the number of special integers that 
// belong to the interval [1, n].
//
// 
// Example 1: 
//
// 
// Input: n = 20
// Output: 19
// Explanation: All the integers from 1 to 20, except 11, are special. Thus,
// there are 19 special integers.
// 
//
// Example 2: 
//
// 
// Input: n = 5
// Output: 5
// Explanation: All the integers from 1 to 5 are special.
// 
//
// Example 3: 
//
// 
// Input: n = 135
// Output: 110
// Explanation: There are 110 integers from 1 to 135 that are special.
// Some of the integers that are not special are: 22, 114, and 131.
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2 * 10⁹ 
// 
//
// 👍 62 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2376
 * <p>
 * Name：Count Special Integers
 *
 * @author Yuri
 * @since 2023-07-14 17:31:38
 */


public class CountSpecialIntegers {
    public static void main(String[] args) {
        Solution solution = new CountSpecialIntegers().new Solution();
        System.out.println(solution.countSpecialNumbers(135));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dp;
        char[] s;
        int len;
        int x;

        public int countSpecialNumbers(int n) {
            s = String.valueOf(n).toCharArray();
            len = s.length;
            x = 10;
            int j = (1 << x) - 1;
            dp = new int[x][j + 1];
            for (int i = 0; i < x; i++) Arrays.fill(dp[i], -1);
            return dfs(0, j, true, false);
        }

        private int dfs(int i, int j, boolean limit, boolean isNum) {
            if (i == len) return isNum ? 1 : 0;
            if (!limit && dp[i][j] >= 0) return dp[i][j];
            int res = 0;
            for (int k = 0; k < (limit ? s[i] - '0' + 1 : x); k++) {
                if ((j >> k & 1) == 0) continue;
                isNum = isNum || k > 0;
                res += dfs(i + 1, isNum ? 1 << k ^ j : j, limit && k == s[i] - '0', isNum);
            }
            if (!limit) dp[i][j] = res;
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
