// Given an integer number n, return the difference between the product of its
// digits and the sum of its digits.
//
// 
// Example 1: 
//
// 
// Input: n = 234
// Output: 15
// Explanation:
// Product of digits = 2 * 3 * 4 = 24
// Sum of digits = 2 + 3 + 4 = 9
// Result = 24 - 9 = 15
// 
//
// Example 2: 
//
// 
// Input: n = 4421
// Output: 21
// Explanation:
// Product of digits = 4 * 4 * 2 * 1 = 32
// Sum of digits = 4 + 4 + 2 + 1 = 11
// Result = 32 - 11 = 21
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10^5 
// 
//
// 👍 129 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1281
 * <p>
 * Name：Subtract the Product and Sum of Digits of an Integer
 *
 * @author Yuri
 * @since 2023-08-09 11:08:11
 */


public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
        Solution solution = new SubtractTheProductAndSumOfDigitsOfAnInteger().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subtractProductAndSum(int n) {
            int mul = 1;
            int sum = 0;
            for (char c : String.valueOf(n).toCharArray()) {
                int d = c - '0';
                mul *= d;
                sum += d;
            }
            return mul - sum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
