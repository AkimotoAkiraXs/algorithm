// You are given a 0-indexed integer array nums having length n, an integer
// indexDifference, and an integer valueDifference.
//
// Your task is to find two indices i and j, both in the range [0, n - 1], that 
// satisfy the following conditions:
//
// 
// abs(i - j) >= indexDifference, and 
// abs(nums[i] - nums[j]) >= valueDifference 
// 
//
// Return an integer array answer, where answer = [i, j] if there are two such 
// indices, and answer = [-1, -1] otherwise. If there are multiple choices for the
// two indices, return any of them.
//
// Note: i and j may be equal. 
//
// 
// Example 1: 
//
// 
// Input: nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
// Output: [0,3]
// Explanation: In this example, i = 0 and j = 3 can be selected.
// abs(0 - 3) >= 2 and abs(nums[0] - nums[3]) >= 4.
// Hence, a valid answer is [0,3].
//[3,0] is also a valid answer.
// 
//
// Example 2: 
//
// 
// Input: nums = [2,1], indexDifference = 0, valueDifference = 0
// Output: [0,0]
// Explanation: In this example, i = 0 and j = 0 can be selected.
// abs(0 - 0) >= 0 and abs(nums[0] - nums[0]) >= 0.
// Hence, a valid answer is [0,0].
// Other valid answers are [0,1], [1,0], and [1,1].
// 
//
// Example 3: 
//
// 
// Input: nums = [1,2,3], indexDifference = 2, valueDifference = 4
// Output: [-1,-1]
// Explanation: In this example, it can be shown that it is impossible to find
// two indices that satisfy both conditions.
// Hence, [-1,-1] is returned.
//
// 
// Constraints: 
//
// 
// 1 <= n == nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= indexDifference <= 10⁵ 
// 0 <= valueDifference <= 10⁹ 
// 
//
// 👍 25 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Id：&emsp;&emsp;2905
 * <p>
 * Name：Find Indices With Index and Value Difference II
 *
 * @author Yuri
 * @since 2024-09-29 11:03:58
 */

public class FindIndicesWithIndexAndValueDifferenceIi {

    public static void main(String[] args) {
        Solution solution = new FindIndicesWithIndexAndValueDifferenceIi().new Solution();
        solution.findIndices(new int[]{0, 8, 2, 5, 10}, 0, 10);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
            int n = nums.length;
            int[] max = new int[n], min = new int[n];
            max[0] = min[0] = 0;
            for (int i = 1; i < n; i++) {
                max[i] = nums[i] > nums[max[i - 1]] ? i : max[i - 1];
                min[i] = nums[i] < nums[min[i - 1]] ? i : min[i - 1];
            }
            for (int i = indexDifference; i < n; i++) {
                if (nums[max[i - indexDifference]] - nums[i] >= valueDifference)
                    return new int[]{max[i - indexDifference], i};
                if (nums[i] - nums[min[i - indexDifference]] >= valueDifference)
                    return new int[]{min[i - indexDifference], i};
            }
            return new int[]{-1, -1};
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}