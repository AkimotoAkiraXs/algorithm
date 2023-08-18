//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1984 👎 0


package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;17
 * <p>
 * Name：电话号码的字母组合
 *
 * @author Yuri
 * @since 2022-07-06 11:50:55
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] strings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        String str;

        public List<String> letterCombinations(String digits) {
            if (digits.length() != 0) {
                str = digits;
                dfs(0, new StringBuilder());
            }
            return ans;
        }

        void dfs(int index, StringBuilder res) {
            if (index == str.length()) {
                ans.add(res.toString());
                return;
            }
            int k = str.charAt(index) - '0';
            String string = strings[k];
            for (int j = 0; j < string.length(); j++) {
                res.append(string.charAt(j));
                dfs(index + 1, res);
                res.deleteCharAt(res.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}