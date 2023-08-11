package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;292
 * <p>
 * Name：Nim 游戏
 *
 * @author Yuri
 * @since 2023-02-11 21:46:49
 */

public class NimGame {
    public static void main(String[] args) {
        Solution solution = new NimGame().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
