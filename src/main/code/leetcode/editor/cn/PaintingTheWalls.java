package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;2742 <br/>
 * Name：Painting the Walls <br/>
 * <p>
 * 单周赛350 Q4
 *
 * @author Yuri
 * @since 2023-06-25 23:08:18
 */

public class PaintingTheWalls {
    public static void main(String[] args) {
        Solution solution = new PaintingTheWalls().new Solution();
        solution.paintWalls(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1});
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 01背包思路：∵花费墙+免费墙 = n，又∵花费时间 >= 免费墙，∴花费时间 >= n - 花费墙 <br>
         * 即推出：花费时间 + 花费墙 >= n
         * <p>
         * 转换为背包问题：从time[]中选择一些数，使得sum(time[i]+1)的和不小于n的情况下，花费cost最小
         */
        public int paintWalls(int[] cost, int[] time) {
            int n = cost.length;
            long[] dp = new long[n + 1];
            for (int i = 0; i <= n; i++) dp[i] = Integer.MAX_VALUE;
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = n; j > 0; j--) {
                    dp[j] = Math.min(dp[Math.max(j - time[i] - 1, 0)] + cost[i], dp[j]);
                }
            }
            return (int) dp[n];
        }

        /**
         * 01背包思路回溯版本：i代表第几个物品，j代表现在还需要最少满足的 花费时间+花费墙
         */
        private class Dfs_Memory_01 {
            int[] cost;
            int[] time;
            Map<Integer, Long> map;

            public int paintWalls(int[] cost, int[] time) {
                this.cost = cost;
                this.time = time;
                map = new HashMap<>();
                int n = cost.length;
                return (int) dfs(n - 1, n);
            }

            long dfs(int i, int j) {
                if (j <= 0) return 0; // j <= 0说明：花费时间 + 花费墙 >= n 已经满足，此时不需要再花费了
                if (i < 0) return Integer.MAX_VALUE;
                int key = i * 1001 + j; // 自定义hash，j范围-n~n，i范围500
                if (map.containsKey(key)) return map.get(key);
                long min = Math.min(dfs(i - 1, j - time[i] - 1) + (long) cost[i], dfs(i - 1, j));
                map.put(key, min);
                return min;
            }
        }


        /**
         * 记忆化搜索：i表示第几个物品，j表示目前剩余的付费时间和，可以为负数（就是先用后补）
         * <p>
         * ∵j范围-n~n，i范围0~n，其中j为负数，还有个判断j>i要返回，不返回会超时，所以此处改为Dp比较困难，需要转换思路将其想为01背包
         */
        private class Dfs_Memory {
            int[] cost;
            int[] time;
            Map<Integer, Long> map;

            public int paintWalls(int[] cost, int[] time) {
                this.cost = cost;
                this.time = time;
                map = new HashMap<>();
                return (int) dfs(cost.length - 1, 0);
            }

            long dfs(int i, int j) {
                if (j > i) return 0;
                if (i < 0) return Integer.MAX_VALUE; // 涵盖了i<0，j<0的情况
                int key = i * 1001 + j; // 自定义hash，j范围-n~n，i范围500
                if (map.containsKey(key)) return map.get(key);
                long min = Math.min(dfs(i - 1, j + time[i]) + (long) cost[i], dfs(i - 1, j - 1));
                map.put(key, min);
                return min;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
