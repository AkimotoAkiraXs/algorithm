// You have n coins and you want to build a staircase with these coins. The
// staircase consists of k rows where the iᵗʰ row has exactly i coins. The last row of
// the staircase may be incomplete.
//
// Given the integer n, return the number of complete rows of the staircase you 
// will build.
//
// 
// Example 1: 
// 
// 
// Input: n = 5
// Output: 2
// Explanation: Because the 3ʳᵈ row is incomplete, we return 2.
// 
//
// Example 2: 
// 
// 
// Input: n = 8
// Output: 3
// Explanation: Because the 4ᵗʰ row is incomplete, we return 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// 👍 315 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;441
 * <p>
 * Name：Arranging Coins
 *
 * @author Yuri
 * @since 2025-03-09 16:33:59
 */

public class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new ArrangingCoins().new Solution();
        solution.arrangeCoins(2147483647);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力
         */
        public int arrangeCoins_bf(int n) {
            int t;
            for (t = 1; n >= t; t++) n -= t;
            return t - 1;
        }

        /**
         * 二分：利用求和公式sum = (n*(n+1))/2
         */
        public int arrangeCoins(int n) {
            long l = 1, r = (long) n + 1; // r = n+1保证其再n=1的时候也满足左闭右开
            while (l < r) {
                long m = r + l >> 1;
                if (m * (m + 1) <= (long) 2 * n) l = m + 1;
                else r = m;
            }
            return (int) (l - 1);
        }

        /**
         * 数学 略
         */

    }
// leetcode submit region end(Prohibit modification and deletion)

}