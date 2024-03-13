// Given an array of intervals where intervals[i] = [starti, endi], merge all
// overlapping intervals, and return an array of the non-overlapping intervals that
// cover all the intervals in the input.
//
// 
// Example 1: 
//
// 
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// 👍 2248 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Id：&emsp;&emsp;56
 * <p>
 * Name：Merge Intervals
 *
 * @author Yuri
 * @since 2024-03-01 14:25:17
 */

public class MergeIntervals {

    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 双指针
        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            List<Integer[]> res = new ArrayList<>();
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int left = intervals[0][0], right = intervals[0][1];
            for (int i = 1; i < n; i++) {
                int[] interval = intervals[i];
                if (interval[0] > right) {
                    res.add(new Integer[]{left, right});
                    left = interval[0];
                    right = interval[1];
                } else right = Math.max(right, interval[1]);
            }
            res.add(new Integer[]{left, right});
            return res.stream().map(a -> Arrays.stream(a).mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}