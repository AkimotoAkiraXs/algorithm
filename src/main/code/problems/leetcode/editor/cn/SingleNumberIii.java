// Given an integer array nums, in which exactly two elements appear only once
// and all the other elements appear exactly twice. Find the two elements that
// appear only once. You can return the answer in any order.
//
// You must write an algorithm that runs in linear runtime complexity and uses 
// only constant extra space.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]
// Explanation:  [5, 3] is also a valid answer.
// 
//
// Example 2: 
//
// 
// Input: nums = [-1,0]
// Output: [-1,0]
// 
//
// Example 3: 
//
// 
// Input: nums = [0,1]
// Output: [1,0]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// Each integer in nums will appear twice, only two integers will appear once. 
// 
//
// 👍 799 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;260
 * <p>
 * Name：Single Number III
 *
 * @author Yuri
 * @see SingleNumber
 * @see SingleNumberIi
 * @since 2023-10-16 15:23:22
 */

public class SingleNumberIii {

    public static void main(String[] args) {
        Solution solution = new SingleNumberIii().new Solution();
        solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 因为两个数不相等，所以对nums中数进行异或的结果k>=0。
         * 取k的任意一位，对于不相等单独出现的两个数，在这一位置的bit，肯定有个是0，有个是1，根据在该位是否为1对nums进行分组。
         * 对两个分组的数进行异或处理，最后剩下的两个数就是答案。
         */
        public int[] singleNumber(int[] nums) {
            int k = 0;
            for (int num : nums) k ^= num;
            k = k & -k; // 获取最低位1
            int[] ans = new int[2];
            for (int num : nums) ans[(k & num) > 0 ? 0 : 1] ^= num;
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}