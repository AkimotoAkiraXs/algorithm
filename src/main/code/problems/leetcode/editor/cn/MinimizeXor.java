// Given two positive integers num1 and num2, find the positive integer x such
// that:
//
// 
// x has the same number of set bits as num2, and 
// The value x XOR num1 is minimal. 
// 
//
// Note that XOR is the bitwise XOR operation. 
//
// Return the integer x. The test cases are generated such that x is uniquely 
// determined.
//
// The number of set bits of an integer is the number of 1's in its binary 
// representation.
//
// 
// Example 1: 
//
// 
// Input: num1 = 3, num2 = 5
// Output: 3
// Explanation:
// The binary representations of num1 and num2 are 0011 and 0101, respectively.
// The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 =
// 0 is minimal.
// 
//
// Example 2: 
//
// 
// Input: num1 = 1, num2 = 12
// Output: 3
// Explanation:
// The binary representations of num1 and num2 are 0001 and 1100, respectively.
// The integer 3 has the same number of set bits as num2, and the value 3 XOR 1 =
// 2 is minimal.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num1, num2 <= 10⁹ 
// 
//
// 👍 28 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2429
 * <p>
 * Name：Minimize XOR
 *
 * @author Yuri
 * @since 2024-07-10 16:32:30
 */

public class MinimizeXor {

    public static void main(String[] args) {
        Solution solution = new MinimizeXor().new Solution();
        System.out.println(solution.minimizeXor(8, 75));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimizeXor(int num1, int num2) {
            int k1 = Integer.bitCount(num1), k2 = Integer.bitCount(num2);
            for (; k1 < k2; k1++) num1 |= num1 + 1;
            for (; k1 > k2; k1--) num1 &= num1 - 1;
            return num1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}