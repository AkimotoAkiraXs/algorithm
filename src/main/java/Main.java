import java.util.*;

/**
 * @author Yuri
 * @since 2021/12/15 11:06
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("请输入数字选择排序算法：\n");


    }

    public static boolean[] er() {
        final int MAX = 60000 + 10;
        boolean[] vis = new boolean[MAX];
        vis[0] = vis[1] = true;
        for (int i = 2; i <= 60000; i++) {
            if (vis[i]) continue;
            for (int j = i; i * j < MAX; j++) {
                vis[i * j] = true;
            }
        }
        return vis;
    }
}
