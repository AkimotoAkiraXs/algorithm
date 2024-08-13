// Given an array of integers nums containing n + 1 integers where each integer
// is in the range [1, n] inclusive.
//
// There is only one repeated number in nums, return this repeated number. 
//
// You must solve the problem without modifying the array nums and uses only 
// constant extra space.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,3,4,2,2]
// Output: 2
// 
//
// Example 2: 
//
// 
// Input: nums = [3,1,3,4,2]
// Output: 3
// 
//
// Example 3: 
//
// 
// Input: nums = [3,3,3,3,3]
// Output: 3
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// All the integers in nums appear only once except for precisely one integer 
// which appears two or more times.
// 
//
// 
// Follow up: 
//
// 
// How can we prove that at least one duplicate number must exist in nums? 
// Can you solve the problem in linear runtime complexity? 
// 
//
// 👍 2441 👎 0

package problems.leetcode.editor.cn;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;287
 * <p>
 * Name：Find the Duplicate Number
 *
 * @author Yuri
 * @since 2024-08-08 11:15:53
 */

public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        solution.findDuplicate(new int[]{1, 3, 4, 2, 2});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 位运算：考虑第 i 位，我们记 nums 数组中二进制展开后第 i 位为 1 的数有 x 个，数字 [1,n] 这 n 个数二进制展开后第 i 位为 1 的数有 y 个，那么重复的数第 i 位为 1 当且仅当 x>y。
         */
        public int findDuplicate_(int[] nums) {
            int n = nums.length - 1;
            var cnt1 = count(IntStream.range(1, n + 1).toArray());
            var cnt2 = count(nums);
            int ans = 0;
            for (int i = 0; n > 0; n >>= 1, i++)
                if (cnt2[i] > cnt1[i]) ans ^= (1 << i);
            return ans;
        }

        private int[] count(int[] nums) {
            int[] ans = new int[30];
            for (int num : nums) {
                for (int i = 0; num > 0; i++) {
                    if ((num & 1) == 1) ans[i]++;
                    num >>= 1;
                }
            }
            return ans;
        }

        /**
         * 二分法：因为只有一个数有重复，其余数都在1~n，所以二分求小于等于k数的个数，如果<=k个则表示重复数在右边，否则在左边
         */
        public int findDuplicate(int[] nums) {
            int l = 1, r = nums.length;
            while (l < r) {
                int mid = l + r >> 1;
                int cnt = 0;
                for (int num : nums)
                    if (num <= mid) cnt++;
                if (cnt <= mid) l = mid + 1;
                else r = mid;
            }
            return l;
        }


        /**
         * 双指针：以nums中值->坐标构造链表，因为nums中有n+1个数，且范围在[1,n]所以不会越界且不会因为某数指向0而生成环，
         * 因为只有一个数重复所以一定有一个环。题意则转换为了Lc142。
         *
         * @see LinkedListCycleIi Lc142.环形链表 II
         */
        public int findDuplicate_doublePoint(int[] nums) {
            int s = 0, f = 0;
            do {
                s = nums[s];
                f = nums[nums[f]];
            } while (s != f);

            // 寻找环的起点，公式推导看Lc142
            s = 0;
            while (s != f) {
                s = nums[s];
                f = nums[f];
            }
            return s;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}