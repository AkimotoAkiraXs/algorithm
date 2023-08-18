//请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 
//9，则该函数输出 2。 
//
// 
//
// 示例 1： 
//
// 
//输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 
//输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 
//输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 输入必须是长度为 32 的 二进制串 。 
// 
//
// 
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/ 
// Related Topics 位运算 
// 👍 134 👎 0


/*
 * Id：剑指 Offer 15
 * Name：二进制中1的个数
 * Date：2021-06-23 11:06:51
 */
package problems.leetcode.editor.cn;

public class ErJinZhiZhong1deGeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ErJinZhiZhong1deGeShuLcof().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight2(int n) {
            return Integer.bitCount(n);
        }

        //lowBit解法
        public int hammingWeightLowBit(int n) {
            int ans = 0;
            for (int i = n; i != 0; i -= lowBit(i)) ans++;
            return ans;
        }

        int lowBit(int x) {
            return x & -x; //每次返回x最低位 1 所表示的数值, 例如 (0000...111100)返回(0000...000100)
        }

        //Kernighan算法 每次s &= s - 1 就删除了s二进制最右边的1
        public int hammingWeight(int n) {
            int ans = 0;
            while (n != 0) {
                n &= n - 1;
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 