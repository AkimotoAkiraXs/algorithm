// You are given a binary string s consisting only of zeroes and ones.
//
// A substring of s is considered balanced if all zeroes are before ones and 
// the number of zeroes is equal to the number of ones inside the substring. Notice
// that the empty substring is considered a balanced substring.
//
// Return the length of the longest balanced substring of s. 
//
// A substring is a contiguous sequence of characters within a string. 
//
// 
// Example 1: 
//
// 
// Input: s = "01000111"
// Output: 6
// Explanation: The longest balanced substring is "000111", which has length 6.
// 
//
// Example 2: 
//
// 
// Input: s = "00111"
// Output: 4
// Explanation: The longest balanced substring is "0011", which has length 4. 
// 
//
// Example 3: 
//
// 
// Input: s = "111"
// Output: 0
// Explanation: There is no balanced substring except the empty substring, so
// the answer is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 50 
// '0' <= s[i] <= '1' 
// 
//
// 👍 68 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2609
 * <p>
 * Name：Find the Longest Balanced Substring of a Binary String
 *
 * @author Yuri
 * @since 2023-11-08 18:46:27
 */

public class FindTheLongestBalancedSubstringOfABinaryString {

    public static void main(String[] args) {
        Solution solution = new FindTheLongestBalancedSubstringOfABinaryString().new Solution();
        solution.findTheLongestBalancedSubstring("010");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findTheLongestBalancedSubstring(String s) {
            int i = 0, n = s.length(), max = 0;
            while (i < n) {
                int a = 0, b = 0;
                while (i < n && s.charAt(i) == '0' && ++a > 0) i++;
                while (i < n && s.charAt(i) == '1' && ++b > 0) i++;
                max = Math.max(max, Math.min(a, b) * 2);
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}