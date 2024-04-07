// You are given positive integers n and target.
//
// An array nums is beautiful if it meets the following conditions: 
//
// 
// nums.length == n. 
// nums consists of pairwise distinct positive integers. 
// There doesn't exist two distinct indices, i and j, in the range [0, n - 1], 
// such that nums[i] + nums[j] == target.
// 
//
// Return the minimum possible sum that a beautiful array could have modulo 10⁹ 
//+ 7. 
//
// 
// Example 1: 
//
// 
// Input: n = 2, target = 3
// Output: 4
// Explanation: We can see that nums = [1,3] is beautiful.
//- The array nums has length n = 2.
//- The array nums consists of pairwise distinct positive integers.
//- There doesn't exist two distinct indices, i and j, with nums[i] + nums[j] ==
// 3.
// It can be proven that 4 is the minimum possible sum that a beautiful array
// could have.
// 
//
// Example 2: 
//
// 
// Input: n = 3, target = 3
// Output: 8
// Explanation: We can see that nums = [1,3,4] is beautiful.
//- The array nums has length n = 3.
//- The array nums consists of pairwise distinct positive integers.
//- There doesn't exist two distinct indices, i and j, with nums[i] + nums[j] ==
// 3.
// It can be proven that 8 is the minimum possible sum that a beautiful array
// could have.
// 
//
// Example 3: 
//
// 
// Input: n = 1, target = 1
// Output: 1
// Explanation: We can see, that nums = [1] is beautiful.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 1 <= target <= 10⁹ 
// 
//
// 👍 42 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2834
 * <p>
 * Name：Find the Minimum Possible Sum of a Beautiful Array
 *
 * @author Yuri
 * @since 2024-03-08 16:51:08
 */

public class FindTheMinimumPossibleSumOfABeautifulArray {

    public static void main(String[] args) {
        Solution solution = new FindTheMinimumPossibleSumOfABeautifulArray().new Solution();
        solution.minimumPossibleSum(100000000, 1000000000);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 数据范围：1 <= n <= 10^9 ，只能用数学解法
         * <p>
         * 以k=target/2为界限，n<=k则选1~n，n>k则选1~k和target~(target+k-1)
         */
        public int minimumPossibleSum(int n, int target) {
            int mod = (int) 1e9 + 7;
            long k = target / 2;
            if (n <= k) return (int) ((long) (1 + n) * n / 2 % mod);
            return (int) (((1 + k) * k / 2 + (target + target + (n - k) - 1) * (n - k) / 2) % mod);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}