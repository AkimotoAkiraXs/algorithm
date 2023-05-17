// An attendance record for a student can be represented as a string where each
// character signifies whether the student was absent, late, or present on that day.
// The record only contains the following three characters: 
//
// 
// 'A': Absent. 
// 'L': Late. 
// 'P': Present. 
// 
//
// Any student is eligible for an attendance award if they meet both of the 
// following criteria:
//
// 
// The student was absent ('A') for strictly fewer than 2 days total. 
// The student was never late ('L') for 3 or more consecutive days. 
// 
//
// Given an integer n, return the number of possible attendance records of 
// length n that make a student eligible for an attendance award. The answer may be
// very large, so return it modulo 10⁹ + 7.
//
// 
// Example 1: 
//
// 
// Input: n = 2
// Output: 8
// Explanation: There are 8 records with length 2 that are eligible for an award:
//
//"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
// Only "AA" is not eligible because there are 2 absences (there need to be
// fewer than 2).
// 
//
// Example 2: 
//
// 
// Input: n = 1
// Output: 3
// 
//
// Example 3: 
//
// 
// Input: n = 10101
// Output: 183236316
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 动态规划 👍 294 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;552
 * <p>
 * Name：Student Attendance Record II
 *
 * @author Yuri
 * @since 2023-05-12 18:14:27
 */


public class StudentAttendanceRecordIi {
    public static void main(String[] args) {
        Solution solution = new StudentAttendanceRecordIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int checkRecord(int n) {
            final double mod = 10e8 + 7;
            double[] dp = new double[n + 3];
            double[] dpNa = new double[n + 3];
            dp[0] = 1;
            dp[1] = 3;
            dp[2] = 8;
            dp[3] = 19;
            dpNa[0] = 1;
            dpNa[1] = 2;
            dpNa[2] = 4;
            dpNa[3] = 7;
            for (int i = 4; i <= n; i++) {
                dp[i] = ((2 * dp[i - 1] + dpNa[i - 1] - dp[i - 4] - dpNa[i - 4]) % mod + mod) % mod;
                dpNa[i] = ((2 * dpNa[i - 1] - dpNa[i - 4]) % mod + mod) % mod;
            }
            return (int) (dp[n] % mod);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
