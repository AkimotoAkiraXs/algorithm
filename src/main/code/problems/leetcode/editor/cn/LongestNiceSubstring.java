// A string s is nice if, for every letter of the alphabet that s contains, it
// appears both in uppercase and lowercase. For example, "abABB" is nice because 'A'
// and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b'
// appears, but 'B' does not.
//
// Given a string s, return the longest substring of s that is nice. If there 
// are multiple, return the substring of the earliest occurrence. If there are none,
// return an empty string.
//
// 
// Example 1: 
//
// 
// Input: s = "YazaAay"
// Output: "aAa"
// Explanation: "aAa" is a nice string because 'A/a' is the only letter of the
// alphabet in s, and both 'A' and 'a' appear.
//"aAa" is the longest nice substring.
// 
//
// Example 2: 
//
// 
// Input: s = "Bb"
// Output: "Bb"
// Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole
// string is a substring.
// 
//
// Example 3: 
//
// 
// Input: s = "c"
// Output: ""
// Explanation: There are no nice substrings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of uppercase and lowercase English letters. 
// 
//
// 👍 232 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1763
 * <p>
 * Name：Longest Nice Substring
 *
 * @author Yuri
 * @since 2024-05-15 14:44:08
 */

public class LongestNiceSubstring {

    public static void main(String[] args) {
        Solution solution = new LongestNiceSubstring().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 滑动窗口：自己增加限制条件构造左指针移动
        public String longestNiceSubstring_(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            int[] res = new int[]{0, -1}; // r初始化-1避免未匹配命中时，res返回值
            for (int i = 1; i <= 26; i++) {
                int[] cnt = new int[128];
                int t = 0, u = 0;
                for (int l = 0, r = 0; r < n; r++) {
                    char rc = cs[r];
                    if (cnt[rc] == 0) {
                        if ((rc >= 'a' && cnt[rc - 32] == 0) || (rc <= 'Z' && cnt[rc + 32] == 0)) t++;
                        else if ((rc >= 'a' && cnt[rc - 32] > 0) || (rc <= 'Z' && cnt[rc + 32] > 0)) u++;
                    }
                    cnt[rc]++;
                    while (t > i) {
                        char lc = cs[l++];
                        if (cnt[lc] == 1) {
                            if ((lc >= 'a' && cnt[lc - 32] > 0) || (lc <= 'Z' && cnt[lc + 32] > 0)) u--;
                            else t--;
                        }
                        cnt[lc]--;
                    }
                    if (t == u && r - l > res[1] - res[0]) {
                        res[1] = r;
                        res[0] = l;
                    }
                }
            }
            return s.substring(res[0], res[1] + 1);
        }

        // 分治法
        public String longestNiceSubstring(String s) {
            for (int i = 0; i < s.length(); i++) {
                if ((s.charAt(i) >= 'a' && !s.contains(String.valueOf((char) (s.charAt(i) - 32))))
                    || s.charAt(i) <= 'Z' && !s.contains(String.valueOf((char) (s.charAt(i) + 32)))) {
                    String s1 = longestNiceSubstring(s.substring(0, i)), s2 = longestNiceSubstring(s.substring(i + 1));
                    return s1.length() >= s2.length() ? s1 : s2;
                }
            }
            return s;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}