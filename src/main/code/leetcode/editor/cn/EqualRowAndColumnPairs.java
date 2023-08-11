// Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri,
// cj) such that row ri and column cj are equal.
//
// A row and column pair is considered equal if they contain the same elements 
// in the same order (i.e., an equal array).
//
// 
// Example 1: 
// 
// 
// Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
// Output: 1
// Explanation: There is 1 equal row and column pair:
//- (Row 2, Column 1): [2,7,7]
// 
//
// Example 2: 
// 
// 
// Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
// Output: 3
// Explanation: There are 3 equal row and column pairs:
//- (Row 0, Column 0): [3,1,2,2]
//- (Row 2, Column 2): [2,4,2,2]
//- (Row 3, Column 2): [2,4,2,2]
// 
//
// 
// Constraints: 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 矩阵 模拟 👍 41 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;2352
 * <p>
 * Name：Equal Row and Column Pairs
 *
 * @author Yuri
 * @since 2023-06-06 10:02:30
 */


public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        Solution solution = new EqualRowAndColumnPairs().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 模拟o(n^3)，哈希o(n^2)
        public int equalPairs(int[][] grid) {
            int ans = 0;
            int n = grid.length;
            Map<String, Integer> map = new HashMap<>();
            for (int[] value : grid) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) sb.append(value[j]).append(",");
                String key = sb.toString();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int[] ints : grid) sb.append(ints[i]).append(",");
                String key = sb.toString();
                ans += map.getOrDefault(key, 0);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
