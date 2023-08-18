//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 
// 👍 747 👎 0


/*
 * Id：77
 * Name：组合
 * Date：2021-10-27 15:46:31
 */
package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        solution.combine(3, 1);
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int N, K;
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.N = n;
            this.K = k;
            recursion(new ArrayList<>(), 1);
            return res;
        }

        private void recursion(List<Integer> list, int b) {
//            if (list.size() + (N - b) + 1 < 0) return;
            if (list.size() == K) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = b; i <= N; i++) {
                list.add(i);
                recursion(list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 