// Given 3 positives numbers a, b and c. Return the minimum flips required in
// some bits of a and b to make ( a OR b == c ). (bitwise OR operation). Flip
// operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their
// binary representation.
//
// 
// Example 1: 
//
// 
//
// 
// Input: a = 2, b = 6, c = 5
// Output: 3
// Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
//
// Example 2: 
//
// 
// Input: a = 4, b = 2, c = 7
// Output: 1
// 
//
// Example 3: 
//
// 
// Input: a = 1, b = 2, c = 3
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= a <= 10^9 
// 1 <= b <= 10^9 
// 1 <= c <= 10^9 
// 
//
// 👍 70 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1318
 * <p>
 * Name：Minimum Flips to Make a OR b Equal to c
 *
 * @author Yuri
 * @since 2024-06-25 14:40:46
 */

public class MinimumFlipsToMakeAOrBEqualToC {

    public static void main(String[] args) {
        Solution solution = new MinimumFlipsToMakeAOrBEqualToC().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minFlips(int a, int b, int c) {
            int cnt = 0;
            while (c != 0 || b != 0 || a != 0) {
                int k = c & 1;
                if (k == 1) cnt += ((a | b) & 1) ^ 1;
                else cnt += (a & 1) + (b & 1);
                a >>= 1;
                b >>= 1;
                c >>= 1;
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}