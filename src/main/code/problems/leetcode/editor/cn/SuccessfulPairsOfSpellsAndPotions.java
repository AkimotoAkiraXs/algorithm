// You are given two positive integer arrays spells and potions, of length n and
// m respectively, where spells[i] represents the strength of the iᵗʰ spell and
// potions[j] represents the strength of the jᵗʰ potion.
//
// You are also given an integer success. A spell and potion pair is considered 
// successful if the product of their strengths is at least success.
//
// Return an integer array pairs of length n where pairs[i] is the number of 
// potions that will form a successful pair with the iᵗʰ spell.
//
// 
// Example 1: 
//
// 
// Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
// Output: [4,0,3]
// Explanation:
//- 0ᵗʰ spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
//- 1ˢᵗ spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
//- 2ⁿᵈ spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
// Thus, [4,0,3] is returned.
// 
//
// Example 2: 
//
// 
// Input: spells = [3,1,2], potions = [8,5,8], success = 16
// Output: [2,0,2]
// Explanation:
//- 0ᵗʰ spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
//- 1ˢᵗ spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful. 
//- 2ⁿᵈ spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful. 
// Thus, [2,0,2] is returned.
// 
//
// 
// Constraints: 
//
// 
// n == spells.length 
// m == potions.length 
// 1 <= n, m <= 10⁵ 
// 1 <= spells[i], potions[i] <= 10⁵ 
// 1 <= success <= 10¹⁰ 
// 
//
// 👍 107 👎 0

package problems.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2300
 * <p>
 * Name：Successful Pairs of Spells and Potions
 *
 * @author Yuri
 * @since 2024-08-14 16:14:57
 */

public class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        Solution solution = new SuccessfulPairsOfSpellsAndPotions().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int n = spells.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                long t = success / spells[i] + Math.min(1, success % spells[i]);
                ans[i] =  t > Integer.MAX_VALUE ? 0 : dichotomy(potions, (int) t);
            }
            return ans;
        }

        private int dichotomy(int[] nums, int t) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] < t) l = mid + 1;
                else r = mid;
            }
            return nums.length - l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}