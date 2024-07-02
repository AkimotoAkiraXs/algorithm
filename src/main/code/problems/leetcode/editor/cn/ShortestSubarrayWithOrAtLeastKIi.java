// You are given an array nums of non-negative integers and an integer k.
//
// An array is called special if the bitwise OR of all of its elements is at 
// least k.
//
// Return the length of the shortest special non-empty subarray of nums, or 
// return -1 if no special subarray exists.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3], k = 2 
// 
//
// Output: 1 
//
// Explanation: 
//
// The subarray [3] has OR value of 3. Hence, we return 1. 
//
// Example 2: 
//
// 
// Input: nums = [2,1,8], k = 10 
// 
//
// Output: 3 
//
// Explanation: 
//
// The subarray [2,1,8] has OR value of 11. Hence, we return 3. 
//
// Example 3: 
//
// 
// Input: nums = [1,2], k = 0 
// 
//
// Output: 1 
//
// Explanation: 
//
// The subarray [1] has OR value of 1. Hence, we return 1. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁹ 
// 
//
// 👍 10 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;

/**
 * Id：&emsp;&emsp;3097
 * <p>
 * Name：Shortest Subarray With OR at Least K II
 *
 * @author Yuri
 * @since 2024-06-27 15:37:21
 */

public class ShortestSubarrayWithOrAtLeastKIi {

    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayWithOrAtLeastKIi().new Solution();
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 81, 32, 2, 73, 43}, 107));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumSubarrayLength(int[] nums, int k) {
            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            var ors = new ArrayList<int[]>();
            for (int i = n - 1; i >= 0; i--) {
                ors.add(new int[]{0, i});
                int t = 0;
                for (var or : ors) {
                    or[0] |= nums[i];
                    if (ors.get(t)[0] == or[0]) ors.get(t)[1] = or[1];
                    else ors.set(++t, or);
                }
                ors.subList(t + 1, ors.size()).clear();
                int l = 0, r = ors.size();
                while (l < r) {
                    int m = (l + r) >> 1;
                    if (ors.get(m)[0] >= k) l = m+1;
                    else r = m;
                }
                l--;
                if (l >= 0) ans = Math.min(ans, ors.get(l)[1] - i + 1);            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}