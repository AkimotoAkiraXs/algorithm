// You are at a fruit market with different types of exotic fruits on display.
//
// You are given a 1-indexed array prices, where prices[i] denotes the number 
// of coins needed to purchase the iᵗʰ fruit.
//
// The fruit market has the following offer: 
//
// 
// If you purchase the iᵗʰ fruit at prices[i] coins, you can get the next i 
// fruits for free.
// 
//
// Note that even if you can take fruit j for free, you can still purchase it 
// for prices[j] coins to receive a new offer.
//
// Return the minimum number of coins needed to acquire all the fruits. 
//
// 
// Example 1: 
//
// 
// Input: prices = [3,1,2]
// Output: 4
// Explanation: You can acquire the fruits as follows:
//- Purchase the 1ˢᵗ fruit with 3 coins, you are allowed to take the 2ⁿᵈ fruit 
// for free.
//- Purchase the 2ⁿᵈ fruit with 1 coin, you are allowed to take the 3ʳᵈ fruit 
// for free.
//- Take the 3ʳᵈ fruit for free.
// Note that even though you were allowed to take the 2ⁿᵈ fruit for free, you
// purchased it because it is more optimal.
// It can be proven that 4 is the minimum number of coins needed to acquire all
// the fruits.
// 
//
// Example 2: 
//
// 
// Input: prices = [1,10,1,1]
// Output: 2
// Explanation: You can acquire the fruits as follows:
//- Purchase the 1ˢᵗ fruit with 1 coin, you are allowed to take the 2ⁿᵈ fruit 
// for free.
//- Take the 2ⁿᵈ fruit for free.
//- Purchase the 3ʳᵈ fruit for 1 coin, you are allowed to take the 4ᵗʰ fruit 
// for free.
//- Take the 4ᵗʰ fruit for free.
// It can be proven that 2 is the minimum number of coins needed to acquire all
// the fruits.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 1000 
// 1 <= prices[i] <= 10⁵ 
// 
//
// 👍 16 👎 0

package problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;2944
 * <p>
 * Name：Minimum Number of Coins for Fruits
 *
 * @author Yuri
 * @since 2024-02-18 17:55:52
 */

public class MinimumNumberOfCoinsForFruits {

    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfCoinsForFruits().new Solution();
        System.out.println(solution.minimumCoins(new int[]{14,37,37,38,24,15,12}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Dp，O(n^2)
         * <p>
         * 直接以price[]代替f[]，price[i]代表从位置i（i从1开始）到末尾获取所有水果所需最小花费。
         * 由此可以推出当i > (n+1)/2-1时，最小花费都是price[i]。
         * 所以遍历i <= (n+1)/2-1的情况，对于某位置i而言，最小花费为price[i] + min(f[j]) {i < j <= 2*i+1}。
         */
        public int minimumCoins_dp(int[] prices) {
            int n = prices.length;
            // i是从1开始
            for (int i = (n + 1) / 2 - 1; i > 0; i--) {
                int mn = Integer.MAX_VALUE;
                // j是从0开始，所以其实j的开始位置是i+1，结束位置是2*i+1
                for (int j = i; j <= 2 * i; j++)
                    mn = Math.min(mn, prices[j]);
                prices[i - 1] += mn;
            }
            return prices[0];
        }

        /**
         * 单调队列优化O(n)
         */
        public int minimumCoins(int[] prices) {
            int n = prices.length;
            Deque<Integer> q = new LinkedList<>();
            for (int i = n; i >= (n + 1) / 2; i--) {
                while (!q.isEmpty() && prices[q.peekLast() - 1] > prices[i - 1]) q.removeLast();
                q.add(i);
            }
            for (int i = (n + 1) / 2 - 1; i > 0; i--) {
                while (q.element() > 2 * i + 1) q.remove();
                while (!q.isEmpty() && prices[q.peekLast() - 1] > prices[i - 1] + prices[q.element() - 1])
                    q.removeLast();
                prices[i - 1] += prices[q.element() - 1];
                q.add(i);
            }
            return prices[0];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}