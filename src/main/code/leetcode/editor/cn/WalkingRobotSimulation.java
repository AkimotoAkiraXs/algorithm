// A robot on an infinite XY-plane starts at point (0, 0) facing north. The
// robot can receive a sequence of these three possible types of commands:
//
// 
// -2: Turn left 90 degrees. 
// -1: Turn right 90 degrees. 
// 1 <= k <= 9: Move forward k units, one unit at a time. 
// 
//
// Some of the grid squares are obstacles. The iᵗʰ obstacle is at grid point 
// obstacles[i] = (xi, yi). If the robot runs into an obstacle, then it will instead
// stay in its current location and move on to the next command.
//
// Return the maximum Euclidean distance that the robot ever gets from the 
// origin squared (i.e. if the distance is 5, return 25).
//
// Note: 
//
// 
// North means +Y direction. 
// East means +X direction. 
// South means -Y direction. 
// West means -X direction. 
// 
//
// 
// Example 1: 
//
// 
// Input: commands = [4,-1,3], obstacles = []
// Output: 25
// Explanation: The robot starts at (0, 0):
// 1. Move north 4 units to (0, 4).
// 2. Turn right.
// 3. Move east 3 units to (3, 4).
// The furthest point the robot ever gets from the origin is (3, 4), which
// squared is 3² + 4² = 25 units away.
// 
//
// Example 2: 
//
// 
// Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
// Output: 65
// Explanation: The robot starts at (0, 0):
// 1. Move north 4 units to (0, 4).
// 2. Turn right.
// 3. Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1,
// 4).
// 4. Turn left.
// 5. Move north 4 units to (1, 8).
// The furthest point the robot ever gets from the origin is (1, 8), which
// squared is 1² + 8² = 65 units away.
// 
//
// Example 3: 
//
// 
// Input: commands = [6,-1,-1,6], obstacles = []
// Output: 36
// Explanation: The robot starts at (0, 0):
// 1. Move north 6 units to (0, 6).
// 2. Turn right.
// 3. Turn right.
// 4. Move south 6 units to (0, 0).
// The furthest point the robot ever gets from the origin is (0, 6), which
// squared is 6² = 36 units away.
// 
//
// 
// Constraints: 
//
// 
// 1 <= commands.length <= 10⁴ 
// commands[i] is either -2, -1, or an integer in the range [1, 9]. 
// 0 <= obstacles.length <= 10⁴ 
// -3 * 10⁴ <= xi, yi <= 3 * 10⁴ 
// The answer is guaranteed to be less than 2³¹. 
// 
//
// 👍 207 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;874
 * <p>
 * Name：Walking Robot Simulation
 *
 * @author Yuri
 * @since 2023-07-19 15:10:43
 */


public class WalkingRobotSimulation {
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
        System.out.println(-1 % 4);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // hash+模拟：注意数据范围最大值是6e4，可以得出结论所求值只会在终点和起点出现，除了开始点其他点都会作为终点所以只需要考虑终点就行了
        public int robotSim(int[] commands, int[][] obstacles) {
            int MAX = (int) (6e4 + 1); // 注意数据范围，最大值+1避免hash被击中
            int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            Set<Integer> hash = new HashSet<>();
            for (int[] obstacle : obstacles) hash.add(obstacle[0] * MAX + obstacle[1]);
            int d = 0, x = 0, y = 0, max = 0;
            for (int command : commands) {
                if (command == -1) d = (d + 1) % 4;
                else if (command == -2) d = (d - 1 + 4) % 4;
                else {
                    int xx, yy;
                    for (int i = 1; i <= command; i++) {
                        xx = x + dir[d][0];
                        yy = y + dir[d][1];
                        if (hash.contains(xx * MAX + yy)) break;
                        x = xx;
                        y = yy;
                    }
                    max = Math.max(max, x * x + y * y);
                }
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
