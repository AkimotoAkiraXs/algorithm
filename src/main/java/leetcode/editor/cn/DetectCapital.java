//我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如 "USA" 。 
// 单词中所有字母都不是大写，比如 "leetcode" 。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。 
// 
//
// 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "USA"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：word = "FlaG"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 由小写和大写英文字母组成 
// 
//
// Related Topics 字符串 👍 213 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;520
 * <p>
 * Name：检测大写字母
 *
 * @author Yuri
 * @since 2022-08-26 09:33:55
 */
public class DetectCapital {
    public static void main(String[] args) {
        Solution solution = new DetectCapital().new Solution();
        solution.detectCapitalUse("FlaG");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 优雅
        public boolean detectCapitalUse(String word) {
            int n = word.length();
            int cnt = 0;
            for (int i = 0; i < n; i++)
                if (Character.isUpperCase(word.charAt(i))) cnt++;
            return cnt == 0 || cnt == n || (Character.isUpperCase(word.charAt(0)) && cnt == 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}