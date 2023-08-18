//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 
// 👍 313 👎 0


/*
 * Id：784
 * Name：字母大小写全排列
 * Date：2021-10-28 09:54:43
 */
package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String str;
        List<String> res = new ArrayList<>();

        public List<String> letterCasePermutation(String s) {
            str = s;
            dfs(new StringBuffer());
            return res;
        }

        void dfs(StringBuffer sb) {
            if (sb.length() == str.length()) {
                res.add(sb.toString());
                return;
            }
            char c = str.charAt(sb.length());
            sb.append(c);
            if (c >= 'a' && c <= 'z') {
                dfs(sb);
                sb.deleteCharAt(sb.length() - 1);
                sb.append((char) (c - 32));
            } else if (c >= 'A' && c <= 'Z') {
                dfs(sb);
                sb.deleteCharAt(sb.length() - 1);
                sb.append((char) (c + 32));
            }
            dfs(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 