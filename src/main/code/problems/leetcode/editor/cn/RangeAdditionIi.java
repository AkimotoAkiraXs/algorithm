//给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < 
//ai 和 0 <= y < bi 时， M[x][y] 应该加 1。 
//
// 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: m = 3, n = 3，ops = [[2,2],[3,3]]
//输出: 4
//解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
// 
//
// 示例 2: 
//
// 
//输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2]
//,[3,3],[3,3],[3,3]]
//输出: 4
// 
//
// 示例 3: 
//
// 
//输入: m = 3, n = 3, ops = []
//输出: 9
// 
//
// 
//
// 提示: 
//
// 
// 
//
// 
// 1 <= m, n <= 4 * 10⁴ 
// 0 <= ops.length <= 10⁴ 
// ops[i].length == 2 
// 1 <= ai <= m 
// 1 <= bi <= n 
// 
//
// Related Topics 数组 数学 👍 170 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;598
 * <p>
 * Name：范围求和 II
 *
 * @author Yuri
 * @since 2022-08-19 17:43:52
 */
public class RangeAdditionIi {
    public static void main(String[] args) {
        Solution solution = new RangeAdditionIi().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCount(int m, int n, int[][] ops) {
            int x = m, y = n;
            for (int i = 0; i < ops.length; i++) {
                x = Math.min(ops[i][0], x);
                y = Math.min(ops[i][1], y);
            }
            return x * y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}