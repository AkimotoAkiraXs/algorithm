// You are given an array points, an integer angle, and your location, where
// location = [posx, posy] and points[i] = [xi, yi] both denote integral coordinates
// on the X-Y plane.
//
// Initially, you are facing directly east from your position. You cannot move 
// from your position, but you can rotate. In other words, posx and posy cannot be
// changed. Your field of view in degrees is represented by angle, determining how
// wide you can see from any given view direction. Let d be the amount in degrees
// that you rotate counterclockwise. Then, your field of view is the inclusive range
// of angles [d - angle/2, d + angle/2].
//
// 
// 
// Your browser does not support the video tag or this video format.
// 
//
// You can see some set of points if, for each point, the angle formed by the 
// point, your position, and the immediate east direction from your position is in
// your field of view.
//
// There can be multiple points at one coordinate. There may be points at your 
// location, and you can always see these points regardless of your rotation.
// Points do not obstruct your vision to other points.
//
// Return the maximum number of points you can see. 
//
// 
// Example 1: 
// 
// 
// Input: points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]
// Output: 3
// Explanation: The shaded region represents your field of view. All points can
// be made visible in your field of view, including [3,3] even though [2,2] is in
// front and in the same line of sight.
// 
//
// Example 2: 
//
// 
// Input: points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]
// Output: 4
// Explanation: All points can be made visible in your field of view, including
// the one at your location.
// 
//
// Example 3: 
// 
// 
// Input: points = [[1,0],[2,1]], angle = 13, location = [1,1]
// Output: 1
// Explanation: You can only see one of the two points, as shown above.
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 10⁵ 
// points[i].length == 2 
// location.length == 2 
// 0 <= angle < 360 
// 0 <= posx, posy, xi, yi <= 100 
// 
//
// 👍 130 👎 0

package problems.leetcode.editor.cn;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Id：&emsp;&emsp;1610
 * <p>
 * Name：Maximum Number of Visible Points
 *
 * @author Yuri
 * @since 2024-04-30 17:31:02
 */

public class MaximumNumberOfVisiblePoints {

    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfVisiblePoints().new Solution();

        // System.out.println(solution.ang(0, 0, 1, -1));
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = Lists.newArrayList(2, 1);
        List<Integer> l2 = Lists.newArrayList(2, 2);
        List<Integer> l3 = Lists.newArrayList(3, 3);
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        solution.visiblePoints(lists, 90, Lists.newArrayList(1, 1));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            double pi = Math.PI, eps = 1e-9;

            Integer x = location.get(0), y = location.get(1);

            List<Double> q = new ArrayList<>();
            int cnt = 0;
            for (List<Integer> point : points) {
                Integer xx = point.get(0), yy = point.get(1);
                if (Objects.equals(yy, y) && Objects.equals(xx, x)) cnt++; // 重叠的点能直接看到
                else q.add(Math.atan2(yy - y, xx - x));
            }
            Collections.sort(q);
            int n = q.size();
            for (int i = 0; i < n; i++) q.add(q.get(i) + 2 * pi); // 因为是个环，所以直接把头尾相连

            double t = angle * pi / 180; // 视野弧度
            int max = 0;
            for (int l = 0, r = 0; r < 2 * n; r++) {
                while (q.get(r) - q.get(l) > t + eps) l++;
                max = Math.max(max, r - l + 1);
            }
            return max + cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}