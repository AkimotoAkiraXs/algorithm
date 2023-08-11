//The count-and-say sequence is a sequence of digit strings defined by the 
//recursive formula: 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) is the way you would "say" the digit string from countAndSay(
//n-1), which is then converted into a different digit string. 
// 
//
// To determine how you "say" a digit string, split it into the minimal number 
//of substrings such that each substring contains exactly one unique digit. Then 
//for each substring, say the number of digits, then say the digit. Finally, 
//concatenate every said digit. 
//
// For example, the saying and conversion for digit string "3322251": 
// 
// Given a positive integer n, return the nᵗʰ term of the count-and-say 
//sequence. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: "1"
//Explanation: This is the base case.
// 
//
// Example 2: 
//
// 
//Input: n = 4
//Output: "1211"
//Explanation:
//countAndSay(1) = "1"
//countAndSay(2) = say "1" = one 1 = "11"
//countAndSay(3) = say "11" = two 1's = "21"
//countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 30 
// 
//
// Related Topics 字符串 👍 955 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;38
 * <p>
 * Name：Count and Say
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
        solution.countAndSay(5);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private String s = "1";

        public String countAndSay(int n) {
            for (int i = 1; i < n; i++)  handle();
            return s;
        }

        private void handle() {
            char last = 0;
            int k = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == last) k++;
                else {
                    if (last != 0) sb.append(k).append(last);
                    k = 1;
                    last = c;
                }
            }
            sb.append(k).append(last);
            s = sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}