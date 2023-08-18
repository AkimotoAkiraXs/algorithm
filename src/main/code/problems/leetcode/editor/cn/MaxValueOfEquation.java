// You are given an array points containing the coordinates of points on a 2D
// plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for
// all 1 <= i < j <= points.length. You are also given an integer k.
//
// Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| 
//<= k and 1 <= i < j <= points.length. 
//
// It is guaranteed that there exists at least one pair of points that satisfy 
// the constraint |xi - xj| <= k.
//
// 
// Example 1: 
//
// 
// Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
// Output: 4
// Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if
// we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points
// also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
// No other pairs satisfy the condition, so we return the max of 4 and 1.
// 
//
// Example 2: 
//
// 
// Input: points = [[0,0],[3,0],[9,2]], k = 3
// Output: 3
// Explanation: Only the first two points have an absolute difference of 3 or
// less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.
// 
//
// 
// Constraints: 
//
// 
// 2 <= points.length <= 10⁵ 
// points[i].length == 2 
// -10⁸ <= xi, yi <= 10⁸ 
// 0 <= k <= 2 * 10⁸ 
// xi < xj for all 1 <= i < j <= points.length 
// xi form a strictly increasing sequence. 
// 
//
// 👍 106 👎 0

package problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;1499
 * <p>
 * Name：Max Value of Equation
 *
 * @author Yuri
 * @since 2023-07-21 14:48:34
 */


public class MaxValueOfEquation {
    public static void main(String[] args) {
        Solution solution = new MaxValueOfEquation().new Solution();

        System.out.println(solution.findMaxValueOfEquation(new int[][]{{-16,15},{-7,-18},{-4,2},{1,0},{7,10},{9,-6},{14,5},{15,13},{16,-12},{20,20}}, 8));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxValueOfEquation(int[][] points, int k) {
            Deque<int[]> deque = new LinkedList<>();
            deque.add(points[0]);
            int ans = Integer.MIN_VALUE;
            for (int i = 1; i < points.length; i++) {
                int x = points[i][0], y = points[i][1];
                while (!deque.isEmpty() && Math.abs(x - deque.peekFirst()[0]) > k) deque.removeFirst();
                if (!deque.isEmpty())
                    ans = Math.max(ans, Math.abs(x - deque.peekFirst()[0]) + deque.peekFirst()[1] + y);
                while (!deque.isEmpty() && y - deque.peekLast()[1] > x - deque.peekLast()[0]) deque.pollLast();
                deque.add(points[i]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
