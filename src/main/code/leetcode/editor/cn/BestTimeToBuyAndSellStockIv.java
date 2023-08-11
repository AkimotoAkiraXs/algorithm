// You are given an integer array prices where prices[i] is the price of a given
// stock on the iᵗʰ day, and an integer k.
//
// Find the maximum profit you can achieve. You may complete at most k 
// transactions: i.e. you may buy at most k times and sell at most k times.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
// must sell the stock before you buy again).
//
// 
// Example 1: 
//
// 
// Input: k = 2, prices = [2,4,1]
// Output: 2
// Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit =
// 4-2 = 2.
// 
//
// Example 2: 
//
// 
// Input: k = 2, prices = [3,2,6,5,0,3]
// Output: 7
// Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit =
// 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3
//-0 = 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 950 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;188
 * <p>
 * Name：Best Time to Buy and Sell Stock IV
 *
 * @author Yuri
 * @since 2023-05-31 10:46:44
 */


public class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int[][] dp = new int[k][2];

            for (int i = 0; i < k; i++) {
                dp[i][0] = -prices[0];
                dp[i][1] = 0;
            }
            for (int i = 1; i < prices.length; i++) {
                dp[0][0] = Math.max(dp[0][0], -prices[i]);
                dp[0][1] = Math.max(dp[0][1], dp[0][0] + prices[i]);
                for (int j = 1; j < k; j++) {
                    dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                    dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
                }
            }
            int res = 0;
            for (int i = 0; i < k; i++) res = Math.max(res, dp[i][1]);
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
