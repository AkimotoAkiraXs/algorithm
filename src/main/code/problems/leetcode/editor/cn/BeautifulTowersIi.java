// You are given a 0-indexed array maxHeights of n integers.
//
// You are tasked with building n towers in the coordinate line. The iᵗʰ tower 
// is built at coordinate i and has a height of heights[i].
//
// A configuration of towers is beautiful if the following conditions hold: 
//
// 
// 1 <= heights[i] <= maxHeights[i] 
// heights is a mountain array. 
// 
//
// Array heights is a mountain if there exists an index i such that: 
//
// 
// For all 0 < j <= i, heights[j - 1] <= heights[j] 
// For all i <= k < n - 1, heights[k + 1] <= heights[k] 
// 
//
// Return the maximum possible sum of heights of a beautiful configuration of 
// towers.
//
// 
// Example 1: 
//
// 
// Input: maxHeights = [5,3,4,1,1]
// Output: 13
// Explanation: One beautiful configuration with a maximum sum is heights = [5,3,
// 3,1,1]. This configuration is beautiful since:
//- 1 <= heights[i] <= maxHeights[i]  
//- heights is a mountain of peak i = 0.
// It can be shown that there exists no other beautiful configuration with a sum
// of heights greater than 13.
//
// Example 2: 
//
// 
// Input: maxHeights = [6,5,3,9,2,7]
// Output: 22
// Explanation: One beautiful configuration with a maximum sum is heights = [3,3,
// 3,9,2,2]. This configuration is beautiful since:
//- 1 <= heights[i] <= maxHeights[i]
//- heights is a mountain of peak i = 3.
// It can be shown that there exists no other beautiful configuration with a sum
// of heights greater than 22.
//
// Example 3: 
//
// 
// Input: maxHeights = [3,2,5,5,2,3]
// Output: 18
// Explanation: One beautiful configuration with a maximum sum is heights = [2,2,
// 5,5,2,2]. This configuration is beautiful since:
//- 1 <= heights[i] <= maxHeights[i]
//- heights is a mountain of peak i = 2. 
// Note that, for this configuration, i = 3 can also be considered a peak.
// It can be shown that there exists no other beautiful configuration with a sum
// of heights greater than 18.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n == maxHeights <= 10⁵ 
// 1 <= maxHeights[i] <= 10⁹ 
// 
//
// 👍 126 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Id：&emsp;&emsp;2866
 * <p>
 * Name：Beautiful Towers II
 *
 * @author Yuri
 * @since 2024-01-24 18:53:44
 */

public class BeautifulTowersIi {

    public static void main(String[] args) {
        Solution solution = new BeautifulTowersIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 单调栈
         * <p>
         * Beautiful Towers 指有个尖端，左右两边单调递减，题目要求所给数组中的数只能减少不能增加，所以当某（几）个作为尖端时，其左右两边
         * 均具有单调性，我们遍历每个点假设其是尖端进行贪心计算并记录，取其中所有遍历结果的最大值为答案。
         * <p>
         * 利用单调栈的特性，进行贪心计算。
         */
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            Integer[] nums = maxHeights.toArray(Integer[]::new);
            int n = nums.length;
            long[] suf = new long[n + 1];
            Deque<Integer> stack = new ArrayDeque<>(); //单调栈，其中的数一定具有单调性，当到达某个数k时，会以k为尖端的前提进行贪心计算
            stack.push(n); // 哨兵
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                Integer x = nums[i];

                while (stack.size() > 1 && nums[stack.element()] > x) {
                    Integer p = stack.pop();   // 弹出栈中比x大的数
                    sum -= (long) nums[p] * (stack.element() - p); // 减去之前多加的值
                }
                sum += (long) nums[i] * (stack.element() - i);
                suf[i] = sum;
                stack.push(i);
            }

            stack.clear();
            stack.push(-1);
            long pre = 0;
            for (int i = 0; i < n; i++) {
                Integer x = nums[i];
                while (stack.size() > 1 && nums[stack.element()] > x) {
                    Integer p = stack.pop();
                    pre -= (long) nums[p] * (p - stack.element());
                }
                pre += (long) nums[i] * (i - stack.element());
                sum = Math.max(sum, pre + suf[i + 1]); // suf[i+1]没加入当前数，避免i被重复计算
                stack.push(i);
            }
            return sum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}