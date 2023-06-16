// You are given an integer array coins representing coins of different
// denominations and an integer amount representing a total amount of money.
//
// Return the number of combinations that make up that amount. If that amount 
// of money cannot be made up by any combination of the coins, return 0.
//
// You may assume that you have an infinite number of each kind of coin. 
//
// The answer is guaranteed to fit into a signed 32-bit integer. 
//
// 
// Example 1: 
//
// 
// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
// 
//
// Example 2: 
//
// 
// Input: amount = 3, coins = [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.
// 
//
// Example 3: 
//
// 
// Input: amount = 10, coins = [10]
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// All the values of coins are unique. 
// 0 <= amount <= 5000 
// 
//
// Related Topics 数组 动态规划 👍 1097 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;518
 * <p>
 * Name：Coin Change II
 *
 * @author Yuri
 * @since 2023-06-15 18:25:51
 */


public class CoinChangeIi {
    public static void main(String[] args) {
        Solution solution = new CoinChangeIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 完全背包：dp[i]表示金额为i时，当前零钱种类能组成的方案数。
         * <p>
         * dp[j-coin]就是选择「任意个」面值为coin的硬币数量的总和，所以状态转移中使用的是 +=。
         */
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int j = coin; j <= amount; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            return dp[amount];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
