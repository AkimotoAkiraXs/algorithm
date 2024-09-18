// You are given an integer k and an integer x. The price of a number num is
// calculated by the count of set bits at positions x, 2x, 3x, etc., in its binary
// representation, starting from the least significant bit. The following table
// contains examples of how price is calculated.
//
// 
// 
// 
// x 
// num 
// Binary Representation 
// Price 
// 
// 
// 1 
// 13 
// 000001101 
// 3 
// 
// 
// 2 
// 13 
// 000001101 
// 1 
// 
// 
// 2 
// 233 
// 011101001 
// 3 
// 
// 
// 3 
// 13 
// 000001101 
// 1 
// 
// 
// 3 
// 362 
// 101101010 
// 2 
// 
// 
// 
//
// The accumulated price of num is the total price of numbers from 1 to num. 
// num is considered cheap if its accumulated price is less than or equal to k.
//
// Return the greatest cheap number. 
//
// 
// Example 1: 
//
// 
// Input: k = 9, x = 1 
// 
//
// Output: 6 
//
// Explanation: 
//
// As shown in the table below, 6 is the greatest cheap number. 
//
// 
// 
// 
// x 
// num 
// Binary Representation 
// Price 
// Accumulated Price 
// 
// 
// 1 
// 1 
// 001 
// 1 
// 1 
// 
// 
// 1 
// 2 
// 010 
// 1 
// 2 
// 
// 
// 1 
// 3 
// 011 
// 2 
// 4 
// 
// 
// 1 
// 4 
// 100 
// 1 
// 5 
// 
// 
// 1 
// 5 
// 101 
// 2 
// 7 
// 
// 
// 1 
// 6 
// 110 
// 2 
// 9 
// 
// 
// 1 
// 7 
// 111 
// 3 
// 12 
// 
// 
// 
//
// Example 2: 
//
// 
// Input: k = 7, x = 2 
// 
//
// Output: 9 
//
// Explanation: 
//
// As shown in the table below, 9 is the greatest cheap number. 
//
// 
// 
// 
// x 
// num 
// Binary Representation 
// Price 
// Accumulated Price 
// 
// 
// 2 
// 1 
// 0001 
// 0 
// 0 
// 
// 
// 2 
// 2 
// 0010 
// 1 
// 1 
// 
// 
// 2 
// 3 
// 0011 
// 1 
// 2 
// 
// 
// 2 
// 4 
// 0100 
// 0 
// 2 
// 
// 
// 2 
// 5 
// 0101 
// 0 
// 2 
// 
// 
// 2 
// 6 
// 0110 
// 1 
// 3 
// 
// 
// 2 
// 7 
// 0111 
// 1 
// 4 
// 
// 
// 2 
// 8 
// 1000 
// 1 
// 5 
// 
// 
// 2 
// 9 
// 1001 
// 1 
// 6 
// 
// 
// 2 
// 10 
// 1010 
// 2 
// 8 
// 
// 
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 10¹⁵ 
// 1 <= x <= 8 
// 
//
// 👍 50 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;3007
 * <p>
 * Name：Maximum Number That Sum of the Prices Is Less Than or Equal to K
 *
 * @author Yuri
 * @since 2024-08-28 16:54:20
 */

public class MaximumNumberThatSumOfThePricesIsLessThanOrEqualToK {

    public static void main(String[] args) {
        Solution solution = new MaximumNumberThatSumOfThePricesIsLessThanOrEqualToK().new Solution();
        System.out.println(solution.findMaximumNumber(1, 2));


    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 二分法+数学
     * <p>
     * 计算1~num，间隔x设置位1的个数，具体逻辑请看灵神题解
     * <p>
     * 找上界思路：要保证至少有k个1，对于1~num的数，如果除以2^(x-1)是奇数则至少包含一个1，所以上届就是k * 2 * (2 ^ x-1) = k * (2 ^ x-1)
     *
     * @see <a href="https://leetcode.cn/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/solutions/2603673/er-fen-da-an-shu-wei-dpwei-yun-suan-pyth-tkir/">Lc3007. 价值和小于等于K的最大数字 题解二：二分+数学</a>
     */
    class Solution {

        public long findMaximumNumber(long k, int x) {
            long l = 0, r = k << x;
            while (l <= r) {
                long m = l + r >> 1;
                long count = count(m, x);
                if (k >= count) l = m + 1;
                else r = m - 1;
            }
            return r;
        }

        private long count(long num, int x) {
            long res = 0;
            for (long i = x - 1, n = num >> i; n > 0; i += x, n >>= x) {
                res += n >> 1 << i;
                if (n % 2 == 1) res += (num & ((1L << i) - 1)) + 1;
            }
            return res;
        }
    }

    /**
     * 试填法
     */
    class Solution_TrialFillMethod {

        // todo 试填法
        public long findMaximumNumber(long k, int x) {

            return 1;
        }
    }

    /**
     * 数位dp
     */
    class Solution_Dp {
        // todo 数位dp
        public long findMaximumNumber(long k, int x) {

            return 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}