// You are given an n x n binary matrix grid. You are allowed to change at most
// one 0 to be 1.
//
// Return the size of the largest island in grid after applying this operation. 
//
//
// An island is a 4-directionally connected group of 1s. 
//
// 
// Example 1: 
//
// 
// Input: grid = [[1,0],[0,1]]
// Output: 3
// Explanation: Change one 0 to 1 and connect two 1s, then we get an island with
// area = 3.
// 
//
// Example 2: 
//
// 
// Input: grid = [[1,1],[1,0]]
// Output: 4
// Explanation: Change the 0 to 1 and make the island bigger, only one island
// with area = 4.
//
// Example 3: 
//
// 
// Input: grid = [[1,1],[1,1]]
// Output: 4
// Explanation: Can't change any 0 to 1, only one island with area = 4.
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 500 
// grid[i][j] is either 0 or 1. 
// 
//
// 👍 416 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;827
 * <p>
 * Name：Making A Large Island
 *
 * @author Yuri
 * @since 2024-05-24 15:04:57
 */

public class MakingALargeIsland {

    public static void main(String[] args) {
        Solution solution = new MakingALargeIsland().new Solution();
        solution.largestIsland(new int[][]{{1, 1}, {1, 1}});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        int[] p, sz;
        int[][] grid;
        int n;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int largestIsland(int[][] grid) {
            this.grid = grid;
            n = grid.length;
            p = new int[n * n + 1];
            sz = new int[n * n + 1];
            for (int i = 0; i < n * n; i++) {
                p[i] = i;
                sz[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) continue;
                    for (int[] d : dir) {
                        int a = i + d[0], b = j + d[1];
                        if (a >= 0 && a < n && b >= 0 && b < n && grid[a][b] == 1) union(i * n + j, a * n + b);
                    }
                }
            }

            int max = 0;
            Set<Integer> hash = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) { // 水
                        int cnt = 1;
                        hash.clear();
                        for (int[] d : dir) {
                            int a = i + d[0], b = j + d[1];
                            if (a < 0 || a >= n || b < 0 || b >= n || grid[a][b] == 0) continue;
                            int r = find(a * n + b);
                            if (hash.add(r)) cnt += sz[r];
                        }
                        max = Math.max(max, cnt);
                    } else max = Math.max(max, sz[i * n + j]);
                }
            }
            return max;
        }

        private int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }

        private void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra != rb) {
                sz[rb] += sz[ra];
                p[ra] = p[rb];
            }
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}