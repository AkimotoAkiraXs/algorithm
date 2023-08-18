//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则： 
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 双指针 字符串 👍 62 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;481
 * <p>
 * Name：神奇字符串
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class MagicalString {
    public static void main(String[] args) {
        Solution solution = new MagicalString().new Solution();
        System.out.println(solution.magicalString(61));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicalString(int n) {
            if (n == 1) return 1;
            int[] num = new int[100000 + 10];
            int a = 1, b = 1;
            num[1] = 1;
            num[2] = 2;
            int ans = 0;
            int number = 1;
            while (b <= n) {
                for (int j = 0; j < num[a] && b <= n; j++) {
                    num[b++] = number;
                    if (number == 1) ans++;
                }
                a++;
                number = number == 1 ? 2 : 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}