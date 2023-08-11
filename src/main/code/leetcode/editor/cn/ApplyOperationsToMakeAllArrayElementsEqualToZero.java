// You are given a 0-indexed integer array nums and a positive integer k.
//
// You can apply the following operation on the array any number of times: 
//
// 
// Choose any subarray of size k from the array and decrease all its elements 
// by 1.
// 
//
// Return true if you can make all the array elements equal to 0, or false 
// otherwise.
//
// A subarray is a contiguous non-empty part of an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [2,2,3,1,1,0], k = 3
// Output: true
// Explanation: We can do the following operations:
//- Choose the subarray [2,2,3]. The resulting array will be nums = [1,1,2,1,1,0
//].
//- Choose the subarray [2,1,1]. The resulting array will be nums = [1,1,1,0,0,0
//].
//- Choose the subarray [1,1,1]. The resulting array will be nums = [0,0,0,0,0,0
//].
// 
//
// Example 2: 
//
// 
// Input: nums = [1,3,1,1], k = 2
// Output: false
// Explanation: It is not possible to make all the array elements equal to 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁶ 
// 
//
// 👍 14 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2772
 * <p>
 * Name：Apply Operations to Make All Array Elements Equal to Zero
 *
 * @author Yuri
 * @since 2023-07-10 19:24:06
 */


public class ApplyOperationsToMakeAllArrayElementsEqualToZero {
    public static void main(String[] args) {
        Solution solution = new ApplyOperationsToMakeAllArrayElementsEqualToZero().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 差分数组O(n)：差分数组最主要是省去每次循环对k个数字进行分别减操作的时间
        public boolean checkArray(int[] nums, int k) {
            int n = nums.length;
            int[] dif = new int[n + 1];
            int sumD = 0;
            for (int i = 0; i < n; i++) {
                sumD += dif[i];
                int num = nums[i] + sumD;
                if (num == 0) continue;
                if (num < 0 || i + k > n) return false;
                sumD -= num;
                dif[i + k] = num;
            }
            return true;
        }

        // 暴力O(n^4/4)：第一个/最后一个数字长度为k的子数组是固定的，所以我们肯定要从第一个/最后一个进行减
        public boolean checkArray_(int[] nums, int k) {
            int n = nums.length;
            int i = 0;
            while (i < n) {
                int x = nums[i]; // num[i]会变，要提前记录num[i]
                if (x != 0) {
                    if (x < 0 || i + k > n) return false;
                    for (int j = 0; j < k; j++) nums[i + j] = nums[i + j] - x;
                }
                i++;
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
