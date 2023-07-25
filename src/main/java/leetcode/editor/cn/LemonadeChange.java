package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;860 <br/>
 * Name：Lemonade Change <br/>
 *
 * @author Yuri
 * @since 2023-07-22 22:10:29
 */

public class LemonadeChange {
    public static void main(String[] args) {
        Solution solution = new LemonadeChange().new Solution();
        solution.lemonadeChange(new int[]{5, 5, 5, 10, 20});
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int f = 0, t = 0;
            for (int bill : bills) {
                if (bill == 5) f++;
                else if (bill == 10) {
                    if (f <= 0) return false;
                    f--;
                    t++;
                } else {
                    if (t > 0 && f > 0) {
                        t--;
                        f--;
                    } else if (f >= 3) f -= 3;
                    else return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
