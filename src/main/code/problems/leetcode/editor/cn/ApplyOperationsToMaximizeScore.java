// You are given an array nums of n positive integers and an integer k.
//
// Initially, you start with a score of 1. You have to maximize your score by 
// applying the following operation at most k times:
//
// 
// Choose any non-empty subarray nums[l, ..., r] that you haven't chosen 
// previously.
// Choose an element x of nums[l, ..., r] with the highest prime score. If 
// multiple such elements exist, choose the one with the smallest index.
// Multiply your score by x. 
// 
//
// Here, nums[l, ..., r] denotes the subarray of nums starting at index l and 
// ending at the index r, both ends being inclusive.
//
// The prime score of an integer x is equal to the number of distinct prime 
// factors of x. For example, the prime score of 300 is 3 since 300 = 2 * 2 * 3 * 5 * 5
//. 
//
// Return the maximum possible score after applying at most k operations. 
//
// Since the answer may be large, return it modulo 109 + 7. 
//
// 
// Example 1: 
//
// 
// Input: nums = [8,3,9,3,8], k = 2
// Output: 81
// Explanation: To get a score of 81, we can apply the following operations:
//- Choose subarray nums[2, ..., 2]. nums[2] is the only element in this 
// subarray. Hence, we multiply the score by nums[2]. The score becomes 1 * 9 = 9.
//- Choose subarray nums[2, ..., 3]. Both nums[2] and nums[3] have a prime 
// score of 1, but nums[2] has the smaller index. Hence, we multiply the score by nums[2
//]. The score becomes 9 * 9 = 81.
// It can be proven that 81 is the highest score one can obtain.
//
// Example 2: 
//
// 
// Input: nums = [19,12,14,6,10,18], k = 3
// Output: 4788
// Explanation: To get a score of 4788, we can apply the following operations:
//- Choose subarray nums[0, ..., 0]. nums[0] is the only element in this 
// subarray. Hence, we multiply the score by nums[0]. The score becomes 1 * 19 = 19.
//- Choose subarray nums[5, ..., 5]. nums[5] is the only element in this 
// subarray. Hence, we multiply the score by nums[5]. The score becomes 19 * 18 = 342.
//- Choose subarray nums[2, ..., 3]. Both nums[2] and nums[3] have a prime 
// score of 2, but nums[2] has the smaller index. Hence, we multipy the score by nums[2]
//. The score becomes 342 * 14 = 4788.
// It can be proven that 4788 is the highest score one can obtain.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length == n <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 1 <= k <= min(n * (n + 1) / 2, 10⁹) 
// 
//
// 👍 18 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Id：&emsp;&emsp;2818
 * <p>
 * Name：Apply Operations to Maximize Score
 *
 * @author Yuri
 * @since 2023-08-14 16:56:18
 */


public class ApplyOperationsToMaximizeScore {
    public static void main(String[] args) {
        Solution solution = new ApplyOperationsToMaximizeScore().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 大杂烩：数论 + 贡献法（子数组） + 单调栈 + 坐标排序 + 矩阵快速幂
     */
    class Solution {
        static int MAXN = (int) 1e5 + 1;
        static int[] omega = new int[MAXN];
        int mod = (int) 1e9 + 7;

        // 预处理omega
        static {
            for (int i = 2; i < MAXN; i++) {
                if (omega[i] > 0) continue;
                for (int j = 1; j * i < MAXN; j++) omega[j * i]++;
            }
        }

        public int maximumScore(List<Integer> nums, int k) {
            int[] ints = nums.stream().mapToInt(i -> i).toArray();
            int n = ints.length;

            int[] vals = new int[n]; // vals存放着每个位置的数所对应的不同质数因子个数。
            for (int i = 0; i < n; i++) vals[i] = omega[ints[i]];

            // 每个数能做的最大贡献即：它作为质数分数最高的数（且在最右边）的子数组个数
            // 根据题意，第i个数能做的贡献为左边分数不小于它的数的位置l，右边分数大于它的数的位置r
            // ∴子数组个数 = 贡献数 = (i-l)*(r-i)
            int[] left = new int[n];
            int[] right = new int[n];
            // 预设边界
            Arrays.fill(left, -1);
            Arrays.fill(right, n);
            // 单调栈
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                // i不断弹出栈中的比他小的数直到栈为空或者找到一个不小于它的数，该数位置即i的左边界
                // 对于被弹出的数，i便是他们遇到的第一个比它大的数，所以i是它们的右边界
                while (!deque.isEmpty() && vals[deque.peekLast()] < vals[i]) right[deque.pollLast()] = i;
                if (!deque.isEmpty()) left[i] = deque.peekLast();
                deque.add(i);
            }

            // 小技巧：需要找到ints中数的顺序，可以将[0,1,2...n-1]的数组以ints中数排序
            Integer[] sorted = new Integer[n];
            for (int i = 0; i < n; i++) sorted[i] = i;
            Arrays.sort(sorted, (o1, o2) -> ints[o2] - ints[o1]);

            long ans = 1;
            int i = 0; // 从最大的数开始进行计算
            while (k > 0) {
                Integer index = sorted[i++];
                int p = (right[index] - index) * (index - left[index]); // 求贡献长度
                if (p > k) p = k;
                // ∵需要取模 ∴不能调用 pow()，需要手动乘法取模，如果循环p次会超时，这里运用矩阵快速幂logn的时间计算n^m
                ans = (ans * mfp(ints[index], p)) % mod;
                k -= p;
            }
            return (int) ans;
        }

        private long mfp(long num, int p) {
            if (p == 0) return 1;
            long mfp = mfp(num, p / 2);
            if ((p & 1) == 1) return (mfp * mfp % mod * num) % mod;
            return (mfp * mfp) % mod;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
