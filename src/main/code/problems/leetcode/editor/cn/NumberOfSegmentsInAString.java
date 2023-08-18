//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
//
// Related Topics 字符串 👍 179 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;434
 * <p>
 * Name：字符串中的单词数
 *
 * @author Yuri
 * @since 2022-08-26 15:34:20
 */
public class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Solution solution = new NumberOfSegmentsInAString().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            int cnt = 0;
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (flag && (!Character.isWhitespace(c))) {
                    cnt++;
                    flag = false;
                } else if (Character.isWhitespace(c)) {
                    flag = true;
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}