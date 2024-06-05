// There is a 1 million by 1 million grid on an XY-plane, and the coordinates of
// each grid square are (x, y).
//
// We start at the source = [sx, sy] square and want to reach the target = [tx, 
// ty] square. There is also an array of blocked squares, where each blocked[i] = [
// xi, yi] represents a blocked square with coordinates (xi, yi).
//
// Each move, we can walk one square north, east, south, or west if the square 
// is not in the array of blocked squares. We are also not allowed to walk outside
// of the grid.
//
// Return true if and only if it is possible to reach the target square from 
// the source square through a sequence of valid moves.
//
// 
// Example 1: 
//
// 
// Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
// Output: false
// Explanation: The target square is inaccessible starting from the source
// square because we cannot move.
// We cannot move north or east because those squares are blocked.
// We cannot move south or west because we cannot go outside of the grid.
// 
//
// Example 2: 
//
// 
// Input: blocked = [], source = [0,0], target = [999999,999999]
// Output: true
// Explanation: Because there are no blocked cells, it is possible to reach the
// target square.
// 
//
// 
// Constraints: 
//
// 
// 0 <= blocked.length <= 200 
// blocked[i].length == 2 
// 0 <= xi, yi < 10⁶ 
// source.length == target.length == 2 
// 0 <= sx, sy, tx, ty < 10⁶ 
// source != target 
// It is guaranteed that source and target are not blocked. 
// 
//
// 👍 206 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;1036
 * <p>
 * Name：Escape a Large Maze
 *
 * @author Yuri
 * @since 2024-06-03 19:09:42
 */

public class EscapeALargeMaze {

    public static void main(String[] args) {
        Solution solution = new EscapeALargeMaze().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * bfs+离散化
     * <p>
     * 简单来说就是进行压缩，把无限空间中有限的个体映射到有限的空间中去
     * <p>
     * 添加(-1,-1)、(1e6,1e6)是保证如果图中所有点不是从某方向的边界开始，离散化后也会在该方向开始时留一条空边
     */
    class Solution {

        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            int edge = (int) 1e6;
            List<int[]> list = new ArrayList<>();
            for (int[] block : blocked) list.add(new int[]{block[0], block[1], 0});
            list.add(new int[]{-1, -1, 0}); // 上、左边界，虽然该边界无法通过，但是为后续代码生成上、左边界生成通行边提供便利
            list.add(new int[]{edge, edge, 0}); // 下、右边界
            list.add(new int[]{source[0], source[1], 1});
            list.add(new int[]{target[0], target[1], 2});

            int[][] cp = list.toArray(new int[0][]);
            int n = cp.length;
            int mx = 0, my = 0; // 右、下最大边界值

            Arrays.sort(cp, Comparator.comparing(o -> o[0]));
            for (int i = 0; i < n; ) {
                int j = i, cur = cp[i][0];
                while (i < n && cp[i][0] == cur) i++;
                for (; j < i; j++) cp[j][0] = mx;
                if (i < n) {
                    if (cp[i][0] - cur > 1) mx += 2;
                    else mx++;
                }
            }
            Arrays.sort(cp, Comparator.comparing(o -> o[1]));
            for (int i = 0; i < n; ) {
                int j = i, cur = cp[i][1];
                while (i < n && cp[i][1] == cur) i++;
                for (; j < i; j++) cp[j][1] = my;
                if (i < n) {
                    if (cp[i][1] - cur > 1) my += 2;
                    else my++;
                }
            }
            boolean[][] vis = new boolean[mx + 1][my + 1];
            int sx = 0, sy = 0, ex = 0, ey = 0;
            for (int[] c : cp) {
                int x = c[0], y = c[1];
                if (c[2] == 1) {
                    sx = x;
                    sy = y;
                } else if (c[2] == 2) {
                    ex = x;
                    ey = y;
                } else vis[x][y] = true;
            }

            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            Deque<int[]> deque = new LinkedList<>();
            deque.add(new int[]{sx, sy});
            vis[sx][sy] = true;
            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                int x = q[0], y = q[1];
                for (int[] d : dir) {
                    int a = x + d[0], b = y + d[1];
                    if (a == ex && b == ey) return true; // source != target 所以不用担心原点情况
                    if (a > 0 && a < mx && b > 0 && b < my && !vis[a][b]) { // 上、左边的第一行、第一列是由-1、-1生成的边界，不可通过
                        vis[a][b] = true;
                        deque.add(new int[]{a, b});
                    }
                }
            }
            return false;
        }
    }

    /**
     * bfs+最大面积
     * <p>
     * 根据题意，如果两点无法到达则必然是有个点被障碍所围住而另一个点没有被围住。
     * ∵ n=blocked.length <= 200，所以根据该数据量推导其可围得最大面积为max=(n*(n-1))/2，即靠两边墙斜着围。
     * 所以我们进行bfs对两点进行搜索，如果搜索结束面积小于max则表示被围住，大于max则表示没被围住
     * （max除了精算也可以估一个较大值，因为没被围住时则搜索方块数一定为1e12-n，所以考虑不超时情况下估一个较大的数也是可以的）。
     * 如果两点同时被围住或同时没被围住则返回true（因为grid范围1e6，n<=200，所以不存在一面墙围两边）。
     */
    class Solution_ {

        long m = (long) 1e6;

        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            int n = blocked.length;
            int max = (n * (n - 1)) / 2;
            Set<Long> hash = Arrays.stream(blocked).map(a -> a[0] * m + a[1]).collect(Collectors.toSet());
            return bfs(new HashSet<>(hash), source, max) == bfs(new HashSet<>(hash), target, max);
        }

        private boolean bfs(Set<Long> hash, int[] pos, int cnt) {
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            Deque<Long> deque = new LinkedList<>();
            deque.add(pos[0] * m + pos[1]);
            hash.add(pos[0] * m + pos[1]);
            while (!deque.isEmpty() && --cnt >= 0) {
                long p = deque.poll();
                long x = p / m, y = p % m;
                for (int[] d : dir) {
                    long a = x + d[0], b = y + d[1];
                    if (a >= 0 && a < m && b >= 0 && b < m && hash.add(a * m + b))
                        deque.add(a * m + b);
                }
            }
            return cnt < 0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}