// Given a positive integer num, split it into two non-negative integers num1
// and num2 such that:
//
// 
// The concatenation of num1 and num2 is a permutation of num. 
// 
//
// 
// In other words, the sum of the number of occurrences of each digit in num1 
// and num2 is equal to the number of occurrences of that digit in num.
// 
// 
// num1 and num2 can contain leading zeros. 
//
//
// Return the minimum possible sum of num1 and num2. 
//
// Notes: 
//
// 
// It is guaranteed that num does not contain any leading zeros. 
// The order of occurrence of the digits in num1 and num2 may differ from the 
// order of occurrence of num.
// 
//
// 
// Example 1: 
//
// 
// Input: num = 4325
// Output: 59
// Explanation: We can split 4325 so that num1 is 24 and num2 is 35, giving a
// sum of 59. We can prove that 59 is indeed the minimal possible sum.
// 
//
// Example 2: 
//
// 
// Input: num = 687
// Output: 75
// Explanation: We can split 687 so that num1 is 68 and num2 is 7, which would
// give an optimal sum of 75.
// 
//
// 
// Constraints: 
//
// 
// 10 <= num <= 10⁹ 
// 
//
// 👍 54 👎 0

package problems.leetcode.editor.cn;

import java.util.stream.IntStream;

/**
 * Id：&emsp;&emsp;2578
 * <p>
 * Name：Split With Minimum Sum
 *
 * @author Yuri
 * @since 2023-10-09 18:07:40
 */

public class SplitWithMinimumSum {

    public static void main(String[] args) {
        Solution solution = new SplitWithMinimumSum().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int splitNum(int num) {
            int[] nums = String.valueOf(num).chars().sorted().map(o -> (o - '0')).toArray();
            int num1 = 0, num2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((i & 1) == 1) num2 = num2 * 10 + nums[i];
                else num1 = num1 * 10 + nums[i];
            }
            return num1 + num2;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}