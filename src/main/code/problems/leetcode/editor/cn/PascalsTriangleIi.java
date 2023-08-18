//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 
// 👍 318 👎 0


/*
  * Id：119
  * Name：杨辉三角 II
  * Date：2021-09-02 10:44:14
*/
package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> nums = new ArrayList<>();
            nums.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> pre = ans.get(i - 1);
                nums.add(pre.get(j - 1) + pre.get(j));
            }
            if (i != 0) nums.add(1);
            ans.add(nums);
        }
        return ans.get(rowIndex);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
} 