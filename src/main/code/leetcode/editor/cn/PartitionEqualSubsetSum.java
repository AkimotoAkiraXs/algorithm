package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;416
 * <p>
 * Name：分割等和子集
 * <p>
 * <b>01背包问题：</b>
 * 判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等其实就是转换为是否能在数组里找到一些数和为Sum/2
 * 状态转义方程：<p>
 * d[p] = dp[i−1][j] ∣ dp[i−1][j−nums[i]]（j ≥ nums[i]），dp[i−1][j]（j < nums[i]）
 * <p>
 * 注意此题二维数组转一维的技巧
 *
 * @author Yuri
 * @see <a href=https://leetcode.cn/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-by-leetcode-solution>LeetCode题解</a>
 * @since 2023-02-18 00:38:21
 */

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        solution.canPartition(new int[]{1, 5, 10, 6});
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        private class Dfs {
            int[] nums;

            public boolean canPartition(int[] nums) {
                this.nums = nums;
                int n = nums.length;
                int sum = 0;
                for (int num : nums) sum += num;
                // 判断nums数量是否为奇数或和是否为奇数，此时答案肯定是false
                if ((sum & 1) == 1) return false;
                return dfs(n - 1, sum / 2);
            }

            boolean dfs(int i, int j) {
                if (j == 0) return true;
                if (i < 0) return false;
                return dfs(i - 1, j) || dfs(i - 1, j - nums[i]);
            }
        }

        public boolean canPartition_2D(int[] nums) {
            int sum = 0;
            for (int num : nums) sum += num;
            // 判断nums数量是否为奇数或和是否为奇数，此时答案肯定是false
            if ((sum & 1) == 1) return false;
            int target = sum / 2;
            int n = nums.length;
            boolean[][] dp = new boolean[n + 1][target + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                int num = nums[i - 1];
                for (int j = 0; j <= target; j++) {
                    if (j < num) dp[i][j] = dp[i - 1][j]; // 二维dp要更新j<num的情况，一维dp时这些判断可以被优化掉
                    else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
            return dp[n][target];
        }

        // 滚动数组
        public boolean canPartition_scrolling(int[] nums) {
            int sum = 0;
            for (int num : nums) sum += num;
            // 判断nums数量是否为奇数或和是否为奇数，此时答案肯定是false
            if ((sum & 1) == 1) return false;
            int target = sum / 2;
            int n = nums.length;
            boolean[][] dp = new boolean[2][target + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                int num = nums[i - 1];
                for (int j = 0; j <= target; j++) {
                    if (j < num) dp[i & 1][j] = dp[(i - 1) & 1][j]; // 二维dp要更新j<num的情况，一维dp时这些判断可以被优化掉
                    else dp[i & 1][j] = dp[(i - 1) & 1][j] || dp[(i - 1) & 1][j - num];
                }
            }
            return dp[n & 1][target];
        }

        // 一维优化
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) sum += num;
            // 判断nums数量是否为奇数或和是否为奇数，此时答案肯定是false
            if ((sum & 1) == 1) return false;
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            // 这里进行空间优化，正规dp思路是建立二维数组dp[i][j]（i表示可以拿取的前n个元素，j[0~target]需要当时组成的数）
            dp[0] = true;
            for (int num : nums) {
                // 这里是从后往前遍历主要是要理解在二维数组中，当j>=num，dp[i][j]=dp[i-1][j]|dp[i-1][j-num]
                // 也就是只取决于上层顶部和上层顶部左边，所以一维数组是不断更新dp[i]如果从小遍历大的话dp[i-num]已经被污染（即不是上一层的，而是这一层的）
                for (int j = target; j >= num; j--) {
                    dp[j] |= dp[j - num];
                }
            }
            return dp[target];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
