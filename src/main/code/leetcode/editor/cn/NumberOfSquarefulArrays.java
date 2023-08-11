// An array is squareful if the sum of every pair of adjacent elements is a
// perfect square.
//
// Given an integer array nums, return the number of permutations of nums that 
// are squareful.
//
// Two permutations perm1 and perm2 are different if there is some index i such 
// that perm1[i] != perm2[i].
//
// 
// Example 1: 
//
// 
// Input: nums = [1,17,8]
// Output: 2
// Explanation: [1,8,17] and [17,8,1] are the valid permutations.
// 
//
// Example 2: 
//
// 
// Input: nums = [2,2,2]
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 12 
// 0 <= nums[i] <= 10⁹ 
// 
//
// 👍 111 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;996
 * <p>
 * Name：Number of Squareful Arrays
 *
 * @author Yuri
 * @since 2023-06-27 10:18:23
 */


public class NumberOfSquarefulArrays {
    public static void main(String[] args) {
        Solution solution = new NumberOfSquarefulArrays().new Solution();
        solution.numSquarefulPerms(new int[]{1, 1});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquarefulPerms(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[1 << n][n];
            Arrays.fill(dp[0], 1);
            for (int i = 1; i < 1 << n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i >> j & 1) == 0) continue;
                    for (int k = 0; k < n; k++) {
                        if (Math.pow((int) Math.sqrt(nums[j] + nums[k]), 2) == nums[j] + nums[k]) {
                            dp[i][k] += dp[i ^ (1 << j)][j];
                        }
                    }
                }
            }
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                ans += dp[((1 << n) - 1) ^ (1 << i)][i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            // 去重很简单，第i个数有k个重复的ans就除以k!因为不考虑重复每次选num[i]这个数时可选项依次是k,k-1,k-2...1
            for (Integer k : map.values()) while (k > 1) ans /= k--;
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
