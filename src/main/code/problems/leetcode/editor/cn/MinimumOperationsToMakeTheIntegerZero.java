// You are given two integers num1 and num2.
//
// In one operation, you can choose integer i in the range [0, 60] and subtract 
// 2ⁱ + num2 from num1.
//
// Return the integer denoting the minimum number of operations needed to make 
// num1 equal to 0.
//
// If it is impossible to make num1 equal to 0, return -1. 
//
// 
// Example 1: 
//
// 
// Input: num1 = 3, num2 = -2
// Output: 3
// Explanation: We can make 3 equal to 0 with the following operations:
//- We choose i = 2 and substract 2² + (-2) from 3, 3 - (4 + (-2)) = 1.
//- We choose i = 2 and substract 2² + (-2) from 1, 1 - (4 + (-2)) = -1.
//- We choose i = 0 and substract 2⁰ + (-2) from -1, (-1) - (1 + (-2)) = 0.
// It can be proven, that 3 is the minimum number of operations that we need to
// perform.
// 
//
// Example 2: 
//
// 
// Input: num1 = 5, num2 = 7
// Output: -1
// Explanation: It can be proven, that it is impossible to make 5 equal to 0
// with the given operation.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num1 <= 10⁹ 
// -10⁹ <= num2 <= 10⁹ 
// 
//
// 👍 10 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2749
 * <p>
 * Name：Minimum Operations to Make the Integer Zero
 * <p>
 * 单周赛351 Q2
 *
 * @author Yuri
 * @since 2023-06-27 09:36:59
 */


public class MinimumOperationsToMakeTheIntegerZero {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToMakeTheIntegerZero().new Solution();
        solution.makeTheIntegerZero(3, -2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 公式：num1 - k*num2 - k*2^i = 0 (0<=i<=60)
         * <p>
         * ∴能推导出num = num1 - k*num2的值是k个2^i相加而得，得出以下结论： <br>
         * ①.num>0，∵k>0，∴k个2^i。<br>
         * ②.bit(num)<=k，2^i每个位置不同就多就是k个1。 <br>
         * ③.num>=k，2^i最小就是2^0=1，∴k*2^i>=k
         */
        public int makeTheIntegerZero(int num1, int num2) {
            for (long k = 0; k <= 60; k++) {
                long num = num1 - (k * num2);
                if (num > 0 && Long.bitCount(num) <= k && num >= k) return (int) k;
            }
            return -1;
        }

        /**
         * 灵神做法中将num1 - num2 * k作为循环退出条件就满足①③的情况了
         */
        public int makeTheIntegerZero_Ling(int num1, int num2) {
            for (long k = 1; k <= num1 - num2 * k; k++)
                if (k >= Long.bitCount(num1 - num2 * k))
                    return (int) k;
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
