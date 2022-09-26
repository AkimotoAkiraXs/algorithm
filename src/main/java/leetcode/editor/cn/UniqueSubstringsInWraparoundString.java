//把字符串 s 看作 "abcdefghijklmnopqrstuvwxyz" 的无限环绕字符串，所以 s 看起来是这样的： 
//
// 
// "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." 。 
// 
//
// 现在给定另一个字符串 p 。返回 s 中 不同 的 p 的 非空子串 的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = "a"
//输出：1
//解释：字符串 s 中只有 p 的一个 "a" 子字符。
// 
//
// 示例 2： 
//
// 
//输入：p = "cac"
//输出：2
//解释：字符串 s 中只有 p 的两个子串 ("a", "c") 。
// 
//
// 示例 3： 
//
// 
//输入：p = "zab"
//输出：6
//解释：在字符串 s 中有 p 的六个子串 ("z", "a", "b", "za", "ab", "zab") 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= p.length <= 10⁵ 
// p 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 352 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;467
 * <p>
 * Name：环绕字符串中唯一的子字符串
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class UniqueSubstringsInWraparoundString {
    public static void main(String[] args) {
        Solution solution = new UniqueSubstringsInWraparoundString().new Solution();
        solution.findSubstringInWraproundString("zaba");
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSubstringInWraproundString(String p) {
            int[] max = new int[26];
            int k = 1;
            for (int i = 0; i < p.length(); i++) {
                if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) k++;
                else k = 1;
                int c = p.charAt(i) - 'a';
                max[c] = Math.max(max[c], k);
            }
            int ans = 0;
            for (int n : max) ans += n;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}