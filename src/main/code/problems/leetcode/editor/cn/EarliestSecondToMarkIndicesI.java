// You are given two 1-indexed integer arrays, nums and, changeIndices, having
// lengths n and m, respectively.
//
// Initially, all indices in nums are unmarked. Your task is to mark all 
// indices in nums.
//
// In each second, s, in order from 1 to m (inclusive), you can perform one of 
// the following operations:
//
// 
// Choose an index i in the range [1, n] and decrement nums[i] by 1. 
// If nums[changeIndices[s]] is equal to 0, mark the index changeIndices[s]. 
// Do nothing. 
// 
//
// Return an integer denoting the earliest second in the range [1, m] when all 
// indices in nums can be marked by choosing operations optimally, or -1 if it is
// impossible.
//
// 
// Example 1: 
//
// 
// Input: nums = [2,2,0], changeIndices = [2,2,2,2,3,2,2,1]
// Output: 8
// Explanation: In this example, we have 8 seconds. The following operations can
// be performed to mark all indices:
// Second 1: Choose index 1 and decrement nums[1] by one. nums becomes [1,2,0].
// Second 2: Choose index 1 and decrement nums[1] by one. nums becomes [0,2,0].
// Second 3: Choose index 2 and decrement nums[2] by one. nums becomes [0,1,0].
// Second 4: Choose index 2 and decrement nums[2] by one. nums becomes [0,0,0].
// Second 5: Mark the index changeIndices[5], which is marking index 3, since
// nums[3] is equal to 0.
// Second 6: Mark the index changeIndices[6], which is marking index 2, since
// nums[2] is equal to 0.
// Second 7: Do nothing.
// Second 8: Mark the index changeIndices[8], which is marking index 1, since
// nums[1] is equal to 0.
// Now all indices have been marked.
// It can be shown that it is not possible to mark all indices earlier than the 8
// th second.
// Hence, the answer is 8.
// 
//
// Example 2: 
//
// 
// Input: nums = [1,3], changeIndices = [1,1,1,2,1,1,1]
// Output: 6
// Explanation: In this example, we have 7 seconds. The following operations can
// be performed to mark all indices:
// Second 1: Choose index 2 and decrement nums[2] by one. nums becomes [1,2].
// Second 2: Choose index 2 and decrement nums[2] by one. nums becomes [1,1].
// Second 3: Choose index 2 and decrement nums[2] by one. nums becomes [1,0].
// Second 4: Mark the index changeIndices[4], which is marking index 2, since
// nums[2] is equal to 0.
// Second 5: Choose index 1 and decrement nums[1] by one. nums becomes [0,0].
// Second 6: Mark the index changeIndices[6], which is marking index 1, since
// nums[1] is equal to 0.
// Now all indices have been marked.
// It can be shown that it is not possible to mark all indices earlier than the 6
// th second.
// Hence, the answer is 6.
// 
//
// Example 3: 
//
// 
// Input: nums = [0,1], changeIndices = [2,2,2]
// Output: -1
// Explanation: In this example, it is impossible to mark all indices because
// index 1 isn't in changeIndices.
// Hence, the answer is -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n == nums.length <= 2000 
// 0 <= nums[i] <= 10⁹ 
// 1 <= m == changeIndices.length <= 2000 
// 1 <= changeIndices[i] <= n 
// 
//
// 👍 25 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Id：&emsp;&emsp;3048
 * <p>
 * Name：Earliest Second to Mark Indices I
 *
 * @author Yuri
 * @since 2024-08-21 11:11:28
 */

public class EarliestSecondToMarkIndicesI {

    public static void main(String[] args) {
        Solution solution = new EarliestSecondToMarkIndicesI().new Solution();
        solution.earliestSecondToMarkIndices(new int[]{2, 2, 0}, new int[]{2, 2, 2, 2, 3, 2, 2, 1});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 灵神思路，大体方向和自己一样，但是在找能否满足时要简单很多，用个cnt记录下可复习天数就行了
         */
        public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
            int max = changeIndices.length + 1;
            int l = 1, r = max;
            while (l < r) {
                int mid = l + r >> 1;
                if (f(nums, changeIndices, mid)) l = mid + 1;
                else r = mid;
            }
            return l == max ? -1 : l;
        }

        private boolean f(int[] nums, int[] changeIndices, int mid) {
            int n = nums.length;
            int[] ns = new int[n + 1]; // changeIndices是从1~m，所以多给ns一个位置，避免后续频繁-1
            for (int i = 0; i < mid; i++)
                ns[changeIndices[i]] = i + 1; // ns记录在mid范围内，每个数出现的最后位置，这里把0作为标记，所以对位置都进行+1，为0则表示某个数未曾出现
            for (int i = 1; i <= n; i++)
                if (ns[i] == 0) return true;
            int cnt = 0; // cnt表示前面可以操作将nums[i]减少1的次数
            for (int i = 0; i < mid; i++) {
                if (ns[changeIndices[i]] == 0) return true;
                if (ns[changeIndices[i]] == i + 1) {
                    if (nums[changeIndices[i] - 1] > cnt) return true;
                    cnt -= nums[changeIndices[i] - 1];
                } else cnt++;
            }
            return false;
        }

        /**
         * 自己的思路：二分 + 范围查找最后出现位置，然后排序再看能不能达成条件。
         */
        public int earliestSecondToMarkIndices_self(int[] nums, int[] changeIndices) {
            int n = nums.length, m = changeIndices.length;
            int l = 1, r = m + 1;
            out:
            while (l < r) {
                int mid = l + r >> 1;
                int[] ns = new int[n];
                for (int i = 0; i < mid; i++) ns[changeIndices[i] - 1] = i + 1;
                List<int[]> rcs = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (ns[i] == -1) {
                        l = mid + 1;
                        continue out;
                    }
                    rcs.add(new int[]{i, ns[i]});
                }
                rcs.sort(Comparator.comparing(o -> o[1]));

                int last = 0;
                for (int[] rc : rcs) {
                    last += nums[rc[0]] + 1;
                    if (rc[1] < last) {
                        l = mid + 1;
                        continue out;
                    }
                }
                r = mid;
            }
            return l == m + 1 ? -1 : l;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}