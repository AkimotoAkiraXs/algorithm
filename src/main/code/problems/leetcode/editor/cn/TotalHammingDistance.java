// The Hamming distance between two integers is the number of positions at which
// the corresponding bits are different.
//
// Given an integer array nums, return the sum of Hamming distances between all 
// the pairs of the integers in nums.
//
// 
// Example 1: 
//
// 
// Input: nums = [4,14,2]
// Output: 6
// Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 001
// 0 (just
// showing the four bits relevant in this case).
// The answer will be:
// HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 +
// 2 + 2 = 6.
// 
//
// Example 2: 
//
// 
// Input: nums = [4,14,4]
// Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁹ 
// The answer for the given input will fit in a 32-bit integer. 
// 
//
// 👍 301 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;477
 * <p>
 * Name：Total Hamming Distance
 *
 * @author Yuri
 * @since 2024-07-16 11:06:53
 */

public class TotalHammingDistance {

    public static void main(String[] args) {
        Solution solution = new TotalHammingDistance().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int totalHammingDistance(int[] nums) {
            int[] b = new int[31];
            int n = nums.length;
            for (int num : nums)
                for (int i = 0; i < 31; i++) b[i] += num >> i & 1;
            int ans = 0;
            for (int i = 0; i < 31; i++) ans += (n - b[i]) * b[i];
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}