//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2732 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;22
 * <p>
 * Name：括号生成
 *
 * @author Yuri
 * @since 2022-07-06 14:23:01
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            traceBack(n, n, new StringBuilder());
            return ans;
        }

        void traceBack(int l, int r, StringBuilder res) {
            if (r == 0) {
                ans.add(res.toString());
                return;
            }
            if (l > 0) {
                traceBack(l - 1, r, res.append("("));
                res.deleteCharAt(res.length() - 1);
            }
            if (r > 0 && l < r) {
                traceBack(l, r - 1, res.append(")"));
                res.deleteCharAt(res.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}