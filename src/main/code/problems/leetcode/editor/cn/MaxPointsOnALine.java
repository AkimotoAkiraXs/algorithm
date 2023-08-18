//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
//
//
//
// 示例 1：
//
//
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
//
//
// 示例 2：
//
//
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
//
//
//
//
// 提示：
//
//
// 1 <= points.length <= 300
// points[i].length == 2
// -104 <= xi, yi <= 104
// points 中的所有点 互不相同
//
// Related Topics 几何 哈希表 数学
// 👍 264 👎 0


/*
 * Id：149
 * Name：直线上最多的点数
 * Date：2021-06-24 09:24:32
 */
package problems.leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new MaxPointsOnALine().new Solution();
        int[][] points = new int[][]{{7, 3}, {19, 19}, {-16, 3}, {13, 17}, {-18, 1}, {-18, -17}, {13, -3}, {3, 7}, {-11, 12}, {7, 19}, {19, -12}, {20, -18}, {-16, -15}, {-10, -15}, {-16, -18}, {-14, -1}, {18, 10}, {-13, 8}, {7, -5}, {-4, -9}, {-11, 2}, {-9, -9}, {-5, -16}, {10, 14}, {-3, 4}, {1, -20}, {2, 16}, {0, 14}, {-14, 5}, {15, -11}, {3, 11}, {11, -10}, {-1, -7}, {16, 7}, {1, -11}, {-8, -3}, {1, -6}, {19, 7}, {3, 6}, {-1, -2}, {7, -3}, {-6, -8}, {7, 1}, {-15, 12}, {-17, 9}, {19, -9}, {1, 0}, {9, -10}, {6, 20}, {-12, -4}, {-16, -17}, {14, 3}, {0, -1}, {-18, 9}, {-15, 15}, {-3, -15}, {-5, 20}, {15, -14}, {9, -17}, {10, -14}, {-7, -11}, {14, 9}, {1, -1}, {15, 12}, {-5, -1}, {-17, -5}, {15, -2}, {-12, 11}, {19, -18}, {8, 7}, {-5, -3}, {-17, -1}, {-18, 13}, {15, -3}, {4, 18}, {-14, -15}, {15, 8}, {-18, -12}, {-15, 19}, {-9, 16}, {-9, 14}, {-12, -14}, {-2, -20}, {-3, -13}, {10, -7}, {-2, -10}, {9, 10}, {-1, 7}, {-17, -6}, {-15, 20}, {5, -17}, {6, -6}, {-11, -8}};

        System.out.println(solution.maxPoints(points));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            Map<Double, Integer> map = new HashMap<>();
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
            });
            Map<Double, Integer> x = new HashMap<>();
            Map<Double, Integer> y = new HashMap<>();
            int k = 0, i = 0, j = 0;
            for (i = 0; i < points.length; i++) {
                for (j = i + 1; j < points.length; j++) {
                    double num;
                    if ((points[i][0] - points[j][0]) == 0) {
                        num = points[i][0];
                        if (x.containsKey(num)) {
                            x.put(num, x.get(num) + 1);
                        } else {
                            x.put(num, 1);
                        }
                        continue;
                    }
                    if ((points[i][1] - points[j][1]) == 0) {
                        num = points[i][1];
                        if (y.containsKey(num)) {
                            y.put(num, y.get(num) + 1);
                        } else {
                            y.put(num, 1);
                        }
                        continue;
                    } else {
                        num = (double) (points[i][0] - points[j][0]) / (double) (points[i][1] - points[j][1]);
                    }
                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }
            }
            AtomicInteger ans = new AtomicInteger();
            map.forEach((key, value) -> {
                if (value > ans.get()) {
                    ans.set(value);
                    System.out.println("k1 = " + key);
                }
            });
            x.forEach((key, value) -> {
                if (value > ans.get()) {
                    ans.set(value);
                    System.out.println("k2 = " + key);
                }
            });
            y.forEach((key, value) -> {
                if (value > ans.get()) {
                    ans.set(value);
                    System.out.println("k3 = " + key);
                }
            });
            int res = ans.get();
            int a = 1, b = -1, c = -res * 2;
            return (int) ((1 + Math.sqrt(1 - 4 * c)) / 2.0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 