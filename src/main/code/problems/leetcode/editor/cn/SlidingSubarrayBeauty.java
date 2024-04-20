// Given an integer array nums containing n integers, find the beauty of each
// subarray of size k.
//
// The beauty of a subarray is the xᵗʰ smallest integer in the subarray if it 
// is negative, or 0 if there are fewer than x negative integers.
//
// Return an integer array containing n - k + 1 integers, which denote the 
// beauty of the subarrays in order from the first index in the array.
//
// 
// A subarray is a contiguous non-empty sequence of elements within an array. 
// 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,-1,-3,-2,3], k = 3, x = 2
// Output: [-1,-2,-2]
// Explanation: There are 3 subarrays with size k = 3.
// The first subarray is [1, -1, -3] and the 2ⁿᵈ smallest negative integer is -1.
// 
// The second subarray is [-1, -3, -2] and the 2ⁿᵈ smallest negative integer is -
// 2. 
// The third subarray is [-3, -2, 3] and the 2ⁿᵈ smallest negative integer is -2.
// 
//
// Example 2: 
//
// 
// Input: nums = [-1,-2,-3,-4,-5], k = 2, x = 2
// Output: [-1,-2,-3,-4]
// Explanation: There are 4 subarrays with size k = 2.
// For [-1, -2], the 2ⁿᵈ smallest negative integer is -1.
// For [-2, -3], the 2ⁿᵈ smallest negative integer is -2.
// For [-3, -4], the 2ⁿᵈ smallest negative integer is -3.
// For [-4, -5], the 2ⁿᵈ smallest negative integer is -4. 
//
// Example 3: 
//
// 
// Input: nums = [-3,1,2,-3,0,-3], k = 2, x = 1
// Output: [-3,0,-3,-3,-3]
// Explanation: There are 5 subarrays with size k = 2.
// For [-3, 1], the 1ˢᵗ smallest negative integer is -3.
// For [1, 2], there is no negative integer so the beauty is 0.
// For [2, -3], the 1ˢᵗ smallest negative integer is -3.
// For [-3, 0], the 1ˢᵗ smallest negative integer is -3.
// For [0, -3], the 1ˢᵗ smallest negative integer is -3.
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= k <= n 
// 1 <= x <= k 
// -50 <= nums[i] <= 50 
// 
//
// 👍 50 👎 0

package problems.leetcode.editor.cn;

import java.util.TreeMap;

/**
 * Id：&emsp;&emsp;2653
 * <p>
 * Name：Sliding Subarray Beauty
 *
 * @author Yuri
 * @since 2024-04-20 16:06:16
 */

public class SlidingSubarrayBeauty {
    public static void main(String[] args) {
        Solution solution = new SlidingSubarrayBeauty().new Solution();
        solution.getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 直接用数组计数
        public int[] getSubarrayBeauty(int[] nums, int k, int x) {
            final int BASE = 50;
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int[] cnt = new int[BASE * 2 + 1];
            int l = 0;
            for (int r = 0; r < n; r++) {
                cnt[nums[r] + BASE]++;
                if (r - l >= k) cnt[nums[l++] + BASE]--;
                if (r - l + 1 == k) {
                    int left = x;
                    // 遍历-50 ~ -1，如果left遍历结束>1就说明x小的数不是负数，返回默认值0
                    for (int i = 0; i < BASE; i++) {
                        left -= cnt[i];
                        if (left <= 0) {
                            res[r - k + 1] = i - BASE;
                            break;
                        }
                    }
                }
            }
            return res;
        }

        /**
         * 用的TreeMap计数，有点没必要
         */
        public int[] getSubarrayBeauty_(int[] nums, int k, int x) {
            int n = nums.length;
            TreeMap<Integer, Integer> map = new TreeMap<>(); // Treemap可以直接用个数组代替
            int[] res = new int[n - k + 1];
            int l = 0;
            for (int r = 0; r < n; r++) {
                map.merge(nums[r], 1, Integer::sum);
                if (r - l >= k) map.merge(nums[l++], -1, Integer::sum);
                if (r - l + 1 == k) res[r - k + 1] = getXMin(map, x);
            }
            return res;
        }

        private int getXMin(TreeMap<Integer, Integer> map, int x) {
            for (var m : map.entrySet()) {
                x -= m.getValue();
                if (x <= 0)
                    return m.getKey() < 0 ? m.getKey() : 0;
            }
            throw new RuntimeException();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}