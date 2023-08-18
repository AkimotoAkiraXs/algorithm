// An ugly number is a positive integer whose prime factors are limited to 2, 3,
// and 5.
//
// Given an integer n, return true if n is an ugly number. 
//
// 
// Example 1: 
//
// 
// Input: n = 6
// Output: true
// Explanation: 6 = 2 × 3
// 
//
// Example 2: 
//
// 
// Input: n = 1
// Output: true
// Explanation: 1 has no prime factors, therefore all of its prime factors are
// limited to 2, 3, and 5.
// 
//
// Example 3: 
//
// 
// Input: n = 14
// Output: false
// Explanation: 14 is not ugly since it includes the prime factor 7.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 393 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;263
 * <p>
 * Name：Ugly Number
 *
 * @author Yuri
 * @since 2023-05-31 17:52:02
 */


public class UglyNumber {

    public static void main(String[] args) {
        Solution solution = new UglyNumber().new Solution();
        solution.isUgly(1352);

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isUgly(int n) {
            if (n == 0) return false;
            while (n % 2 == 0) n /= 2;
            while (n % 3 == 0) n /= 3;
            while (n % 5 == 0) n /= 5;
            return n == 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
