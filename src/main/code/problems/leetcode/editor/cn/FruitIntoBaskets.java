// You are visiting a farm that has a single row of fruit trees arranged from
// left to right. The trees are represented by an integer array fruits where fruits[i]
// is the type of fruit the iᵗʰ tree produces. 
//
// You want to collect as much fruit as possible. However, the owner has some 
// strict rules that you must follow:
//
// 
// You only have two baskets, and each basket can only hold a single type of 
// fruit. There is no limit on the amount of fruit each basket can hold.
// Starting from any tree of your choice, you must pick exactly one fruit from 
// every tree (including the start tree) while moving to the right. The picked
// fruits must fit in one of your baskets.
// Once you reach a tree with fruit that cannot fit in your baskets, you must 
// stop.
// 
//
// Given the integer array fruits, return the maximum number of fruits you can 
// pick.
//
// 
// Example 1: 
//
// 
// Input: fruits = [1,2,1]
// Output: 3
// Explanation: We can pick from all 3 trees.
// 
//
// Example 2: 
//
// 
// Input: fruits = [0,1,2,2]
// Output: 3
// Explanation: We can pick from trees [1,2,2].
// If we had started at the first tree, we would only pick from trees [0,1].
// 
//
// Example 3: 
//
// 
// Input: fruits = [1,2,3,2,2]
// Output: 4
// Explanation: We can pick from trees [2,3,2,2].
// If we had started at the first tree, we would only pick from trees [1,2].
// 
//
// 
// Constraints: 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
//
// 👍 639 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;904
 * <p>
 * Name：Fruit Into Baskets
 *
 * @author Yuri
 * @since 2024-04-29 17:09:18
 */

public class FruitIntoBaskets {

    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int totalFruit(int[] fruits) {
            Map<Integer, Integer> map = new HashMap<>();
            int max = 0;
            int l = 0;
            for (int r = 0; r < fruits.length; r++) {
                map.merge(fruits[r], 1, Integer::sum);
                while (map.size() > 2) {
                    map.compute(fruits[l++], (key, value) -> {
                        if (value == 1) return null;
                        return --value;
                    });
                }
                max = Math.max(max, r - l + 1);
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}