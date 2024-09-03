// You have n computers. You are given the integer n and a 0-indexed integer
// array batteries where the iᵗʰ battery can run a computer for batteries[i] minutes.
// You are interested in running all n computers simultaneously using the given
// batteries.
//
// Initially, you can insert at most one battery into each computer. After that 
// and at any integer time moment, you can remove a battery from a computer and
// insert another battery any number of times. The inserted battery can be a totally
// new battery or a battery from another computer. You may assume that the removing
// and inserting processes take no time.
//
// Note that the batteries cannot be recharged. 
//
// Return the maximum number of minutes you can run all the n computers 
// simultaneously.
//
// 
// Example 1: 
// 
// 
// Input: n = 2, batteries = [3,3,3]
// Output: 4
// Explanation:
// Initially, insert battery 0 into the first computer and battery 1 into the
// second computer.
// After two minutes, remove battery 1 from the second computer and insert
// battery 2 instead. Note that battery 1 can still run for one minute.
// At the end of the third minute, battery 0 is drained, and you need to remove
// it from the first computer and insert battery 1 instead.
// By the end of the fourth minute, battery 1 is also drained, and the first
// computer is no longer running.
// We can run the two computers simultaneously for at most 4 minutes, so we
// return 4.
// 
//
//
// Example 2: 
// 
// 
// Input: n = 2, batteries = [1,1,1,1]
// Output: 2
// Explanation:
// Initially, insert battery 0 into the first computer and battery 2 into the
// second computer.
// After one minute, battery 0 and battery 2 are drained so you need to remove
// them and insert battery 1 into the first computer and battery 3 into the second
// computer.
// After another minute, battery 1 and battery 3 are also drained so the first
// and second computers are no longer running.
// We can run the two computers simultaneously for at most 2 minutes, so we
// return 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= batteries.length <= 10⁵ 
// 1 <= batteries[i] <= 10⁹ 
// 
//
// 👍 87 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;2141
 * <p>
 * Name：Maximum Running Time of N Computers
 *
 * @author Yuri
 * @since 2024-09-03 14:39:21
 */

public class MaximumRunningTimeOfNComputers {

    public static void main(String[] args) {
        Solution solution = new MaximumRunningTimeOfNComputers().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 受二分推出的结论，直接使用贪心
         */
        public long maxRunTime(int n, int[] batteries) {
            Arrays.sort(batteries);
            long sum = Arrays.stream(batteries).mapToLong(i -> i).sum();
            for (var i = batteries.length - 1; ; i--) {
                if (batteries[i] <= sum / n) return sum / n; // sum/n不可能比前一个batteries[i+1]大，否则在前一个if就直接返回了
                sum -= batteries[i];
                n--;
            }
        }

        /**
         * 排序+二分+贪心
         * <p>
         * 需要理解：二分电量为m，当某个电池大于等于m时则只能给一台电脑供电，剩余小于m的电池则可以给sum/m台电脑供电（因为小于m所以不会发生同一时间给一台电脑供电的情况）
         */
        public long maxRunTime_(int n, int[] batteries) {
            Arrays.sort(batteries);
            long l = 1, r = Arrays.stream(batteries).mapToLong(i -> i).sum() / n;
            while (l <= r) {
                long m = l + r >> 1;
                int cnt = 0, i = batteries.length;
                while (--i >= 0 && batteries[i] >= m) cnt++;
                cnt += (int) (Arrays.stream(batteries, 0, i + 1).mapToLong(o -> o).sum() / m);
                if (cnt >= n) l = m + 1;
                else r = m - 1;
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}