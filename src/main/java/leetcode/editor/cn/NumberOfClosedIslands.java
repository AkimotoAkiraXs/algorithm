package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1254 <br/>
 * Name：Number of Closed Islands <br/>
 *
 * @author Yuri
 * @since 2023-06-18 09:04:06
 */

public class NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfClosedIslands().new Solution();
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int X, Y;
        boolean[][] vis;
        int[][] graph;

        public int closedIsland(int[][] grid) {
            X = grid.length;
            Y = grid[0].length;
            vis = new boolean[X][Y];
            int ans = 0;
            this.graph = grid;
            for (int i = 0; i < X; i++) {
                if (grid[i][0] == 0) dfs(i, 0);
                if (grid[i][Y - 1] == 0) dfs(i, Y - 1);
            }
            for (int i = 0; i < Y; i++) {
                if (grid[0][i] == 0) dfs(0, i);
                if (grid[X - 1][i] == 0) dfs(X - 1, i);
            }
            for (int i = 1; i < X - 1; i++) {
                for (int j = 1; j < Y - 1; j++) {
                    if (graph[i][j] == 0) {
                        ans++;
                        dfs(i, j);
                    }
                }
            }
            return ans;
        }

        private void dfs(int x, int y) {
            graph[x][y] = 1;
            if (x > 0 && graph[x - 1][y] == 0) dfs(x - 1, y);
            if (x < X - 1 && graph[x + 1][y] == 0) dfs(x + 1, y);
            if (y > 0 && graph[x][y - 1] == 0) dfs(x, y - 1);
            if (y < Y - 1 && graph[x][y + 1] == 0) dfs(x, y + 1);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
