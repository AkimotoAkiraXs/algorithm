// Given a set of distinct positive integers nums, return the largest subset
// answer such that every pair (answer[i], answer[j]) of elements in this subset
// satisfies:
//
// 
// answer[i] % answer[j] == 0, or 
// answer[j] % answer[i] == 0 
// 
//
// If there are multiple solutions, return any of them. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3]
// Output: [1,2]
// Explanation: [1,3] is also accepted.
// 
//
// Example 2: 
//
// 
// Input: nums = [1,2,4,8]
// Output: [1,2,4,8]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 10⁹ 
// All the integers in nums are unique. 
// 
//
// Related Topics 数组 数学 动态规划 排序 👍 503 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;368
 * <p>
 * Name：Largest Divisible Subset
 *
 * @author Yuri
 * @since 2023-06-06 17:59:33
 */


public class LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new LargestDivisibleSubset().new Solution();
        solution.largestDivisibleSubset(new int[]{2, 3, 4, 9, 8});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<Integer>[] dp = new List[n]; // 也可以先dp求maxSize数，然后倒叙找到答案
            for (int i = 0; i < n; i++) dp[i] = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> init = new ArrayList<>();
                init.add(nums[i]);
                dp[i] = init;
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && dp[i].size() < dp[j].size() + 1) {
                        List<Integer> list = new ArrayList<>(dp[j]);
                        list.add(nums[i]);
                        dp[i] = list;
                    }
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (dp[i].size() > res.size()) res = dp[i];
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
