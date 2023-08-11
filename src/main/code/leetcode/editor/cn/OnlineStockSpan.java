//编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。 
//
// 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。 
//
// 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
// 
//
// 
//
// 示例： 
//
// 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[10
//0],[80],[60],[70],[60],[75],[85]]
//输出：[null,1,1,1,2,1,4,6]
//解释：
//首先，初始化 S = StockSpanner()，然后：
//S.next(100) 被调用并返回 1，
//S.next(80) 被调用并返回 1，
//S.next(60) 被调用并返回 1，
//S.next(70) 被调用并返回 2，
//S.next(60) 被调用并返回 1，
//S.next(75) 被调用并返回 4，
//S.next(85) 被调用并返回 6。
//
//注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
//(包括今天的价格 75) 小于或等于今天的价格。
// 
//
// 
//
// 提示： 
//
// 
// 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。 
// 每个测试用例最多可以调用 10000 次 StockSpanner.next。 
// 在所有测试用例中，最多调用 150000 次 StockSpanner.next。 
// 此问题的总时间限制减少了 50%。 
// 
//
// Related Topics 栈 设计 数据流 单调栈 👍 263 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Id：&emsp;&emsp;901
 * <p>
 * Name：股票价格跨度
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class OnlineStockSpan {
    public static void main(String[] args) {
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 可以用双端队列Deque对数据进行处理，price >= stock[lastDay][0]时可以在队列中弹出这天（再也不会使用到）和下面逻辑是一样的
     */
    class StockSpanner {
/*
        private int[][] stock;
        private int day;

        public StockSpanner() {
            this.stock = new int[10000 + 10][2];
            this.day = 0;
            stock[0][0] = Integer.MAX_VALUE;
        }

        public int next(int price) {
            day++;
            int lastDay = day - 1;
            stock[day][0] = price;
            while (price >= stock[lastDay][0]) {
                lastDay = stock[lastDay][1];
            }
            stock[day][1] = lastDay;
            return day - lastDay;
        }
*/
        // 单调栈
        Deque<int[]> stack;
        int idx;

        public StockSpanner() {
            stack = new ArrayDeque<int[]>();
            stack.push(new int[]{-1, Integer.MAX_VALUE});
            idx = -1;
        }

        public int next(int price) {
            idx++;
            while (price >= stack.peek()[1]) {
                stack.pop();
            }
            int ret = idx - stack.peek()[0];
            stack.push(new int[]{idx, price});
            return ret;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

}