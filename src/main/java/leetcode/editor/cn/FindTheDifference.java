//给定两个字符串 s 和 t ，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 
//输入：s = "", t = "y"
//输出："y"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
//
// Related Topics 位运算 哈希表 字符串 排序 👍 350 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;389
 * <p>
 * Name：找不同
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new FindTheDifference().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 位运算：将两个字符串合成一个，则一定存在某个字符有奇数个（其余全为偶数个），
         * 所以使用异或运算即可以得到该字符
         */
        public char findTheDifference(String s, String t) {
            int ret = t.charAt(0);
            for (int i = 0; i < s.length(); ++i) {
                ret ^= s.charAt(i);
                ret ^= t.charAt(i + 1);
            }
            return (char) ret;
        }

/*
        // ASCII求和
        public char findTheDifference(String s, String t) {
            int tot = -t.charAt(0);
            for (int i = 0; i < s.length(); ++i) {
                tot += s.charAt(i);
                tot -= t.charAt(i + 1);
            }
            return (char) (-tot);
        }
*/

 /*       // 暴力hash
        public char findTheDifference(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            }
            map.put(t.charAt(t.length() - 1), map.getOrDefault(t.charAt(t.length() - 1), 0) - 1);
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                if (entry.getValue() == -1) return entry.getKey();
            }
            return ' ';
        }
*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}