//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
// 示例 2：
//
//
//输入：triangle = [[-10]]
//输出：-10
//
//
//
//
// 提示：
//
//
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -10⁴ <= triangle[i][j] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
//
// Related Topics 数组 动态规划 👍 912 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Id：&emsp;&emsp;120
 * <p>
 * Name：三角形最小路径和
 *
 * @author Yuri
 * @since 2021-12-14 10:23:16
 */
public class Triangle {
    public static void main(String[] args) {
        Integer[][] arrays = new Integer[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> list = new ArrayList<>();
        for (Integer[] a : arrays) {
            list.add(new ArrayList<>(Arrays.asList(a)));
        }

        Solution solution = new Triangle().new Solution();
        solution.minimumTotal(list);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * i表示竖向层数，j表示横向位置，c[i][j]表示某个点的值
     * <p>
     * 状态转移方程：f[i][j]=min(f[i−1][j−1],f[i−1][j])+c[i][j]
     */
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            List<List<Integer>> smallest = new ArrayList<>();
            List<Integer> first = triangle.get(0);
            smallest.add(first);
            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> layer = triangle.get(i);
                ArrayList<Integer> small = new ArrayList<>();
                List<Integer> lastSmall = smallest.get(i - 1);
                small.add(lastSmall.get(0) + layer.get(0));
                for (int j = 1; j < layer.size() - 1; j++) {
                    int sm = Math.min(lastSmall.get(j - 1), lastSmall.get(j));
                    small.add(sm + layer.get(j));
                }
                small.add(lastSmall.get(lastSmall.size() - 1) + layer.get(layer.size() - 1));
                smallest.add(small);
            }
            List<Integer> lastLayer = smallest.get(smallest.size() - 1);
            return Collections.min(lastLayer);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}