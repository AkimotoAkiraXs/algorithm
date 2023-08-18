// Given a positive integer n, return the number of the integers in the range [0,
// n] whose binary representations do not contain consecutive ones. 
//
// 
// Example 1: 
//
// 
// Input: n = 5
// Output: 5
// Explanation:
// Here are the non-negative integers <= 5 with their corresponding binary
// representations:
// 0 : 0
// 1 : 1
// 2 : 10
// 3 : 11
// 4 : 100
// 5 : 101
// Among them, only integer 3 disobeys the rule (two consecutive ones) and the
// other 5 satisfy the rule.
// 
//
// Example 2: 
//
// 
// Input: n = 1
// Output: 2
// 
//
// Example 3: 
//
// 
// Input: n = 2
// Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// 👍 331 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;600
 * <p>
 * Name：Non-negative Integers without Consecutive Ones
 *
 * @author Yuri
 * @since 2023-07-13 16:14:08
 */


public class NonNegativeIntegersWithoutConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new NonNegativeIntegersWithoutConsecutiveOnes().new Solution();
        solution.findIntegers(5);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 数位Dp：经典例题
         * <p>
         * 第一步推出状态转移方程式：设dp[i]表示第i位数中不包含连续1的个数。
         * 对第i位数考虑其自身为0和自身为1两种情况：
         * n[i]为0时，i-1位数中所有不包含连续1的个数都可以取，即dp[i]=dp[i-1]。
         * n[i]为1时，n[i-1]必须为0，dp[i]=dp[i-2]。
         * ∴ dp[i]=dp[i-1]+dp[i-2]
         * <p>
         * 第二步通过数位Dp算答案：数位dp思想关键在一个区间一个区间对数量进行计算！
         * 我们每次计算二进制下[0~左边一位1的范围)，后续算[上一位1~下一位1)的范围，如此反复。
         * <p>
         * 以10101001为例：第一次计算[0~10000000)区间的答案数，但其中不包含10000000。
         * 第二次计算[10000000，10100000)，其实就是在第一次的范围上加上[0~100000)，所以10000000就相当于加上0。
         * 以此类推，遇到11的情况就表示后续已经不满足则退出循环。 <br>
         * 在计算到最后一个1的时候需要做特殊处理：首先其计算范围为[10101000~10101001)，此时dp[0]=1的初始状态定义就体现出作用，
         * 其表示0这种情况，也就是10101000，然后对于右区间10101001，因为没有下一个1用于计算这个数，所以直接加1。
         */
        public int findIntegers(int n) {
            int len = Integer.toBinaryString(n).length();
            int[] dp = new int[32];
            dp[0] = 1; // dp[0]=1比较抽象，在算法实际意义是代表0这一种情况
            dp[1] = 2;
            for (int i = 2; i < len; i++) dp[i] = dp[i - 1] + dp[i - 2];
            int ans = 0;
            int pre = 0;
            for (int i = len - 1; i >= 0; i--) {
                if ((n >> i & 1) == 1) { // 条件满足代表n的i+1位是1，
                    ans += dp[i];
                    if (pre == 1) break;
                    pre = 1;
                } else pre = 0;
                if (i == 0) ans++; // 因为每次计算区间是包含左区间，不包含右区间，右区间是交给下一次1进行计算，但此时已经算到最后一个1了，所以直接加1
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
