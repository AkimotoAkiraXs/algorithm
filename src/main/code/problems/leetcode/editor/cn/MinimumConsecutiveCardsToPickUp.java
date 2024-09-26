// You are given an integer array cards where cards[i] represents the value of
// the iᵗʰ card. A pair of cards are matching if the cards have the same value.
//
// Return the minimum number of consecutive cards you have to pick up to have a 
// pair of matching cards among the picked cards. If it is impossible to have
// matching cards, return -1.
//
// 
// Example 1: 
//
// 
// Input: cards = [3,4,2,3,4,7]
// Output: 4
// Explanation: We can pick up the cards [3,4,2,3] which contain a matching pair
// of cards with value 3. Note that picking up the cards [4,2,3,4] is also optimal.
//
// 
//
// Example 2: 
//
// 
// Input: cards = [1,0,5,3]
// Output: -1
// Explanation: There is no way to pick up a set of consecutive cards that
// contain a pair of matching cards.
// 
//
// 
// Constraints: 
//
// 
// 1 <= cards.length <= 10⁵ 
// 0 <= cards[i] <= 10⁶ 
// 
//
// 👍 21 👎 0

package problems.leetcode.editor.cn;

import cn.hutool.core.lang.hash.Hash;
import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;2260
 * <p>
 * Name：Minimum Consecutive Cards to Pick Up
 *
 * @author Yuri
 * @since 2024-09-26 11:32:39
 */

public class MinimumConsecutiveCardsToPickUp {

    public static void main(String[] args) {
        Solution solution = new MinimumConsecutiveCardsToPickUp().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumCardPickup(int[] cards) {
            Set<Integer> hash = new HashSet<>();
            int ans = Integer.MAX_VALUE;
            for (int i = 0, j = 0; i < cards.length; i++) {
                while (hash.contains(cards[i])) {
                    ans = Math.min(ans, i - j + 1);
                    hash.remove(cards[j++]);
                }
                hash.add(cards[i]);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}