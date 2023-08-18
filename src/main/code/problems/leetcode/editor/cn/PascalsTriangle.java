//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 563 👎 0


/*
 * Id：118
 * Name：杨辉三角
 * Date：2021-09-02 10:29:00
 */
package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        solution.generate(5);
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> nums = new ArrayList<>();
                nums.add(1);
                for (int j = 1; j < i; j++) {
                    List<Integer> pre = ans.get(i - 1);
                    nums.add(pre.get(j - 1) + pre.get(j));
                }
                if (i != 0) nums.add(1);
                ans.add(nums);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 