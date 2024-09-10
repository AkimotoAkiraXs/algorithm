// You have an inventory of different colored balls, and there is a customer
// that wants orders balls of any color.
//
// The customer weirdly values the colored balls. Each colored ball's value is 
// the number of balls of that color you currently have in your inventory. For
// example, if you own 6 yellow balls, the customer would pay 6 for the first yellow
// ball. After the transaction, there are only 5 yellow balls left, so the next
// yellow ball is then valued at 5 (i.e., the value of the balls decreases as you sell
// more to the customer).
//
// You are given an integer array, inventory, where inventory[i] represents the 
// number of balls of the iᵗʰ color that you initially own. You are also given an
// integer orders, which represents the total number of balls that the customer
// wants. You can sell the balls in any order.
//
// Return the maximum total value that you can attain after selling orders 
// colored balls. As the answer may be too large, return it modulo 109 + 7.
//
// 
// Example 1: 
// 
// 
// Input: inventory = [2,5], orders = 4
// Output: 14
// Explanation: Sell the 1st color 1 time (2) and the 2nd color 3 times (5 + 4 +
// 3).
// The maximum total value is 2 + 5 + 4 + 3 = 14.
// 
//
// Example 2: 
//
// 
// Input: inventory = [3,5], orders = 6
// Output: 19
// Explanation: Sell the 1st color 2 times (3 + 2) and the 2nd color 4 times (5 +
// 4 + 3 + 2).
// The maximum total value is 3 + 2 + 5 + 4 + 3 + 2 = 19.
// 
//
// 
// Constraints: 
//
// 
// 1 <= inventory.length <= 10⁵ 
// 1 <= inventory[i] <= 10⁹ 
// 1 <= orders <= min(sum(inventory[i]), 10⁹) 
// 
//
// 👍 90 👎 0

package problems.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;1648
 * <p>
 * Name：Sell Diminishing-Valued Colored Balls
 *
 * @author Yuri
 * @since 2024-09-06 10:32:51
 */
public class SellDiminishingValuedColoredBalls {

    public static void main(String[] args) {
        Solution solution = new SellDiminishingValuedColoredBalls().new Solution();
        solution.maxProfit(new int[]{2, 8, 4, 10, 6}, 20);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二分：以最后一次卖出价格进行二分，总感觉极其麻烦不优雅
         */
        public int maxProfit(int[] inventory, int orders) {
            int mod = (int) (1e9 + 7);
            int l = 1, r = Arrays.stream(inventory).max().getAsInt();
            long ans = 0;
            while (l <= r) {
                int m = l + r >> 1;
                long sum1 = 0, sum2 = 0;
                for (int inv : inventory) {
                    if (inv > m) sum1 += inv - m;
                    if (inv >= m) sum2 += inv - m + 1;
                }
                if (orders > sum2) r = m - 1;
                else {
                    if (orders > sum1) {
                        long t = orders - sum1;
                        long tmp = 0;
                        for (int inv : inventory) {
                            if (t > 0 && inv >= m) {
                                tmp += (long) (inv + m) * (inv - m + 1) / 2;
                                t--;
                            } else if (inv > m) tmp += (long) (inv + m + 1) * (inv - m) / 2;
                        }
                        ans = Math.max(ans, tmp);
                    }
                    l = m + 1;
                }
            }
            return (int) (ans % mod);
        }

        /**
         * 贪心+数学：从最大的值开始取，取到下一个值时停止，计算价值（gap*球数）
         */
        public int maxProfit_(int[] inventory, int orders) {
            int mod = (int) (1e9 + 7);
            inventory = Arrays.copyOf(inventory, inventory.length + 1);
            int n = inventory.length;
            inventory[n - 1] = 0;
            Arrays.sort(inventory);
            long ans = 0;
            for (int i = n - 1; ; i--) {
                int gap = inventory[i] - inventory[i - 1];
                long t = (long) gap * (n - i);
                if (orders > t) {
                    orders -= (int) t;
                    ans = ((long) (inventory[i] + inventory[i - 1] + 1) * gap / 2 * (n - i) + ans) % mod;
                } else {
                    int k = orders / (n - i);
                    ans = ((long) (inventory[i] + inventory[i] - k + 1) * k / 2 * (n - i) + ans) % mod;
                    return (int) (((long) (inventory[i] - k) * (orders % (n - i)) + ans) % mod);
                }
            }
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

}