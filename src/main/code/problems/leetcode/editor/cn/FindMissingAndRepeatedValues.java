// You are given a 0-indexed 2D integer matrix grid of size n * n with values in
// the range [1, n²]. Each integer appears exactly once except a which appears
// twice and b which is missing. The task is to find the repeating and missing numbers
// a and b.
//
// Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and 
// ans[1] equals to b.
//
// 
// Example 1: 
//
// 
// Input: grid = [[1,3],[2,2]]
// Output: [2,4]
// Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,
// 4].
// 
//
// Example 2: 
//
// 
// Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
// Output: [9,5]
// Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,
// 5].
// 
//
// 
// Constraints: 
//
// 
// 2 <= n == grid.length == grid[i].length <= 50 
// 1 <= grid[i][j] <= n * n 
// For all x that 1 <= x <= n * n there is exactly one x that is not equal to 
// any of the grid members.
// For all x that 1 <= x <= n * n there is exactly one x that is equal to 
// exactly two of the grid members.
// For all x that 1 <= x <= n * n except two of them there is exatly one pair 
// of i, j that 0 <= i, j <= n - 1 and grid[i][j] == x.
// 
//
// 👍 23 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;2965
 * <p>
 * Name：Find Missing and Repeated Values
 *
 * @author Yuri
 * @since 2024-08-02 15:04:43
 */

public class FindMissingAndRepeatedValues {

    public static void main(String[] args) {
        Solution solution = new FindMissingAndRepeatedValues().new Solution();
        solution.findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 位运算：把1、2...n^2加入进grid进行异或运算，则a会出现3次（相当于1次），b会出现1次，其他数出现2次，
         * 则问题转换为了 Lc260.SingleNumberIii
         * <p>
         * 1...n的与或值有O(1)的做法，请看Lc1486.XorOperationInAnArray
         * <p>
         * 复杂度：O(n^2)
         *
         * @see SingleNumberIii Lc260.只出现一次的数字III
         * @see XorOperationInAnArray Lc1486.数组异或操作
         */
        public int[] findMissingAndRepeatedValues_bit(int[][] grid) {
            int n = grid.length;
            int k = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    k ^= grid[i][j] ^ i * n + j + 1;
            k &= -k;
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((grid[i][j] & k) > 0) a.add(grid[i][j]);
                    else b.add(grid[i][j]);
                    int num = i * n + j + 1;
                    if ((num & k) > 0) a.add(num);
                    else b.add(num);
                }
            }
            int[] ans = new int[2];
            for (int num : a) ans[0] ^= num;
            for (int num : b) ans[1] ^= num;
            for (int[] xs : grid)
                for (int x : xs)
                    if (x == ans[0]) return ans;
            return new int[]{ans[1], ans[0]};
        }

        /**
         * 计数：直接暴力计数，最标准的解
         */
        public int[] findMissingAndRepeatedValues_count(int[][] grid) {
            return null;
        }

        /**
         * 数学：<a href="https://gitee.com/YuriMing/akira-pictures/raw/master/img/202408021658568.png">推理思路</a>
         */
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            int d1 = 0, d2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = grid[i][j], y = i * n + j + 1;
                    d1 += x - y;
                    d2 += x * x - y * y;
                }
            }
            return new int[]{(d2 / d1 + d1) / 2, (d2 / d1 - d1) / 2};
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}