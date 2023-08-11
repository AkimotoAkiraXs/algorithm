// Given a string containing just the characters '(' and ')', return the length
// of the longest valid (well-formed) parentheses substring.
//
// 
// Example 1: 
//
// 
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
// Input: s = ""
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] is '(', or ')'. 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2275 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;32
 * <p>
 * Name：Longest Valid Parentheses
 *
 * @author Yuri
 * @since 2023-06-02 16:03:14
 */


public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        solution.longestValidParentheses("()(())");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * Dp：dp[i]表示位置i处所匹配到的有效括号数
         * <p>
         * 忽略第一个符号，从index_1开始进行匹配
         */
        public int longestValidParentheses(String s) {
            int n = s.length();
            int[] dp = new int[n];
            int max = 0;
            for (int i = 1; i < n; i++) {
                char c = s.charAt(i);
                if (c == ')') {
                    if (s.charAt(i - 1) == '(') dp[i] = i > 1 ? dp[i - 2] + 2 : 2; // 遇到 xxx()情况，dp[i-2]代表前面匹配到的有效括号
                    else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') // 遇到 xxx))情况，dp[i-1]表示前一个)的有效括号数，i-dp[i-1]可以追到其对应的 ( 位置
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0);
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }

        /**
         * 栈 o(n)
         * <p>
         * 始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，栈里其他元素维护左括号的下标
         * <p>
         * 如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈底，这样就不满足提及的「最后一个没有被匹配的右括号的下标」，
         * 为了保持统一，我们在一开始的时候往栈中放入一个值为 −1 的元素
         */
        public int longestValidParentheses_Stack(String s) {
            int maxans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') stack.push(i);
                else {
                    stack.pop();
                    if (stack.isEmpty()) stack.push(i);
                    else maxans = Math.max(maxans, i - stack.peek());
                }
            }
            return maxans;
        }

        // self 栈 o(2n)
        public int longestValidParentheses_SelfStack(String s) {
            Deque<Integer> deque = new LinkedList<>();
            int n = s.length();
            boolean[] vis = new boolean[n];
            int max = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '(') deque.add(i);
                else if (deque.size() > 0) {
                    Integer num = deque.removeLast();
                    vis[num] = true;
                    vis[i] = true;
                }
            }
            for (int i = 0; i < n; i++) {
                if (vis[i]) max = Math.max(max, ++cnt);
                else cnt = 0;
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
