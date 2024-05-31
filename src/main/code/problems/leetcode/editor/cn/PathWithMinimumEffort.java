// You are a hiker preparing for an upcoming hike. You are given heights, a 2D
// array of size rows x columns, where heights[row][col] represents the height of
// cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to
// travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can
// move up, down, left, or right, and you wish to find a route that requires the
// minimum effort.
//
// A route's effort is the maximum absolute difference in heights between two 
// consecutive cells of the route.
//
// Return the minimum effort required to travel from the top-left cell to the 
// bottom-right cell.
//
// 
// Example 1: 
//
// 
//
// 
// Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
// Output: 2
// Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2
// in consecutive cells.
// This is better than the route of [1,2,2,2,5], where the maximum absolute
// difference is 3.
// 
//
// Example 2: 
//
// 
//
// 
// Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
// Output: 1
// Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1
// in consecutive cells, which is better than route [1,3,5,3,5].
// 
//
// Example 3: 
// 
// 
// Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//
// Output: 0
// Explanation: This route does not require any effort.
// 
//
// 
// Constraints: 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 10⁶ 
// 
//
// 👍 507 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Id：&emsp;&emsp;1631
 * <p>
 * Name：Path With Minimum Effort
 *
 * @author Yuri
 * @since 2024-05-30 18:01:29
 */

public class PathWithMinimumEffort {

    public static void main(String[] args) {
        Solution solution = new PathWithMinimumEffort().new Solution();

        System.out.println(solution.minimumEffortPath(
            new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    // bfs+优先队列，思路和Prim、Dijkstra差不多
    class Solution {

        public int minimumEffortPath(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int[][] cnt = new int[m][n];
            for (int[] t : cnt) Arrays.fill(t, Integer.MAX_VALUE);
            cnt[0][0] = 0;
            TreeSet<Integer> s = new TreeSet<>((a, b) -> {
                if (cnt[a / n][a % n] == cnt[b / n][b % n]) return a - b;
                return cnt[a / n][a % n] - cnt[b / n][b % n];
            });
            s.add(0);
            while (!s.isEmpty()) {
                int p = s.pollFirst();
                int i = p / n, j = p % n;
                for (int[] d : dir) {
                    int a = i + d[0], b = j + d[1];
                    if (a >= 0 && a < m && b >= 0 && b < n && cnt[a][b] > Math.max(cnt[i][j],
                        Math.abs(heights[i][j] - heights[a][b]))) {
                        cnt[a][b] = Math.max(cnt[i][j], Math.abs(heights[i][j] - heights[a][b]));
                        s.add(a * n + b);
                    }
                }
            }
            return cnt[m - 1][n - 1];
        }
    }

    // kurskal 基于并查集的最小生成树
    class Solution_Kurskal {

        int[] p, h;

        private int find(int k) {
            if (k != p[k]) p[k] = find(p[k]);
            return p[k];
        }

        private void union(int x, int y, int val) {
            int a = find(x), b = find(y);
            if (a != b) {
                p[a] = p[b];
                h[b] = Math.max(val, Math.max(h[a], h[b]));
            }
        }

        public int minimumEffortPath(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            p = new int[m * n];
            h = new int[m * n];
            TreeSet<int[]> q = new TreeSet<>((a, b) -> {
                for (int i = 2; i >= 0; i--)
                    if (a[i] != b[i]) return a[i] - b[i];
                return 0;
            });
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    q.add(new int[]{i * n + j, i * n + j + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
                    q.add(new int[]{i * n + j, (i + 1) * n + j, Math.abs(heights[i][j] - heights[i + 1][j])});
                }
            }
            for (int i = 0; i < m - 1; i++)
                q.add(
                    new int[]{i * n + n - 1, (i + 1) * n + n - 1, Math.abs(heights[i][n - 1] - heights[i + 1][n - 1])});
            for (int j = 0; j < n - 1; j++)
                q.add(new int[]{(m - 1) * n + j, (m - 1) * n + j + 1,
                    Math.abs(heights[m - 1][j] - heights[m - 1][j + 1])});

            for (int i = 0; i < m * n; i++) p[i] = i;
            for (int[] t : q) {
                int x = t[0], y = t[1], val = t[2];
                if (find(x) != find(y)) {
                    union(x, y, val);
                    if (find(0) == find(n * m - 1)) return h[find(0)];
                }
            }
            return 0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}