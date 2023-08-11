//将非负整数 num 转换为其对应的英文表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 123
//输出："One Hundred Twenty Three"
// 
//
// 示例 2： 
//
// 
//输入：num = 12345
//输出："Twelve Thousand Three Hundred Forty Five"
// 
//
// 示例 3： 
//
// 
//输入：num = 1234567
//输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 2³¹ - 1 
// 
//
// Related Topics 递归 数学 字符串 👍 292 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;273
 * <p>
 * Name：整数转换英文表示
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        Solution solution = new IntegerToEnglishWords().new Solution();
        System.out.println(solution.numberToWords(12345));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final String[] level = new String[]{"", "Thousand", "Million", "Billion"};
        private final String[] spe = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
                "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private final String[] dec = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        public String numberToWords(int num) {
            if (num == 0) return "Zero";
            StringBuilder ans = new StringBuilder();
            for (int i = 1000000000; i > 0; i /= 1000) {
                int k = num / i;
                int l = (int) Math.log10(i) / 3;
                if (k > 0) {
                    if (ans.length() > 0) ans.append(" ");
                    ans.append(hundred(k));
                    if (l > 0) ans.append(" ").append(level[l]);
                }
                num %= i;
            }
            return ans.toString();
        }

        String hundred(int num) {
            String res = "";
            int h = num / 100;
            if (h > 0) res += spe[h] + " " + "Hundred";
            num %= 100;
            if (num == 0) return res;
            if (num < 20) {
                if (res.length() > 0) res += " ";
                res += spe[num];
            } else {
                int d = num / 10;
                if (res.length() > 0) res += " ";
                res += dec[d];
                num %= 10;
                if (num != 0) {
                    res += " " + spe[num];
                }
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}