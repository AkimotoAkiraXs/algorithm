// Given three integers a, b, and n, return the maximum value of (a XOR x) * (b
// XOR x) where 0 <= x < 2ⁿ.
//
// Since the answer may be too large, return it modulo 109 + 7. 
//
// Note that XOR is the bitwise XOR operation. 
//
// 
// Example 1: 
//
// 
// Input: a = 12, b = 5, n = 4
// Output: 98
// Explanation: For x = 2, (a XOR x) = 14 and (b XOR x) = 7. Hence, (a XOR x) * (
// b XOR x) = 98.
// It can be shown that 98 is the maximum value of (a XOR x) * (b XOR x) for all
// 0 <= x < 2ⁿ.
// 
//
// Example 2: 
//
// 
// Input: a = 6, b = 7 , n = 5
// Output: 930
// Explanation: For x = 25, (a XOR x) = 31 and (b XOR x) = 30. Hence, (a XOR x) *
// (b XOR x) = 930.
// It can be shown that 930 is the maximum value of (a XOR x) * (b XOR x) for
// all 0 <= x < 2ⁿ.
//
// Example 3: 
//
// 
// Input: a = 1, b = 6, n = 3
// Output: 12
// Explanation: For x = 5, (a XOR x) = 4 and (b XOR x) = 3. Hence, (a XOR x) * (
// b XOR x) = 12.
// It can be shown that 12 is the maximum value of (a XOR x) * (b XOR x) for all
// 0 <= x < 2ⁿ.
// 
//
// 
// Constraints: 
//
// 
// 0 <= a, b < 2⁵⁰ 
// 0 <= n <= 50 
// 
//
// 👍 14 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2939
 * <p>
 * Name：Maximum Xor Product
 *
 * @author Yuri
 * @since 2024-07-31 15:59:06
 */

public class MaximumXorProduct {

    public static void main(String[] args) {
        Solution solution = new MaximumXorProduct().new Solution();
        solution.maximumXorProduct(0, 3, 1);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 贪心
         * <p>
         * 控制所以可变bit位都在n以内，考虑两种情况：
         * 1.两数都为0的bit位，按贪心原则两数中都变为1。
         * 2.两数中一个为1，一个为0的bit位，因为在该位置最后只能有一个数可以为1，所以考虑该把这个1给谁？
         * 按贪心原则，两数和一定的情况下，相乘的值肯定是越接近越大（比如4*8 < 5*7 < 6*6)。
         * 把这些位置提取出来，第一位如果变动，则两数大小也会变动，所以第一位不动，后面的bit位全给小的那个数，这样两个数就是最接近的。
         * <p>
         * 注意：1、2是完全独立的，先后顺序不影响。
         */
        public int maximumXorProduct(long a, long b, int n) {
            // 保证 a > b
            if (a < b) {
                long t = a;
                a = b;
                b = t;
            }

            // 求两数都为0的bit位，在n范围内把这些位置都给两数变为1
            long k = (1L << n) - 1; // 控制范围在n以内
            long x = ~a & k, y = ~b & k; // 分别提取a,b中为0的位置（范围为n，不足补0）
            long fz = x & y;
            a |= fz;
            b |= fz;

            // 求两数中一个为1，一个为0的位置，
            long l = a ^ b;
            l ^= Long.highestOneBit(l); // 去除最高位
            a &= ~l | ~k; // 对a中去掉相应位置的1
            b |= l & k; // 对b中加上对应位置的1

            int mod = (int) (1e9 + 7);
            return (int) ((a % mod * (b % mod)) % mod);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}