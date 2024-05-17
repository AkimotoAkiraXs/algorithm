// You have an integer matrix representing a plot of land, where the value at
// that location represents the height above sea level. A value of zero indicates
// water. A pond is a region of water connected vertically, horizontally, or
// diagonally. The size of the pond is the total number of connected water cells. Write a
// method to compute the sizes of all ponds in the matrix.
//
// Example: 
//
// 
// Input:
//[
//  [0,2,1,0],
//  [0,1,0,1],
//  [1,1,0,1],
//  [0,1,0,1]
//]
// Output:  [1,2,4]
// 
//
// Note: 
//
// 
// 0 < len(land) <= 1000 
// 0 < len(land[i]) <= 1000 
// 
//
// 👍 153 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;面试题 16.19
 * <p>
 * Name：Pond Sizes LCCI
 *
 * @author Yuri
 * @since 2024-05-17 10:10:47
 */

public class PondSizesLcci {

    public static void main(String[] args) {
        Solution solution = new PondSizesLcci().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int x, y;
        boolean[][] vis;
        int[][] land;

        public int[] pondSizes(int[][] land) {
            this.land = land;
            x = land.length;
            y = land[0].length;
            List<Integer> res = new ArrayList<>();
            vis = new boolean[x][y];
            for (int i = 0; i < x; i++)
                for (int j = 0; j < y; j++)
                    if (land[i][j] == 0 && !vis[i][j]) res.add(dfs(i, j));
            return res.stream().sorted().mapToInt(i -> i).toArray();
        }

        private int dfs(int i, int j) {
            if (i < 0 || i >= x || j < 0 || j >= y || land[i][j] != 0 || vis[i][j]) return 0;
            vis[i][j] = true;
            int sum = 1;
            for (int k = -1; k <= 1; k++)
                for (int l = -1; l <= 1; l++)
                    sum += dfs(i + k, j + l);
            return sum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}