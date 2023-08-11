// Given an integer array nums of length n and an integer target, find three
// integers in nums such that the sum is closest to target.
//
// Return the sum of the three integers. 
//
// You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// Example 2: 
//
// 
// Input: nums = [0,0,0], target = 1
// Output: 0
// Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 500 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// 👍 1454 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;16
 * <p>
 * Name：3Sum Closest
 *
 * @author Yuri
 * @since 2023-07-10 17:48:28
 */


public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int res = Integer.MAX_VALUE;
            int sum;
            for (int i = 0; i < n - 2; i++) {
                int num = nums[i];

                // 优化1
                if (i > 1 && num == nums[i - 1]) continue;

                // 优化2
                sum = num + nums[i + 1] + nums[i + 2];
                if (sum > target) {
                    if (Math.abs(sum - target) >= Math.abs(res - target)) return res;
                    else return sum;
                }

                // 优化3
                sum = num + nums[n - 2] + nums[n - 1];
                if (sum < target) {
                    res = sum;
                    continue;
                }


                int a = i + 1;
                int b = n - 1;
                while (a != b) {
                    sum = num + nums[a] + nums[b];
                    if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
                    if (sum - target > 0) b--;
                    else if (sum - target < 0) a++;
                    else return target; // 优化4
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
