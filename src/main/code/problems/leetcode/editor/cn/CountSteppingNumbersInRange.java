// Given two positive integers low and high represented as strings, find the
// count of stepping numbers in the inclusive range [low, high].
//
// A stepping number is an integer such that all of its adjacent digits have an 
// absolute difference of exactly 1.
//
// Return an integer denoting the count of stepping numbers in the inclusive 
// range [low, high].
//
// Since the answer may be very large, return it modulo 10⁹ + 7. 
//
// Note: A stepping number should not have a leading zero. 
//
// 
// Example 1: 
//
// 
// Input: low = "1", high = "11"
// Output: 10
// Explanation: The stepping numbers in the range [1,11] are 1, 2, 3, 4, 5, 6, 7,
// 8, 9 and 10. There are a total of 10 stepping numbers in the range. Hence, the 
// output is 10.
//
// Example 2: 
//
// 
// Input: low = "90", high = "101"
// Output: 2
// Explanation: The stepping numbers in the range [90,101] are 98 and 101. There
// are a total of 2 stepping numbers in the range. Hence, the output is 2.
//
// 
// Constraints: 
//
// 
// 1 <= int(low) <= int(high) < 10¹⁰⁰ 
// 1 <= low.length, high.length <= 100 
// low and high consist of only digits. 
// low and high don't have any leading zeros. 
// 
//
// 👍 10 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2801
 * <p>
 * Name：Count Stepping Numbers in Range
 *
 * @author Yuri
 * @since 2023-08-01 18:54:55
 */


public class CountSteppingNumbersInRange {
    public static void main(String[] args) {
        Solution solution = new CountSteppingNumbersInRange().new Solution();

        solution.countSteppingNumbers("1", "10");
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 数位Dp+前缀和+模运算：
     * <p>
     * ①.数位Dp，需要判断是否构成数字
     * <p>
     * ②.因为上下界位数不一致所以需要分别对上下界进行计算然后用前缀和原理进行减法算区间内个数。
     * 且题目包含左区间，所以需要计算下界是否为满足题意需求的数，如果是答案+1（注意！如果先模运算后+1需要再次取模！所以这里先+1后模运算）
     * <p>
     * ③.因为存在取模，运用模运算 (a-b)%mod = (a%mod - b%mod + mod)%mod
     */
    class Solution {
        int mod = (int) 1e9 + 7;
        char[] nums;
        int n;
        long[][] dp;

        public int countSteppingNumbers(String low, String high) {
            n = high.length();
            dp = new long[10][n];
            for (int i = 0; i < 10; i++) Arrays.fill(dp[i], -1);
            nums = high.toCharArray();
            long hi = dfs(0, 0, false, true);
            n = low.length();
            dp = new long[11][n];
            for (int i = 0; i < 10; i++) Arrays.fill(dp[i], -1);
            nums = low.toCharArray();
            long lw = dfs(0, 0, false, true);

            boolean flag = true;
            for (int i = 1; i < nums.length; i++) {
                if (Math.abs(nums[i] - nums[i - 1]) != 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) hi++;

            return (int) ((hi - lw + mod) % mod);
        }

        long dfs(int i, int j, boolean isNum, boolean limit) {
            if (j == n) return isNum ? 1 : 0;
            if (!limit && isNum && dp[i][j] >= 0) return dp[i][j];
            long res = 0;
            if (!isNum) res += dfs(i, j + 1, false, false);
            for (int k = (isNum ? 0 : 1); k <= (limit ? nums[j] - '0' : 9); k++) {
                if (!isNum || Math.abs(i - k) == 1) // isNum判断是否为首位，首位可以直接通过不用减去上一位绝对值=1
                    res = (res + dfs(k, j + 1, true, limit && k == nums[j] - '0')) % mod;
            }
            if (!limit && isNum) dp[i][j] = res;
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
