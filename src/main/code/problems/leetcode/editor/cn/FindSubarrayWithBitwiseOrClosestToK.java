// You are given an array nums and an integer k. You need to find a subarray of
// nums such that the absolute difference between k and the bitwise OR of the
// subarray elements is as small as possible. In other words, select a subarray nums[l..
// r] such that |k - (nums[l] OR nums[l + 1] ... OR nums[r])| is minimum.
//
// Return the minimum possible value of the absolute difference. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,4,5], k = 3 
// 
//
// Output: 0 
//
// Explanation: 
//
// The subarray nums[0..1] has OR value 3, which gives the minimum absolute 
// difference |3 - 3| = 0.
//
// Example 2: 
//
// 
// Input: nums = [1,3,1,3], k = 2 
// 
//
// Output: 1 
//
// Explanation: 
//
// The subarray nums[1..1] has OR value 3, which gives the minimum absolute 
// difference |3 - 2| = 1.
//
// Example 3: 
//
// 
// Input: nums = [1], k = 10 
// 
//
// Output: 9 
//
// Explanation: 
//
// There is a single subarray with OR value 1, which gives the minimum absolute 
// difference |10 - 1| = 9.
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// 
//
// 👍 11 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;

/**
 * Id：&emsp;&emsp;3171
 * <p>
 * Name：Find Subarray With Bitwise OR Closest to K
 *
 * @author Yuri
 * @since 2024-07-05 11:52:47
 */

public class FindSubarrayWithBitwiseOrClosestToK {

    public static void main(String[] args) {
        Solution solution = new FindSubarrayWithBitwiseOrClosestToK().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumDifference(int[] nums, int k) {
            int ans = Integer.MAX_VALUE;
            var ors = new ArrayList<int[]>();
            for (int num : nums) {
                int t = 0;
                ors.add(new int[]{0});
                for (int[] or : ors) {
                    or[0] |= num;
                    ans = Math.min(ans, Math.abs(or[0] - k));
                    if (or[0] != ors.get(t)[0]) ors.set(++t, or);
                }
                ors.subList(t + 1, ors.size()).clear();
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}