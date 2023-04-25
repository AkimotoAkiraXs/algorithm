// Given an integer n, return an array ans of length n + 1 such that for each i (
// 0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
//
// 
// Example 1: 
//
// 
// Input: n = 2
// Output: [0,1,1]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 
//
// Example 2: 
//
// 
// Input: n = 5
// Output: [0,1,1,2,1,2]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
// Follow up: 
//
// 
// It is very easy to come up with a solution with a runtime of O(n log n). Can 
// you do it in linear time O(n) and possibly in a single pass?
// Can you do it without using any built-in function (i.e., like __builtin_
// popcount in C++)?
// 
//
// Related Topics 位运算 动态规划 👍 1193 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;338
 * <p>
 * Name：Counting Bits
 *
 * @author Yuri
 * @since 2023-04-24 18:34:11
 */


public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countBits(int n) {
            // todo 三种动态规划
            int[] ans = new int[n + 1];
            ans[0] = 0;
/*
            // 1.最低设置位
            for (int i = 1; i <= n; i++) ans[i] = ans[i & (i - 1)] + 1;
*/

/*
            // 2.最高位有效位，用哨兵记录最高bit数(2的幂)的值，如遇到更大的数则更新哨兵
            int highBit = 0;
            for (int i = 1; i <= n; i++) {
                if ((i & (i - 1)) == 0) highBit = i;
                ans[i] = ans[i - highBit] + 1;
            }
*/
            // 3.最低有效位，奇数最低位一定是1，偶数一定是0
            for (int i = 1; i <= n; i++) {
                ans[i] = ans[i >> 1] + (i & 1);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
