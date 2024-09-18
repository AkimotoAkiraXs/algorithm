// Given an n x n matrix where each of the rows and columns is sorted in
// ascending order, return the kᵗʰ smallest element in the matrix.
//
// Note that it is the kᵗʰ smallest element in the sorted order, not the kᵗʰ 
// distinct element.
//
// You must find a solution with a memory complexity better than O(n²). 
//
// 
// Example 1: 
//
// 
// Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
// Output: 13
// Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and
// the 8ᵗʰ smallest number is 13
// 
//
// Example 2: 
//
// 
// Input: matrix = [[-5]], k = 1
// Output: -5
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// All the rows and columns of matrix are guaranteed to be sorted in non-
// decreasing order.
// 1 <= k <= n² 
// 
//
// 
// Follow up: 
//
// 
// Could you solve the problem with a constant memory (i.e., O(1) memory 
// complexity)?
// Could you solve the problem in O(n) time complexity? The solution may be too 
// advanced for an interview but you may find reading this paper fun.
// 
//
// 👍 1073 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;378
 * <p>
 * Name：Kth Smallest Element in a Sorted Matrix
 *
 * @author Yuri
 * @since 2024-09-14 11:24:23
 */

public class KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

            /**
         * 二分，思路看官方题解，需要注意的是计算矩阵中比m小的个数时，从后往前能保证不会走回头路
         *
         * @see <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/solutions/311472/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/">官方题解</a>
         */
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int l = matrix[0][0], r = matrix[n - 1][n - 1];
            while (l <= r) {
                int m = (r - l >> 1) + l;
                if (cal(matrix, m, k)) l = m + 1;
                else r = m - 1;
            }
            return l;
        }

        private boolean cal(int[][] matrix, int m, int k) {
            int n = matrix.length;
            int tot = 0;
            for (int[] mat : matrix) {
                for (int j = n - 1; j >= 0; j--) {
                    if (mat[j] <= m) {
                        tot += j + 1;
                        break;
                    }
                }
            }
            return tot < k;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}