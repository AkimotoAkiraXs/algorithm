// You are given two strings start and target, both of length n. Each string
// consists only of the characters 'L', 'R', and '_' where:
//
// 
// The characters 'L' and 'R' represent pieces, where a piece 'L' can move to 
// the left only if there is a blank space directly to its left, and a piece 'R' can
// move to the right only if there is a blank space directly to its right.
// The character '_' represents a blank space that can be occupied by any of 
// the 'L' or 'R' pieces.
// 
//
// Return true if it is possible to obtain the string target by moving the 
// pieces of the string start any number of times. Otherwise, return false.
//
// 
// Example 1: 
//
// 
// Input: start = "_L__R__R_", target = "L______RR"
// Output: true
// Explanation: We can obtain the string target from start by doing the
// following moves:
//- Move the first piece one step to the left, start becomes equal to "L___R__R_
//".
//- Move the last piece one step to the right, start becomes equal to "L___R___
// R".
//- Move the second piece three steps to the right, start becomes equal to "L___
//___RR".
// Since it is possible to get the string target from start, we return true.
// 
//
// Example 2: 
//
// 
// Input: start = "R_L_", target = "__LR"
// Output: false
// Explanation: The 'R' piece in the string start can move one step to the right
// to obtain "_RL_".
// After that, no pieces can move anymore, so it is impossible to obtain the
// string target from start.
// 
//
// Example 3: 
//
// 
// Input: start = "_R", target = "R_"
// Output: false
// Explanation: The piece in the string start can move only to the right, so it
// is impossible to obtain the string target from start.
//
// 
// Constraints: 
//
// 
// n == start.length == target.length 
// 1 <= n <= 10⁵ 
// start and target consist of the characters 'L', 'R', and '_'. 
// 
//
// 👍 99 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2337
 * <p>
 * Name：Move Pieces to Obtain a String
 *
 * @author Yuri
 * @since 2023-08-21 18:35:34
 */


public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        Solution solution = new MovePiecesToObtainAString().new Solution();
        solution.canChange("_L__R__R_", "L______RR");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canChange(String start, String target) {
            int n = start.length();
            int x = 0, y = 0;
            while (x < n || y < n) {
                while (x < n && start.charAt(x) == '_') x++;
                while (y < n && target.charAt(y) == '_') y++;
                if (x >= n || y >= n) return x >= n && y >= n;
                if (start.charAt(x) != target.charAt(y) || (x < y && start.charAt(x) == 'L') || (x > y && start.charAt(x) == 'R'))
                    return false;
                x++;
                y++;
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
