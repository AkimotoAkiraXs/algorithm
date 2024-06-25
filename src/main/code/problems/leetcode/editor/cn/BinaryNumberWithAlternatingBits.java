// Given a positive integer, check whether it has alternating bits: namely, if
// two adjacent bits will always have different values.
//
// 
// Example 1: 
//
// 
// Input: n = 5
// Output: true
// Explanation: The binary representation of 5 is: 101
// 
//
// Example 2: 
//
// 
// Input: n = 7
// Output: false
// Explanation: The binary representation of 7 is: 111.
//
// Example 3: 
//
// 
// Input: n = 11
// Output: false
// Explanation: The binary representation of 11 is: 1011.
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// 👍 240 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;693
 * <p>
 * Name：Binary Number with Alternating Bits
 *
 * @author Yuri
 * @since 2024-06-25 10:58:47
 */

public class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        Solution solution = new BinaryNumberWithAlternatingBits().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean hasAlternatingBits(int n) {
            int a = 1, b = 2;
            int x = 0, y = 0;
            for (int i = 0; i < 32; i+=2) {
                if ((x |= a << i) == n) return true;
                if ((y |= b << i) == n) return true;
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}