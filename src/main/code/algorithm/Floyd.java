package algorithm;

import java.util.Arrays;

/**
 * 弗洛伊德
 * <p>
 * 求图中某个点到某个点的最小距离，于Dijkstra不同的是Floyd是求一整个图
 * <p>
 * 思路：类似于0-1背包，对i-j的最短路中间编号进行是否需要的选择考虑。
 * f[k][i][j]的定义表示从 i 到 j 的最短路长度，并且这条最短路的中间节点编号都<=k。
 *
 * @author Yuri
 * @see <a href="https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/solutions/2525946/dai-ni-fa-ming-floyd-suan-fa-cong-ji-yi-m8s51/">Floyd 算法介绍</a>
 * @see Dijkstra 迪杰斯特拉
 * @since 2024/4/16 18:13
 */


public class Floyd {

    public int[][] findTheCity(int n, int[][] edges) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int[] x : g) Arrays.fill(x, INF);
        for (int[] e : edges) {
            int x = e[0], y = e[1], z = e[2];
            g[x][y] = z;
            g[y][x] = z;
        }
        // 维度k的空间被省略了,所以直接把g当做f使用（既完成了初始化又解约了空间）
        for (int k = 0; k < n; k++)
            for (int i = n - 1; i >= 0; i--)
                for (int j = n - 1; j >= 0; j--)
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
        return g;
    }
}
