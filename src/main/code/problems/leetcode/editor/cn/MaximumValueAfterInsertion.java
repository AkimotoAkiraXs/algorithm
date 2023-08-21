// You are given a very large integer n, represented as a string, and an integer
// digit x. The digits in n and the digit x are in the inclusive range [1, 9], and
// n may represent a negative number.
//
// You want to maximize n's numerical value by inserting x anywhere in the 
// decimal representation of n. You cannot insert x to the left of the negative sign.
//
// 
// For example, if n = 73 and x = 6, it would be best to insert it between 7 
// and 3, making n = 763.
// If n = -55 and x = 2, it would be best to insert it before the first 5, 
// making n = -255.
// 
//
// Return a string representing the maximum value of n after the insertion. 
//
// 
// Example 1: 
//
// 
// Input: n = "99", x = 9
// Output: "999"
// Explanation: The result is the same regardless of where you insert 9.
// 
//
// Example 2: 
//
// 
// Input: n = "-13", x = 2
// Output: "-123"
// Explanation: You can make n one of {-213, -123, -132}, and the largest of
// those three is -123.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n.length <= 10⁵ 
// 1 <= x <= 9 
// The digits in n are in the range [1, 9]. 
// n is a valid representation of an integer. 
// In the case of a negative n, it will begin with '-'. 
// 
//
// 👍 20 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1881
 * <p>
 * Name：Maximum Value after Insertion
 *
 * @author Yuri
 * @since 2023-08-21 18:15:05
 */


public class MaximumValueAfterInsertion {
    public static void main(String[] args) {
        Solution solution = new MaximumValueAfterInsertion().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maxValue(String n, int x) {
            StringBuilder sb = new StringBuilder(n);
            boolean neg = n.startsWith("-");
            int i;
            if (neg) {
                i = 0;
                while (++i < n.length()) if (x < n.charAt(i) - '0') break;
            } else {
                i = -1;
                while (++i < n.length()) if (x > n.charAt(i) - '0') break;
            }
            return sb.insert(i, x).toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
