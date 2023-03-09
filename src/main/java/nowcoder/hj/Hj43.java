package nowcoder.hj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/9 15:50
 */

public class Hj43 {
    static int n, m;
    static int[][] map;
    static boolean flag;
    static boolean[][] vis;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }
        flag = false;
        vis = new boolean[n][m];
        dfs(0, 0, new ArrayDeque<>(), new ArrayDeque<>());
    }

    public static void dfs(int x, int y, Deque<Integer> xq, Deque<Integer> yq) {
        if (flag || x < 0 || x >= n || y < 0 || y >= m || vis[x][y] || map[x][y] == 1) return;
        vis[x][y] = true;
        xq.add(x);
        yq.add(y);
        if (x == n - 1 && y == m - 1) {
            while (!xq.isEmpty()) {
                System.out.println("(" + xq.poll() + "," + yq.poll() + ")");
            }
            flag = true;
        }

        dfs(x + 1, y, new ArrayDeque<>(xq), new ArrayDeque<>(yq));
        dfs(x - 1, y, new ArrayDeque<>(xq), new ArrayDeque<>(yq));
        dfs(x, y + 1, new ArrayDeque<>(xq), new ArrayDeque<>(yq));
        dfs(x, y - 1, new ArrayDeque<>(xq), new ArrayDeque<>(yq));
    }
}
