// Given a string s consisting only of characters a, b and c.
//
// Return the number of substrings containing at least one occurrence of all 
// these characters a, b and c.
//
// 
// Example 1: 
//
// 
// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the
// characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc",
//"cab", "cabc" and "abc" (again). 
// 
//
// Example 2: 
//
// 
// Input: s = "aaacb"
// Output: 3
// Explanation: The substrings containing at least one occurrence of the
// characters a, b and c are "aaacb", "aacb" and "acb".
// 
//
// Example 3: 
//
// 
// Input: s = "abc"
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 3 <= s.length <= 5 x 10^4 
// s only consists of a, b or c characters. 
// 
//
// 👍 110 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1358
 * <p>
 * Name：Number of Substrings Containing All Three Characters
 *
 * @author Yuri
 * @since 2024-05-11 17:08:27
 */

public class NumberOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {
        Solution solution = new NumberOfSubstringsContainingAllThreeCharacters().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numberOfSubstrings(String s) {
            char[] cs = s.toCharArray();
            int n = cs.length;
            int[] cnt = new int[3];
            int res = 0;
            for (int l = 0, r = 0; r < n; r++) {
                cnt[cs[r] - 'a']++;
                while (judge(cnt)){
                    res += n - r;
                    cnt[cs[l++] - 'a']--;
                }
            }
            return res;
        }

        private boolean judge(int[] cnt) {
            for (int i = 0; i < 3; i++) if (cnt[i] == 0) return false;
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}