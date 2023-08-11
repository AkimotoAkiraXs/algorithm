//我们构建了一个包含 n 行( 索引从 1 开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。 
//
// 
// 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。 
// 
//
// 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始） 
//
// 示例 1: 
//
// 
//输入: n = 1, k = 1
//输出: 0
//解释: 第一行：0
// 
//
// 示例 2: 
//
// 
//输入: n = 2, k = 1
//输出: 0
//解释: 
//第一行: 0 
//第二行: 01
// 
//
// 示例 3: 
//
// 
//输入: n = 2, k = 2
//输出: 1
//解释:
//第一行: 0
//第二行: 01
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 30 
// 1 <= k <= 2n - 1 
// 
//
// Related Topics 位运算 递归 数学 👍 247 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;779
 * <p>
 * Name：第K个语法符号
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class KThSymbolInGrammar {
    public static void main(String[] args) {
        Solution solution = new KThSymbolInGrammar().new Solution();
        System.out.println(solution.kthGrammar(2, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
/*
        // 模拟翻转 翻转次数为偶数则是0 为奇数则是1
        public int kthGrammar(int n, int k) {
            int fold = 0;
            while (k > 1) {
                for (int i = 1; ; i++) {
                    int p = (int) Math.pow(2, i);
                    if (k <= p) {
                        k = p - k + 1;
                        fold += i;
                        break;
                    }
                }
            }
            return fold % 2;
        }
*/

        /**
         * 把数字k转为二进制表示，对于上述模拟翻转，每次翻转相当于把二进制表示k前i个为1的数变为0的过程
         * ∴ bitCount(k) = fold
         */

        public int kthGrammar(int n, int k) {
            return Integer.bitCount(k - 1) & 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}