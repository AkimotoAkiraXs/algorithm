// You are given an n x n binary matrix grid where 1 represents land and 0
// represents water.
//
// An island is a 4-directionally connected group of 1's not connected to any 
// other 1's. There are exactly two islands in grid.
//
// You may change 0's to 1's to connect the two islands to form one island. 
//
// Return the smallest number of 0's you must flip to connect the two islands. 
//
// 
// Example 1: 
//
// 
// Input: grid = [[0,1],[1,0]]
// Output: 1
// 
//
// Example 2: 
//
// 
// Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
// Output: 2
// 
//
// Example 3: 
//
// 
// Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == grid.length == grid[i].length 
// 2 <= n <= 100 
// grid[i][j] is either 0 or 1. 
// There are exactly two islands in grid. 
// 
//
// 👍 519 👎 0

package problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Id：&emsp;&emsp;934
 * <p>
 * Name：Shortest Bridge
 *
 * @author Yuri
 * @since 2024-05-27 18:52:50
 */

public class ShortestBridge {

    public static void main(String[] args) {
        Solution solution = new ShortestBridge().new Solution();
        solution.shortestBridge(new int[][]{{0, 1}, {1, 0}});
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public int shortestBridge(int[][] grid) {
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int x = grid.length, y = grid[0].length;
            Deque<Integer> qa = new LinkedList<>();
            Deque<int[]> qb = new LinkedList<>();
            for (int i = 0; i < x * y; i++) {
                if (grid[i / y][i % y] == 1) {
                    grid[i / y][i % y] = -1;
                    qa.add(i);
                    break;
                }
            }
            while (!qa.isEmpty()) {
                Integer pos = qa.poll();
                int i = pos / y, j = pos % y;
                qb.add(new int[]{pos, 0});
                for (int[] d : dir) {
                    int a = i + d[0], b = j + d[1];
                    if (a >= 0 && a < x && b >= 0 && b < y && grid[a][b] == 1){
                        grid[a][b] = -1;
                        qa.add(a * y + b);
                    }
                }
            }
            while (!qb.isEmpty()) {
                int[] q = qb.poll();
                int pos = q[0];
                int val = q[1];
                int i = pos / y, j = pos % y;
                for (int[] d : dir) {
                    int a = i + d[0], b = j + d[1];
                    if (a >= 0 && a < x && b >= 0 && b < y) {
                        if (grid[a][b] == 1) return val;
                        if (grid[a][b] == 0){
                            grid[a][b] = -1;
                            qb.add(new int[]{a * y + b, val + 1});
                        }
                    }
                }
            }
            return -1;
        }
    }

    // 用了并查集+dfs+bfs 把问题想复杂了
    class Solution_disjointSet_dfs_bfs {

        int[] p;
        int[][] grid;
        int x, y;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] vis;

        public int find(int a) {
            if (a != p[a]) p[a] = find(p[a]);
            return p[a];
        }

        public void union(int i, int j) {
            int a = find(i), b = find(j);
            if (a != b) p[a] = p[b];
        }

        public int shortestBridge(int[][] grid) {
            this.grid = grid;
            x = grid.length;
            y = grid[0].length;
            vis = new boolean[x][y];
            p = new int[x * y];

            for (int i = 0; i < x * y; i++) {
                if (grid[i / y][i % y] == 1) p[i] = i;
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == 0) continue;
                    for (int[] d : dir) {
                        int a = i + d[0], b = j + d[1];
                        if (a >= 0 && a < x && b >= 0 && b < y && grid[a][b] == 1) union(i * y + j, a * y + b);
                    }
                }
            }

            Deque<int[]> deque = new LinkedList<>();

            int origin = -1;

            for (int i = 0; i < x * y; i++) {
                if (grid[i / y][i % y] == 1) {
                    dfs(i / y, i % y, deque);
                    origin = find(i);
                    break;
                }
            }

            vis = new boolean[x][y];
            int val;
            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                int pos = q[0];
                int i = pos / y, j = pos % y;
                val = q[1];
                for (int[] d : dir) {
                    int a = i + d[0], b = j + d[1];
                    if (a >= 0 && a < x && b >= 0 && b < y && !vis[a][b]) {
                        vis[a][b] = true;
                        if (grid[a][b] == 1 && find(a * y + b) != origin) return val;
                        if (grid[a][b] == 0) deque.add(new int[]{a * y + b, val + 1});
                    }
                }
            }
            return -1;
        }

        private void dfs(int i, int j, Deque<int[]> deque) {
            if (i >= 0 && i < x && j >= 0 && j < y && grid[i][j] == 1 && !vis[i][j]) {
                deque.add(new int[]{i * y + j, 0});
                vis[i][j] = true;
                for (int[] d : dir) dfs(i + d[0], j + d[1], deque);
            }
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}