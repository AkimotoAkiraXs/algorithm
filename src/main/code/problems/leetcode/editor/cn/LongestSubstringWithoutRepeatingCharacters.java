// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
// 输入: s = "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
// 输入: s = "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
// 输入: s = "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
// 输入: s = ""
// 输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 6171 👎 0


/*
 * Id：3
 * Name：无重复字符的最长子串
 * Date：2021-09-28 13:58:55
 */
package problems.leetcode.editor.cn;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("dvdf");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            char[] cs = s.toCharArray();
            int[] cnt = new int[128];
            int n = cs.length;
            int l = 0, max = 0;
            for (int r = 0; r < n; r++) {
                cnt[cs[r]]++;
                while (cnt[cs[r]] > 1) cnt[cs[l++]]--;
                max = Math.max(max, r - l + 1);
            }
            return max;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
} 