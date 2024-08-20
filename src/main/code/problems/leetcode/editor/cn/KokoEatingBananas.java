// Koko loves to eat bananas. There are n piles of bananas, the iᵗʰ pile has
// piles[i] bananas. The guards have gone and will come back in h hours.
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she 
// chooses some pile of bananas and eats k bananas from that pile. If the pile has less
// than k bananas, she eats all of them instead and will not eat any more bananas
// during this hour.
//
// Koko likes to eat slowly but still wants to finish eating all the bananas 
// before the guards return.
//
// Return the minimum integer k such that she can eat all the bananas within h 
// hours.
//
// 
// Example 1: 
//
// 
// Input: piles = [3,6,7,11], h = 8
// Output: 4
// 
//
// Example 2: 
//
// 
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30
// 
//
// Example 3: 
//
// 
// Input: piles = [30,11,23,4,20], h = 6
// Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// 👍 624 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;875
 * <p>
 * Name：Koko Eating Bananas
 *
 * @author Yuri
 * @since 2024-08-20 14:49:02
 */

public class KokoEatingBananas {

    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int l = 1, r = Arrays.stream(piles).max().getAsInt();
            while (l < r) {
                int m = l + r >> 1, t = h;
                for (int i = 0; i < piles.length && t >= 0; i++)
                    t -= (piles[i] - 1) / m + 1;
                if (t < 0) l = m + 1;
                else r = m;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}