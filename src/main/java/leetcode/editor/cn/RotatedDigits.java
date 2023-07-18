// An integer x is a good if after rotating each digit individually by 180
// degrees, we get a valid number that is different from x. Each digit must be rotated -
// we cannot choose to leave it alone.
//
// A number is valid if each digit remains a digit after rotation. For example: 
//
//
// 
// 0, 1, and 8 rotate to themselves, 
// 2 and 5 rotate to each other (in this case they are rotated in a different 
// direction, in other words, 2 or 5 gets mirrored),
// 6 and 9 rotate to each other, and 
// the rest of the numbers do not rotate to any other number and become invalid.
// 
// 
//
// Given an integer n, return the number of good integers in the range [1, n]. 
//
// 
// Example 1: 
//
// 
// Input: n = 10
// Output: 4
// Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
// Note that 1 and 10 are not good numbers, since they remain unchanged after
// rotating.
// 
//
// Example 2: 
//
// 
// Input: n = 1
// Output: 0
// 
//
// Example 3: 
//
// 
// Input: n = 2
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// 👍 202 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;788
 * <p>
 * Name：Rotated Digits
 *
 * @author Yuri
 * @since 2023-07-18 15:32:52
 */


public class RotatedDigits {
    public static void main(String[] args) {
        Solution solution = new RotatedDigits().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 0 1 8
        // 2 5 6 9
        int[][] dp;
        char[] chars;
        int len;
        int[] vis = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

        public int rotatedDigits(int n) {
            String s = String.valueOf(n);
            len = s.length();
            chars = s.toCharArray();
            dp = new int[len][2];
            for (int i = 0; i < len; i++) Arrays.fill(dp[i], -1);
            return dfs(0, 0, true, false);
        }

        // 此题不用管isNum，因为000这种情况并没有包含必须得2569，不会被计算
        int dfs(int i, int j, boolean limit, boolean isNum) {
            if (i == len) return j;
            if (!limit && dp[i][j] >= 0) return dp[i][j];
            int res = 0;
            for (int k = 0; k <= (limit ? chars[i] - '0' : 9); k++) {
                if (vis[k] == -1) continue;
                res += dfs(i + 1, j == 0 ? vis[k] : j, limit && k == chars[i] - '0', true);
            }
            if (!limit) dp[i][j] = res;
            return res;
        }

        // 暴力
        public int rotatedDigits_BF(int n) {
            int res = 0;
            Set<Integer> able = Stream.of(0, 1, 8).collect(Collectors.toSet());
            Set<Integer> must = Stream.of(2, 5, 6, 9).collect(Collectors.toSet());
            next:
            for (int i = 1; i <= n; i++) {
                boolean flag = false;
                String s = String.valueOf(i);
                for (char c : s.toCharArray()) {
                    int k = c - '0';
                    if (must.contains(k)) flag = true;
                    else if (!able.contains(k)) continue next;
                }
                if (flag) res++;
            }
            return res;
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

} 
