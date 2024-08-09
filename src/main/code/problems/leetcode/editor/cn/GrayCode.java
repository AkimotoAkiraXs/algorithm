// An n-bit gray code sequence is a sequence of 2ⁿ integers where:
//
// 
// Every integer is in the inclusive range [0, 2ⁿ - 1], 
// The first integer is 0, 
// An integer appears no more than once in the sequence, 
// The binary representation of every pair of adjacent integers differs by 
// exactly one bit, and
// The binary representation of the first and last integers differs by exactly 
// one bit.
// 
//
// Given an integer n, return any valid n-bit gray code sequence. 
//
// 
// Example 1: 
//
// 
// Input: n = 2
// Output: [0,1,3,2]
// Explanation:
// The binary representation of [0,1,3,2] is [00,01,11,10].
//- 00 and 01 differ by one bit
//- 01 and 11 differ by one bit
//- 11 and 10 differ by one bit
//- 10 and 00 differ by one bit
//[0,2,3,1] is also a valid gray code sequence, whose binary representation is [
// 00,10,11,01].
//- 00 and 10 differ by one bit
//- 10 and 11 differ by one bit
//- 11 and 01 differ by one bit
//- 01 and 00 differ by one bit
// 
//
// Example 2: 
//
// 
// Input: n = 1
// Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 16 
// 
//
// 👍 680 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;89
 * <p>
 * Name：Gray Code
 *
 * @author Yuri
 * @since 2024-08-08 18:34:03
 */

public class GrayCode {

    public static void main(String[] args) {
        Solution solution = new GrayCode().new Solution();
        solution.grayCode(2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二进制->格雷码公式：G(n) = n ⊕ [n/2]
         * <p>
         * 证明：<a href="https://gitee.com/YuriMing/akira-pictures/raw/master/img/202408121044272.png">OI WIKI 格雷码</a>
         */
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < 1 << n; i++) ans.add((i >> 1) ^ i);
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}