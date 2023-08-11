package leetcode.editor.cn;

import java.util.Stack;

/**
 * Id：&emsp;&emsp;20 <br/>
 * Name：有效的括号 <br/>
 *
 * @author Yuri
 * @since 2023-03-08 11:36:56
 */

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (Character c : s.toCharArray()) {
                if (c == '[' || c == '{' || c == '(') stack.add(c);
                else if (stack.isEmpty()) return false;
                else {
                    Character left = stack.pop();
                    if (!((left == '(' && c == ')') || (left == '[' && c == ']') || (left == '{' && c == '}')))
                        return false;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
