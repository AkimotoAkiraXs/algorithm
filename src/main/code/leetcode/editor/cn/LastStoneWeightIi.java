package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;1049 <br/>
 * Name：Last Stone Weight II <br/>
 *
 * @author Yuri
 * @since 2023-06-14 22:58:11
 */

public class LastStoneWeightIi {
    public static void main(String[] args) {
        Solution solution = new LastStoneWeightIi().new Solution();
        solution.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 01背包Dp：先推导，把stones分为俩堆pos、neg，设pos>=neg。
         * 则有：pos = sum - neg，设pos - neg = (sum - neg) - neg = sum - 2*neg设其为k。
         * 题目要求k尽可能小，即可转化为neg在小于sum/2的前提下尽可能大。
         * 所以就转化为经典01背包问题：在容量为sum/2的背包中选取任意物品，要求背包在容量内尽可能多装。
         */
        public int lastStoneWeightII(int[] stones) {
            int sum = Arrays.stream(stones).sum();
            int volume = sum / 2;
            int[] dp = new int[volume + 1];
            for (int stone : stones) {
                for (int j = volume; j >= 0; j--) {
                    if (j >= stone) dp[j] = Math.max(dp[j], dp[j - stone] + stone);
                }
            }
            return sum - 2 * dp[volume];
        }

        // 哈希表模拟
        public int lastStoneWeightII_Hash(int[] stones) {
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for (int stone : stones) {
                Set<Integer> temp = new HashSet<>();
                for (Integer num : set) {
                    temp.add(num + stone);
                    temp.add(Math.abs(num - stone));
                }
                set = temp;
            }
            return Collections.min(set);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
