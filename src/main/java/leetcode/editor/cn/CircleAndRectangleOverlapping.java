package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1401 <br/>
 * Name：Circle and Rectangle Overlapping <br/>
 *
 * @author Yuri
 * @since 2023-06-25 21:45:50
 */

public class CircleAndRectangleOverlapping {
    public static void main(String[] args) {
        Solution solution = new CircleAndRectangleOverlapping().new Solution();
        solution.checkOverlap(4, 102, 50, 0, 0, 100, 100);
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 数学（几何）：求矩形上（包含矩形内部）的点到圆心的最小距离dis，这个距离小于r则表示有点在园中
         * <p>
         * dis*dis = x^2+y^2，这里把x，y分类讨论： <br>
         * 如果x1<=xCenter<=x2，如果x1>xCenter那么x轴上最短距离是x1-xCenter，x2<xCenter是xCenter-x2，y轴同理。
         */
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            double dis = 0;
            if (x1 > xCenter || x2 < xCenter) {
                // 这里取的平方不会有符号，所以不用担心谁减谁，(x1-x2)^2 = (x2-x1)^2
                dis += Math.min(Math.pow(x1 - xCenter, 2), Math.pow(xCenter - x2, 2));
            }
            if (y1 > yCenter || y2 < yCenter) {
                dis += Math.min(Math.pow(y1 - yCenter, 2), Math.pow(yCenter - y2, 2));
            }
            return dis <= radius * radius;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
