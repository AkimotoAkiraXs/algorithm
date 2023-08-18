//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 491 👎 0


/*
 * Id：461
 * Name：汉明距离
 * Date：2021-06-22 15:01:21
 */
package problems.leetcode.editor.cn;

public class HammingDistance {
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 异或运算
         */
        public int hammingDistance(int x, int y) {
            int n = x ^ y, res = 0;
            String s = Integer.toBinaryString(n);
            int k;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    res++;
                }
            }
            return res;
        }

        //官方 内置位计数功能
        public int hammingDistanceOfficially(int x, int y) {
            return Integer.bitCount(x ^ y);
        }

        //官方2 开始想出来没实现的思路 移位实现位计数
        public int hammingDistanceOfficially2(int x, int y) {
            int z = x ^ y;
            int sum = 0;
            while (z != 0) {
                sum += z & 1;
                z = z >> 1;
            }
            return sum;
        }

        //官方3 Brian Kernighan算法 每次s &= s - 1 就删除了s二进制最右边的1
        public int hammingDistanceOfficially3(int x, int y) {
            int s = x ^ y, ret = 0;
            while (s != 0) {
                s &= s - 1;
                ret++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 