// Given an integer n, return true if it is a power of four. Otherwise, return
// false.
//
// An integer n is a power of four, if there exists an integer x such that n == 
// 4ˣ.
//
// 
// Example 1: 
// Input: n = 16
// Output: true
// 
// Example 2: 
// Input: n = 5
// Output: false
// 
// Example 3: 
// Input: n = 1
// Output: true
// 
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
// Follow up: Could you solve it without loops/recursion?
//
// 👍 374 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;342
 * <p>
 * Name：Power of Four
 *
 * @author Yuri
 * @since 2024-06-11 17:49:46
 */

public class PowerOfFour {

    public static void main(String[] args) {
        Solution solution = new PowerOfFour().new Solution();

        solution.isPowerOfFour(6);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPowerOfFour(int n) {
            return n > 0 && Integer.bitCount(n & 0xaaaaaaaa) == 0 && Integer.bitCount(n & 0x55555555) == 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}