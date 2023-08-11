//给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。 
//
// 我们想要重新格式化字符串 s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。此外，两组之间必须插入破折号，并且应该将
//所有小写字母转换为大写字母。 
//
// 返回 重新格式化的许可密钥 。 
//
// 
//
// 示例 1： 
//
// 
//输入：S = "5F3Z-2e-9-w", k = 4
//输出："5F3Z-2E9W"
//解释：字符串 S 被分成了两个部分，每部分 4 个字符；
//     注意，两个额外的破折号需要删掉。
// 
//
// 示例 2： 
//
// 
//输入：S = "2-5g-3-J", k = 2
//输出："2-5G-3J"
//解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含字母、数字和破折号 '-'. 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 字符串 👍 150 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;482
 * <p>
 * Name：密钥格式化
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        Solution solution = new LicenseKeyFormatting().new Solution();
        solution.licenseKeyFormatting("---", 3);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
                // 字符串函数处理
                public String licenseKeyFormatting(String s, int k) {
                    s = s.toUpperCase();
                    s = s.replaceAll("-", "");
                    int mod = s.length() % k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(s, 0, mod);
                    for (int i = mod; i < s.length(); i += k) {
                        if (i != 0) sb.append("-");
                        sb.append(s, i, i + k);
                    }
                    return sb.toString();
                }
        */

        // 手搓 时间复杂度降低
        public String licenseKeyFormatting(String s, int k) {
            StringBuilder sb = new StringBuilder("");
            for (int i = s.length() - 1; i >= 0; ) {
                for (int j = 0; j < k && i >= 0; i--) {
                    char c = s.charAt(i);
                    if (c == '-') continue;
                    sb.append(Character.toUpperCase(c));
                    j++;
                }
                sb.append("-");
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}