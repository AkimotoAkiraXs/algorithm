// You are given a 0-indexed integer array nums. A subarray s of length m is
// called alternating if:
//
// 
// m is greater than 1. 
// s1 = s0 + 1. 
// The 0-indexed subarray s looks like [s0, s1, s0, s1,...,s(m-1) % 2]. In 
// other words, s1 - s0 = 1, s2 - s1 = -1, s3 - s2 = 1, s4 - s3 = -1, and so on up to s[
// m - 1] - s[m - 2] = (-1)ᵐ.
// 
//
// Return the maximum length of all alternating subarrays present in nums or -1 
// if no such subarray exists.
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [2,3,4,3,4]
// Output: 4
// Explanation: The alternating subarrays are [3,4], [3,4,3], and [3,4,3,4]. The
// longest of these is [3,4,3,4], which is of length 4.
// 
//
// Example 2: 
//
// 
// Input: nums = [4,5,6]
// Output: 2
// Explanation: [4,5] and [5,6] are the only two alternating subarrays. They are
// both of length 2.
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 100 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 👍 3 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2765
 * <p>
 * Name：Longest Alternating Subarray
 *
 * @author Yuri
 * @since 2023-07-10 11:24:36
 */


public class LongestAlternatingSubarray {
    public static void main(String[] args) {
        Solution solution = new LongestAlternatingSubarray().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 模拟 + 退格 O(n)
        public int alternatingSubarray(int[] nums) {
            int max = 0;
            int k = 1;
            int cnt = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == k) {
                    cnt++;
                    max = Math.max(max, cnt);
                    k = -k;
                } else {
                    if (nums[i] - nums[i - 1] == 1) i--;
                    k = 1;
                    cnt = 1;
                }
            }
            return max <= 1 ? -1 : max;
        }

        // O(n^2)
        public int alternatingSubarray_ct(int[] nums) {
            int max = 0;
            for (int i = 1; i < nums.length; i++) {
                int cnt = 0;
                int k = 1;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] - nums[j - 1] == k) {
                        cnt++;
                        k = -k;
                        max = Math.max(max, cnt);
                    } else break;
                }
            }
            return max >= 1 ? max + 1 : -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
