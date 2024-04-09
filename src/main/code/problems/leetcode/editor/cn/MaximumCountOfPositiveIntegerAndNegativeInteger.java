//Given an array nums sorted in non-decreasing order, return the maximum 
//between the number of positive integers and the number of negative integers. 
//
// 
// In other words, if the number of positive integers in nums is pos and the 
//number of negative integers is neg, then return the maximum of pos and neg. 
// 
//
// Note that 0 is neither positive nor negative. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,-1,-1,1,2,3]
//Output: 3
//Explanation: There are 3 positive integers and 3 negative integers. The 
//maximum count among them is 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [-3,-2,-1,0,0,1,2]
//Output: 3
//Explanation: There are 2 positive integers and 3 negative integers. The 
//maximum count among them is 3.
// 
//
// Example 3: 
//
// 
//Input: nums = [5,20,66,1314]
//Output: 4
//Explanation: There are 4 positive integers and 0 negative integers. The 
//maximum count among them is 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2000 
// -2000 <= nums[i] <= 2000 
// nums is sorted in a non-decreasing order. 
// 
//
// 
// Follow up: Can you solve the problem in O(log(n)) time complexity? 
//
// 👍 18 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2529
 * <p>
 * Name：Maximum Count of Positive Integer and Negative Integer
 *
 * @author Yuri
 * @since 2024-04-09 10:18:18
 */

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public static void main(String[] args) {
        Solution solution = new MaximumCountOfPositiveIntegerAndNegativeInteger().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumCount(int[] nums) {
            int pos = binarySearch(nums, 0);
            int neg = nums.length - binarySearch(nums, 1);
            return Math.max(pos, neg);
        }

        public int binarySearch(int[] nums, int target) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] < target) l = mid + 1;
                else r = mid;
            }
            return l;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}