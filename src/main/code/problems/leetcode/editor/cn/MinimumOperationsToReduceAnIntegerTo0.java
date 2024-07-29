// You are given a positive integer n, you can do the following operation any
// number of times:
//
// 
// Add or subtract a power of 2 from n. 
// 
//
// Return the minimum number of operations to make n equal to 0. 
//
// A number x is power of 2 if x == 2ⁱ where i >= 0. 
//
// 
// Example 1: 
//
// 
// Input: n = 39
// Output: 3
// Explanation: We can do the following operations:
//- Add 2⁰ = 1 to n, so now n = 40.
//- Subtract 2³ = 8 from n, so now n = 32.
//- Subtract 2⁵ = 32 from n, so now n = 0.
// It can be shown that 3 is the minimum number of operations we need to make n
// equal to 0.
// 
//
// Example 2: 
//
// 
// Input: n = 54
// Output: 3
// Explanation: We can do the following operations:
//- Add 2¹ = 2 to n, so now n = 56.
//- Add 2³ = 8 to n, so now n = 64.
//- Subtract 2⁶ = 64 from n, so now n = 0.
// So the minimum number of operations is 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// 👍 48 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2571
 * <p>
 * Name：Minimum Operations to Reduce an Integer to 0
 *
 * @author Yuri
 * @since 2024-07-25 18:03:32
 */

public class MinimumOperationsToReduceAnIntegerTo0 {

    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceAnIntegerTo0().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 位运算技巧
         *
         * @see <a href="https://gitee.com/YuriMing/akira-pictures/raw/master/img/202407291100706.png">位运算优化</a>
         */
        public int minOperations(int n) {
            return Integer.bitCount(n ^ 3 * n);
        }

        /**
         * 贪心：有连续1就先在末尾增加1，单个1就直接减去。因为前位1只能因为后位+1而被约去，所以我们从后向前。
         */
        public int minOperations_(int n) {
            int ans = 0;
            while (n > 0) {
                int k = n & -n;
                if ((k << 1 & n) > 0) n += k;
                else n -= k;
                ans++;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}