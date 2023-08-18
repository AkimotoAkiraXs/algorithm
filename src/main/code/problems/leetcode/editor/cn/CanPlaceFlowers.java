// You have a long flowerbed in which some of the plots are planted, and some
// are not. However, flowers cannot be planted in adjacent plots.
//
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty 
// and 1 means not empty, and an integer n, return true if n new flowers can be
// planted in the flowerbed without violating the no-adjacent-flowers rule and false
// otherwise.
//
// 
// Example 1: 
// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: true
// 
// Example 2: 
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= flowerbed.length <= 2 * 10⁴ 
// flowerbed[i] is 0 or 1. 
// There are no two adjacent flowers in flowerbed. 
// 0 <= n <= flowerbed.length 
// 
//
// Related Topics 贪心 数组 👍 554 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;605
 * <p>
 * Name：Can Place Flowers
 *
 * @author Yuri
 * @since 2023-04-25 16:08:28
 */


public class CanPlaceFlowers {
    public static void main(String[] args) {
        Solution solution = new CanPlaceFlowers().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int length = flowerbed.length;
            if (flowerbed[0] == 0 && ((length > 1 && flowerbed[1] == 0) || length == 1)) {
                n--;
                flowerbed[0] = 1;
            }
            if (flowerbed[length - 1] == 0 && length > 1 && flowerbed[length - 2] == 0) {
                n--;
                flowerbed[length - 1] = 1;
            }
            for (int i = 1; i < length - 1; i++) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
            return n <= 0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
