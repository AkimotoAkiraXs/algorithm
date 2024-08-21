// You are given an integer array ranks representing the ranks of some mechanics.
// ranksi is the rank of the iᵗʰ mechanic. A mechanic with a rank r can repair n 
// cars in r * n² minutes.
//
// You are also given an integer cars representing the total number of cars 
// waiting in the garage to be repaired.
//
// Return the minimum time taken to repair all the cars. 
//
// Note: All the mechanics can repair the cars simultaneously. 
//
// 
// Example 1: 
//
// 
// Input: ranks = [4,2,3,1], cars = 10
// Output: 16
// Explanation:
//- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16
// minutes.
//- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8
// minutes.
//- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12
// minutes.
//- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 
// 16 minutes.
// It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​
//​
// 
//
// Example 2: 
//
// 
// Input: ranks = [5,1,8], cars = 6
// Output: 16
// Explanation:
//- The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 
// minutes.
//- The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 
// 16 minutes.
//- The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 
// minutes.
// It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​
//​
// 
//
// 
// Constraints: 
//
// 
// 1 <= ranks.length <= 10⁵ 
// 1 <= ranks[i] <= 100 
// 1 <= cars <= 10⁶ 
// 
//
// 👍 223 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2594
 * <p>
 * Name：Minimum Time to Repair Cars
 *
 * @author Yuri
 * @since 2024-08-20 18:45:34
 */

public class MinimumTimeToRepairCars {

    public static void main(String[] args) {
        Solution solution = new MinimumTimeToRepairCars().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long repairCars(int[] ranks, int cars) {
            long l = 0, r = (long) cars * cars * Arrays.stream(ranks).max().getAsInt();
            while (l < r) {
                long m = l + r >> 1;
                int c = cars;
                for (int i = 0; i < ranks.length && c > 0; i++) c -= (int) Math.sqrt((double) m / ranks[i]);
                if (c > 0) l = m + 1;
                else r = m;
            }
            return l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}