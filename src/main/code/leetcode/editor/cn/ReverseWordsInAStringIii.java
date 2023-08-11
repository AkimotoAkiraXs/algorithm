//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 
// 👍 336 👎 0


/*
 * Id：557
 * Name：反转字符串中的单词 III
 * Date：2021-09-28 09:31:05
 */
package leetcode.editor.cn;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        solution.reverseWords("has code ?");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] ary = s.split(" ");
            StringBuffer ans = new StringBuffer();
            for (int i = 0; i < ary.length; i++) {
                String str = ary[i];
                char[] chars = str.toCharArray();
                reverse(chars);
                str = String.valueOf(chars);
                if (i != 0) ans.append(" ");
                ans.append(str);
            }
            return ans.toString();
        }

        private void reverse(char[] chars) {
            int a = 0, b = chars.length - 1;
            while (a < b) {
                char temp = chars[a];
                chars[a] = chars[b];
                chars[b] = temp;
                a++;
                b--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 