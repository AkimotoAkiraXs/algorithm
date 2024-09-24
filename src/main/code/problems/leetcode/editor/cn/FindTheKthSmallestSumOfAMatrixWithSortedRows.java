// You are given an m x n matrix mat that has its rows sorted in non-decreasing
// order and an integer k.
//
// You are allowed to choose exactly one element from each row to form an array.
// 
//
// Return the kᵗʰ smallest array sum among all possible arrays. 
//
// 
// Example 1: 
//
// 
// Input: mat = [[1,3,11],[2,4,6]], k = 5
// Output: 7
// Explanation: Choosing one element from each row, the first k smallest sum are:
//
//[1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
// 
//
// Example 2: 
//
// 
// Input: mat = [[1,3,11],[2,4,6]], k = 9
// Output: 17
// 
//
// Example 3: 
//
// 
// Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
// Output: 9
// Explanation: Choosing one element from each row, the first k smallest sum are:
//
//[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th 
// sum is 9.
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat.length[i] 
// 1 <= m, n <= 40 
// 1 <= mat[i][j] <= 5000 
// 1 <= k <= min(200, nᵐ) 
// mat[i] is a non-decreasing array. 
// 
//
// 👍 190 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Id：&emsp;&emsp;1439
 * <p>
 * Name：Find the Kth Smallest Sum of a Matrix With Sorted Rows
 *
 * @author Yuri
 * @since 2024-09-24 11:30:34
 */

public class FindTheKthSmallestSumOfAMatrixWithSortedRows {

    public static void main(String[] args) {
        Solution solution = new FindTheKthSmallestSumOfAMatrixWithSortedRows().new Solution();
        solution.kthSmallest(new int[][]{{1, 3, 11}, {2, 4, 6}}, 9);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 最小堆：和Lc373 查找和最小的K对数字 思路一样，两两计算合并就好
         *
         * @see FindKPairsWithSmallestSums Lc373 查找和最小的K对数字
         */
        public int kthSmallest(int[][] mat, int k) {
            var a = new int[]{0};
            for (var m : mat) a = kSmallestPairs(a, m, k);
            return a[k - 1];
        }

        // lc.373
        public int[] kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            int[] ans = new int[Math.min(k, nums1.length * nums2.length)];
            queue.add(new int[]{nums1[0] + nums2[0], 0, 0});
            for (int i = 0; i < k && !queue.isEmpty(); i++) {
                int[] q = queue.poll();
                int x = q[1], y = q[2];
                ans[i] = nums1[x] + nums2[y];
                if (y == 0 && x + 1 < nums1.length) queue.add(new int[]{nums1[x + 1] + nums2[y], x + 1, y});
                if (y + 1 < nums2.length) queue.add(new int[]{nums1[x] + nums2[y + 1], x, y + 1});
            }
            return ans;
        }

        // 暴力，每一行只记录k个最小的值，然后又下一行计算的k*len个值，排序保留最小k个
        public int kthSmallest_bf(int[][] mat, int k) {
            int[] a = {0};
            for (int[] row : mat) {
                int[] b = new int[row.length * a.length];
                int i = 0;
                for (int x : a)
                    for (int y : row)
                        b[i++] = x + y;
                Arrays.sort(b);
                if (b.length > k)
                    b = Arrays.copyOfRange(b, 0, k);
                a = b;
            }
            return a[k - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}