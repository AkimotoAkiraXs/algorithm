//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 👍 2411 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;14
 * <p>
 * Name：最长公共前缀
 *
 * @author Yuri
 * @since 2022-08-26 15:22:36
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String ans = strs[0];
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                for (int j = 0; j < ans.length(); j++) {
                    if (j >= str.length() || ans.charAt(j) != str.charAt(j)) {
                        ans = ans.substring(0, j);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}