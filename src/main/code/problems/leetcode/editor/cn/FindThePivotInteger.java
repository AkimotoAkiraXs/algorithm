// Given a positive integer n, find the pivot integer x such that:
//
// 
// The sum of all elements between 1 and x inclusively equals the sum of all 
// elements between x and n inclusively.
// 
//
// Return the pivot integer x. If no such integer exists, return -1. It is 
// guaranteed that there will be at most one pivot index for the given input.
//
// 
// Example 1: 
//
// 
// Input: n = 8
// Output: 6
// Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 =
// 21.
// 
//
// Example 2: 
//
// 
// Input: n = 1
// Output: 1
// Explanation: 1 is the pivot integer since: 1 = 1.
// 
//
// Example 3: 
//
// 
// Input: n = 4
// Output: -1
// Explanation: It can be proved that no such integer exist.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
//
// 👍 46 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2485
 * <p>
 * Name：Find the Pivot Integer
 *
 * @author Yuri
 * @since 2023-06-26 16:36:39
 */


public class FindThePivotInteger {
    public static void main(String[] args) {
        Solution solution = new FindThePivotInteger().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 数学，推公式为：(1+k-1)(k-1)/2 = (n+k+1)(n-k)/2 -> 2k^2 = n^2+n
         */
        public int pivotInteger(int n) {
            int num = n * n + n;
            if ((num & 1) == 0) {
                double sqrt = Math.sqrt(num / 2.0);
                if (sqrt == (int) sqrt) return (int) sqrt;
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
