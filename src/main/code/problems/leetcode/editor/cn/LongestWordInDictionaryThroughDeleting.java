//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
//
// Related Topics 数组 双指针 字符串 排序 👍 319 👎 0

package problems.leetcode.editor.cn;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;524
 * <p>
 * Name：通过删除字母匹配到字典里最长单词
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        System.out.println(solution.findLongestWord("aewfafwafjlwajflwajflwafj", Lists.newArrayList(
                "apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf"
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            List<String> ans = new ArrayList<>();
            ans.add("");
            dictionary = dictionary.stream().sorted((a, b) -> {
                if (a.length() == b.length()) return a.compareTo(b);
                return b.length() - a.length();
            }).collect(Collectors.toList());
            for (String str : dictionary) {
                int index = 0;
                int i;
                for (i = 0; i < str.length() && index < s.length(); ) {
                    while (index < s.length() && str.charAt(i) != s.charAt(index)) index++;
                    if (index < s.length()) {
                        i++;
                        index++;
                    }
                }
                if (i == str.length()) return str;
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}