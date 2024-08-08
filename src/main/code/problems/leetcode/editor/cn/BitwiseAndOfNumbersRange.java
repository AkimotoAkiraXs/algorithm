// 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
// 输入：left = 5, right = 7
// 输出：4
// 
//
// 示例 2： 
//
// 
// 输入：left = 0, right = 0
// 输出：0
// 
//
// 示例 3： 
//
// 
// 输入：left = 1, right = 2147483647
// 输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 318 👎 0


/*
 * Id：201
 * Name：数字范围按位与
 * Date：2021-09-13 16:43:20
 */
package problems.leetcode.editor.cn;

public class BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        Solution solution = new BitwiseAndOfNumbersRange().new Solution();
        System.out.println("Hello world");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 此题本质就是找公共前缀
         */
        public int rangeBitwiseAnd(int left, int right) {
            while (left < right) right &= right - 1;
            return right;
        }

        /**
         * 以left高位到低位计算，如果right范围超过该位置，则该1约去
         */
        public int rangeBitwiseAnd_(int left, int right) {
            int ans = 0;
            while (left > 0) {
                long high = Integer.highestOneBit(left);
                if ((high << 1) + ans <= right) return ans;
                ans ^= (int) high;
                left ^= (int) high;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
} 