// You are given a 2D array points and a string s where, points[i] represents
// the coordinates of point i, and s[i] represents the tag of point i.
//
// A valid square is a square centered at the origin (0, 0), has edges parallel 
// to the axes, and does not contain two points with the same tag.
//
// Return the maximum number of points contained in a valid square. 
//
// Note: 
//
// 
// A point is considered to be inside the square if it lies on or within the 
// square's boundaries.
// The side length of the square can be zero. 
// 
//
// 
// Example 1: 
//
// 
//
// 
// Input: points = [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], s = "abdca" 
// 
//
// Output: 2 
//
// Explanation: 
//
// The square of side length 4 covers two points points[0] and points[1]. 
//
// Example 2: 
//
// 
//
// 
// Input: points = [[1,1],[-2,-2],[-2,2]], s = "abb" 
// 
//
// Output: 1 
//
// Explanation: 
//
// The square of side length 2 covers one point, which is points[0]. 
//
// Example 3: 
//
// 
// Input: points = [[1,1],[-1,-1],[2,-2]], s = "ccd" 
// 
//
// Output: 0 
//
// Explanation: 
//
// It's impossible to make any valid squares centered at the origin such that 
// it covers only one point among points[0] and points[1].
//
// 
// Constraints: 
//
// 
// 1 <= s.length, points.length <= 10⁵ 
// points[i].length == 2 
// -10⁹ <= points[i][0], points[i][1] <= 10⁹ 
// s.length == points.length 
// points consists of distinct coordinates. 
// s consists only of lowercase English letters. 
// 
//
// 👍 34 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;3143
 * <p>
 * Name：Maximum Points Inside the Square
 *
 * @author Yuri
 * @since 2024-09-05 10:45:59
 */

public class MaximumPointsInsideTheSquare {

    public static void main(String[] args) {
        Solution solution = new MaximumPointsInsideTheSquare().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxPointsInsideSquare(int[][] points, String s) {
            char[] cs = s.toCharArray();
            int l = 0, r = 0, ans = 0;
            for (int[] p : points) r = Math.max(r, Math.max(Math.abs(p[0]), Math.abs(p[1])));
            out:
            while (l <= r) {
                int mid = l + r >> 1;
                var hash = new boolean[128];
                var cnt = 0;
                for (int i = 0; i < points.length; i++) {
                    var p = points[i];
                    if (Math.abs(p[0]) <= mid && Math.abs(p[1]) <= mid) {
                        if (!hash[cs[i]]) {
                            hash[cs[i]] = true;
                            cnt++;
                        } else {
                            r = mid - 1;
                            continue out;
                        }
                    }
                }
                l = mid + 1;
                ans = cnt;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}