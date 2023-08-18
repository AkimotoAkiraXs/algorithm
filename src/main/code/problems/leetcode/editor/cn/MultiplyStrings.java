//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1076 👎 0

package problems.leetcode.editor.cn;

import java.util.Objects;

/**
 * Id：&emsp;&emsp;43
 * <p>
 * Name：字符串相乘
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("9133", "0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            String ans = "0";
            if (Objects.equals(num2, "0") || Objects.equals(num1, "0")) return ans;
            for (int i = num1.length() - 1; i >= 0; i--) {
                int x = num1.charAt(i) - '0';
                int mod = 0;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num1.length() - 1 - i; j++) sb.append(0);
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int y = num2.charAt(j) - '0';
                    int num = (x * y + mod) % 10;
                    sb.append(num);
                    mod = (x * y + mod) / 10;
                }
                if (mod != 0) sb.append(mod);
                ans = addStrings(ans, sb.reverse().toString());
            }
            return ans;
        }

        private String addStrings(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            StringBuilder sb = new StringBuilder();
            int mod = 0;
            while (i >= 0 || j >= 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                sb.append((x + y + mod) % 10);
                mod = (x + y + mod) / 10;
                i--;
                j--;
            }
            if (mod == 1) sb.append(1);
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}