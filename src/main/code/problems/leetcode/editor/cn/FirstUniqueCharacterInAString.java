//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 601 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;387
 * <p>
 * Name：字符串中的第一个唯一字符
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        solution.firstUniqChar("loveleetcode");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 虽然慢，但优雅
        public int firstUniqChar(String s) {
            for(int i=0;i<s.length();i++){
                if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))){
                    return i;
                }
            }
            return -1;
        }

/*
        // 双循环
        public int firstUniqChar(String s) {
            int ans = Integer.MAX_VALUE;
            int[] ints = new int[26];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (ints[c - 'a'] == 0) {
                    ints[c - 'a'] = i + 1;
                } else {
                    ints[c - 'a'] = -1;
                }
            }

            for (int i : ints) {
                if (i != 0 && i != -1 && ans > i) {
                    ans = i;
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans - 1;
        }
*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}