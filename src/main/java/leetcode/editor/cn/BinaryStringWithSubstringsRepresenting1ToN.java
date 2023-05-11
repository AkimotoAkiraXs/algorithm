// Given a binary string s and a positive integer n, return true if the binary
// representation of all the integers in the range [1, n] are substrings of s, or
// false otherwise.
//
// A substring is a contiguous sequence of characters within a string. 
//
// 
// Example 1: 
// Input: s = "0110", n = 3
// Output: true
// 
// Example 2: 
// Input: s = "0110", n = 4
// Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s[i] is either '0' or '1'. 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 字符串 👍 90 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1016
 * <p>
 * Name：Binary String With Substrings Representing 1 To N
 *
 * @author Yuri
 * @since 2023-05-11 15:17:44
 */


public class BinaryStringWithSubstringsRepresenting1ToN {
    public static void main(String[] args) {
        Solution solution = new BinaryStringWithSubstringsRepresenting1ToN().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean queryString(String s, int n) {
            int k = n;
            while ((k & (k - 1)) != 0) k &= k - 1;
            k = Math.max(1, k / 2);
            for (; k <= n; k++) if (!s.contains(Integer.toBinaryString(k))) return false;
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
