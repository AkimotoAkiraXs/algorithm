//Given a binary array nums, you should delete one element from it. 
//
// Return the size of the longest non-empty subarray containing only 1's in the 
//resulting array. Return 0 if there is no such subarray. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,0,1]
//Output: 3
//Explanation: After deleting the number in position 2, [1,1,1] contains 3 
//numbers with value of 1's.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1,1,0,1,1,0,1]
//Output: 5
//Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] 
//longest subarray with value of 1's is [1,1,1,1,1].
// 
//
// Example 3: 
//
// 
//Input: nums = [1,1,1]
//Output: 2
//Explanation: You must delete one element.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 
//
// 👍 127 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1493
 * <p>
 * Name：Longest Subarray of 1's After Deleting One Element
 *
 * @author Yuri
 * @since 2024-04-29 16:21:32
 */

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        Solution solution = new LongestSubarrayOf1sAfterDeletingOneElement().new Solution();
        solution.longestSubarray(new int[]{1, 1, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {
            int n = nums.length;
            int l = 0;
            int max = 0;
            int cnt = 0;
            for (int r = 0; r < n; r++) {
                if (nums[r] != 1) cnt++;
                while (cnt > 1 && nums[l++] != 1) cnt--;
                max = Math.max(max, r - l); // 题意是必须删除一个元素，所以这里+1，-1互相抵消了
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}