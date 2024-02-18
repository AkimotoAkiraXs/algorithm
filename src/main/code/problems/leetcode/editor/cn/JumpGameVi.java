// You are given a 0-indexed integer array nums and an integer k.
//
// You are initially standing at index 0. In one move, you can jump at most k 
// steps forward without going outside the boundaries of the array. That is, you can
// jump from index i to any index in the range [i + 1, min(n - 1, i + k)]
// inclusive.
//
// You want to reach the last index of the array (index n - 1). Your score is 
// the sum of all nums[j] for each index j you visited in the array.
//
// Return the maximum score you can get. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,-1,-2,4,-7,3], k = 2
// Output: 7
// Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (
// underlined above). The sum is 7.
// 
//
// Example 2: 
//
// 
// Input: nums = [10,-5,-2,4,0,3], k = 3
// Output: 17
// Explanation: You can choose your jumps forming the subsequence [10,4,3] (
// underlined above). The sum is 17.
// 
//
// Example 3: 
//
// 
// Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length, k <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 👍 165 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;1696
 * <p>
 * Name：Jump Game VI
 *
 * @author Yuri
 * @since 2024-02-05 10:34:17
 */

public class JumpGameVi {

    public static void main(String[] args) {
        Solution solution = new JumpGameVi().new Solution();
        solution.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 单调队列
        public int maxResult(int[] nums, int k) {
            Deque<Integer> q = new LinkedList<>();
            int[] f = new int[nums.length];
            q.add(0); // 初始化队列
            f[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (q.element() < i - k) q.remove();
                f[i] = f[q.element()] + nums[i];
                while (!q.isEmpty() && f[q.peekLast()] <= f[i]) q.removeLast();
                q.add(i);
            }
            return f[nums.length - 1];
        }

        // Dp做法，时间复杂度O(nk)，超时！dp[i]表示从位置i开始跳，跳到末尾的最大值之和
        public int maxResult_dp(int[] nums, int k) {
            int n = nums.length;
            int[] dp = new int[n]; //
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[n - 1] = 0; // 初始化，dp[n-1]不会参与二层循环计算，所以需要初始化为0
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j <= Math.min(n - 1, i + k); j++)
                    dp[i] = Math.max(dp[i], dp[j]);
                dp[i] = dp[i] + nums[i];
            }
            return dp[0];
        }

        // 正序dp
        public int maxResult_dp2(int[] nums, int k) {
            int n = nums.length;
            int[] dp = new int[n]; // dp[i]表示从位置0到i能走过和的最大值
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = Math.max(0, i - k); j < i; j++)
                    max = Math.max(max, dp[j]);
                dp[i] = max + nums[i];
            }
            return dp[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}