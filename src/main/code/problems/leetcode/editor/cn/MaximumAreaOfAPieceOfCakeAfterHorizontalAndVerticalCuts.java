// You are given a rectangular cake of size h x w and two arrays of integers
// horizontalCuts and verticalCuts where:
//
// 
// horizontalCuts[i] is the distance from the top of the rectangular cake to 
// the iᵗʰ horizontal cut and similarly, and
// verticalCuts[j] is the distance from the left of the rectangular cake to the 
// jᵗʰ vertical cut.
// 
//
// Return the maximum area of a piece of cake after you cut at each horizontal 
// and vertical position provided in the arrays horizontalCuts and verticalCuts.
// Since the answer can be a large number, return this modulo 10⁹ + 7.
//
// 
// Example 1: 
// 
// 
// Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
// Output: 4
// Explanation: The figure above represents the given rectangular cake. Red
// lines are the horizontal and vertical cuts. After you cut the cake, the green piece
// of cake has the maximum area.
// 
//
// Example 2: 
// 
// 
// Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
// Output: 6
// Explanation: The figure above represents the given rectangular cake. Red
// lines are the horizontal and vertical cuts. After you cut the cake, the green and
// yellow pieces of cake have the maximum area.
// 
//
// Example 3: 
//
// 
// Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
// Output: 9
// 
//
// 
// Constraints: 
//
// 
// 2 <= h, w <= 10⁹ 
// 1 <= horizontalCuts.length <= min(h - 1, 10⁵) 
// 1 <= verticalCuts.length <= min(w - 1, 10⁵) 
// 1 <= horizontalCuts[i] < h 
// 1 <= verticalCuts[i] < w 
// All the elements in horizontalCuts are distinct. 
// All the elements in verticalCuts are distinct. 
// 
//
// 👍 81 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;1465
 * <p>
 * Name：Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 *
 * @author Yuri
 * @since 2023-10-27 17:34:56
 */

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public static void main(String[] args) {
        Solution solution = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            int mod = (int) 1e9 + 7;
            return (int) ((getMax(h, horizontalCuts) * getMax(w, verticalCuts)) % mod);
        }

        private Long getMax(int n, int[] arrays) {
            Arrays.sort(arrays);
            int max = arrays[0];
            max = Math.max(n - arrays[arrays.length - 1], max);
            for (int i = 1; i < arrays.length; i++) max = Math.max(max, arrays[i] - arrays[i - 1]);
            return (long) max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}