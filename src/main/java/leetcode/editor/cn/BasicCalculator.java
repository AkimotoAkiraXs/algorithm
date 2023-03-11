package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;224 <br/>
 * Name：基本计算器 <br/>
 * <p>此题力扣官方是通过巧妙地控制正负号的方式按顺序对表达式中数字进行加减（因为没有乘除），
 * 但是比较标准的通用解题方式应该是转逆波兰表达式后用辅助栈求值，这也是表达式题型的通用解
 *
 * <p>参考：{@link algorithm.ReversePolishNotation 逆波兰表达式}
 *
 * @author Yuri
 * @see <a href="https://leetcode.cn/problems/basic-calculator/solution/ji-ben-ji-suan-qi-by-leetcode-solution-jvir/">力扣官方题解：控制正负号</a>
 * @since 2023-03-11 08:18:44
 */

public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
        int calculate = solution.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 此题力扣官方题解是通过控制正负号号来做的
        public int calculate(String s) {
            Deque<Integer> nums = new LinkedList<>();
            Deque<Integer> ops = new LinkedList<>();
/*
            // 预处理
            s = s.replace(" ", "");
            s = s.replace("[", "(");
            s = s.replace("]", ")");
            s = s.replace("{", "(");
            s = s.replace("}", ")");
*/
            int res = 0;
            ops.add(1);
            int sign = 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '+') sign = ops.peekLast();
                else if (c == '-') sign = -ops.peekLast();
                else if (c == '(') ops.add(sign);
                else if (c == ')') ops.pollLast();
                else if (Character.isDigit(c)) {
                    int num = (c - '0');
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        c = s.charAt(++i);
                        num = num * 10 + (c - '0');
                    }
                    res += sign * num;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
