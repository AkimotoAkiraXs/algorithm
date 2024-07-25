// You are given an integer array nums. You have an integer array arr of the
// same length with all values set to 0 initially. You also have the following modify
// function:
// 
// You want to use the modify function to convert arr to nums using the minimum 
// number of calls.
//
// Return the minimum number of function calls to make nums from arr. 
//
// The test cases are generated so that the answer fits in a 32-bit signed 
// integer.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,5]
// Output: 5
// Explanation: Increment by 1 (second element): [0, 0] to get [0, 1] (1
// operation).
// Double all the elements: [0, 1] -> [0, 2] -> [0, 4] (2 operations).
// Increment by 1 (both elements)  [0, 4] -> [1, 4] -> [1, 5] (2 operations).
// Total of operations: 1 + 2 + 2 = 5.
// 
//
// Example 2: 
//
// 
// Input: nums = [2,2]
// Output: 3
// Explanation: Increment by 1 (both elements) [0, 0] -> [0, 1] -> [1, 1] (2
// operations).
// Double all the elements: [1, 1] -> [2, 2] (1 operation).
// Total of operations: 2 + 1 = 3.
// 
//
// Example 3: 
//
// 
// Input: nums = [4,2,5]
// Output: 6
// Explanation: (initial)[0,0,0] -> [1,0,0] -> [1,0,1] -> [2,0,2] -> [2,1,2] -> [
// 4,2,4] -> [4,2,5](nums).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// 👍 50 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

/**
 * Id：&emsp;&emsp;1558
 * <p>
 * Name：Minimum Numbers of Function Calls to Make Target Array
 *
 * @author Yuri
 * @since 2024-07-25 17:16:39
 */

public class MinimumNumbersOfFunctionCallsToMakeTargetArray {

    public static void main(String[] args) {
        Solution solution = new MinimumNumbersOfFunctionCallsToMakeTargetArray().new Solution();
        System.out.println(solution.minOperations(new int[]{7, 4, 3, 2, 0, 2}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minOperations(int[] nums) {
            int res = 0, max = 0;
            for (int num : nums) {
                res += Integer.bitCount(num);
                max = Math.max(max, num);
            }
            while (max > 1 ) {
                res++;
                max >>= 1;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}