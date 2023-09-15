// Given an array nums of n integers, return an array of all the unique
// quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// 👍 1753 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;18
 * <p>
 * Name：4Sum
 *
 * @author Yuri
 * @since 2023-09-15 14:42:47
 */

public class FourSum {

    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        solution.fourSum(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
                for (int j = i + 1; j < n - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                    int l = j + 1, r = n - 1;
                    while (l < r) {
                        long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                        if (sum > target) r--;
                        else if (sum < target) l++;
                        else {
                            ans.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                            for (++l; l < r && nums[l] == nums[l - 1]; ++l) ;
                            for (--r; l < r && nums[r] == nums[r + 1]; --r) ;
                        }
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}