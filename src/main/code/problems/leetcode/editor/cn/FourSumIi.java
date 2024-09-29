// Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
// return the number of tuples (i, j, k, l) such that:
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
// Example 1: 
//
// 
// Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
// Output: 2
// Explanation:
// The two tuples are:
// 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
// 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// Example 2: 
//
// 
// Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// 👍 1033 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;454
 * <p>
 * Name：4Sum II
 *
 * @author Yuri
 * @since 2024-09-26 17:26:46
 */

public class FourSumIi {

    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
        solution.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums3)
                for (int y : nums4)
                    map.merge(x + y, 1, Integer::sum);
            for (int x : nums1) {
                for (int y : nums2) {
                    Integer val = map.get(-(x + y));
                    ans += val == null ? 0 : val;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}