// Given a list of non-negative integers nums, arrange them such that they form
// the largest number and return it.
//
// Since the result may be very large, so you need to return a string instead 
// of an integer.
//
// 
// Example 1: 
//
// 
// Input: nums = [10,2]
// Output: "210"
// 
//
// Example 2: 
//
// 
// Input: nums = [3,30,34,5,9]
// Output: "9534330"
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 字符串 排序 👍 1121 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;179
 * <p>
 * Name：Largest Number
 *
 * @author Yuri
 * @since 2023-04-27 16:52:39
 */


public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        // for (int i = 0; i < len; i++) sb.append(0);


    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            String res = Arrays.stream(nums).mapToObj(String::valueOf).sorted((o1, o2) -> (o2 + o1).compareTo((o1 + o2)))
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
            if (res.startsWith("0")) return "0";
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
