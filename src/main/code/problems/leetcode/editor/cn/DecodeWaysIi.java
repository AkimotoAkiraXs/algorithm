// A message containing letters from A-Z can be encoded into numbers using the
// following mapping:
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// 
//
// To decode an encoded message, all the digits must be grouped then mapped 
// back into letters using the reverse of the mapping above (there may be multiple
// ways). For example, "11106" can be mapped into:
//
// 
// "AAJF" with the grouping (1 1 10 6) 
// "KJF" with the grouping (11 10 6) 
// 
//
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped 
// into 'F' since "6" is different from "06".
//
// In addition to the mapping above, an encoded message may contain the '*' 
// character, which can represent any digit from '1' to '9' ('0' is excluded). For
// example, the encoded message "1*" may represent any of the encoded messages "11", "1
// 2", "13", "14", "15", "16", "17", "18", or "19". Decoding "1*" is equivalent to
// decoding any of the encoded messages it can represent.
//
// Given a string s consisting of digits and '*' characters, return the number 
// of ways to decode it.
//
// Since the answer may be very large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
// Input: s = "*"
// Output: 9
// Explanation: The encoded message can represent any of the encoded messages "1
//", "2", "3", "4", "5", "6", "7", "8", or "9".
// Each of these can be decoded to the strings "A", "B", "C", "D", "E", "F", "G",
// "H", and "I" respectively.
// Hence, there are a total of 9 ways to decode "*".
// 
//
// Example 2: 
//
// 
// Input: s = "1*"
// Output: 18
// Explanation: The encoded message can represent any of the encoded messages "11
//", "12", "13", "14", "15", "16", "17", "18", or "19".
// Each of these encoded messages have 2 ways to be decoded (e.g. "11" can be
// decoded to "AA" or "K").
// Hence, there are a total of 9 * 2 = 18 ways to decode "1*".
// 
//
// Example 3: 
//
// 
// Input: s = "2*"
// Output: 15
// Explanation: The encoded message can represent any of the encoded messages "21
//", "22", "23", "24", "25", "26", "27", "28", or "29".
//"21", "22", "23", "24", "25", and "26" have 2 ways of being decoded, but "27",
// "28", and "29" only have 1 way.
// Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15 ways to decode "2*
//".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is a digit or '*'. 
// 
//
// Related Topics 字符串 动态规划 👍 211 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;639
 * <p>
 * Name：Decode Ways II
 *
 * @author Yuri
 * @since 2023-05-12 09:54:21
 */


public class DecodeWaysIi {
    public static void main(String[] args) {
        Solution solution = new DecodeWaysIi().new Solution();
        int i = solution.numDecodings("*0**0");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

/*
        // 又臭又长的枚举做法
        public int numDecodings(String s) {
            final double mod = 10e8 + 7;
            if (s.startsWith("0") || s.contains("00")) return 0;
            double[] dp = new double[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.startsWith("*") ? 9 : 1;
            for (int i = 2; i <= s.length(); i++) {
                String str = s.substring(i - 2, i);
                if (i < s.length() && s.charAt(i) == '0') {
                    if (s.charAt(i - 1) == '*') dp[i] = (dp[i - 1] * 2) % mod;
                    else dp[i] = dp[i - 1] % mod;
                } else if (str.equals("**")) {
                    dp[i] = (dp[i - 1] * 9 + dp[i - 2] * 15) % mod;
                } else if (str.equals("*0")) {
                    dp[i] = dp[i - 2] * 2 % mod;
                } else if (str.startsWith("*")) {
                    if ((str.charAt(1) - '0') < 7) dp[i] = (dp[i - 1] + dp[i - 2] * 2) % mod;
                    else dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
                } else if (str.endsWith("*")) {
                    if (str.equals("1*")) {
                        dp[i] = (dp[i - 1] * 9 + dp[i - 2] * 9) % mod;
                    } else if (str.equals("2*")) {
                        dp[i] = (dp[i - 1] * 9 + dp[i - 2] * 6) % mod;
                    } else {
                        dp[i] = dp[i - 1] * 9 % mod;
                    }
                } else {
                    int k = Integer.parseInt(str);
                    if (k > 26 && k % 10 == 0) return 0;
                    if (str.startsWith("0") || str.endsWith("0") || k > 26 || k < 1
                    ) {
                        dp[i] = dp[i - 1] % mod;
                    } else {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
                    }
                }
            }
            return (int) (dp[s.length()] % (mod));
        }
*/

        // 处理所有0的情况，比上面慢
        public int numDecodings(String s) {
            final double mod = 10e8 + 7;
            s = s.replace("*0", "B");
            s = s.replace("10", "A");
            s = s.replace("20", "A");
            if (s.contains("0")) return 0;
            double[] dp = new double[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.startsWith("*") ? 9 : s.startsWith("B") ? 2 : 1;
            for (int i = 2; i <= s.length(); i++) {
                String str = s.substring(i - 2, i);
                if (s.charAt(i - 1) == 'A') dp[i] = dp[i - 1];
                else if (s.charAt(i - 1) == 'B') dp[i] = dp[i - 1] * 2;
                else if (str.startsWith("A") || str.startsWith("B")) {
                    if (str.endsWith("*")) dp[i] = (dp[i - 1] * 9) % mod;
                    else dp[i] = dp[i - 1];
                } else if (str.equals("**")) dp[i] = (dp[i - 1] * 9 + dp[i - 2] * 15) % mod;
                else if (str.startsWith("*")) {
                    if ((str.charAt(1) - '0') < 7) dp[i] = (dp[i - 1] + dp[i - 2] * 2) % mod;
                    else dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
                } else if (str.endsWith("*")) {
                    if (str.equals("1*")) {
                        dp[i] = (dp[i - 1] * 9 + dp[i - 2] * 9) % mod;
                    } else if (str.equals("2*")) {
                        dp[i] = (dp[i - 1] * 9 + dp[i - 2] * 6) % mod;
                    } else {
                        dp[i] = dp[i - 1] * 9 % mod;
                    }
                } else {
                    int k = Integer.parseInt(str);
                    if (k > 26) dp[i] = dp[i - 1];
                    else dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
                }
            }
            return (int) dp[s.length()];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
