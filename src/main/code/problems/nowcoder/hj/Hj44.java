package problems.nowcoder.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/10 0:28
 */

public class Hj44 {

    static int[][] map;
    static List<Integer> xList; // 牛客不支持Pair，不然坐标用pair更优雅
    static List<Integer> yList;
    static boolean brk;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        map = new int[9][9];
        xList = new ArrayList<>();
        yList = new ArrayList<>();
        brk = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = in.nextInt();
                map[i][j] = num;
                if (num == 0) {
                    xList.add(i);
                    yList.add(j);
                }
            }
        }
        func(0);
    }

    public static void func(int l) {
        if (brk) return;
        if (l == xList.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.printf("%d ", map[i][j]);
                }
                System.out.println();
            }
            brk = true;
            return;
        }
        Integer x = xList.get(l);
        Integer y = yList.get(l);
        for (int i = 1; i <= 9; i++) {
            boolean flag = true;
            for (int j = 0; j < 9; j++) {
                if ((j != x && map[j][y] == i) || (j != y && map[x][j] == i)) { // 横 竖
                    flag = false;
                    break;
                }
            }
            for (int j = (x / 3) * 3; j < (x / 3 + 1) * 3 && flag; j++) {
                for (int k = (y / 3) * 3; k < (y / 3 + 1) * 3; k++) {
                    if ((j != x || k != y) && map[j][k] == i) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                map[x][y] = i;
                func(l + 1);
                map[x][y] = 0; // 回溯
            }
        }
    }
}
