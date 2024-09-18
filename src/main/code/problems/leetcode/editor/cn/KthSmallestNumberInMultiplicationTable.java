// Nearly everyone has used the Multiplication Table. The multiplication table
// of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).
//
// Given three integers m, n, and k, return the kᵗʰ smallest element in the m x 
// n multiplication table.
//
// 
// Example 1: 
// 
// 
// Input: m = 3, n = 3, k = 5
// Output: 3
// Explanation: The 5ᵗʰ smallest number is 3.
// 
//
// Example 2: 
// 
// 
// Input: m = 2, n = 3, k = 6
// Output: 6
// Explanation: The 6ᵗʰ smallest number is 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 3 * 10⁴ 
// 1 <= k <= m * n 
// 
//
// 👍 367 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;668
 * <p>
 * Name：Kth Smallest Number in Multiplication Table
 *
 * @author Yuri
 * @since 2024-09-18 15:32:24
 */

public class KthSmallestNumberInMultiplicationTable {

    public static void main(String[] args) {
        Solution solution = new KthSmallestNumberInMultiplicationTable().new Solution();
        System.out.println(solution.findKthNumber(7341, 13535, 12330027));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 和 Lc.378 有序矩阵中第K小的元素思路一样，但是计算每一列有多少个小于mid的数时不能遍历（会超时），直接用数学求出
         *
         * @see KthSmallestElementInASortedMatrix Lc.378 有序矩阵中第K小的元素
         */
        public int findKthNumber(int m, int n, int k) {
            int l = 1, r = k;
            while (l <= r) {
                int mid = (r - l >> 1) + l;
                if (cal(mid, m, n, k)) l = mid + 1;
                else r = mid - 1;
            }
            return l;
        }

        private boolean cal(int mid, int m, int n, int k) {
            long tot = 0;
            for (int i = 1; i <= m; i++)
                tot += Math.min(n, mid / i);
            return tot < k;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}