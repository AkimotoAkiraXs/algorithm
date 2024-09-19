// An ugly number is a positive integer that is divisible by a, b, or c.
//
// Given four integers n, a, b, and c, return the nᵗʰ ugly number. 
//
// 
// Example 1: 
//
// 
// Input: n = 3, a = 2, b = 3, c = 5
// Output: 4
// Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3ʳᵈ is 4.
// 
//
// Example 2: 
//
// 
// Input: n = 4, a = 2, b = 3, c = 4
// Output: 6
// Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4ᵗʰ is 6.
// 
//
// Example 3: 
//
// 
// Input: n = 5, a = 2, b = 11, c = 13
// Output: 10
// Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5ᵗʰ is 10.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= n, a, b, c <= 10⁹ 
// 1 <= a * b * c <= 10¹⁸ 
// It is guaranteed that the result will be in range [1, 2 * 10⁹]. 
// 
//
// 👍 153 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1201
 * <p>
 * Name：Ugly Number III
 *
 * @author Yuri
 * @since 2024-09-19 14:33:50
 */

public class UglyNumberIii {

    public static void main(String[] args) {
        Solution solution = new UglyNumberIii().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int nthUglyNumber(int n, int a, int b, int c) {
            long l = Math.min(Math.min(a, b), c), r = n * l;
            while (l <= r) {
                long m = l + r >> 1;
                long cnt =
                    m / a + m / b + m / c - m / lcm(a, b) - m / lcm(a, c) - m / lcm(b, c) + m / lcm(lcm(a, b), c);
                if (cnt < n) l = m + 1;
                else r = m - 1;
            }
            return (int) l;
        }

        private long lcm(long a, long b) {
            return a / gcd(a, b) * b;
        }

        private long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}