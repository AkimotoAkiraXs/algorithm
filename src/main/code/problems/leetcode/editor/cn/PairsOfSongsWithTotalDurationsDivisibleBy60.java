// You are given a list of songs where the iᵗʰ song has a duration of time[i]
// seconds.
//
// Return the number of pairs of songs for which their total duration in 
// seconds is divisible by 60. Formally, we want the number of indices i, j such that i <
// j with (time[i] + time[j]) % 60 == 0.
//
// 
// Example 1: 
//
// 
// Input: time = [30,20,150,100,40]
// Output: 3
// Explanation: Three pairs have a total duration divisible by 60:
//(time[0] = 30, time[2] = 150): total duration 180
//(time[1] = 20, time[3] = 100): total duration 120
//(time[1] = 20, time[4] = 40): total duration 60
// 
//
// Example 2: 
//
// 
// Input: time = [60,60,60]
// Output: 3
// Explanation: All three pairs have a total duration of 120, which is divisible
// by 60.
// 
//
// 
// Constraints: 
//
// 
// 1 <= time.length <= 6 * 10⁴ 
// 1 <= time[i] <= 500 
// 
//
// 👍 304 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;1010
 * <p>
 * Name：Pairs of Songs With Total Durations Divisible by 60
 *
 * @author Yuri
 * @since 2024-09-26 11:47:12
 */

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public static void main(String[] args) {
        Solution solution = new PairsOfSongsWithTotalDurationsDivisibleBy60().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numPairsDivisibleBy60(int[] time) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int t : time) {
                int key = (60 - t % 60) % 60; // 60对应的值应该是0
                Integer val = map.get(key);
                ans += val == null ? 0 : val;
                map.merge(t % 60, 1, Integer::sum);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}