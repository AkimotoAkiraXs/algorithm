// Given an array of integers nums and an integer k, return the number of
// subarrays of nums where the bitwise AND of the elements of the subarray equals k.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,1,1], k = 1 
// 
//
// Output: 6 
//
// Explanation: 
//
// All subarrays contain only 1's. 
//
// Example 2: 
//
// 
// Input: nums = [1,1,2], k = 1 
// 
//
// Output: 3 
//
// Explanation: 
//
// Subarrays having an AND value of 1 are: [1,1,2], [1,1,2], [1,1,2]. 
//
// Example 3: 
//
// 
// Input: nums = [1,2,3], k = 2 
// 
//
// Output: 2 
//
// Explanation: 
//
// Subarrays having an AND value of 2 are: [1,2,3], [1,2,3]. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i], k <= 10⁹ 
// 
//
// 👍 7 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;3209
 * <p>
 * Name：Number of Subarrays With AND Value of K
 *
 * @author Yuri
 * @since 2024-08-13 15:18:47
 */

public class NumberOfSubarraysWithAndValueOfK {

    public static void main(String[] args) {
        Solution solution = new NumberOfSubarraysWithAndValueOfK().new Solution();
        System.out.println(solution.countSubarrays_(new int[]{1, 2, 3, 2, 1}, 2));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 三指针
         */
        public long countSubarrays(int[] nums, int k) {
            long ans = 0;
            int l = 0, r = 0;
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                for (int j = i - 1; j >= 0 && (nums[j] & x) != nums[j]; j--)
                    nums[j] &= x; // 当num[j]无法再减小，则num[k](k<j)也不会再减小,所以直接退出自循环
                while (l <= i && nums[l] < k) l++; // 左闭
                while (r <= i && nums[r] <= k) r++; // 右开
                ans += r - l;
            }
            return ans;
        }

        /**
         * 子循环的同时维护等于 k 的子数组个数
         */
        public long countSubarrays_(int[] nums, int k) {
            long ans = 0;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                cnt += x == k ? 1 : 0;
                for (int j = i - 1; j >= 0 && (nums[j] & x) != nums[j]; j--) {
                    cnt -= nums[j] == k ? 1 : 0;
                    nums[j] &= x;
                    cnt += nums[j] == k ? 1 : 0;
                }
                ans += cnt;
            }
            return ans;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}