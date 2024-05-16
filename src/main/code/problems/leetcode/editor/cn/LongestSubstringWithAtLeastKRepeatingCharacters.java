// Given a string s and an integer k, return the length of the longest substring
// of s such that the frequency of each character in this substring is greater
// than or equal to k.
//
// if no such substring exists, return 0. 
//
// 
// Example 1: 
//
// 
// Input: s = "aaabb", k = 3
// Output: 3
// Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
// 
//
// Example 2: 
//
// 
// Input: s = "ababbc", k = 2
// Output: 5
// Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and
//'b' is repeated 3 times.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of only lowercase English letters. 
// 1 <= k <= 10⁵ 
// 
//
// 👍 891 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;395
 * <p>
 * Name：Longest Substring with At Least K Repeating Characters
 *
 * @author Yuri
 * @since 2024-05-14 17:51:06
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 滑动窗口，通过题意，限制窗口内的字符种类来调动左指针的滑动
        public int longestSubstring(String s, int k) {
            int n = s.length();
            char[] cs = s.toCharArray();
            int max =0;
            for (int i = 1; i <= 26; i++) {
                int[] cnt = new int[128];
                int tot = 0, sum = 0;
                for (int l = 0, r = 0; r < n; r++) {
                    cnt[cs[r]]++;
                    if (cnt[cs[r]] == 1) tot++;
                    if (cnt[cs[r]] == k) sum++;
                    while (tot > i) {
                        if (cnt[cs[l]] == 1) tot--;
                        if (cnt[cs[l]] == k) sum--;
                        cnt[cs[l++]]--;
                    }
                    if (tot == sum) max = Math.max(max, r - l + 1);
                }
            }
            return max;
        }

        // 分治法
        public int longestSubstring_(String s, int k) {
            int[] cnt = new int[26];
            char[] cs = s.toCharArray();
            for (Character c : cs) cnt[c - 'a']++;
            for (int i = 0; i < s.length(); i++) {
                if (cnt[cs[i] - 'a'] < k) {
                    int x = longestSubstring(s.substring(0, i), k), y = longestSubstring(s.substring(i + 1), k);
                    return Math.max(x, y);
                }
            }
            return s.length();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}