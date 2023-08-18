// You are given an integer array coins representing coins of different
// denominations and an integer amount representing a total amount of money.
//
// Return the fewest number of coins that you need to make up that amount. If 
// that amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
// Input: coins = [2], amount = 3
// Output: -1
// 
//
// Example 3: 
//
// 
// Input: coins = [1], amount = 0
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2457 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;322
 * <p>
 * Name：Coin Change
 *
 * @author Yuri
 * @since 2023-06-15 17:47:29
 */


public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{1, 2, 5}, 11);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 完全背包模板题
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 1); // -1是避免dp[j - coin] + 1爆内存
            dp[0] = 0;
            for (int coin : coins) {
                for (int j = 1; j <= amount; j++) {
                    if (coin <= j) dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
            return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
