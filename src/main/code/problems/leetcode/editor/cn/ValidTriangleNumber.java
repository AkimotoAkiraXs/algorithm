// Given an integer array nums, return the number of triplets chosen from the
// array that can make triangles if we take them as side lengths of a triangle.
//
// 
// Example 1: 
//
// 
// Input: nums = [2,2,3,4]
// Output: 3
// Explanation: Valid combinations are:
// 2,3,4 (using the first 2)
// 2,3,4 (using the second 2)
// 2,2,3
// 
//
// Example 2: 
//
// 
// Input: nums = [4,2,3,4]
// Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// 👍 517 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;611
 * <p>
 * Name：Valid Triangle Number
 *
 * @author Yuri
 * @since 2023-09-15 18:12:59
 */

public class ValidTriangleNumber {

    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
        solution.triangleNumber(new int[]{2, 2, 3, 4});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 三角形条件：两边之和大于第三边
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n - 2; i++) {
                int l = i + 1;
                for (int r = i + 2; r < n; r++) {
                    while (l < r && nums[i] + nums[l] <= nums[r]) l++;
                    if (nums[i] + nums[l] > nums[r]) ans += r - l;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}