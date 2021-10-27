//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 449 👎 0


/*
  * Id：567
  * Name：字符串的排列
  * Date：2021-09-28 16:32:56
*/
package leetcode.editor.cn;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        solution.checkInclusion("adc", "dcda");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        int a = 0, b = length;
        while (b <= s2.length()) {
            String str = s2.substring(a, b);
            char[] chars2 = str.toCharArray();
            Arrays.sort(chars2);
            if (Arrays.equals(chars1, chars2)) {
                return true;
            }
            a++;
            b++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
} 