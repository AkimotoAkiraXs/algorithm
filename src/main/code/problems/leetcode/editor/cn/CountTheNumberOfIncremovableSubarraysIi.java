// You are given a 0-indexed array of positive integers nums.
//
// A subarray of nums is called incremovable if nums becomes strictly 
// increasing on removing the subarray. For example, the subarray [3, 4] is an incremovable
// subarray of [5, 3, 4, 6, 7] because removing this subarray changes the array [5,
// 3, 4, 6, 7] to [5, 6, 7] which is strictly increasing.
//
// Return the total number of incremovable subarrays of nums. 
//
// Note that an empty array is considered strictly increasing. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,4]
// Output: 10
// Explanation: The 10 incremovable subarrays are: [1], [2], [3], [4], [1,2], [2,
// 3], [3,4], [1,2,3], [2,3,4], and [1,2,3,4], because on removing any one of
// these subarrays nums becomes strictly increasing. Note that you cannot select an
// empty subarray.
// 
//
// Example 2: 
//
// 
// Input: nums = [6,5,7,8]
// Output: 7
// Explanation: The 7 incremovable subarrays are: [5], [6], [5,7], [6,5], [5,7,8]
//, [6,5,7] and [6,5,7,8].
// It can be shown that there are only 7 incremovable subarrays in nums.
// 
//
// Example 3: 
//
// 
// Input: nums = [8,7,6,6]
// Output: 3
// Explanation: The 3 incremovable subarrays are: [8,7,6], [7,6,6], and [8,7,6,6]
//. Note that [8,7] is not an incremovable subarray because after removing [8,7] 
// nums becomes [6,6], which is sorted in ascending order but not strictly
// increasing.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 12 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2972
 * <p>
 * Name：Count the Number of Incremovable Subarrays II
 *
 * @author Yuri
 * @since 2024-05-16 15:00:58
 */

public class CountTheNumberOfIncremovableSubarraysIi {

    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfIncremovableSubarraysIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long incremovableSubarrayCount(int[] a) {
            int n = a.length;
            int i = 0;
            while (i < n - 1 && a[i] < a[i + 1]) i++;
            if (i == n - 1) return (long) (n + 1) * n / 2; // 如果数组本身严格递增，则不满足以下推论
            long ans = i + 2; // 从左边0~i位置为左边界，n-1为右边界均为满足条件的子数组
            for (int j = n - 1; j >= 0 && (j == n - 1 || a[j] < a[j + 1]); j--) { // 从右边j为右边界，左边0~i为左边界均为符合题意的子数组
                while (i >= 0 && a[i] >= a[j]) i--;
                ans += i + 2;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}