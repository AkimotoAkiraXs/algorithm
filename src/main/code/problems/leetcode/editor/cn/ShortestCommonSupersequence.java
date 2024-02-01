// Given two strings str1 and str2, return the shortest string that has both str1
// and str2 as subsequences. If there are multiple valid strings, return any of 
// them.
//
// A string s is a subsequence of string t if deleting some number of 
// characters from t (possibly 0) results in the string s.
//
// 
// Example 1: 
//
// 
// Input: str1 = "abac", str2 = "cab"
// Output: "cabac"
// Explanation:
// str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
//
// str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
// The answer provided is the shortest such string that satisfies these
// properties.
// 
//
// Example 2: 
//
// 
// Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
// Output: "aaaaaaaa"
// 
//
// 
// Constraints: 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 and str2 consist of lowercase English letters. 
// 
//
// 👍 246 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1092
 * <p>
 * Name：Shortest Common Supersequence
 *
 * @author Yuri
 * @since 2024-02-01 11:36:00
 */

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        Solution solution = new ShortestCommonSupersequence().new Solution();

        solution.shortestCommonSupersequence("bbbaaaba", "bbababbb");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // abac cab
        public String shortestCommonSupersequence(String str1, String str2) {
            int m = str1.length();
            int n = str2.length();
            char[] a = str1.toCharArray();
            char[] b = str2.toCharArray();

            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) dp[i][0] = i;
            for (int j = 1; j <= n; j++) dp[0][j] = j;

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }

            int min = dp[m][n];
            char[] ans = new char[min];
            for (int i = m, j = n, k = min; ; ) {
                if (i == 0) {
                    System.arraycopy(b, 0, ans, 0, j);
                    break;
                }
                if (j == 0) {
                    System.arraycopy(a, 0, ans, 0, i);
                    break;
                }
                if (a[i - 1] == b[j - 1]) { // 不能用dp[i][j] == dp[i - 1][j - 1] + 1
                    i--;
                    j--;
                    ans[--k] = a[i];
                } else if (dp[i][j] == dp[i - 1][j] + 1) ans[--k] = a[--i];
                else ans[--k] = b[--j];
            }
            return new String(ans);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}