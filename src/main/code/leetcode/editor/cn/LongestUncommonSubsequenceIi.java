//给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。 
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。 
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。 
//
// 
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括
//"aebdc"、 "aeb" 和 "" (空字符串)。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: strs = ["aba","cdc","eae"]
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] 只包含小写英文字母 
// 
//
// Related Topics 数组 哈希表 双指针 字符串 排序 👍 170 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;522
 * <p>
 * Name：最长特殊序列 II
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class LongestUncommonSubsequenceIi {
    public static void main(String[] args) {
        Solution solution = new LongestUncommonSubsequenceIi().new Solution();
        System.out.println(solution.findLUSlength(new String[]{
                "aba", "cdc", "eae", "ad", "a", "dasd"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            List<String> strings = Arrays.stream(strs).sorted((a, b) -> {
                if (a.length() == b.length()) return a.compareTo(b);
                return b.length() - a.length();
            }).collect(Collectors.toList());

            for (int i = 0; i < strings.size(); i++) {
                boolean flag = true;
                for (int j = 0; j < strings.size(); j++) {
                    if (i == j) continue;
                    if (strings.get(i).equals(strings.get(j))) {
                        flag = false;
                        break;
                    }
                    if (strings.get(i).length() > strings.get(j).length()) break;
                    else if (check(strings.get(i), strings.get(j))){
                        flag = false;
                        break;
                    }
                }
                if (flag) return strings.get(i).length();
            }
            return -1;
        }

        private boolean check(String s, String ss) {
            int a = 0, b = 0;
            while (a < s.length() && b < ss.length()) {
                if (s.charAt(a) == ss.charAt(b)) {
                    a++;
                    b++;
                } else {
                    b++;
                }
            }
            return a >= s.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}