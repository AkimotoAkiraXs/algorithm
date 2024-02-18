// Given an array of integers nums and an integer limit, return the size of the
// longest non-empty subarray such that the absolute difference between any two
// elements of this subarray is less than or equal to limit.
//
// 
// Example 1: 
//
// 
// Input: nums = [8,2,4,7], limit = 4
// Output: 2
// Explanation: All subarrays are:
//[8] with maximum absolute diff |8-8| = 0 <= 4.
//[8,2] with maximum absolute diff |8-2| = 6 > 4. 
//[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
//[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
//[2] with maximum absolute diff |2-2| = 0 <= 4.
//[2,4] with maximum absolute diff |2-4| = 2 <= 4.
//[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
//[4] with maximum absolute diff |4-4| = 0 <= 4.
//[4,7] with maximum absolute diff |4-7| = 3 <= 4.
//[7] with maximum absolute diff |7-7| = 0 <= 4. 
// Therefore, the size of the longest subarray is 2.
// 
//
// Example 2: 
//
// 
// Input: nums = [10,1,2,4,7,2], limit = 5
// Output: 4
// Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute
// diff is |2-7| = 5 <= 5.
// 
//
// Example 3: 
//
// 
// Input: nums = [4,2,2,2,4,4,2,2], limit = 0
// Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 0 <= limit <= 10⁹ 
// 
//
// 👍 360 👎 0

package problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Id：&emsp;&emsp;1438
 * <p>
 * Name：Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 *
 * @author Yuri
 * @since 2024-02-18 15:09:22
 */

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public static void main(String[] args) {
        Solution solution = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
        solution.longestSubarray(new int[]{2, 1, 10, 4, 7, 2}, 5);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         *  维护两个单调队列分别单调递增、单调递减；维护left、right控制一个滑动窗口。
         *  比较两个队列队首则知道当前窗口是否符合条件，如果不符合条件则移动left更新窗口范围和队列内的元素大小直至符合条件位置。
         */
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> mnq = new LinkedList<>();
            Deque<Integer> mxq = new LinkedList<>();
            int max = 0;
            for (int left = 0, right = 0; right < nums.length; right++) {
                while (!mnq.isEmpty() && nums[mnq.peekLast()] > nums[right]) mnq.removeLast();
                while (!mxq.isEmpty() && nums[mxq.peekLast()] < nums[right]) mxq.removeLast();
                mnq.add(right);
                mxq.add(right);
                while (!mxq.isEmpty() && !mnq.isEmpty() && nums[mxq.element()] - nums[mnq.element()] > limit) {
                    if (nums[mxq.element()] == nums[left]) mxq.removeFirst();
                    if (nums[mnq.element()] == nums[left]) mnq.removeFirst();
                    left++;
                }
                max = Math.max(max, right - left + 1);
            }
            return max;
        }


        // O(nlogn)大小堆+滑动窗口，TreeMap对key排序，value可以用于记录每个key出现次数
        public int longestSubarray_(int[] nums, int limit) {
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int max = 0;
            for (int left = 0, right = 0; right < nums.length; right++) {
                map.merge(nums[right], 1, Integer::sum);
                while (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
                    if (map.get(nums[left]) <= 1) map.remove(nums[left]);
                    else map.merge(nums[left], -1, Integer::sum);
                    left++;
                }
                max = Math.max(max, right - left + 1);
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}