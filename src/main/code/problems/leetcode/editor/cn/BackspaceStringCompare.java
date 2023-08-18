//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
// Related Topics 栈 双指针 字符串 模拟 👍 407 👎 0


package problems.leetcode.editor.cn;

import java.util.Stack;

/**
 * Id：&emsp;&emsp;844
 * <p>
 * Name：比较含退格的字符串
 * <p>
 * Reflection：除了栈思想外还可以用双指针，从后往前比较每个字符串，不相符则跳出false
 * 遇到'#'则计数往后抵消字符直至'#’为0后继续比较
 *
 * @author Yuri
 * @since 2022-04-14 16:49:27
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 栈
        public boolean backspaceCompare(String s, String t) {
            Stack<Character> a = deal(s);
            Stack<Character> b = deal(t);
            return a.equals(b);
        }

        private Stack<Character> deal(String s) {
            Stack<Character> res = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '#') {
                    res.add(c);
                } else if (!res.isEmpty()) {
                    res.pop();
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}