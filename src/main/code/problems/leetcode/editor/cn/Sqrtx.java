// Given a non-negative integer x, return the square root of x rounded down to
// the nearest integer. The returned integer should be non-negative as well.
//
// You must not use any built-in exponent function or operator. 
//
// 
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. 
// 
//
// 
// Example 1: 
//
// 
// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.
// 
//
// Example 2: 
//
// 
// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we round it down
// to the nearest integer, 2 is returned.
// 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// 👍 1634 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;69
 * <p>
 * Name：Sqrt(x)
 *
 * @author Yuri
 * @since 2025-03-08 16:36:06
 */

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        solution.mySqrt(8);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int l = 0, r = 50000;
            while (l < r) {
                int m = l + r >> 1;
                if ((long) m * m <= x) l = m + 1;
                else r = m;
            }
            return l - 1; // l表示是l*l>x的第一个数，所以后退一位则是答案所求
        }

        /**
         *  牛顿迭代法 略
         */
    }
// leetcode submit region end(Prohibit modification and deletion)

}