// Given an integer array nums, return the length of the longest strictly
// increasing subsequence.
//
// 
// Example 1: 
//
// 
// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
// length is 4.
// 
//
// Example 2: 
//
// 
// Input: nums = [0,1,0,3,2,3]
// Output: 4
// 
//
// Example 3: 
//
// 
// Input: nums = [7,7,7,7,7,7,7]
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
// complexity?
//
// 👍 3279 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;300
 * <p>
 * Name：Longest Increasing Subsequence
 *
 * @author Yuri
 * @since 2023-07-20 14:21:02
 */


public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 标准做法O(n^2)
        public int lengthOfLIS_(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++)
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
            return max + 1;
        }


        /**
         * 贪心+二分：O(nlogn)
         * <p>
         * f[i]记录的是长度为i的非递增子序列的最后一个数大小，所以所得的数组一定是单调递增的，可以采用二分判断每一个数合适的位置。
         * 相应的，该位置便是以该数为结尾的最长非递增子序列。
         */
        public int lengthOfLIS__(int[] nums) {
            int n = nums.length;
            int max = 0;
            int[] f = new int[n + 1];
            Arrays.fill(f, Integer.MIN_VALUE);
            for (int num : nums) {
                int l = 0, r = max + 1;
                while (l < r) {
                    int mid = (l + r) >>> 2;
                    if (f[mid] < num) l = mid + 1;
                    else r = mid;
                }
                f[r] = num;
                max = Math.max(max, r);
            }
            return max;
        }

        /**
         * 贪心+二分+原地更新：O(nlogn)
         * <p>
         */
        public int lengthOfLIS(int[] nums) {
            int max = 0;
            for (int num : nums) {
                int l = -1, r = max;
                while (l + 1 < r) {
                    int mid = (l + r) >>> 1;
                    if (nums[mid] < num) l = mid;
                    else r = mid;
                }
                nums[r] = num;
                if (r == max) max++;
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
