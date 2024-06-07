// English description is not available for the problem. Please switch to
// Chinese.
// 👍 9 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.TreeSet;

/**
 * Id：&emsp;&emsp;LCP 75
 * <p>
 * Name：传送卷轴
 *
 * @author Yuri
 * @since 2024-06-06 17:58:24
 */

public class RdmXM7 {

    public static void main(String[] args) {
        Solution solution = new RdmXM7().new Solution();
        solution.challengeOfTheKeeper(new String[]{".....", "##S..", "...#.", "T.#..", "###.."});

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 1.bfs记录所有点到target的距离
     * 2.遍历每个点，记录其两个镜像点中的最大值（表示守卫者在该点使用魔法卷轴的收益）
     * 3.现在问题转变为了：每个点的有一定代价，求达到target代价最小值，bfs+优先队列
     */
    class Solution {

        public int challengeOfTheKeeper(String[] maze) {
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            char[][] g = Arrays.stream(maze).map(String::toCharArray).toArray(char[][]::new);
            int m = g.length, n = g[0].length;

            int sx = -1, sy = -1, tx = -1, ty = -1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char c = g[i][j];
                    if (c == 'S') {
                        sx = i;
                        sy = j;
                        g[i][j] = '.';
                    } else if (c == 'T') {
                        tx = i;
                        ty = j;
                        g[i][j] = '.';
                    }
                }
            }

            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{tx, ty, 0});
            boolean[][] vis = new boolean[m][n];
            int[][] dis = new int[m][n];
            for (int[] d : dis) Arrays.fill(d, Integer.MAX_VALUE);
            while (!deque.isEmpty()) {
                int[] q = deque.poll();
                int x = q[0], y = q[1], v = q[2];
                dis[x][y] = v;
                for (int[] d : dir) {
                    int a = x + d[0], b = y + d[1];
                    if (a >= 0 && a < m && b >= 0 && b < n && !vis[a][b] && g[a][b] == '.') {
                        vis[a][b] = true;
                        deque.add(new int[]{a, b, v + 1});
                    }
                }
            }
            dis[tx][ty] = 0;

            int[][] mir = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] == '.') {
                        int x = m - 1 - i, y = n - 1 - j;
                        if (g[x][j] == '.') mir[i][j] = Math.max(mir[i][j], dis[x][j]);
                        if (g[i][y] == '.') mir[i][j] = Math.max(mir[i][j], dis[i][y]);
                    }
                }
            }
            mir[sx][sy] = 0;

            TreeSet<int[]> t = new TreeSet<>(((o1, o2) -> {
                for (int i = 2; i >= 0; i--) if (o1[i] != o2[i]) return o1[i] - o2[i];
                return 0;
            }));

            t.add(new int[]{sx, sy, 0});
            while (!t.isEmpty()) {
                int[] q = t.pollFirst();
                int x = q[0], y = q[1], v = q[2];
                for (int[] d : dir) {
                    int a = x + d[0], b = y + d[1];
                    if (a >= 0 && a < m && b >= 0 && b < n && g[a][b] == '.') {
                        if (a == tx && b == ty) return v == Integer.MAX_VALUE ? -1 : v;
                        t.add(new int[]{a, b, Math.max(v, mir[a][b])});
                        g[a][b] = '#';
                    }
                }
            }
            return -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}