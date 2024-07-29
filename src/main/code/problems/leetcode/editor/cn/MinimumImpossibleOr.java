// You are given a 0-indexed integer array nums.
//
// We say that an integer x is expressible from nums if there exist some 
// integers 0 <= index1 < index2 < ... < indexk < nums.length for which nums[index1] |
// nums[index2] | ... | nums[indexk] = x. In other words, an integer is expressible
// if it can be written as the bitwise OR of some subsequence of nums.
//
// Return the minimum positive non-zero integer that is not expressible from 
// nums.
//
// 
// Example 1: 
//
// 
// Input: nums = [2,1]
// Output: 4
// Explanation: 1 and 2 are already present in the array. We know that 3 is
// expressible, since nums[0] | nums[1] = 2 | 1 = 3. Since 4 is not expressible, we
// return 4.
// 
//
// Example 2: 
//
// 
// Input: nums = [5,3,2]
// Output: 1
// Explanation: We can show that 1 is the smallest number that is not
// expressible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 23 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;2568
 * <p>
 * Name：Minimum Impossible OR
 *
 * @author Yuri
 * @since 2024-07-29 18:07:56
 */

public class MinimumImpossibleOr {

    public static void main(String[] args) {
        Solution solution = new MinimumImpossibleOr().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * ∵ 从小到大找，∴ 可以推出：如果1、2不是答案那么3也不是答案，如果4不是答案，那么5、6、7也不是答案，所以答案一定是2^k
         * <p>
         * low-bit做法
         */
        public int minImpossibleOR(int[] nums) {
            int m = 0;
            for (int num : nums)
                if ((num & (num - 1)) == 0) m |= num;
            m = ~m;
            return m & -m;
        }


        // 暴力
        public int minImpossibleOR_(int[] nums) {
            Set<Integer> hash = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            int i = 1;
            while (hash.contains(i)) i <<= 1;
            return i;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}