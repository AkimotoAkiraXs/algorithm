// An ugly number is a positive integer whose prime factors are limited to 2, 3,
// and 5.
//
// Given an integer n, return the nᵗʰ ugly number. 
//
// 
// Example 1: 
//
// 
// Input: n = 10
// Output: 12
// Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10
// ugly numbers.
// 
//
// Example 2: 
//
// 
// Input: n = 1
// Output: 1
// Explanation: 1 has no prime factors, therefore all of its prime factors are
// limited to 2, 3, and 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1690 
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 1076 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;264
 * <p>
 * Name：Ugly Number II
 *
 * @author Yuri
 * @since 2023-06-01 18:01:06
 */


public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        solution.nthUglyNumber(10);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * （self）三指针、同时也算是动态规划思路dp[i]=min(dp[p2]×2,dp[p3]×3,dp[p5]×5)
         * <p>
         * 丑数肯定是2、3、5的倍数，所以定三个坐标分别代表从小到大与2、3、5相乘的数，每次选最小的，然后对坐标+1，遇到重复时，重复坐标也要+1
         * <p>
         * 此解法也可以不用Dp来思考，直接用三指针模拟就好
         */
        public int nthUglyNumber(int n) {
            int a = 0, b = 0, c = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int aa = dp[a] * 2;
                int bb = dp[b] * 3;
                int cc = dp[c] * 5;
                int num = Math.min(Math.min(aa, bb), cc);
                dp[i] = num;
                if (num == aa) a++;
                if (num == bb) b++;
                if (num == cc) c++;
            }
            return dp[n - 1];
        }

        /**
         * 优先队列+哈希表（想出来没写出来的做法）时间、空间复杂度都很差
         */
/*
        public int nthUglyNumber(int n) {
            int[] fixed = {2, 3, 5};
            Set<Long> hash = Stream.of(1L).collect(Collectors.toSet());
            PriorityQueue<Long> queue = Stream.of(1L).collect(Collectors.toCollection(PriorityQueue::new));
            int ugly = 0;
            for (int i = 0; i < n; i++) {
                long last = queue.poll();
                ugly = (int) last;
                for (int fix : fixed) {
                    long next = fix * last;
                    if (hash.add(next)){
                        queue.offer(next);
                    }
                }
            }
            return ugly;
        }
*/
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
