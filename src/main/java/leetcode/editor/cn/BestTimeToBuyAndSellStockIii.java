package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;123 <br/>
 * Name：Best Time to Buy and Sell Stock III <br/>
 *
 * @author Yuri
 * @since 2023-05-30 22:31:27
 */

public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
        solution.maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Dp：四个状态每次循环可看在第i天完成了以下动作
         * 1.buy1：只进行过一次买操作 <br>
         * 2.sell1：进行了一次买操作和一次卖操作，即完成了一笔交易 <br>
         * 3.buy2：在完成了一笔交易的前提下，进行了第二次买操作
         * 4.sell2：完成了全部两笔交易
         */
        public int maxProfit(int[] prices) {
            int buy1, sell1, buy2, sell2;
            buy1 = buy2 = -prices[0]; // buy2可以看在同一天完成第一次交易后又进行了一次购买
            sell1 = sell2 = 0; // 在第一天买了又卖，利润不受影响
            for (int i = 1; i < prices.length; i++) {
                buy1 = Math.max(buy1, -prices[i]);
                sell1 = Math.max(sell1, buy1 + prices[i]);
                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return Math.max(sell1, sell2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
