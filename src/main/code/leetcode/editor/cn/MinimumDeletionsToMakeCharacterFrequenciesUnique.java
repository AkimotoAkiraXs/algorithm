//如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。 
//
// 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。 
//
// 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：0
//解释：s 已经是优质字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "aaabbbcc"
//输出：2
//解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
//另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。 
//
// 示例 3： 
//
// 
//输入：s = "ceabaacb"
//输出：2
//解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
//注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s 仅含小写英文字母 
// 
// Related Topics 贪心算法 排序 
// 👍 24 👎 0


/*
 * Id：1647
 * Name：字符频次唯一的最小删除次数
 * Date：2021-06-22 15:29:15
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        Solution solution = new MinimumDeletionsToMakeCharacterFrequenciesUnique().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDeletions(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 'a'; i <= 'z'; i++) {
                map.put((char) i, 0);
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.get(c) + 1);
            }
            List<Integer> n = new ArrayList<>(map.values());
            for (int i = 0; i < 26; i++) {
                n.remove((Object) 0);
            }
            n.sort((o1, o2) -> o2 - o1);
            int ans = 0;
            for (int i = 1; i < n.size(); i++) {
                while (n.get(i) >= n.get(i - 1) && n.get(i) > 0) {
                    ans++;
                    n.set(i, n.get(i) - 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 