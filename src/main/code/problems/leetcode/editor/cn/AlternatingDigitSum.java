// You are given a positive integer n. Each digit of n has a sign according to
// the following rules:
//
// 
// The most significant digit is assigned a positive sign. 
// Each other digit has an opposite sign to its adjacent digits. 
// 
//
// Return the sum of all digits with their corresponding sign. 
//
// 
// Example 1: 
//
// 
// Input: n = 521
// Output: 4
// Explanation: (+5) + (-2) + (+1) = 4.
// 
//
// Example 2: 
//
// 
// Input: n = 111
// Output: 1
// Explanation: (+1) + (-1) + (+1) = 1.
// 
//
// Example 3: 
//
// 
// Input: n = 886996
// Output: 0
// Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// 
// 
//
// 👍 38 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2544
 * <p>
 * Name：Alternating Digit Sum
 *
 * @author Yuri
 * @since 2023-07-12 14:51:08
 */


public class AlternatingDigitSum {
    public static void main(String[] args) {
        Solution solution = new AlternatingDigitSum().new Solution();
        solution.alternateDigitSum(521);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 开局让sym为负，n>0先改变sym，退出循环后sym就是第一位数sym的符号，所以sym也就表示了ans的符号
        public int alternateDigitSum(int n) {
            int sym = -1;
            int ans = 0;
            while (n > 0) {
                sym = -sym;
                ans += n % 10 * sym;
                n /= 10;
            }
            return ans * sym;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
