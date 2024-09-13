// You are given an array of positive integers price where price[i] denotes the
// price of the iᵗʰ candy and a positive integer k.
//
// The store sells baskets of k distinct candies. The tastiness of a candy 
// basket is the smallest absolute difference of the prices of any two candies in the
// basket.
//
// Return the maximum tastiness of a candy basket. 
//
// 
// Example 1: 
//
// 
// Input: price = [13,5,1,8,21,2], k = 3
// Output: 8
// Explanation: Choose the candies with the prices [13,5,21].
// The tastiness of the candy basket is: min(|13 - 5|, |13 - 21|, |5 - 21|) =
// min(8, 8, 16) = 8.
// It can be proven that 8 is the maximum tastiness that can be achieved.
// 
//
// Example 2: 
//
// 
// Input: price = [1,3,1], k = 2
// Output: 2
// Explanation: Choose the candies with the prices [1,3].
// The tastiness of the candy basket is: min(|1 - 3|) = min(2) = 2.
// It can be proven that 2 is the maximum tastiness that can be achieved.
// 
//
// Example 3: 
//
// 
// Input: price = [7,7,7,7], k = 2
// Output: 0
// Explanation: Choosing any two distinct candies from the candies we have will
// result in a tastiness of 0.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= price.length <= 10⁵ 
// 1 <= price[i] <= 10⁹ 
// 
//
// 👍 171 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2517
 * <p>
 * Name：Maximum Tastiness of Candy Basket
 *
 * @author Yuri
 * @since 2024-09-13 15:45:58
 */

public class MaximumTastinessOfCandyBasket {

    public static void main(String[] args) {
        Solution solution = new MaximumTastinessOfCandyBasket().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 和Lc1552一样
         *
         * @see MagneticForceBetweenTwoBalls Lc1552.两球之间的磁力
         */
        public int maximumTastiness(int[] price, int k) {
            int n = price.length;
            Arrays.sort(price);
            int l = 0, r = price[n - 1] - price[0];
            while (l <= r) {
                int m = (r - l >> 1) + l;
                int cur = price[0], t = k - 1; // 贪心：第一颗糖是最小的，所以一定可以放进礼盒
                for (int i = 1; i < n && t > 0; i++) {
                    int nex = price[i];
                    if (nex - cur >= m) {
                        t--;
                        cur = nex;
                    }
                }
                if (t > 0) r = m - 1;
                else l = m + 1;
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}