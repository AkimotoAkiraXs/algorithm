//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 336 👎 0


/*
 * Id：剑指 Offer 38
 * Name：字符串的排列
 * Date：2021-06-22 15:38:36
 */
package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<StringBuilder> insert(Character character, List<StringBuilder> temp) {
            List<StringBuilder> str = new ArrayList<>();
            temp.forEach(item -> {
                for (int i = 0; i <= item.length(); i++) {
                    StringBuilder sb = new StringBuilder(item);
                    sb.insert(i, character);
                    str.add(sb);
                }
            });
            return str;
        }

        public String[] permutation(String s) {
            List<StringBuilder> temp = new ArrayList<>();
            Set<String> res = new HashSet<>();
            if (s.length() != 0) {
                temp.add(new StringBuilder(Character.toString(s.charAt(0))));
            }
            for (int i = 1; i < s.length(); i++) {
                temp = insert(s.charAt(i), temp);
            }
            temp.stream().distinct().forEach(item -> {
                res.add(item.toString());
            });
            return res.toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 