// We have two arrays arr1 and arr2 which are initially empty. You need to add
// positive integers to them such that they satisfy all the following conditions:
//
// 
// arr1 contains uniqueCnt1 distinct positive integers, each of which is not 
// divisible by divisor1.
// arr2 contains uniqueCnt2 distinct positive integers, each of which is not 
// divisible by divisor2.
// No integer is present in both arr1 and arr2. 
// 
//
// Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2, return the minimum 
// possible maximum integer that can be present in either array.
//
// 
// Example 1: 
//
// 
// Input: divisor1 = 2, divisor2 = 7, uniqueCnt1 = 1, uniqueCnt2 = 3
// Output: 4
// Explanation:
// We can distribute the first 4 natural numbers into arr1 and arr2.
// arr1 = [1] and arr2 = [2,3,4].
// We can see that both arrays satisfy all the conditions.
// Since the maximum value is 4, we return it.
// 
//
// Example 2: 
//
// 
// Input: divisor1 = 3, divisor2 = 5, uniqueCnt1 = 2, uniqueCnt2 = 1
// Output: 3
// Explanation:
// Here arr1 = [1,2], and arr2 = [3] satisfy all conditions.
// Since the maximum value is 3, we return it.
//
// Example 3: 
//
// 
// Input: divisor1 = 2, divisor2 = 4, uniqueCnt1 = 8, uniqueCnt2 = 2
// Output: 15
// Explanation:
// Here, the final possible arrays can be arr1 = [1,3,5,7,9,11,13,15], and arr2 =
// [2,6].
// It can be shown that it is not possible to obtain a lower maximum satisfying
// all conditions.
// 
//
// 
// Constraints: 
//
// 
// 2 <= divisor1, divisor2 <= 10⁵ 
// 1 <= uniqueCnt1, uniqueCnt2 < 10⁹ 
// 2 <= uniqueCnt1 + uniqueCnt2 <= 10⁹ 
// 
//
// 👍 47 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2513
 * <p>
 * Name：Minimize the Maximum of Two Arrays
 *
 * @author Yuri
 * @since 2024-09-11 10:36:24
 */

public class MinimizeTheMaximumOfTwoArrays {

    public static void main(String[] args) {
        Solution solution = new MinimizeTheMaximumOfTwoArrays().new Solution();
        System.out.println(solution.minimizeSet(2, 5, 683651932, 161878530));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二分+数学：x、y、z分别表示能被d1整除的个数，能被d2整除的个数，能被d1、d2同时整除的个数
         * y-z表示只能被d2整除的个数，x-z表示只能被d1整除的个数（贪心思想，优先放入对方的数组）
         * m-(x+y-z)表示既不能被d1也不能被d2整除的个数，这些数可以随意选择放入两个数组中的一个
         */
        public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
            long gcm = (long) divisor1 * divisor2 / gcd(divisor1, divisor2); // 最大公倍数
            int l = 0, r = Integer.MAX_VALUE;
            while (l <= r) {
                int m = (r - l >> 1) + l;
                long x = m / divisor1, y = m / divisor2, z = (int) (m / gcm);
                if (Math.max(0, uniqueCnt1 - (y - z)) + Math.max(0, uniqueCnt2 - (x - z)) <= m - (x + y - z)) r = m - 1;
                else l = m + 1;
            }
            return l;
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        // 暴力，超时
        public int minimizeSet_bf(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
            int cache = 0, i = 0;
            while (uniqueCnt1 + uniqueCnt2 > cache && ++i > 0) {
                if (i % divisor1 > 0 && i % divisor2 > 0) cache++;
                else if (uniqueCnt1 > 0 && i % divisor1 > 0) uniqueCnt1--;
                else if (uniqueCnt2 > 0 && i % divisor2 > 0) uniqueCnt2--;
            }
            return i;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}