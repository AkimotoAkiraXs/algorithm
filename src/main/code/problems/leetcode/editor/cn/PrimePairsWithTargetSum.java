package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;2761 <br/>
 * Name：Prime Pairs With Target Sum <br/>
 *
 * @author Yuri
 * @since 2023-07-03 22:44:49
 */

public class PrimePairsWithTargetSum {
    public static void main(String[] args) {
        Solution solution = new PrimePairsWithTargetSum().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 埃氏筛选法
        public List<List<Integer>> findPrimePairs(int n) {
            boolean[] vis = new boolean[n + 1];
            eratosthenes(n + 1, vis);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 2; i <= n / 2; i++) {
                if (!vis[i] && !vis[n - i]) {
                    ArrayList<Integer> objects = new ArrayList<>();
                    objects.add(i);
                    objects.add(n - i);
                    ans.add(objects);
                }
            }
            return ans;
        }

        private void eratosthenes(int MAX_N, boolean[] vis) {
            vis[0] = vis[1] = true;
            // 如果到了他的根号，还没有一个因子出现，那么后半部分也不会有因子出现了
            int sqrt = (int) Math.sqrt(MAX_N);
            for (int i = 2; i <= sqrt; i++) { // 只需计算到sqrt(n)
                if (vis[i]) continue; // 合数直接跳
                for (int j = i; i * j < MAX_N; j++) {
                    vis[i * j] = true; // 标记为合数
                }
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
