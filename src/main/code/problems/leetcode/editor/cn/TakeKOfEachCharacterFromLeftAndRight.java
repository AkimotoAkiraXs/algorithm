// You are given a string s consisting of the characters 'a', 'b', and 'c' and a
// non-negative integer k. Each minute, you may take either the leftmost character
// of s, or the rightmost character of s.
//
// Return the minimum number of minutes needed for you to take at least k of 
// each character, or return -1 if it is not possible to take k of each character.
//
// 
// Example 1: 
//
// 
// Input: s = "aabaaaacaabc", k = 2
// Output: 8
// Explanation:
// Take three characters from the left of s. You now have two 'a' characters,
// and one 'b' character.
// Take five characters from the right of s. You now have four 'a' characters,
// two 'b' characters, and two 'c' characters.
// A total of 3 + 5 = 8 minutes is needed.
// It can be proven that 8 is the minimum number of minutes needed.
// 
//
// Example 2: 
//
// 
// Input: s = "a", k = 1
// Output: -1
// Explanation: It is not possible to take one 'b' or 'c' so return -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only the letters 'a', 'b', and 'c'. 
// 0 <= k <= s.length 
// 
//
// 👍 39 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2516
 * <p>
 * Name：Take K of Each Character From Left and Right
 *
 * @author Yuri
 * @since 2024-04-30 14:24:42
 */

public class TakeKOfEachCharacterFromLeftAndRight {

    public static void main(String[] args) {
        Solution solution = new TakeKOfEachCharacterFromLeftAndRight().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 正难则返，问题转换为求每个字母不大于cnt[i]-k的窗口最大值，cnt[i]表示字符串原本该字母数量
         */
        public int takeCharacters(String s, int k) {
            int n = s.length();
            char[] cs = s.toCharArray();
            int[] limit = new int[3];
            for (Character c : cs) limit[c - 'a']++;
            for (int i = 0; i < limit.length; i++) {
                if (limit[i] < k) return -1;
                else limit[i] -= k;
            }
            int[] cnt = new int[3];
            int max = 0;
            for (int r = 0, l = 0; r < n; r++) {
                int i = cs[r] - 'a';
                cnt[i]++;
                while (cnt[i] > limit[i]) cnt[cs[l++] - 'a']--;
                max = Math.max(max, r - l + 1);
            }
            return n - max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}