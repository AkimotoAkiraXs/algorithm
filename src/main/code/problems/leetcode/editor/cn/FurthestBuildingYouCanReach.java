// You are given an integer array heights representing the heights of buildings,
// some bricks, and some ladders.
//
// You start your journey from building 0 and move to the next building by 
// possibly using bricks or ladders.
//
// While moving from building i to building i+1 (0-indexed), 
//
// 
// If the current building's height is greater than or equal to the next 
// building's height, you do not need a ladder or bricks.
// If the current building's height is less than the next building's height, 
// you can either use one ladder or (h[i+1] - h[i]) bricks.
// 
//
// Return the furthest building index (0-indexed) you can reach if you use the 
// given ladders and bricks optimally.
//
// 
// Example 1: 
// 
// 
// Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
// Output: 4
// Explanation: Starting at building 0, you can follow these steps:
//- Go to building 1 without using ladders nor bricks since 4 >= 2.
//- Go to building 2 using 5 bricks. You must use either bricks or ladders 
// because 2 < 7.
//- Go to building 3 without using ladders nor bricks since 7 >= 6.
//- Go to building 4 using your only ladder. You must use either bricks or 
// ladders because 6 < 9.
// It is impossible to go beyond building 4 because you do not have any more
// bricks or ladders.
// 
//
// Example 2: 
//
// 
// Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
// Output: 7
// 
//
// Example 3: 
//
// 
// Input: heights = [14,3,19,3], bricks = 17, ladders = 0
// Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 10⁵ 
// 1 <= heights[i] <= 10⁶ 
// 0 <= bricks <= 10⁹ 
// 0 <= ladders <= heights.length 
// 
//
// 👍 161 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Id：&emsp;&emsp;1642
 * <p>
 * Name：Furthest Building You Can Reach
 *
 * @author Yuri
 * @since 2024-08-28 14:59:59
 */

public class FurthestBuildingYouCanReach {

    public static void main(String[] args) {
        Solution solution = new FurthestBuildingYouCanReach().new Solution();
        solution.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 直接优先队列就行了，不用二分
         */
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            long sum = 0;
            int i;
            for (i = 0; i < heights.length - 1; i++) {
                int dif = heights[i + 1] - heights[i];
                if (dif > 0) {
                    queue.add(dif);
                    if (queue.size() > ladders) {
                        sum += queue.poll();
                        if (sum > bricks) break;
                    }
                }
            }
            return i;
        }

        /**
         * 二分+优先队列：这里其实把最大的ladders个记住就行，用优先队列只是为了方便，但其实直接优先队列就行了
         */
        public int furthestBuilding_(int[] heights, int bricks, int ladders) {
            int l = 0, r = heights.length - 1;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            while (l <= r) {
                int m = l + r >> 1;
                queue.clear();
                long sum = 0;
                for (int i = 0; i < m; i++) {
                    int dif = heights[i + 1] - heights[i];
                    if (dif > 0) {
                        queue.add(dif);
                        if (queue.size() > ladders) sum += queue.poll();
                    }
                }
                if (sum <= bricks) l = m + 1;
                else r = m - 1;
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}