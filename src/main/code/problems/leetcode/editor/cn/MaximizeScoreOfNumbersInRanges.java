// You are given an array of integers start and an integer d, representing n
// intervals [start[i], start[i] + d].
//
// You are asked to choose n integers where the iᵗʰ integer must belong to the 
// iᵗʰ interval. The score of the chosen integers is defined as the minimum
// absolute difference between any two integers that have been chosen.
//
// Return the maximum possible score of the chosen integers. 
//
// 
// Example 1: 
//
// 
// Input: start = [6,0,3], d = 2 
// 
//
// Output: 4 
//
// Explanation: 
//
// The maximum possible score can be obtained by choosing integers: 8, 0, and 4.
// The score of these chosen integers is min(|8 - 0|, |8 - 4|, |0 - 4|) which 
// equals 4.
//
// Example 2: 
//
// 
// Input: start = [2,6,13,13], d = 5 
// 
//
// Output: 5 
//
// Explanation: 
//
// The maximum possible score can be obtained by choosing integers: 2, 7, 13, 
// and 18. The score of these chosen integers is min(|2 - 7|, |2 - 13|, |2 - 18|, |7
//- 13|, |7 - 18|, |13 - 18|) which equals 5. 
//
// 
// Constraints: 
//
// 
// 2 <= start.length <= 10⁵ 
// 0 <= start[i] <= 10⁹ 
// 0 <= d <= 10⁹ 
// 
//
// 👍 11 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;3281
 * <p>
 * Name：Maximize Score of Numbers in Ranges
 *
 * @author Yuri
 * @since 2024-09-13 14:44:41
 */

public class MaximizeScoreOfNumbersInRanges {

    public static void main(String[] args) {
        Solution solution = new MaximizeScoreOfNumbersInRanges().new Solution();
        solution.maxPossibleScore(new int[]{0, 9, 2, 9}, 2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxPossibleScore(int[] start, int d) {
            int n = start.length;
            Arrays.sort(start);
            int l = 0, r = start[n - 1] - start[0] + d;
            out:
            while (l <= r) {
                int m = (r - l >> 1) + l;
                int cur = start[0];
                for (int i = 1; i < n; i++) {
                    int nex = start[i];
                    if (nex - cur < m) {
                        if (nex - cur + d < m) {
                            r = m - 1;
                            continue out;
                        }
                        cur += m;
                    } else cur = nex;
                }
                l = m + 1;
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}