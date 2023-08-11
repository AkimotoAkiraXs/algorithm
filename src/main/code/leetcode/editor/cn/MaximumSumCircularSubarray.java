// Given a circular integer array nums of length n, return the maximum possible
// sum of a non-empty subarray of nums.
//
// A circular array means the end of the array connects to the beginning of the 
// array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the
// previous element of nums[i] is nums[(i - 1 + n) % n].
//
// A subarray may only include each element of the fixed buffer nums at most 
// once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not
// exist i <= k1, k2 <= j with k1 % n == k2 % n.
//
// 
// Example 1: 
//
// 
// Input: nums = [1,-2,3,-2]
// Output: 3
// Explanation: Subarray [3] has maximum sum 3.
// 
//
// Example 2: 
//
// 
// Input: nums = [5,-3,5]
// Output: 10
// Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
// 
//
// Example 3: 
//
// 
// Input: nums = [-3,-2,-3]
// Output: -2
// Explanation: Subarray [-2] has maximum sum -2.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
//
// 👍 547 👎 0

package leetcode.editor.cn;

import cn.hutool.core.lang.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Id：&emsp;&emsp;918
 * <p>
 * Name：Maximum Sum Circular Subarray
 *
 * @author Yuri
 * @since 2023-07-20 11:22:58
 */


public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSumCircularSubarray().new Solution();

        System.out.println(solution.maxSubarraySumCircular(new int[]{5, -3, 5}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 经典Dp模板题{@link MaximumSubarray 最大子数组和}的进阶版，加了环形条件。
         * <p>
         * Dp+前缀和：答案所求子数组只有两种可能，一种是中间一段，一种是首位相连的一段，分别求这两种可能。
         * <p>
         * 第一种可能和模板题一样求法，第二种可能的答案就是：前缀和+后缀和最大的情况。
         */
        public int maxSubarraySumCircular_Dp_preSum(int[] nums) {
            int n = nums.length;
            int[] lmaxSum = new int[n];
            lmaxSum[0] = nums[0];
            int lSum = nums[0], pre = nums[0], max = nums[0];
            for (int i = 1; i < n; i++) {
                pre = Math.max(pre + nums[i], nums[i]);
                max = Math.max(pre, max);
                lSum += nums[i];
                lmaxSum[i] = Math.max(lmaxSum[i - 1], lSum);
            }

            int rSum = 0;
            for (int i = n - 1; i > 0; i--) {
                rSum += nums[i];
                max = Math.max(max, rSum + lmaxSum[i - 1]);
            }
            return max;
        }

        /**
         * Dp+取反：思路和第一种一样，但是第二种可能求法用取反思想。
         * <p>
         * 取反思想，两端前缀和要尽可能大，其实就是中间这段尽可能小，所以只需求中间这段最小值就好。
         * <p>
         * 有个注意地方时，当所有数都是非正数时，sum-preMinSum=0，这时表示不取任何数，不符合题意。
         */
        public int maxSubarraySumCircular_reverse(int[] nums) {
            int sum = 0, px = 0, pi = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int num : nums) {
                sum += num;
                px = Math.max(px + num, num);
                max = Math.max(px, max);
                pi = Math.min(pi + num, num);
                min = Math.min(pi, min);
            }
            if (sum - min == 0) return max;
            return Math.max(max, sum - min);
        }

        /**
         * 单调队列：我们把问题转换为在一个长度为2n的数组上，寻找长度不超过n的最大子数组和，用一个单调队列维护n的长度。
         * <p>
         * 我们答案可以通过前缀和sumI-sumJ(J<I)所求得，所以我们用单调队列维护长度为n，且前缀和单调递增就可以求出答案。
         */
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            Deque<Pair<Integer, Integer>> deque = new LinkedList<>();
            deque.add(new Pair<>(0, nums[0]));
            int sum = nums[0], res = nums[0];
            for (int i = 1; i < 2 * n; i++) {
                // 如果长度超过了n，则弹出队头，因为队头元素在该次计算中是作为上一个。
                // 这里用if是根据题意判定一次循环只会增加一个所以也最多减少一个，否则根据单调队列标准应该用while
                if (!deque.isEmpty() && deque.peekFirst().getKey() < i - n) deque.removeFirst();
                sum += nums[i % n];
                res = Math.max(res, sum - Objects.requireNonNull(deque.peekFirst()).getValue()); // 更新答案
                // 保证队列中数据单调递增，所以队头一定是长度n以内最小的sumJ。
                while (!deque.isEmpty() && deque.peekLast().getValue() > sum) deque.removeLast();
                deque.add(new Pair<>(i, sum));
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
