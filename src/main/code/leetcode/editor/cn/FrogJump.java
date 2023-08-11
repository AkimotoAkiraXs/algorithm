// A frog is crossing a river. The river is divided into some number of units,
// and at each unit, there may or may not exist a stone. The frog can jump on a
// stone, but it must not jump into the water.
//
// Given a list of stones' positions (in units) in sorted ascending order, 
// determine if the frog can cross the river by landing on the last stone. Initially,
// the frog is on the first stone and assumes the first jump must be 1 unit.
//
// If the frog's last jump was k units, its next jump must be either k - 1, k, 
// or k + 1 units. The frog can only jump in the forward direction.
//
// 
// Example 1: 
//
// 
// Input: stones = [0,1,3,5,6,8,12,17]
// Output: true
// Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd
// stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3
// units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
// 
//
// Example 2: 
//
// 
// Input: stones = [0,1,2,3,4,8,9,11]
// Output: false
// Explanation: There is no way to jump to the last stone as the gap between the
// 5th and 6th stone is too large.
// 
//
// 
// Constraints: 
//
// 
// 2 <= stones.length <= 2000 
// 0 <= stones[i] <= 2³¹ - 1 
// stones[0] == 0 
// stones is sorted in a strictly increasing order. 
// 
//
// Related Topics 数组 动态规划 👍 497 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;403
 * <p>
 * Name：Frog Jump
 *
 * @author Yuri
 * @since 2023-06-02 16:02:59
 */


public class FrogJump {
    public static void main(String[] args) {
        Solution solution = new FrogJump().new Solution();
        boolean b = solution.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11});
        System.out.println(b);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // Dp：比记忆化dfs慢
        public boolean canCross(int[] stones) {
            if (stones[1] != 1) return false; // 不能到达第一块石头直接false
            int n = stones.length;
            boolean[][] dp = new boolean[n][n]; // dp[i][g] 表示是否能以g步状态到达第i块石头，因为一次只会前进一步，所以g的范围在n以内
            dp[1][1] = true; // 初始状态，前方已经判断一定能以1步状态到达第1块石头
            for (int i = 2; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    int g = stones[i] - stones[j]; // gap
                    // ∵ 在第一块石头步数固定为1，往后最多增加1，第j块石头时步数最多为j
                    // ∴ 当gap > j + 1时，dp[i][g]一定无法到达
                    if (g <= j + 1) dp[i][g] = dp[j][g - 1] || dp[j][g] || dp[j][g + 1];
                }
            }
            for (int i = 1; i < n; i++) if (dp[n - 1][i]) return true;
            return false;
        }

/*
        // 记忆化dfs
        int[] stones;
        HashSet<Integer> hash = new HashSet<>();

        public boolean canCross(int[] stones) {
            if (stones[1] - stones[0] != 1) return false;
            this.stones = stones;
            return dfs(1, 1);
        }

        boolean dfs(int step, int pos) {
            return pos == stones.length - 1 || findNext(step - 1, pos) || findNext(step, pos) || findNext(step + 1, pos);
        }

        boolean findNext(int step, int pos) {
            if (!hash.add(step * 2000 + pos)) return false;
            int next = pos + 1;
            while (next < stones.length) {
                int gap = stones[next] - stones[pos];
                if (gap == step) return dfs(step, next);
                if (gap < step) next++;
                else break;
            }
            return false;
        }
*/
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
