// You are given an array prices where prices[i] is the price of a given stock
// on the iᵗʰ day.
//
// Find the maximum profit you can achieve. You may complete as many 
// transactions as you like (i.e., buy one and sell one share of the stock multiple times)
// with the following restrictions:
//
// 
// After you sell your stock, you cannot buy stock on the next day (i.e., 
// cooldown one day).
// 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
// must sell the stock before you buy again).
//
// 
// Example 1: 
//
// 
// Input: prices = [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]
// 
//
// Example 2: 
//
// 
// Input: prices = [1]
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1514 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;309
 * <p>
 * Name：Best Time to Buy and Sell Stock with Cooldown
 *
 * @author Yuri
 * @since 2023-05-30 15:55:59
 */


public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        solution.maxProfit(new int[]{1, 2, 3, 0, 2});

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 以Lc122 Best Time to Buy and Sell Stock II 中动态思路为例：
         * <p>
         * 动态转移方程：<br>
         * todayHave = Math.max(yesterdayHave, yesterdayNone - prices[i]); <br>
         * todayNone = Math.max(yesterdayNone, yesterdayHave + prices[i]);
         * <p>
         * 现将todayHave中的{yesterdayNone-prices[i]}中的yesterdayNone记为x <br>
         * 不加入冷静期时：x = yesterdayNone = Math.max(beforeYesterdayNone, beforeYesterdayHave + prices[i]);
         * 加入冷静期后：x 不可能为 beforeYesterdayHave + prices[i] ∴ x = beforeYesterdayNone
         * <p>
         * ∴此题的转移方程为:<br>
         * todayHave = Math.max(yesterdayHave, beforeYesterdayNone - prices[i]); <br>
         * todayNone = Math.max(yesterdayNone, yesterdayHave + prices[i]);
         */
        public int maxProfit(int[] prices) {
            if (prices.length == 1) return 0;
            if (prices.length == 2) return Math.max(prices[1] - prices[0], 0);
            int yesterdayHave = Math.max(-prices[1], -prices[0]), yesterdayNone = Math.max(prices[1] - prices[0], 0),
                    beforeYesNone = 0;
            int todayHave = 0, todayNone = 0;
            for (int i = 2; i < prices.length; i++) {
                todayHave = Math.max(yesterdayHave, beforeYesNone - prices[i]);
                todayNone = Math.max(yesterdayNone, yesterdayHave + prices[i]);
                beforeYesNone = yesterdayNone;
                yesterdayNone = todayNone;
                yesterdayHave = todayHave;
            }
            return Math.max(todayHave, todayNone);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
