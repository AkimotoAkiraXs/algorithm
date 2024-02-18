// A peak element in a 2D grid is an element that is strictly greater than all
// of its adjacent neighbors to the left, right, top, and bottom.
//
// Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, 
// find any peak element mat[i][j] and return the length 2 array [i,j].
//
// You may assume that the entire matrix is surrounded by an outer perimeter 
// with the value -1 in each cell.
//
// You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time. 
//
// 
// Example 1: 
//
// 
//
// 
// Input: mat = [[1,4],[3,2]]
// Output: [0,1]
// Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both
// acceptable answers.
// 
//
// Example 2: 
//
// 
//
// 
// Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
// Output: [1,1]
// Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both
// acceptable answers.
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 500 
// 1 <= mat[i][j] <= 10⁵ 
// No two adjacent cells are equal. 
// 
//
// 👍 161 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1901
 * <p>
 * Name：Find a Peak Element II
 *
 * @author Yuri
 * @see FindPeakElement 寻找峰值
 * @since 2024-02-05 10:24:43
 */

public class FindAPeakElementIi {

    public static void main(String[] args) {
        Solution solution = new FindAPeakElementIi().new Solution();
        solution.findPeakGrid(new int[][]{{1, 4}, {3, 2}});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 类似于{@link FindPeakElement 寻找峰值}，我们从中间行i开始寻找行中最大值位置j，从位置j与i+1行的位置j做二分答案。
         * 因为每次都在趋近于较大的一方，所以最终我们一定会得到一个峰值。
         */
        public int[] findPeakGrid(int[][] mat) {
            int left = 0, right = mat.length - 1; // 因为要和i+1（i=mid）比较，所以right边界要-1
            while (left < right) {
                int i = left + right >>> 1;
                int j = maxOfRaw(mat[i]);
                if (mat[i][j] < mat[i + 1][j]) left = i + 1;
                else right = i;
            }

            return new int[]{left, maxOfRaw(mat[left])};
        }

        private int maxOfRaw(int[] nums) {
            int x = 0;
            for (int i = 1; i < nums.length; i++)
                if (nums[i] > nums[x]) x = i;
            return x;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}