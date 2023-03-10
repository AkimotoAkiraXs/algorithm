package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * Id：&emsp;&emsp;150 <br/>
 * Name：逆波兰表达式求值 <br/>
 *
 * @author Yuri
 * @since 2023-03-10 13:56:54
 */

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
        solution.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (String token : tokens) {
                if (Objects.equals(token, "+")) {
                    Integer a = stack.pollLast();
                    Integer b = stack.pollLast();
                    stack.add(a + b);
                } else if (Objects.equals(token, "-")) {
                    Integer a = stack.pollLast();
                    Integer b = stack.pollLast();
                    stack.add(b - a);
                } else if (Objects.equals(token, "/")) {
                    Integer a = stack.pollLast();
                    Integer b = stack.pollLast();
                    stack.add(b / a);
                } else if (Objects.equals(token, "*")) {
                    Integer a = stack.pollLast();
                    Integer b = stack.pollLast();
                    stack.add(a * b);
                } else stack.add(Integer.valueOf(token));
            }
            return stack.pollLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
