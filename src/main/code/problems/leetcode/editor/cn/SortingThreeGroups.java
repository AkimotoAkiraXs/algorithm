// You are given a 0-indexed integer array nums of length n. The numbers from 0
// to n - 1 are divided into three groups numbered from 1 to 3, where number i
// belongs to group nums[i]. Notice that some groups may be empty. You are allowed to
// perform this operation any number of times:
//
// 
// Pick number x and change its group. More formally, change nums[x] to any 
// number from 1 to 3.
// 
//
// A new array res is constructed using the following procedure: 
//
// 
// Sort the numbers in each group independently. 
// Append the elements of groups 1, 2, and 3 to res in this order. 
// 
//
// Array nums is called a beautiful array if the constructed array res is 
// sorted in non-decreasing order.
//
// Return the minimum number of operations to make nums a beautiful array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [2,1,3,2,1]
// Output: 3
// Explanation: It's optimal to perform three operations:
// 1. change nums[0] to 1.
// 2. change nums[2] to 1.
// 3. change nums[3] to 1.
// After performing the operations and sorting the numbers in each group, group 1
// becomes equal to [0,1,2,3,4] and group 2 and group 3 become empty. Hence, res 
// is equal to [0,1,2,3,4] which is sorted in non-decreasing order.
// It can be proven that there is no valid sequence of less than three
// operations.
// 
//
// Example 2: 
//
// 
// Input: nums = [1,3,2,1,3,3]
// Output: 2
// Explanation: It's optimal to perform two operations:
// 1. change nums[1] to 1.
// 2. change nums[2] to 1.
// After performing the operations and sorting the numbers in each group, group 1
// becomes equal to [0,1,2,3], group 2 becomes empty, and group 3 becomes equal 
// to [4,5]. Hence, res is equal to [0,1,2,3,4,5] which is sorted in non-decreasing
// order.
// It can be proven that there is no valid sequence of less than two operations.
// 
//
// Example 3: 
//
// 
// Input: nums = [2,2,2,2,3,3]
// Output: 0
// Explanation: It's optimal to not perform operations.
// After sorting the numbers in each group, group 1 becomes empty, group 2
// becomes equal to [0,1,2,3] and group 3 becomes equal to [4,5]. Hence, res is equal to
//[0,1,2,3,4,5] which is sorted in non-decreasing order.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 3 
// 
//
// 👍 6 👎 0

package problems.leetcode.editor.cn;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;2826
 * <p>
 * Name：Sorting Three Groups
 *
 * @author Yuri
 * @since 2023-09-19 18:38:12
 */

public class SortingThreeGroups {

    public static void main(String[] args) {
        Solution solution = new SortingThreeGroups().new Solution();
        solution.minimumOperations(Lists.newArrayList(2, 1, 3, 2, 1));
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 状态机Dp
     */
    class Solution {

        /**
         * 定义 f[i+1][j]表示考虑nums[0]到nums[i]，且nums[i]变成j的最小修改次数。
         * j即是状态，在该题中，状态有1、2、3，每个位置的3个状态分别依赖于前一个位置的3个状态，所以此处省略一个维度。
         */
        public int minimumOperations_(List<Integer> nums) {
            var f = new int[4];
            for (int x : nums) {
                for (int j = 3; j > 0; j--) { // 省略了维度，避免覆盖，倒循环
                    for (int k = 1; k <= j; k++)
                        f[j] = Math.min(f[j], f[k]);
                    if (j != x) f[j]++; // 当状态不同时，当前位置需要消耗一步变为x
                }
            }
            int ans = nums.size();
            for (int j = 1; j < 4; j++)
                ans = Math.min(ans, f[j]);
            return ans;
        }

        /**
         * f[i]表示以在i+1以f[i]为结尾满足条件的数组中，能保留(0~i)几个数不修改。
         * 对于0~i而言，只要比f[i+1]小就满足条件不用修改，而不用修改的数越多需要消耗的步数就越小。
         */
        public int minimumOperations(List<Integer> nums) {
            var f = new int[4];
            for (int x : nums) {
                f[x]++;
                f[2] = Math.max(f[2], f[1]);
                f[3] = Math.max(f[3], f[2]);
            }
            return nums.size() - f[3];
        }
    }

    /**
     * 将问题翻译为：求变更最少数能让数组有序，即求最长非递减子序列问题
     * <p>
     * dp做法：分为普通DP->O(n^2)（虽然过了，但实际复杂度不该过），二分Dp->O(nlogn)
     *
     * @see LongestIncreasingSubsequence 最长递增子序列LIS
     */
    class Solution_ {


        // 虽然过了的超时普通做法
        public int minimumOperations_(List<Integer> nums) {
            int n = nums.size();
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++)
                    if (nums.get(j) <= nums.get(i)) dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
            return n - max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}