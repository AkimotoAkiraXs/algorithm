// Given an array of integers nums and an integer threshold, we will choose a
// positive integer divisor, divide all the array by it, and sum the division's
// result. Find the smallest divisor such that the result mentioned above is less than
// or equal to threshold.
//
// Each result of the division is rounded to the nearest integer greater than 
// or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
//
// The test cases are generated so that there will be an answer. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5
// the sum will be 5 (1+1+1+2).
// 
//
// Example 2: 
//
// 
// Input: nums = [44,22,33,11,1], threshold = 5
// Output: 44
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// 1 <= nums[i] <= 10⁶ 
// nums.length <= threshold <= 10⁶ 
// 
//
// 👍 122 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1283
 * <p>
 * Name：Find the Smallest Divisor Given a Threshold
 *
 * @author Yuri
 * @since 2024-08-19 18:05:35
 */

public class FindTheSmallestDivisorGivenAThreshold {

    public static void main(String[] args) {
        Solution solution = new FindTheSmallestDivisorGivenAThreshold().new Solution();
        solution.smallestDivisor(new int[]{21212,10101,12121}, 1000000);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int smallestDivisor(int[] nums, int threshold) {
            int l = 1, r = (int) 1e6;
            while (l < r) {
                int m = l + r >> 1;
                long tot = 0;
                for (int num : nums) tot += (num - 1) / m + 1;
                if (tot > threshold) l = m + 1;
                else r = m;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}