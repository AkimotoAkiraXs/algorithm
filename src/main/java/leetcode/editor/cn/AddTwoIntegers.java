//给你两个整数 num1 和 num2，返回这两个整数的和。
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = 12, num2 = 5
//输出：17
//解释：num1 是 12，num2 是 5 ，它们的和是 12 + 5 = 17 ，因此返回 17 。
// 
//
// 示例 2： 
//
// 
//输入：num1 = -10, num2 = 4
//输出：-6
//解释：num1 + num2 = -6 ，因此返回 -6 。
// 
//
// 
//
// 提示： 
//
// 
// -100 <= num1, num2 <= 100 
// 
//
// Related Topics 数学 👍 76 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2235
 * <p>
 * Name：两整数相加
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class AddTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new AddTwoIntegers().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sum(int num1, int num2) {
            return num1 + num2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}