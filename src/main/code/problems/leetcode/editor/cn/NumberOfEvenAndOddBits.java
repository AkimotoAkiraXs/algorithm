// You are given a positive integer n.
//
// Let even denote the number of even indices in the binary representation of n 
// with value 1.
//
// Let odd denote the number of odd indices in the binary representation of n 
// with value 1.
//
// Note that bits are indexed from right to left in the binary representation 
// of a number.
//
// Return the array [even, odd]. 
//
// 
// Example 1: 
//
// 
// Input: n = 50 
// 
//
// Output: [1,2] 
//
// Explanation: 
//
// The binary representation of 50 is 110010. 
//
// It contains 1 on indices 1, 4, and 5. 
//
// Example 2: 
//
// 
// Input: n = 2 
// 
//
// Output: [0,1] 
//
// Explanation: 
//
// The binary representation of 2 is 10. 
//
// It contains 1 only on index 1. 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
//
// 👍 11 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2595
 * <p>
 * Name：Number of Even and Odd Bits
 *
 * @author Yuri
 * @since 2024-06-11 17:15:51
 */

public class NumberOfEvenAndOddBits {

    public static void main(String[] args) {
        Solution solution = new NumberOfEvenAndOddBits().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // O(1)
        public int[] evenOddBit(int n) {
            return new int[]{Integer.bitCount(n & 0x555), Integer.bitCount(n & 0xaaa)};
        }


        // 暴力O(logn)
        public int[] evenOddBit_bf(int n) {
            int[] ans = new int[2];
            for (int i = 0; n > 0; i++) {
                ans[i % 2] += n & 1;
                n >>= 1;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}