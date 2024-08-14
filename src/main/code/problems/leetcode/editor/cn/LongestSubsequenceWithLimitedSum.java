// You are given an integer array nums of length n, and an integer array queries
// of length m.
//
// Return an array answer of length m where answer[i] is the maximum size of a 
// subsequence that you can take from nums such that the sum of its elements is
// less than or equal to queries[i].
//
// A subsequence is an array that can be derived from another array by deleting 
// some or no elements without changing the order of the remaining elements.
//
// 
// Example 1: 
//
// 
// Input: nums = [4,5,2,1], queries = [3,10,21]
// Output: [2,3,4]
// Explanation: We answer the queries as follows:
//- The subsequence [2,1] has a sum less than or equal to 3. It can be proven 
// that 2 is the maximum size of such a subsequence, so answer[0] = 2.
//- The subsequence [4,5,1] has a sum less than or equal to 10. It can be 
// proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
//- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be 
// proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
// 
//
// Example 2: 
//
// 
// Input: nums = [2,3,4,5], queries = [1]
// Output: [0]
// Explanation: The empty subsequence is the only subsequence that has a sum
// less than or equal to 1, so answer[0] = 0.
//
// 
// Constraints: 
//
// 
// n == nums.length 
// m == queries.length 
// 1 <= n, m <= 1000 
// 1 <= nums[i], queries[i] <= 10⁶ 
// 
//
// 👍 139 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2389
 * <p>
 * Name：Longest Subsequence With Limited Sum
 *
 * @author Yuri
 * @since 2024-08-14 16:46:21
 */

public class LongestSubsequenceWithLimitedSum {

    public static void main(String[] args) {
        Solution solution = new LongestSubsequenceWithLimitedSum().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) sum[i] = sum[i - 1] + nums[i];
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) ans[i] = dichotomy(sum, queries[i]);
            return ans;
        }


        private int dichotomy(int[] nums, int t) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] <= t) l = mid + 1;
                else r = mid;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}