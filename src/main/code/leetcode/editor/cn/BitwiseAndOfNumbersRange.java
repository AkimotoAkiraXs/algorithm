//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
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
package leetcode.editor.cn;

public class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new BitwiseAndOfNumbersRange().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            if (left == right) return left;
            String l = Integer.toBinaryString(left);
            for (int i = l.length(); i > 0; i--) {
                if (right >= Math.pow(2, i)) break;

            }
            int max = (int) Math.pow(2, l.length() + 1);
            if (right >= max) return 0;
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 