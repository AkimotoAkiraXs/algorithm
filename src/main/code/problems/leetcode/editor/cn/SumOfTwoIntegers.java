// Given two integers a and b, return the sum of the two integers without using
// the operators + and -.
//
// 
// Example 1: 
// Input: a = 1, b = 2
// Output: 3
// 
// Example 2: 
// Input: a = 2, b = 3
// Output: 5
// 
// 
// Constraints: 
//
// 
// -1000 <= a, b <= 1000 
// 
//
// 👍 738 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;371
 * <p>
 * Name：Sum of Two Integers
 *
 * @author Yuri
 * @since 2024-08-07 17:44:30
 */

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        Solution solution = new SumOfTwoIntegers().new Solution();
        solution.getSum(2, 3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 位运算：令a=a&b<<1（都为1的位置进1），b=a^b（记录只有一个数为1的位置），当两个数的与值为0则表示没有进1的情况，则返回或值，也就是答案。
         */
        public int getSum(int a, int b) {
            while ((a & b) != 0) {
                b = a ^ b;
                a = (a & (a ^ b)) << 1;
            }
            return a | b;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}