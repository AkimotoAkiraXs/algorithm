package template;

/**
 * @author Yuri
 * @since 2024/5/28 10:52
 */


public class DisjointSet {

    int[] p, sz;
    int[][] grid;
    int x, y;
    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int find(int a) {
        if (a != p[a]) p[a] = find(p[a]);
        return p[a];
    }

    public void union(int i, int j) {
        int a = find(i), b = find(j);
        if (a != b) {
            sz[b] += sz[a];
            p[a] = p[b];
        }
    }

    public void disjointSet(int[][] grid) {
        this.grid = grid;
        x = grid.length;
        y = grid[0].length;

        // 初始化
        for (int i = 0; i < x * y; i++)
            if (grid[i / y][i % y] == 1) p[i] = i;

        // 合并
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 0) continue;
                for (int[] d : dir) {
                    int a = i + d[0], b = i + d[1];
                    if (a >= 0 && a < x && b >= 0 && b < y && grid[a][b] == 1) union(i * y + j, a * y + b);
                }
            }
        }
    }
}
