// You are given an integer array values where values[i] represents the value of
// the iᵗʰ sightseeing spot. Two sightseeing spots i and j have a distance j - i
// between them.
//
// The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + 
// i - j: the sum of the values of the sightseeing spots, minus the distance
// between them.
//
// Return the maximum score of a pair of sightseeing spots. 
//
// 
// Example 1: 
//
// 
// Input: values = [8,1,5,2,6]
// Output: 11
// Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
// 
//
// Example 2: 
//
// 
// Input: values = [1,2]
// Output: 2
// 
//
// 
// Constraints: 
//
// 
// 2 <= values.length <= 5 * 10⁴ 
// 1 <= values[i] <= 1000 
// 
//
// 👍 457 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1014
 * <p>
 * Name：Best Sightseeing Pair
 *
 * @author Yuri
 * @since 2024-09-29 10:02:02
 */

public class BestSightseeingPair {

    public static void main(String[] args) {
        Solution solution = new BestSightseeingPair().new Solution();
        solution.maxScoreSightseeingPair(new int[]{7, 2, 6, 6, 9, 4, 3});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxScoreSightseeingPair(int[] values) {
            int ans = 0;
            for (int i = 0, j = 1; j < values.length; j++) {
                ans = Math.max(ans, values[j] + values[i] + i - j);
                if (values[j] + j - i > values[i]) i = j;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}