// Winter is coming! During the contest, your first job is to design a standard
// heater with a fixed warm radius to warm all the houses.
//
// Every house can be warmed, as long as the house is within the heater's warm 
// radius range.
//
// Given the positions of houses and heaters on a horizontal line, return the 
// minimum radius standard of heaters so that those heaters could cover all houses.
//
// Notice that all the heaters follow your radius standard, and the warm radius 
// will the same.
//
// 
// Example 1: 
//
// 
// Input: houses = [1,2,3], heaters = [2]
// Output: 1
// Explanation: The only heater was placed in the position 2, and if we use the
// radius 1 standard, then all the houses can be warmed.
// 
//
// Example 2: 
//
// 
// Input: houses = [1,2,3,4], heaters = [1,4]
// Output: 1
// Explanation: The two heaters were placed at positions 1 and 4. We need to use
// a radius 1 standard, then all the houses can be warmed.
// 
//
// Example 3: 
//
// 
// Input: houses = [1,5], heaters = [2]
// Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 10⁴ 
// 1 <= houses[i], heaters[i] <= 10⁹ 
// 
//
// 👍 483 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;475
 * <p>
 * Name：Heaters
 *
 * @author Yuri
 * @since 2024-08-20 16:30:39
 */

public class Heaters {

    public static void main(String[] args) {
        Solution solution = new Heaters().new Solution();
        solution.findRadius(
            new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
            new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840,
                143542612});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int l = 0, r = (int) 1e9;
            while (l < r) {
                int m = l + r >> 1;
                int j = 0;
                for (int i = 0; i < houses.length && j < heaters.length; ) {
                    if (houses[i] >= heaters[j] - m) {
                        if (houses[i] <= (long) heaters[j] + m) i++;
                        else j++;
                    } else j = heaters.length;
                }
                if (j == heaters.length) l = m + 1;
                else r = m;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}