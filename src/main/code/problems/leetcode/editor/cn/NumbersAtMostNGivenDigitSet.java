// Given an array of digits which is sorted in non-decreasing order. You can
// write numbers using each digits[i] as many times as we want. For example, if digits
//= ['1','3','5'], we may write numbers such as '13', '551', and '1351315'. 
//
// Return the number of positive integers that can be generated that are less 
// than or equal to a given integer n.
//
// 
// Example 1: 
//
// 
// Input: digits = ["1","3","5","7"], n = 100
// Output: 20
// Explanation:
// The 20 numbers that can be written are:
// 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
// 
//
// Example 2: 
//
// 
// Input: digits = ["1","4","9"], n = 1000000000
// Output: 29523
// Explanation:
// We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
//
// 81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
// 2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit
// numbers.
// In total, this is 29523 integers that can be written using the digits array.
// 
//
// Example 3: 
//
// 
// Input: digits = ["7"], n = 8
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= digits.length <= 9 
// digits[i].length == 1 
// digits[i] is a digit from '1' to '9'. 
// All the values in digits are unique. 
// digits is sorted in non-decreasing order. 
// 1 <= n <= 10⁹ 
// 
//
// 👍 254 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;902
 * <p>
 * Name：Numbers At Most N Given Digit Set
 *
 * @author Yuri
 * @since 2023-07-14 11:07:41
 */


public class NumbersAtMostNGivenDigitSet {
    public static void main(String[] args) {
        Solution solution = new NumbersAtMostNGivenDigitSet().new Solution();
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"7"}, 8));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dp;
        char[] s;
        int[] digits;
        int len;

        public int atMostNGivenDigitSet(String[] digits, int n) {
            String str = String.valueOf(n);
            len = str.length();
            s = str.toCharArray();
            this.digits = new int[digits.length];
            dp = new int[len];
            for (int i = 0; i < digits.length; i++) this.digits[i] = Integer.parseInt(digits[i]);
            Arrays.fill(dp, -1);
/*
            // 位数小于len的个数可以提前算出来，就不用在dfs中加入isNum来控制前导0计算了
            int res = 0;
            for (int i = 1; i < len; i++) {
                int cnt = 1;
                for (int j = 0; j < i; j++) cnt *= digits.length;
                res += cnt;
            }
*/
            return dfs(0, true, false);
        }

        // isNum理解为前导0，前面为0其实就是位数少1的情况。
        private int dfs(int i, boolean limit, boolean isNum) {
            if (i == len) return isNum ? 1 : 0;
            if (!limit && isNum && dp[i] >= 0) return dp[i];
            int res = 0;
            if (!isNum) res += dfs(i + 1, false, false);
            for (int digit : digits) {
                if (limit && digit > s[i] - '0') break;
                res += dfs(i + 1, limit && digit == s[i] - '0', true);
            }
            if (!limit && isNum) dp[i] = res;
            return res;
        }

        // 贪心
        public int atMostNGivenDigitSet_greed(String[] digits, int n) {
            char[] s = String.valueOf(n).toCharArray();
            int b = s.length;
            int ans = 0;
            // 先计算位数小于b的情况
            int len = digits.length;
            for (int i = 1; i < b; i++) ans += Math.pow(len, i);
            // 计算位数等于b的情况
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < len; j++) {
                    int d = Integer.parseInt(digits[j]);
                    int k = s[i] - '0';
                    if (d > k) return ans; // 所有小于的都统计完了
                    if (i == b - 1) ans++;
                    if (d == k) break; // 该位相等了就统计下一位
                    int x = b - i - 1;
                    int cnt = 1;
                    for (int l = 0; l < x; l++) cnt *= len;
                    ans += x == 0 ? 0 : cnt;
                    if (j == len - 1) return ans; // 说明n大于了能组出来的最大的数
                }
            }
            return ans;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

} 
