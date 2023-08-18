// You are given an integer finalSum. Split it into a sum of a maximum number of
// unique positive even integers.
//
// 
// For example, given finalSum = 12, the following splits are valid (unique 
// positive even integers summing up to finalSum): (12), (2 + 10), (2 + 4 + 6), and (4
//+ 8). Among them, (2 + 4 + 6) contains the maximum number of integers. Note 
// that finalSum cannot be split into (2 + 2 + 4 + 4) as all the numbers should be
// unique.
// 
//
// Return a list of integers that represent a valid split containing a maximum 
// number of integers. If no valid split exists for finalSum, return an empty list.
// You may return the integers in any order.
//
// 
// Example 1: 
//
// 
// Input: finalSum = 12
// Output: [2,4,6]
// Explanation: The following are valid splits: (12), (2 + 10), (2 + 4 + 6), and
//(4 + 8).
//(2 + 4 + 6) has the maximum number of integers, which is 3. Thus, we return [2
//,4,6].
// Note that [2,6,4], [6,2,4], etc. are also accepted.
// 
//
// Example 2: 
//
// 
// Input: finalSum = 7
// Output: []
// Explanation: There are no valid splits for the given finalSum.
// Thus, we return an empty array.
// 
//
// Example 3: 
//
// 
// Input: finalSum = 28
// Output: [6,8,2,12]
// Explanation: The following are valid splits: (2 + 26), (6 + 8 + 2 + 12), and (
// 4 + 24).
//(6 + 8 + 2 + 12) has the maximum number of integers, which is 4. Thus, we 
// return [6,8,2,12].
// Note that [10,2,4,12], [6,2,4,16], etc. are also accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= finalSum <= 10¹⁰ 
// 
//
// 👍 71 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;2178
 * <p>
 * Name：Maximum Split of Positive Even Integers
 *
 * @author Yuri
 * @since 2023-07-06 18:56:35
 */


public class MaximumSplitOfPositiveEvenIntegers {
    public static void main(String[] args) {
        Solution solution = new MaximumSplitOfPositiveEvenIntegers().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 可以推出：[n·(n+1)] = finalSum（1...n的数求和公式），可以证明贪心思想的正确。
     * <p>
     * 或者直接贪心思想，既然要数的量最多，肯定是先选最小的偶数，最后不能选了再把剩余数加到最后一个偶数上。
     */
    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            if ((finalSum & 1) == 1) return new ArrayList<>();
            int n = (int) Math.sqrt(finalSum);
            if ((long) n * (n + 1) > finalSum) n--;
            List<Long> res = new ArrayList<>();
            for (long i = 1; i < n; i++) res.add(i * 2);
            res.add(finalSum - ((long) n * (n + 1)) + n * 2L);
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
