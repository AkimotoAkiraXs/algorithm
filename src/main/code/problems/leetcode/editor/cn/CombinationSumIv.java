//Given an array of distinct integers nums and a target integer target, return 
//the number of possible combinations that add up to target. 
//
// The test cases are generated so that the answer can fit in a 32-bit integer. 
//
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.
// 
//
// Example 2: 
//
// 
//Input: nums = [9], target = 3
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// All the elements of nums are unique. 
// 1 <= target <= 1000 
// 
//
// 
// Follow up: What if negative numbers are allowed in the given array? How does 
//it change the problem? What limitation we need to add to the question to allow 
//negative numbers? 
//
// 👍 940 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;377
 * <p>
 * Name：Combination Sum IV
 *
 * @author Yuri
 * @since 2024-04-03 14:59:50
 */

public class CombinationSumIv {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIv().new Solution();
        solution.combinationSum4(new int[]{1, 2, 3}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 本质就是爬楼梯问题 {@link ClimbingStairs Lc70.爬楼梯}
     */
    class Solution {

        // dp
        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            int[] f = new int[target + 1];
            f[0] = 1;
            for (int i = 1; i <= target; i++) {
                int cnt = 0;
                for (int num : nums) {
                    if (num > i) break;
                    cnt += f[i - num];
                }
                f[i] = cnt;
            }
            return f[target];
        }

        // dfs
        public int combinationSum4_dfs(int[] nums, int target) {
            int[] memo = new int[target + 1];
            Arrays.fill(memo, -1);
            Arrays.sort(nums);
            return dfs(nums, target, memo);
        }

        int dfs(int[] nums, int target, int[] memo) {
            if (target == 0) return 1;
            if (memo[target] != -1) return memo[target];
            int cnt = 0;
            for (int num : nums) {
                if (num > target) break;
                cnt += dfs(nums, target - num, memo);
            }
            return memo[target] = cnt;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}