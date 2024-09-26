// Given an integer array hours representing times in hours, return an integer
// denoting the number of pairs i, j where i < j and hours[i] + hours[j] forms a
// complete day.
//
// A complete day is defined as a time duration that is an exact multiple of 24 
// hours.
//
// For example, 1 day is 24 hours, 2 days is 48 hours, 3 days is 72 hours, and 
// so on.
//
// 
// Example 1: 
//
// 
// Input: hours = [12,12,30,24,24] 
// 
//
// Output: 2 
//
// Explanation: The pairs of indices that form a complete day are (0, 1) and (3,
// 4). 
//
// Example 2: 
//
// 
// Input: hours = [72,48,24,3] 
// 
//
// Output: 3 
//
// Explanation: The pairs of indices that form a complete day are (0, 1), (0, 2)
//, and (1, 2). 
//
// 
// Constraints: 
//
// 
// 1 <= hours.length <= 5 * 10⁵ 
// 1 <= hours[i] <= 10⁹ 
// 
//
// 👍 8 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;3185
 * <p>
 * Name：Count Pairs That Form a Complete Day II
 *
 * @author Yuri
 * @since 2024-09-26 14:58:44
 */

public class CountPairsThatFormACompleteDayIi {

    public static void main(String[] args) {
        Solution solution = new CountPairsThatFormACompleteDayIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long countCompleteDayPairs(int[] hours) {
            Map<Integer, Integer> map = new HashMap<>();
            long ans = 0;
            for (int t : hours) {
                int key = (24 - t % 24) % 24; // 60对应的值应该是0
                Integer val = map.get(key);
                ans += val == null ? 0 : val;
                map.merge(t % 24, 1, Integer::sum);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}