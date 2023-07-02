package leetcode.editor.cn;

import cn.hutool.core.lang.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;2741 <br/>
 * Name：Special Permutations <br/>
 * <p>
 * 单周赛350 Q3
 *
 * @author Yuri
 * @since 2023-06-20 22:13:06
 */

public class SpecialPermutations {
    public static void main(String[] args) {
        Solution solution = new SpecialPermutations().new Solution();
        int i = solution.specialPerm(new int[]{2, 3});
        System.out.println(i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 位压Dp：可以由记忆化dfs推导而来，dp[i][j]中i，j和dfs中bit，j意义是一样的
         */
        public int specialPerm(int[] nums) {
            int MOD = (int) 1e9 + 7;
            int n = nums.length;
            int[][] dp = new int[1 << n][n];
            Arrays.fill(dp[0], 1);
            for (int i = 1; i < 1 << n; i++) {
                for (int j = 0; j < n; j++) {
                    // j作为这一次被选择的数
                    if ((i >> j & 1) == 0) continue;
                    for (int k = 0; k < n; k++) {
                        // k作为前一次被选择数
                        // 省略i<<k&1==0，不用判断k位置是否为0，因为虽然i中k位置为0时从逻辑上看选k不合理
                        // 但是dp[i][k]作为脏数据也不会对后续产生影响，因为更新dp[i][k]时影响结果的是数据dp[i<<j^i][j]
                        // 我们前面保证了j位置一定为0，所以不会取到脏数据dp[i][k]（i中k不为0）
                        // 这里不判断不单是为了偷懒，主要还是会快一点
                        if (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0)
                            dp[i][k] = (dp[i][k] + dp[1 << j ^ i][j]) % MOD;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) ans = (ans + dp[((1 << n) - 1) ^ (1 << i)][i]) % MOD;
            return ans;
        }


        /**
         * 运用位运算记忆化搜索的dfs： <br>
         * 用i的二进制表示1-14个数中哪些已被使用（相当云暴力中用的list），j表示上一个数字的位置。 <br>
         * 注意：在hash中需要用i，j共同作Key值。
         */
        private class Dfs_Memory {
            private final int MOD = (int) 1e9 + 7;
            int n;
            Map<Pair<Integer, Integer>, Integer> map;
            int[] nums;

            public int specialPerm(int[] nums) {
                n = nums.length;
                this.nums = nums;
                int bit = (1 << n) - 1;
                long ans = 0;
                map = new HashMap<>();
                for (int i = 0; i < n; i++)
                    ans = (ans + dfs((1 << i) ^ bit, i)) % MOD;
                return (int) ans;
            }

            int dfs(int i, int j) {
                if (i == 0) return 1;
                Pair<Integer, Integer> key = new Pair<>(i, j);
                if (map.containsKey(key)) return map.get(key);
                int res = 0;
                for (int k = 0; k < n; k++) {
                    if (((i >> k) & 1) == 1 && (nums[k] % nums[j] == 0 || nums[j] % nums[k] == 0)) {
                        int new_bit = i ^ (1 << k);
                        res = (res + dfs(new_bit, k)) % MOD;
                    }
                }
                int value = res % MOD;
                map.put(key, value);
                return value;
            }
        }


        /**
         * 暴力dfs，时间复杂度O(14!)+，必超时。
         */
        private class Dfs_TLE {
            int MOD = (int) 1e9 + 7;
            int ans = 0;
            int n;

            public int specialPerm(int[] nums) {
                n = nums.length;
                List<Integer> integers = Arrays.stream(nums).boxed().collect(Collectors.toList());
                for (int i = 0; i < n; i++) {
                    Integer num = integers.get(i);
                    List<Integer> temp = new ArrayList<>(integers);
                    temp.remove(i);
                    dfs(temp, num);
                }
                return ans;
            }

            void dfs(List<Integer> list, int last) {
                if (list.size() == 0) {
                    ans = (ans + 1) % MOD;
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    Integer num = list.get(i);
                    if (num % last == 0 || last % num == 0) {
                        List<Integer> temp = new ArrayList<>(list);
                        temp.remove(i);
                        dfs(temp, num);
                    }
                }
            }
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}
