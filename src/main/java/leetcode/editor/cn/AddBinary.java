//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 898 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;67
 * <p>
 * Name：二进制求和
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int i = a.length() - 1;
            int j = b.length() - 1;
            StringBuilder sb = new StringBuilder();
            int mod = 0;
            while (i >= 0 || j >= 0) {
                int x = i >= 0 ? a.charAt(i) - '0' : 0;
                int y = j >= 0 ? b.charAt(j) - '0' : 0;
                sb.append((x + y + mod) % 2);
                mod = (x + y + mod) / 2;
                i--;
                j--;
            }
            if (mod == 1) sb.append(1);
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}