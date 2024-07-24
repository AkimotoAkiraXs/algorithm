// You are given an array nums consisting of positive integers where all
// integers have the same number of digits.
//
// The digit difference between two integers is the count of different digits 
// that are in the same position in the two integers.
//
// Return the sum of the digit differences between all pairs of integers in 
// nums.
//
// 
// Example 1: 
//
// 
// Input: nums = [13,23,12] 
// 
//
// Output: 4 
//
// Explanation: We have the following: - The digit difference between 13 and 23 
// is 1. - The digit difference between 13 and 12 is 1. - The digit difference
// between 23 and 12 is 2. So the total sum of digit differences between all pairs of
// integers is 1 + 1 + 2 = 4.
//
// Example 2: 
//
// 
// Input: nums = [10,10,10,10] 
// 
//
// Output: 0 
//
// Explanation: All the integers in the array are the same. So the total sum of 
// digit differences between all pairs of integers will be 0.
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] < 10⁹ 
// All integers in nums have the same number of digits. 
// 
//
// 👍 6 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;3153
 * <p>
 * Name：Sum of Digit Differences of All Pairs
 *
 * @author Yuri
 * @since 2024-07-23 18:46:46
 */

public class SumOfDigitDifferencesOfAllPairs {

    public static void main(String[] args) {
        Solution solution = new SumOfDigitDifferencesOfAllPairs().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long sumDigitDifferences(int[] nums) {
            long res = 0;
            int[] d = new int[10];
            for (int i = 0; i < d.length; i++) d[i] = (int) Math.pow(10, i);
            int len = String.valueOf(nums[0]).length();
            int n = nums.length;
            int[][] cnt = new int[len][10];
            for (int num : nums)
                for (int i = 0; i < len; i++)
                    cnt[i][num / d[i] % 10]++;
            for (int i = 0; i < len; i++)
                for (int j = 0; j < 10; j++)
                    res += (long) cnt[i][j] * (n - cnt[i][j]);
            return res / 2;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}