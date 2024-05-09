// Given two strings s and t of lengths m and n respectively, return the minimum
// window substring of s such that every character in t (including duplicates) is
// included in the window. If there is no such substring, return the empty string
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// 
// Example 1: 
//
// 
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
// from string t.
// 
//
// Example 2: 
//
// 
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
//
// 👍 2896 👎 0

package problems.leetcode.editor.cn;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;76
 * <p>
 * Name：Minimum Window Substring
 *
 * @author Yuri
 * @since 2024-05-09 15:58:40
 */

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String minWindow(String s, String t) {
            int n = s.length();
            char[] cs = s.toCharArray();
            Set<Character> hash = t.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
            int[] cnt = new int[128];
            int ct = 0;
            String ans = "";
            for (Character c : t.toCharArray()) if (cnt[c]++ == 0 && hash.contains(c)) ct++;
            for (int l = 0, r = 0; r < n; r++) {
                if (!hash.contains(cs[r])) continue;
                cnt[cs[r]]--;
                if (cnt[cs[r]] == 0) ct--;
                while (ct == 0) {
                    if (ans.isEmpty() || ans.length() > r - l + 1) ans = s.substring(l, r + 1);
                    if (hash.contains(cs[l]) && cnt[cs[l]]++ == 0) ct++;
                    l++;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}