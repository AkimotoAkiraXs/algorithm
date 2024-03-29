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
        solution.lengthOfLongestSubstring("aabaab!bb");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            int[] cnt = new int[127]; // ASCLL最大127
            int l = 0, ans = 0;
            for (int r = 0; r < n; r++) {
                while (cnt[chars[r]] > 0) cnt[chars[l++]]--;
                cnt[chars[r]]++;
                ans = Math.max(ans, r - l + 1);
            }
            return ans;
        }

        // 写成暴力了
        public int lengthOfLongestSubstring_(String s) {
            StringBuilder stringBuilder = new StringBuilder(s);
            StringBuilder str = new StringBuilder();
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = stringBuilder.charAt(i);
                int index = str.indexOf(String.valueOf(c));
                if (index != -1) {
                    str.delete(0, index + 1);
                }
                str.append(c);
                max = Math.max(max, str.length());
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
} 