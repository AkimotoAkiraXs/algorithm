// Given the strings s1 and s2 of size n and the string evil, return the number
// of good strings.
//
// A good string has size n, it is alphabetically greater than or equal to s1, 
// it is alphabetically smaller than or equal to s2, and it does not contain the
// string evil as a substring. Since the answer can be a huge number, return this
// modulo 10⁹ + 7.
//
// 
// Example 1: 
//
// 
// Input: n = 2, s1 = "aa", s2 = "da", evil = "b"
// Output: 51
// Explanation: There are 25 good strings starting with 'a': "aa","ac","ad",...,
//"az". Then there are 25 good strings starting with 'c': "ca","cc","cd",...,"cz" 
// and finally there is one good string starting with 'd': "da". 
// 
//
// Example 2: 
//
// 
// Input: n = 8, s1 = "leetcode", s2 = "leetgoes", evil = "leet"
// Output: 0
// Explanation: All strings greater than or equal to s1 and smaller than or
// equal to s2 start with the prefix "leet", therefore, there is not any good string.
// 
//
// Example 3: 
//
// 
// Input: n = 2, s1 = "gx", s2 = "gz", evil = "x"
// Output: 2
// 
//
// 
// Constraints: 
//
// 
// s1.length == n 
// s2.length == n 
// s1 <= s2 
// 1 <= n <= 500 
// 1 <= evil.length <= 50 
// All strings consist of lowercase English letters. 
// 
//
// 👍 99 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1397
 * <p>
 * Name：Find All Good Strings
 *
 * @author Yuri
 * @since 2023-07-19 16:02:26
 */


public class FindAllGoodStrings {
    public static void main(String[] args) {
        Solution solution = new FindAllGoodStrings().new Solution();
        solution.findGoodStrings(2, "aa", "da", "b");
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这题三个难点：<br>
     * 1.要想清楚dp数组如何定义才有效（确定唯一状态）：此处dp[i][j]表示第i个字符且匹配上了j个evil中的字符，很明显可以确定唯一状态。 <br>
     * 2.当前字符不匹配时，需要进行回退，然后重算现在匹配上了几个字符，此时需要Kmp算法，极其考验对kmp的理解，此外kmp还需要变形做0开始的兼容。<br>
     * 3.因为有模，所以长-短求中间的方式来求答案是行不通的，这考验经验。然后定义下限limit其实和上限limit处理几乎一样也很考验理解。
     */
    class Solution {

        int MOD = (int) 1e9 + 7;
        int[][] dp;
        int[] next;
        int len, n;
        char[] es;
        char[] cs1;
        char[] cs2;

        public int findGoodStrings(int n, String s1, String s2, String evil) {
            this.n = n;
            len = evil.length();
            es = evil.toCharArray();
            cs1 = s1.toCharArray();
            cs2 = s2.toCharArray();

            next = new int[len];
            for (int i = 1, k = 0; i < len; i++) {
                while (k > 0 && es[k] != es[i]) k = next[k - 1];
                if (es[k] == es[i]) k++;
                next[i] = k;
            }
            dp = new int[n][len];
            for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
            return dfs(0, 0, true, true);
        }

        // 因为需要取模，所以不能用 长-短=中间的办法求答案，只能分别定义上限和下限
        int dfs(int i, int j, boolean downLimit, boolean upLimit) {
            if (j == len) return 0;
            if (i == n) return 1;
            if (!downLimit && !upLimit && dp[i][j] >= 0) return dp[i][j];
            long res = 0;
            char down = downLimit ? cs1[i] : 'a';
            char up = upLimit ? cs2[i] : 'z';
            for (char c = down; c <= up; c++) {
                int nj = j;
                while (nj > 0 && es[nj] != c) nj = next[nj - 1];
                if (nj == 0 && c != es[nj]) nj = -1;
                res = (res + dfs(i + 1, nj + 1, downLimit && c == down, upLimit && c == up)) % MOD;
            }
            if (!downLimit && !upLimit) dp[i][j] = (int) res;
            return (int) res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
