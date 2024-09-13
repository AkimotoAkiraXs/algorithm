// In the universe Earth C-137, Rick discovered a special form of magnetic force
// between two balls if they are put in his new invented basket. Rick has n empty
// baskets, the iᵗʰ basket is at position[i], Morty has m balls and needs to
// distribute the balls into the baskets such that the minimum magnetic force between any
// two balls is maximum.
//
// Rick stated that magnetic force between two different balls at positions x 
// and y is |x - y|.
//
// Given the integer array position and the integer m. Return the required 
// force.
//
// 
// Example 1: 
// 
// 
// Input: position = [1,2,3,4,7], m = 3
// Output: 3
// Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the
// magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We
// cannot achieve a larger minimum magnetic force than 3.
// 
//
// Example 2: 
//
// 
// Input: position = [5,4,3,2,1,1000000000], m = 2
// Output: 999999999
// Explanation: We can use baskets 1 and 1000000000.
// 
//
// 
// Constraints: 
//
// 
// n == position.length 
// 2 <= n <= 10⁵ 
// 1 <= position[i] <= 10⁹ 
// All integers in position are distinct. 
// 2 <= m <= position.length 
// 
//
// 👍 176 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1552
 * <p>
 * Name：Magnetic Force Between Two Balls
 *
 * @author Yuri
 * @since 2024-09-13 16:29:18
 */

public class MagneticForceBetweenTwoBalls {

    public static void main(String[] args) {
        Solution solution = new MagneticForceBetweenTwoBalls().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 和Lc2517一样
         *
         * @see MaximumTastinessOfCandyBasket Lc2517.礼盒的最大甜蜜度
         */
        public int maxDistance(int[] price, int k) {
            int n = price.length;
            Arrays.sort(price);
            int l = 0, r = price[n - 1] - price[0];
            while (l <= r) {
                int m = (r - l >> 1) + l;
                int cur = price[0], t = k - 1; // 贪心：第一个桶子一定要放
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