// You are given a positive integer n.
//
// A binary string x is valid if all substrings of x of length 2 contain at 
// least one "1".
//
// Return all valid strings with length n, in any order. 
//
// 
// Example 1: 
//
// 
// Input: n = 3 
// 
//
// Output: ["010","011","101","110","111"] 
//
// Explanation: 
//
// The valid strings of length 3 are: "010", "011", "101", "110", and "111". 
//
// Example 2: 
//
// 
// Input: n = 1 
// 
//
// Output: ["0","1"] 
//
// Explanation: 
//
// The valid strings of length 1 are: "0" and "1". 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 18 
// 
//
// 👍 3 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;3211
 * <p>
 * Name：Generate Binary Strings Without Adjacent Zeros
 *
 * @author Yuri
 * @since 2024-08-02 17:56:20
 */

public class GenerateBinaryStringsWithoutAdjacentZeros {

    public static void main(String[] args) {
        Solution solution = new GenerateBinaryStringsWithoutAdjacentZeros().new Solution();
        solution.validStrings(3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> validStrings(int n) {
            List<String> ans = new ArrayList<>();
            dfs(ans, "", n);
            return ans;
        }

        void dfs(List<String> ans, String str, int n) {
            int len = str.length();
            if (len == n) {
                ans.add(str);
                return;
            }
            dfs(ans, str + "1", n);
            if (len == 0 || str.charAt(len - 1) != '0') dfs(ans, str + "0", n);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}