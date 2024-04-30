// The frequency of an element is the number of times it occurs in an array.
//
// You are given an integer array nums and an integer k. In one operation, you 
// can choose an index of nums and increment the element at that index by 1.
//
// Return the maximum possible frequency of an element after performing at most 
// k operations.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,4], k = 5
// Output: 3
// Explanation: Increment the first element three times and the second element
// two times to make nums = [4,4,4].
// 4 has a frequency of 3.
//
// Example 2: 
//
// 
// Input: nums = [1,4,8,13], k = 5
// Output: 2
// Explanation: There are multiple optimal solutions:
//- Increment the first element three times to make nums = [4,4,8,13]. 4 has a 
// frequency of 2.
//- Increment the second element four times to make nums = [1,8,8,13]. 8 has a 
// frequency of 2.
//- Increment the third element five times to make nums = [1,4,13,13]. 13 has a 
// frequency of 2.
// 
//
// Example 3: 
//
// 
// Input: nums = [3,9,6], k = 2
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁵ 
// 
//
// 👍 295 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1838
 * <p>
 * Name：Frequency of the Most Frequent Element
 *
 * @author Yuri
 * @since 2024-04-30 11:23:45
 */

public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        Solution solution = new FrequencyOfTheMostFrequentElement().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // [1,4,8,13], k = 5
        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            int max = 1;
            for (int r = 1, l = 0; r < nums.length; r++) {
                long sub = (long) (r - l) * (nums[r] - nums[r - 1]); // sub不用long会被干爆
                while (k - sub < 0) {
                    k += nums[r - 1] - nums[l];
                    l++;
                    sub = (long) (r - l) * (nums[r] - nums[r - 1]);
                }
                k -= (int) sub;
                max = Math.max(max, r - l + 1);
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}