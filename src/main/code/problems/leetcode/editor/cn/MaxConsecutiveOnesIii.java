// Given a binary array nums and an integer k, return the maximum number of
// consecutive 1's in the array if you can flip at most k 0's.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
// Example 2: 
//
// 
// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 0 <= k <= nums.length 
// 
//
// 👍 631 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1004
 * <p>
 * Name：Max Consecutive Ones III
 *
 * @author Yuri
 * @since 2023-09-18 10:09:57
 */

public class MaxConsecutiveOnesIii {

    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 问题转换为cnt0<=k时，窗口长度的最大值
         */
        public int longestOnes(int[] nums, int k) {
            int n = nums.length;
            int l = 0, cnt = 0, ans = 0;
            for (int r = 0; r < n; r++) {
                if (nums[r] == 0) cnt++;
                while (cnt > k && nums[l++] == 0) cnt--;
                ans = Math.max(r - l + 1, ans);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}