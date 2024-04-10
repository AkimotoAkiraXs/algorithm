//You are given a binary string binary consisting of only 0's or 1's. You can 
//apply each of the following operations any number of times: 
//
// 
// Operation 1: If the number contains the substring "00", you can replace it 
//with "10". 
// 
//
// 
// For example, "00010" -> "10010" 
// 
// 
// Operation 2: If the number contains the substring "10", you can replace it 
//with "01".
// 
// For example, "00010" -> "00001" 
// 
// 
//
//
// Return the maximum binary string you can obtain after any number of 
//operations. Binary string x is greater than binary string y if x's decimal 
//representation is greater than y's decimal representation. 
//
// 
// Example 1: 
//
// 
//Input: binary = "000110"
//Output: "111011"
//Explanation: A valid transformation sequence can be:
//"000110" -> "000101" 
//"000101" -> "100101" 
//"100101" -> "110101" 
//"110101" -> "110011" 
//"110011" -> "111011"
// 
//
// Example 2: 
//
// 
//Input: binary = "01"
//Output: "01"
//Explanation: "01" cannot be transformed any further.
// 
//
// 
// Constraints: 
//
// 
// 1 <= binary.length <= 10⁵ 
// binary consist of '0' and '1'. 
// 
//
// 👍 68 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1702
 * <p>
 * Name：Maximum Binary String After Change
 *
 * @author Yuri
 * @since 2024-04-10 16:07:09
 */

public class MaximumBinaryStringAfterChange {
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryStringAfterChange().new Solution();
        solution.maximumBinaryString("000110");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 贪心，当binary原本含有0时最后得到的最大值一定只含有一个0，且该0的位置是从第一个0开始向后移动n-1位，n代表零的个数。
         */
        public String maximumBinaryString(String binary) {
            int index = binary.indexOf('0');
            if (index < 0) return binary;
            int first = -1;
            int cnt = 0;
            int n = binary.length();
            for (int i = 0; i < n; i++) {
                if (binary.charAt(i) == '0') {
                    if (first < 0) first = i;
                    cnt++;
                }
            }
            return "1".repeat(first + cnt - 1) + "0" + "1".repeat(n - first - cnt);
        }

        /**
         * 灵神写法
         * <p>
         * 从第一个零开始统计后面1的个数，因为最后所有的1都会被挤到0的最右边。
         */
        public String maximumBinaryString_(String binary) {
            int i = binary.indexOf('0');
            if (i < 0) { // binary 全是 '1'
                return binary;
            }
            char[] s = binary.toCharArray();
            int cnt1 = 0;
            for (i++; i < s.length; i++) {
                cnt1 += s[i] - '0'; // 统计 [i, n-1] 中 '1' 的个数
            }
            return "1".repeat(s.length - 1 - cnt1) + '0' + "1".repeat(cnt1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}