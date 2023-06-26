package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2739 <br/>
 * Name：Total Distance Traveled <br/>
 * <p>
 * 单周赛350 Q1
 *
 * @author Yuri
 * @since 2023-06-20 21:50:43
 */

public class TotalDistanceTraveled {
    public static void main(String[] args) {
        Solution solution = new TotalDistanceTraveled().new Solution();

        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 除法快速模拟
        public int distanceTraveled(int mainTank, int additionalTank) {
            int ans = 0;
            while (mainTank >= 5) {
                int left = mainTank % 5;
                ans += (mainTank - left) * 10;
                mainTank = Math.min(mainTank / 5, additionalTank);
                additionalTank -= mainTank;
                mainTank += left;
            }
            ans += mainTank * 10;
            return ans;
        }

        // 线性模拟
        public int distanceTraveled_normal(int mainTank, int additionalTank) {
            int ans = 0;
            while (mainTank-- > 0) {
                ans += 10;
                if (ans % 50 == 0 && additionalTank-- > 0) mainTank++;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
