// Given an integer array nums, return the maximum possible sum of elements of
// the array such that it is divisible by three.
//
// 
// Example 1: 
//
// 
// Input: nums = [3,6,5,1,8]
// Output: 18
// Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum
// divisible by 3).
//
// Example 2: 
//
// 
// Input: nums = [4]
// Output: 0
// Explanation: Since 4 is not divisible by 3, do not pick any number.
// 
//
// Example 3: 
//
// 
// Input: nums = [1,2,3,4,4]
// Output: 12
// Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum
// divisible by 3).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 4 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 241 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Id：&emsp;&emsp;1262
 * <p>
 * Name：Greatest Sum Divisible by Three
 *
 * @author Yuri
 * @since 2023-06-19 09:42:44
 */


public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        Solution solution = new GreatestSumDivisibleByThree().new Solution();
        int i = solution.maxSumDivThree(new int[]{3, 6, 5, 1, 8});
        System.out.println(i);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 这是自己错了N次写出来的01背包，Dp公式不难推，难在初始状态定义。
         * 该题只能滚动数组优化空间，没法一维优化（没法确定依赖位置），所以a、b就是两个滚动数组。
         * <p>
         * 因为没有推出dp[0][1]、dp[0][2]初始状态如何定义，显然dp[0][1] = dp[0][2] = 0是不正确的，它们是不可能存在的状态（没有任何数时余数不可能为1或者2）
         * 此处只得将其定义为0，然后通过判断k（加上第i个数时可以得到的余数）来更新第i层。
         * k表示（上一层每个数+num）%3来更新当前层的数，但并不一定能得到每一个当前层的数，就会导致当前层部分数无法更新为0，
         * 而为0显然是不对的，如果没法更新当前层某个位置的值dp[i][j]，那么其也该等于d[i-1][j]。
         * <p>
         * 这样的写法显然是不优雅的，终究其问题所在还是因为无法定义dp[0][1]=dp[0][2]的初始值，导致只能根据上层来更新下层，
         * 从而产生了下层部分值没法得到即时更新，需要两次判断来更新。
         * <p>
         * 优化做法为：初始化dp[0][1] = dp[0][2] = Integer.MIN_VALUE，
         * 对于不可能存在的状态（当前数无法凑出余1或者2的情况），进行dp状态转移时永远都是接近MIN_VALUE的值进行变换，
         * 而当遇到加入进某个值后余1\余2的情况变成可能是，dp[?][1]\dp[?][2]则会被更新为正数。
         */
        public int maxSumDivThree_self(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[2][3];
            for (int i = 1; i <= n; i++) {
                int num = nums[i - 1];
                int a = (i - 1) % 2;
                int b = i % 2;
                for (int j = 0; j < 3; j++) {
                    int k = (dp[a][j] + num) % 3;
                    dp[b][k] = Math.max(dp[a][dp[a][j] % 3] + num, dp[a][k]);
                    dp[b][j] = Math.max(dp[a][j], dp[b][j]);
                }
            }
            return dp[n % 2][0];
        }

        // 优化代码
        public int maxSumDivThree(int[] nums) {
            int n = nums.length;
            var f = new int[2][3];
            f[0][1] = f[0][2] = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < 3; j++)
                    f[(i + 1) % 2][j] = Math.max(f[i % 2][j], f[i % 2][(((j - nums[i]) % 3) + 3) % 3] + nums[i]);
            return f[n % 2][0];
        }

        /**
         * 贪心：计算sum为nums的和，统计nums中余3为1的数记录在a，余3为2的数记录为b，
         * 当sum余3=1时，说明sum中多了1个a中的数或者两个b中的数。无论是多了a中数或是b中数都是取其中的最小值，所以对a、b排序。
         * 然后再在这两种情况中取返回值最大的情况，不会存在两种情况都不能取（a<1&&b<2）。
         * <p>
         * sum余3=2时同理，逻辑一样，此时交换a、b顺序即可复用代码。
         */
        public int maxSumDivThree_greed(int[] nums) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            int sum = 0;
            for (Integer num : nums) {
                if (num % 3 == 1) a.add(num);
                else if (num % 3 == 2) b.add(num);
                sum += num;
            }
            if (sum % 3 == 0) return sum;
            Collections.sort(a);
            Collections.sort(b);
            if (sum % 3 == 2) {
                var temp = a;
                a = b;
                b = temp;
            }
            if (a.size() < 1) return sum - b.get(0) - b.get(1);
            if (b.size() < 2) return sum - a.get(0);
            return Math.max(sum - a.get(0), sum - b.get(0) - b.get(1));
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
