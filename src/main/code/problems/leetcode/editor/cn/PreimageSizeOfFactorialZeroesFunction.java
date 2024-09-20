// Let f(x) be the number of zeroes at the end of x!. Recall that x! = 1 * 2 * 3
//* ... * x and by convention, 0! = 1. 
//
// 
// For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 
// 2 because 11! = 39916800 has two zeroes at the end.
// 
//
// Given an integer k, return the number of non-negative integers x have the 
// property that f(x) = k.
//
// 
// Example 1: 
//
// 
// Input: k = 0
// Output: 5
// Explanation: 0!, 1!, 2!, 3!, and 4! end with k = 0 zeroes.
// 
//
// Example 2: 
//
// 
// Input: k = 5
// Output: 0
// Explanation: There is no x such that x! ends in k = 5 zeroes.
// 
//
// Example 3: 
//
// 
// Input: k = 3
// Output: 5
// 
//
// 
// Constraints: 
//
// 
// 0 <= k <= 10⁹ 
// 
//
// 👍 215 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;793
 * <p>
 * Name：Preimage Size of Factorial Zeroes Function
 *
 * @author Yuri
 * @since 2024-09-19 15:03:21
 */

public class PreimageSizeOfFactorialZeroesFunction {

    public static void main(String[] args) {
        Solution solution = new PreimageSizeOfFactorialZeroesFunction().new Solution();
        solution.preimageSizeFZF(5);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二分+数学：二分阶乘0个数大于等于k的最小的数，bs(k+1)-bs(k)就是0个数等于k的数量。
         * 难点在于如何求一个数的阶乘0的个数，很明显0只能由2x5得来，但4x25=100有两个0该如何考虑？其实4x25=2x5x2x5，
         * 换而言之其实就是把所有数分解为质数（就是这点没想到），很明显2远远超过5的数量，所以0的数量就是5的数量。
         */
        public int preimageSizeFZF(int k) {
            return bs(k + 1) - bs(k);
        }

        private int bs(int k) {
            int l = 0, r = Integer.min(5 * k, Integer.MAX_VALUE);
            while (l <= r) {
                int m = (r - l >> 1) + l;
                int cnt = 0, t = 0, p;
                do {
                    p = m / (int) Math.pow(5, ++t);
                    cnt += p;
                } while (p > 0);
                if (k > cnt) l = m + 1;
                else r = m - 1;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}