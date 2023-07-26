// You are given a 0-indexed integer array stations of length n, where stations[
// i] represents the number of power stations in the iᵗʰ city.
//
// Each power station can provide power to every city in a fixed range. In 
// other words, if the range is denoted by r, then a power station at city i can
// provide power to all cities j such that |i - j| <= r and 0 <= i, j <= n - 1.
//
// 
// Note that |x| denotes absolute value. For example, |7 - 5| = 2 and |3 - 10| =
// 7. 
// 
//
// The power of a city is the total number of power stations it is being 
// provided power from.
//
// The government has sanctioned building k more power stations, each of which 
// can be built in any city, and have the same range as the pre-existing ones.
//
// Given the two integers r and k, return the maximum possible minimum power of 
// a city, if the additional power stations are built optimally.
//
// Note that you can build the k power stations in multiple cities. 
//
// 
// Example 1: 
//
// 
// Input: stations = [1,2,4,5,0], r = 1, k = 2
// Output: 5
// Explanation:
// One of the optimal ways is to install both the power stations at city 1.
// So stations will become [1,4,4,5,0].
//- City 0 is provided by 1 + 4 = 5 power stations.
//- City 1 is provided by 1 + 4 + 4 = 9 power stations.
//- City 2 is provided by 4 + 4 + 5 = 13 power stations.
//- City 3 is provided by 5 + 4 = 9 power stations.
//- City 4 is provided by 5 + 0 = 5 power stations.
// So the minimum power of a city is 5.
// Since it is not possible to obtain a larger power, we return 5.
// 
//
// Example 2: 
//
// 
// Input: stations = [4,4,4,4], r = 0, k = 3
// Output: 4
// Explanation:
// It can be proved that we cannot make the minimum power of a city greater than
// 4.
// 
//
// 
// Constraints: 
//
// 
// n == stations.length 
// 1 <= n <= 10⁵ 
// 0 <= stations[i] <= 10⁵ 
// 0 <= r <= n - 1 
// 0 <= k <= 10⁹ 
// 
//
// 👍 32 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2528
 * <p>
 * Name：Maximize the Minimum Powered City
 *
 * @author Yuri
 * @since 2023-07-21 15:32:20
 */


public class MaximizeTheMinimumPoweredCity {
    public static void main(String[] args) {
        Solution solution = new MaximizeTheMinimumPoweredCity().new Solution();
        solution.maxPower(new int[]{4, 2}, 1, 1);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        long[] sums;
        int r, k, n;

        public long maxPower(int[] stations, int r, int k) {
            this.r = r;
            this.k = k;
            this.n = stations.length;
            this.sums = new long[n];

            long[] preSum = new long[n + 1];
            for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + stations[i - 1];
            long mn = Long.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                sums[i - 1] = preSum[Math.min(i + r, n)] - preSum[Math.max(i - r - 1, 0)]; // 前缀和求区间，快速算每个位置总电量
                mn = Math.min(mn, sums[i - 1]);
            }

            // 二分搜答案
            long left = mn, right = mn + k + 1; // 开区间写法，因为返回的是left，right需要取开区间，即right永远不能等于答案
            while (left + 1 < right) {
                long mid = left + (right - left) / 2;
                if (check(mid)) left = mid;
                else right = mid;
            }
            return left;
        }

        private boolean check(long mid) {
            int[] dif = new int[n + 1]; // 差分数组快速求区间加减
            long d = 0;
            long cnt = 0;
            for (int i = 0; i < n; i++) { // 从左到右遍历每个位置是否满足最低电量需求，如果不满足，则用贪心思想在i+r处加电站（因为左到右，左边已经>=mid了）
                d += dif[i];
                long total = sums[i] + d;
                if (total < mid) {
                    long dis = mid - total;
                    cnt += dis;
                    if (cnt > k) return false;
                    dif[i + 1] += dis;
                    dif[Math.min(n, i + 2 * r + 1)] -= dis;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
