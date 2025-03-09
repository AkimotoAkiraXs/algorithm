// Given an integer array nums sorted in non-decreasing order, remove some
// duplicates in-place such that each unique element appears at most twice. The relative
// order of the elements should be kept the same.
//
// Since it is impossible to change the length of the array in some languages, 
// you must instead have the result be placed in the first part of the array nums.
// More formally, if there are k elements after removing the duplicates, then the
// first k elements of nums should hold the final result. It does not matter what
// you leave beyond the first k elements.
//
// Return k after placing the final result in the first k slots of nums. 
//
// Do not allocate extra space for another array. You must do this by modifying 
// the input array in-place with O(1) extra memory.
//
// Custom Judge: 
//
// The judge will test your solution with the following code: 
//
// 
// int[] nums = [...]; // Input array
// int[] expectedNums = [...]; // The expected answer with correct length
//
// int k = removeDuplicates(nums); // Calls your implementation
//
// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
// 
//
// If all assertions pass, then your solution will be accepted. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,1,1,2,2,3]
// Output: 5, nums = [1,1,2,2,3,_]
// Explanation: Your function should return k = 5, with the first five elements
// of nums being 1, 1, 2, 2 and 3 respectively.
// It does not matter what you leave beyond the returned k (hence they are
// underscores).
// 
//
// Example 2: 
//
// 
// Input: nums = [0,0,1,1,1,1,2,3,3]
// Output: 7, nums = [0,0,1,1,2,3,3,_,_]
// Explanation: Your function should return k = 7, with the first seven elements
// of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
// It does not matter what you leave beyond the returned k (hence they are
// underscores).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is sorted in non-decreasing order. 
// 
//
// 👍 1233 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;80
 * <p>
 * Name：Remove Duplicates from Sorted Array II
 *
 * @author Yuri
 * @since 2025-03-09 12:05:13
 */

public class RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 三指针
         */
        public int removeDuplicates_(int[] nums) {
            int r = 0, m = 0, l = 0;
            for (; l < nums.length; l++) {
                if (nums[m] != nums[l]) m = l;
                if (l - m < 2) nums[r++] = nums[m];
            }
            return r;
        }

        /**
         * 栈
         */
        public int removeDuplicates(int[] nums) {
            int stackSize = 2; // 栈大小
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] != nums[stackSize-2]) nums[stackSize++] = nums[i];
            }
            return Math.min(nums.length, stackSize); // 兼容nums.len = 1
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}