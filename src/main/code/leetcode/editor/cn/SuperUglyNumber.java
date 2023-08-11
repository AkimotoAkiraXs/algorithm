// A super ugly number is a positive integer whose prime factors are in the
// array primes.
//
// Given an integer n and an array of integers primes, return the nᵗʰ super 
// ugly number.
//
// The nᵗʰ super ugly number is guaranteed to fit in a 32-bit signed integer. 
//
// 
// Example 1: 
//
// 
// Input: n = 12, primes = [2,7,13,19]
// Output: 32
// Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
// super ugly numbers given primes = [2,7,13,19].
// 
//
// Example 2: 
//
// 
// Input: n = 1, primes = [2,3,5]
// Output: 1
// Explanation: 1 has no prime factors, therefore all of its prime factors are
// in the array primes = [2,3,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= primes.length <= 100 
// 2 <= primes[i] <= 1000 
// primes[i] is guaranteed to be a prime number. 
// All the values of primes are unique and sorted in ascending order. 
// 
//
// Related Topics 数组 数学 动态规划 👍 377 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;313
 * <p>
 * Name：Super Ugly Number
 *
 * @author Yuri
 * @since 2023-06-02 11:46:08
 */


public class SuperUglyNumber {
    public static void main(String[] args) {
        Solution solution = new SuperUglyNumber().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            long[] dp = new long[n];
            dp[0] = 1;
            int p = primes.length;
            int[] indexes = new int[p];
            long[] nums = new long[p];
            for (int i = 1; i < n; i++) {
                long min = Long.MAX_VALUE;
                for (int j = 0; j < p; j++) {
                    long num = dp[indexes[j]] * primes[j];
                    nums[j] = num;
                    min = Math.min(min, num);
                }
                dp[i] = min;
                for (int j = 0; j < p; j++) if (nums[j] == min) indexes[j]++;
            }
            return (int) dp[n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
