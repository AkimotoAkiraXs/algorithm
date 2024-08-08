// You are given an array of integers nums. You are also given an integer
// original which is the first number that needs to be searched for in nums.
//
// You then do the following steps: 
//
// 
// If original is found in nums, multiply it by two (i.e., set original = 2 * 
// original).
// Otherwise, stop the process. 
// Repeat this process with the new number as long as you keep finding the 
// number.
// 
//
// Return the final value of original. 
//
// 
// Example 1: 
//
// 
// Input: nums = [5,3,6,1,12], original = 3
// Output: 24
// Explanation:
//- 3 is found in nums. 3 is multiplied by 2 to obtain 6.
//- 6 is found in nums. 6 is multiplied by 2 to obtain 12.
//- 12 is found in nums. 12 is multiplied by 2 to obtain 24.
//- 24 is not found in nums. Thus, 24 is returned.
// 
//
// Example 2: 
//
// 
// Input: nums = [2,7,9], original = 4
// Output: 4
// Explanation:
//- 4 is not found in nums. Thus, 4 is returned.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i], original <= 1000 
// 
//
// 👍 23 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2154
 * <p>
 * Name：Keep Multiplying Found Values by Two
 *
 * @author Yuri
 * @since 2024-08-08 10:22:42
 */

public class KeepMultiplyingFoundValuesByTwo {

    public static void main(String[] args) {
        Solution solution = new KeepMultiplyingFoundValuesByTwo().new Solution();
        solution.findFinalValue(new int[]{4, 7, 1, 16, 1, 2, 7, 13}, 1);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 哈希表方法略，此处用位运算做，运用倍数来验证思路很巧妙
         */
        public int findFinalValue(int[] nums, int original) {
            int k = 0;
            for (int num : nums) {
                if (num % original == 0) {
                    int t = num / original;
                    if ((t & (t - 1)) == 0) k |= t;
                }
            }
            k = ~k;
            return original * (k & -k);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}