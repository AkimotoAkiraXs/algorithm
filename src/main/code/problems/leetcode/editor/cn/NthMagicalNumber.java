// A positive integer is magical if it is divisible by either a or b.
//
// Given the three integers n, a, and b, return the nᵗʰ magical number. Since 
// the answer may be very large, return it modulo 10⁹ + 7.
//
// 
// Example 1: 
//
// 
// Input: n = 1, a = 2, b = 3
// Output: 2
// 
//
// Example 2: 
//
// 
// Input: n = 4, a = 2, b = 3
// Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 👍 234 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;878
 * <p>
 * Name：Nth Magical Number
 *
 * @author Yuri
 * @since 2024-09-19 10:17:10
 */

public class NthMagicalNumber {

    public static void main(String[] args) {
        Solution solution = new NthMagicalNumber().new Solution();
        solution.nthMagicalNumber(5, 2, 4);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int nthMagicalNumber(int n, int a, int b) {
            int mod = (int) (1e9 + 7);
            long lcm = (long) a * b / gcd(a, b); // 最大公倍数
            long l = Math.min(a, b), r = (long) n * Math.min(a, b);
            while (l <= r) {
                long m = l + r >> 1;
                long cnt = m / a + m / b - m / lcm;
                if (cnt < n) l = m + 1;
                else r = m - 1;
            }
            return (int) (l % mod);
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}