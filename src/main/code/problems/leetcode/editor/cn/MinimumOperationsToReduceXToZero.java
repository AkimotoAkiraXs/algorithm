// You are given an integer array nums and an integer x. In one operation, you
// can either remove the leftmost or the rightmost element from the array nums and
// subtract its value from x. Note that this modifies the array for future
// operations.
//
// Return the minimum number of operations to reduce x to exactly 0 if it is 
// possible, otherwise, return -1.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,1,4,2,3], x = 5
// Output: 2
// Explanation: The optimal solution is to remove the last two elements to
// reduce x to zero.
// 
//
// Example 2: 
//
// 
// Input: nums = [5,6,7,8,9], x = 4
// Output: -1
// 
//
// Example 3: 
//
// 
// Input: nums = [3,2,20,1,1,3], x = 10
// Output: 5
// Explanation: The optimal solution is to remove the last three elements and
// the first two elements (5 operations in total) to reduce x to zero.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 1 <= x <= 10⁹ 
// 
//
// 👍 299 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1658
 * <p>
 * Name：Minimum Operations to Reduce X to Zero
 *
 * @author Yuri
 * @since 2023-08-31 18:50:41
 */


public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
        solution.minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365);
    }

    // leetcode submit region begin(Prohibit modification and deletion)


    //
    class Solution {

        /**
         * 逆向思维，把问题转换为：求数组中和为sum-x的最长子数组的长度。
         * 累减，需要考虑x=sum(nums)，target=0边界值情况。
         */
        public int minOperations_depletion(int[] nums, int x) {
            int sum = Arrays.stream(nums).sum();
            int target = sum - x;
            if (target == 0) return nums.length;
            int l = 0, max = Integer.MIN_VALUE;
            for (int r = 0; r < nums.length; r++) {
                target -= nums[r];
                while (target < 0 && l < r) target += nums[l++];
                if (target == 0) max = Math.max(max, r - l + 1);
            }
            return max == Integer.MIN_VALUE ? -1 : nums.length - max;
        }


        /**
         * 逆向思维，把问题转换为：求数组中和为sum-x的最长子数组的长度。
         * 累加，∵x>0所以不用考虑target=0边界值情况。
         */
        public int minOperations(int[] nums, int x) {
            int target = -x;
            for (int num : nums) target += num;
            if (target < 0) return -1; // 全部移除也无法满足要求
            int ans = -1, left = 0, sum = 0, n = nums.length;
            for (int right = 0; right < n; ++right) {
                sum += nums[right];
                while (sum > target) sum -= nums[left++]; // 缩小子数组长度
                if (sum == target) ans = Math.max(ans, right - left + 1);
            }
            return ans < 0 ? -1 : n - ans;
        }

        /**
         * 正向思维：先求一边（右）的极限，然后再从另一边（左）逐步添加，为0则记录，大于x就从另一边减少（右）。
         * <p>
         * 想到思路了但没（敢）写出代码
         */
        public int minOperations_direct(int[] nums, int x) {
            int sum = 0, n = nums.length, right = n;
            while (right > 0 && sum + nums[right - 1] <= x) // 计算最长后缀
                sum += nums[--right];
            if (right == 0 && sum < x) return -1; // 全部移除也无法满足要求
            int ans = sum == x ? n - right : n + 1;
            for (int left = 0; left < n; ++left) {
                sum += nums[left];
                while (right < n && sum > x) // 缩小后缀长度
                    sum -= nums[right++];
                if (sum > x) break; // 缩小失败，说明前缀过长
                if (sum == x) ans = Math.min(ans, left + 1 + n - right); // 前缀+后缀长度
            }
            return ans > n ? -1 : ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
