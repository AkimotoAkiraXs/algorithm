// You are given a 2D integer array coordinates and an integer k, where
// coordinates[i] = [xi, yi] are the coordinates of the iᵗʰ point in a 2D plane.
//
// We define the distance between two points (x1, y1) and (x2, y2) as (x1 XOR x2
//) + (y1 XOR y2) where XOR is the bitwise XOR operation. 
//
// Return the number of pairs (i, j) such that i < j and the distance between 
// points i and j is equal to k.
//
// 
// Example 1: 
//
// 
// Input: coordinates = [[1,2],[4,2],[1,3],[5,2]], k = 5
// Output: 2
// Explanation: We can choose the following pairs:
//- (0,1): Because we have (1 XOR 4) + (2 XOR 2) = 5.
//- (2,3): Because we have (1 XOR 5) + (3 XOR 2) = 5.
// 
//
// Example 2: 
//
// 
// Input: coordinates = [[1,3],[1,3],[1,3],[1,3],[1,3]], k = 0
// Output: 10
// Explanation: Any two chosen pairs will have a distance of 0. There are 10
// ways to choose two pairs.
// 
//
// 
// Constraints: 
//
// 
// 2 <= coordinates.length <= 50000 
// 0 <= xi, yi <= 10⁶ 
// 0 <= k <= 100 
// 
//
// 👍 19 👎 0

package problems.leetcode.editor.cn;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;2857
 * <p>
 * Name：Count Pairs of Points With Distance k
 *
 * @author Yuri
 * @since 2024-07-15 16:04:45
 */

public class CountPairsOfPointsWithDistanceK {

    public static void main(String[] args) {
        Solution solution = new CountPairsOfPointsWithDistanceK().new Solution();
        solution.countPairs(Arrays.asList(
            Arrays.asList(27, 94),
            Arrays.asList(61, 103)

        ), 95);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countPairs(List<List<Integer>> coordinates, int k) {
            long MAX = (long) 1e6 + 1;
            Map<Long, Integer> count = new HashMap<>();
            int ans = 0;
            for (List<Integer> coordinate : coordinates) {
                int x = coordinate.get(0), y = coordinate.get(1);
                for (int i = 0, j = k; i <= k; i++, j--)
                    ans += count.getOrDefault((x ^ j) * MAX + (y ^ i), 0);
                count.merge(x * MAX + y, 1, Integer::sum);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}