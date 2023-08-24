//颠倒给定的 32 位无符号整数的二进制位。 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 00000010100101000001111010011100
//输出：964176192 (00111001011110000010100101000000)
//解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
//     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。 
//
// 示例 2： 
//
// 
//输入：n = 11111111111111111111111111111101
//输出：3221225471 (10111111111111111111111111111111)
//解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
//     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。 
//
// 
//
// 提示： 
//
// 
// 输入是一个长度为 32 的二进制字符串 
// 
//
// 
//
// 进阶: 如果多次调用这个函数，你将如何优化你的算法？ 
// Related Topics 位运算 分治 👍 471 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;190
 * <p>
 * Name：颠倒二进制位 
 *
 * @since  2021-12-14 16:04:58 
 * @author Yuri 
*/
public class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();

        System.out.println(solution.reverseBits(37));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need treat n as an unsigned value

         /*官方解答：分治位运算*/
        private static final int M1 = 0x55555555; // 01010101010101010101010101010101
        private static final int M2 = 0x33333333; // 00110011001100110011001100110011
        private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
        private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

        /**
         * 以2^(k-1)个数为一组，其中k是颠倒次数，将所有数分为奇偶组，每一次都颠倒奇偶组位置
         */
        public int reverseBits(int n) {
            n = n >>> 1 & M1 | (n & M1) << 1;//21436587
            n = n >>> 2 & M2 | (n & M2) << 2;//43218765
            n = n >>> 4 & M4 | (n & M4) << 4;//87654321
            n = n >>> 8 & M8 | (n & M8) << 8;//...
            return n >>> 16 | n << 16;
        }

/*
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
    */
}
//leetcode submit region end(Prohibit modification and deletion)

}