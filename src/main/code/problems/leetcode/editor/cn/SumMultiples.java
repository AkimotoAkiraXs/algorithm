// Given a positive integer n, find the sum of all integers in the range [1, n]
// inclusive that are divisible by 3, 5, or 7.
//
// Return an integer denoting the sum of all numbers in the given range 
// satisfying the constraint.
//
// 
// Example 1: 
//
// 
// Input: n = 7
// Output: 21
// Explanation: Numbers in the range [1, 7] that are divisible by 3, 5, or 7 are
// 3, 5, 6, 7. The sum of these numbers is 21.
// 
//
// Example 2: 
//
// 
// Input: n = 10
// Output: 40
// Explanation: Numbers in the range [1, 10] that are divisible by 3, 5, or 7
// are 3, 5, 6, 7, 9, 10. The sum of these numbers is 40.
// 
//
// Example 3: 
//
// 
// Input: n = 9
// Output: 30
// Explanation: Numbers in the range [1, 9] that are divisible by 3, 5, or 7 are
// 3, 5, 6, 7, 9. The sum of these numbers is 30.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10³ 
// 
//
// 👍 31 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2652
 * <p>
 * Name：Sum Multiples
 *
 * @author Yuri
 * @since 2023-10-17 09:45:10
 */

public class SumMultiples {

    public static void main(String[] args) {
        Solution solution = new SumMultiples().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int sumOfMultiples(int n) {
            return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7);
        }

        private int f(int n, int k) {
            int x = n / k;
            return (int) ((x * k + k) / 2.0 * x);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}