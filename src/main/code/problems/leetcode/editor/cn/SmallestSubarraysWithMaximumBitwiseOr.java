// You are given a 0-indexed array nums of length n, consisting of non-negative
// integers. For each index i from 0 to n - 1, you must determine the size of the
// minimum sized non-empty subarray of nums starting at i (inclusive) that has the
// maximum possible bitwise OR.
//
// 
// In other words, let Bij be the bitwise OR of the subarray nums[i...j]. You 
// need to find the smallest subarray starting at i, such that bitwise OR of this
// subarray is equal to max(Bik) where i <= k <= n - 1.
// 
//
// The bitwise OR of an array is the bitwise OR of all the numbers in it. 
//
// Return an integer array answer of size n where answer[i] is the length of 
// the minimum sized subarray starting at i with maximum bitwise OR.
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,0,2,1,3]
// Output: [3,3,2,2,1]
// Explanation:
// The maximum possible bitwise OR starting at any index is 3.
//- Starting at index 0, the shortest subarray that yields it is [1,0,2].
//- Starting at index 1, the shortest subarray that yields the maximum bitwise 
// OR is [0,2,1].
//- Starting at index 2, the shortest subarray that yields the maximum bitwise 
// OR is [2,1].
//- Starting at index 3, the shortest subarray that yields the maximum bitwise 
// OR is [1,3].
//- Starting at index 4, the shortest subarray that yields the maximum bitwise 
// OR is [3].
// Therefore, we return [3,3,2,2,1].
// 
//
// Example 2: 
//
// 
// Input: nums = [1,2]
// Output: [2,1]
// Explanation:
// Starting at index 0, the shortest subarray that yields the maximum bitwise OR
// is of length 2.
// Starting at index 1, the shortest subarray that yields the maximum bitwise OR
// is of length 1.
// Therefore, we return [2,1].
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// 👍 46 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;

/**
 * Id：&emsp;&emsp;2411
 * <p>
 * Name：Smallest Subarrays With Maximum Bitwise OR
 *
 * @author Yuri
 * @since 2024-07-01 18:32:49
 */

public class SmallestSubarraysWithMaximumBitwiseOr {

    public static void main(String[] args) {
        Solution solution = new SmallestSubarraysWithMaximumBitwiseOr().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            var ors = new ArrayList<int[]>();
            int[] ans = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                ors.add(new int[]{0, i});
                int k = 0;
                for (var or : ors) {
                    or[0] |= nums[i];
                    if (ors.get(k)[0] == or[0]) ors.get(k)[1] = or[1];
                    else ors.set(++k, or);
                }
                ors.subList(k + 1, ors.size()).clear();
                ans[i] = ors.get(0)[1] - i + 1;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}