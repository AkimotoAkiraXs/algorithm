// Given an array nums of distinct positive integers, return the number of
// tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums,
// and a != b != c != d. 
//
// 
// Example 1: 
//
// 
// Input: nums = [2,3,4,6]
// Output: 8
// Explanation: There are 8 valid tuples:
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
// 
//
// Example 2: 
//
// 
// Input: nums = [1,2,4,5,10]
// Output: 16
// Explanation: There are 16 valid tuples:
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁴ 
// All elements in nums are distinct. 
// 
//
// 👍 52 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;1726
 * <p>
 * Name：Tuple with Same Product
 *
 * @author Yuri
 * @since 2023-10-19 10:06:24
 */

public class TupleWithSameProduct {

    public static void main(String[] args) {
        Solution solution = new TupleWithSameProduct().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // hash + 排列组合
        public int tupleSameProduct(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++)
                for (int j = i + 1; j < nums.length; j++)
                    map.merge(nums[i] * nums[j], 1, Integer::sum);

            int sum = 0;
            for (Integer val : map.values()) sum += combination(val, 2) * 8;
            return sum;
        }

        private Integer combination(Integer n, int k) {
            if (n < k) return 0;
            long a = 1, b = 1;
            while (k > 0) {
                a *= n--;
                b *= k--;
            }
            return (int) (a / b);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}