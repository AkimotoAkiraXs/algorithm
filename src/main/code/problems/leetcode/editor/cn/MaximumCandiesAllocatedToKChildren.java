// You are given a 0-indexed integer array candies. Each element in the array
// denotes a pile of candies of size candies[i]. You can divide each pile into any
// number of sub piles, but you cannot merge two piles together.
//
// You are also given an integer k. You should allocate piles of candies to k 
// children such that each child gets the same number of candies. Each child can
// take at most one pile of candies and some piles of candies may go unused.
//
// Return the maximum number of candies each child can get. 
// 
// Example 1: 
//
// 
// Input: candies = [5,8,6], k = 3
// Output: 5
// Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and
// candies[2] into 2 piles of size 5 and 1. We now have five piles of candies of sizes 5,
// 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be 
// proven that each child cannot receive more than 5 candies.
// 
//
// Example 2: 
//
// 
// Input: candies = [2,5], k = 11
// Output: 0
// Explanation: There are 11 children but only 7 candies in total, so it is
// impossible to ensure each child receives at least one candy. Thus, each child gets
// no candy and the answer is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= candies.length <= 10⁵ 
// 1 <= candies[i] <= 10⁷ 
// 1 <= k <= 10¹² 
// 
//
// 👍 73 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2226
 * <p>
 * Name：Maximum Candies Allocated to K Children
 *
 * @author Yuri
 * @since 2024-08-23 18:04:21
 */

public class MaximumCandiesAllocatedToKChildren {

    public static void main(String[] args) {
        Solution solution = new MaximumCandiesAllocatedToKChildren().new Solution();
        System.out.println((solution.maximumCandies(new int[]{9, 10, 1, 2, 10, 9, 9, 10, 2, 2}, 3)));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumCandies(int[] candies, long k) {
            int l = 1, r = Arrays.stream(candies).max().getAsInt();
            while (l <= r) {
                int m = l + r >> 1;
                long t = 0;
                for (int i = 0; i < candies.length && t < k; i++) t += candies[i] / m;
                if (t >= k) l = m + 1;
                else r = m - 1;
            }
            return Math.max(0, r);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}