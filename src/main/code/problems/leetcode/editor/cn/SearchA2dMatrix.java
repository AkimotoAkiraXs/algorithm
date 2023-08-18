//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 550 👎 0


package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;74
 * <p>
 * Name：搜索二维矩阵
 *
 * @author Yuri
 * @since 2021-12-24 11:26:30
 */
public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        int[][] ary = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        solution.searchMatrix(ary, 3);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            for (int[] ints : matrix) {
                /*这一步也可以二分查找，且还可以用算法将二维数组以一维数组的方式进行二分*/
                if (ints[m - 1] >= target) {
                    int a = 0, b = m;
                    while (a < b) {
                        int mid = (a + b) >> 1;
                        if (ints[mid] > target) {
                            b = mid;
                        } else if (ints[mid] < target) {
                            a = mid + 1;
                        } else {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}