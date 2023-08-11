//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
// s 保证是一个符合题目要求的字符串
//
//
// Related Topics 哈希表 数学 字符串 👍 185 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;423
 * <p>
 * Name：从英文中重建数字
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        Solution solution = new ReconstructOriginalDigitsFromEnglish().new Solution();
        String owoztneoer = solution.originalDigits("owoztneoer");
        System.out.println(owoztneoer);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        final String[] strs = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        final int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};
        final char[] chars = new char[]{'z', 'g', 'x', 'h', 't', 's', 'v', 'i', 'r', 'o'};

        public String originalDigits(String s) {
            int[] cnt = new int[26];
            for (char c : s.toCharArray()) cnt[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            List<Integer> queue = new ArrayList<>();
            for (int i = 0; i <= 9; i++) {
                while (cnt[chars[i] - 'a'] > 0){
                    String str = strs[priority[i]];
                    for (char c : str.toCharArray()) cnt[c - 'a']--;
                    sb.append(priority[i]);
                }
            }
            char[] chars = sb.toString().toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}