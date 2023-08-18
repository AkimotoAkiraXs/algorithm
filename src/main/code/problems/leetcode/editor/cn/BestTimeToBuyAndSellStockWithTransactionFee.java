// You are given an array prices where prices[i] is the price of a given stock
// on the iᵗʰ day, and an integer fee representing a transaction fee.
//
// Find the maximum profit you can achieve. You may complete as many 
// transactions as you like, but you need to pay the transaction fee for each transaction.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
// must sell the stock before you buy again).
//
// 
// Example 1: 
//
// 
// Input: prices = [1,3,2,8,4,9], fee = 2
// Output: 8
// Explanation: The maximum profit can be achieved by:
//- Buying at prices[0] = 1
//- Selling at prices[3] = 8
//- Buying at prices[4] = 4
//- Selling at prices[5] = 9
// The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
// 
//
// Example 2: 
//
// 
// Input: prices = [1,3,7,5,10,3], fee = 3
// Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5 * 10⁴ 
// 1 <= prices[i] < 5 * 10⁴ 
// 0 <= fee < 5 * 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 910 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;714
 * <p>
 * Name：Best Time to Buy and Sell Stock with Transaction Fee
 *
 * @author Yuri
 * @since 2023-05-30 16:33:59
 */


public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
        solution.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 注意理解题意，买卖都要交手续费，但同一天买卖只交一次
        public int maxProfit(int[] prices, int fee) {
            int profit = 0;
            int spend = prices[0] + fee;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < spend - fee) {
                    spend = prices[i] + fee;
                } else if (prices[i] > spend) {
                    profit += prices[i] - spend;
                    spend = prices[i];
                }
            }
            return profit;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
