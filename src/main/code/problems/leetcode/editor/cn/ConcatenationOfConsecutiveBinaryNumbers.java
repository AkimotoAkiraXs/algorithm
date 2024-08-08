// Given an integer n, return the decimal value of the binary string formed by
// concatenating the binary representations of 1 to n in order, modulo 109 + 7.
//
// 
// Example 1: 
//
// 
// Input: n = 1
// Output: 1
// Explanation: "1" in binary corresponds to the decimal value 1.
// 
//
// Example 2: 
//
// 
// Input: n = 3
// Output: 27
// Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
// After concatenating them, we have "11011", which corresponds to the decimal
// value 27.
// 
//
// Example 3: 
//
// 
// Input: n = 12
// Output: 505379714
// Explanation: The concatenation results in "11011100101110111100010011010101111
// 00".
// The decimal value of that is 118505380540.
// After modulo 10⁹ + 7, the result is 505379714.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// 👍 49 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1680
 * <p>
 * Name：Concatenation of Consecutive Binary Numbers
 *
 * @author Yuri
 * @since 2024-08-08 16:14:31
 */

public class ConcatenationOfConsecutiveBinaryNumbers {

    public static void main(String[] args) {
        Solution solution = new ConcatenationOfConsecutiveBinaryNumbers().new Solution();
        solution.concatenatedBinary(3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int concatenatedBinary(int n) {
            int mod = (int) (1e9 + 7);
            long k = 0;
            int p = 0, cnt = 0;
            for (int i = 1; i <= n; i++, cnt--) {
                if (cnt == 0) cnt = 1 << p++;
                k = (k << p) % mod + i;
            }
            return (int) k % mod;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}