// You are given a string s that consists of lowercase English letters.
//
// A string is called special if it is made up of only a single character. For 
// example, the string "abc" is not special, whereas the strings "ddd", "zz", and
//"f" are special. 
//
// Return the length of the longest special substring of s which occurs at 
// least thrice, or -1 if no special substring occurs at least thrice.
//
// A substring is a contiguous non-empty sequence of characters within a string.
// 
//
// 
// Example 1: 
//
// 
// Input: s = "aaaa"
// Output: 2
// Explanation: The longest special substring which occurs thrice is "aa":
// substrings "aaaa", "aaaa", and "aaaa".
// It can be shown that the maximum length achievable is 2.
// 
//
// Example 2: 
//
// 
// Input: s = "abcdef"
// Output: -1
// Explanation: There exists no special substring which occurs at least thrice.
// Hence return -1.
// 
//
// Example 3: 
//
// 
// Input: s = "abcaba"
// Output: 1
// Explanation: The longest special substring which occurs thrice is "a":
// substrings "abcaba", "abcaba", and "abcaba".
// It can be shown that the maximum length achievable is 1.
// 
//
// 
// Constraints: 
//
// 
// 3 <= s.length <= 5 * 10⁵ 
// s consists of only lowercase English letters. 
// 
//
// 👍 30 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2982
 * <p>
 * Name：Find Longest Special Substring That Occurs Thrice II
 *
 * @author Yuri
 * @since 2024-08-27 10:44:44
 */

public class FindLongestSpecialSubstringThatOccursThriceIi {

    public static void main(String[] args) {
        Solution solution = new FindLongestSpecialSubstringThatOccursThriceIi().new Solution();
        solution.maximumLength("aaaa");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumLength(String s) {
            char[] cs = s.toCharArray();
            int l = 1, r = s.length() - 2;
            while (l <= r) {
                int m = l + r >> 1;
                int[] cnt = new int[26];
                boolean f = false;
                // 滑动窗口
                for (int i = 0, j = 0; i < cs.length; i++) {
                    while (j < i && cs[j] != cs[i]) j++;
                    if (i - j + 1 == m && ++cnt[cs[j++] - 'a'] == 3) {
                        f = true;
                        break;
                    }
                }
                if (f) l = m + 1;
                else r = m - 1;
            }
            return r == 0 ? -1 : r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}