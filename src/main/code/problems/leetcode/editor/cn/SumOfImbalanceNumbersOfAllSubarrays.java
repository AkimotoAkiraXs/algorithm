package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Id：&emsp;&emsp;2763 <br/>
 * Name：Sum of Imbalance Numbers of All Subarrays <br/>
 *
 * @author Yuri
 * @since 2023-07-03 22:44:55
 */

public class SumOfImbalanceNumbersOfAllSubarrays {
    public static void main(String[] args) {
        Solution solution = new SumOfImbalanceNumbersOfAllSubarrays().new Solution();
        solution.sumImbalanceNumbers(new int[]{2, 1, 2});
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 贡献法：考虑每个数在所有子数组中的贡献次数。
         * <p>
         * 子数组：指的是一个数组中连续一段非空的元素序列，注意是需要连续。
         * 所以一个长度为n的数组子数组有多少个呢？n(n+1)/2！考虑只含1个数、2个数...n个数的子数组个数分别是n、n-1...1个。
         * <p>
         * 排序后arr[i+1] - arr[i] > 1。
         * 我们定义某个子数组中的数字k是否做出贡献的标志为子数组中是否存在k-1？
         * 不用考虑k+1是因为我们考虑k+1时会考虑k，所以这里我们统一考虑左边。
         * 所以对于某个数k，我们只需要找他的左边界和右边界，边界定义为k-1出现的位置，因为当k-1出现后，k将不再做出贡献，
         * 所以我们只需考虑边界内包含数字k的子数组数就可，其实就是从k的位置到右边，k的位置到左边这两段距离相乘。
         * <p>
         * 对于重复数字，我们会发现在同一个子数组中他们中有一个会做出贡献，而其余的不会做出贡献，而当我们只把边界定义为k-1时，会对他们进行重复计算。
         * 所以我们将左边边界定义为k-1，右边则定义为k/k-1，子数组中重复数字计算贡献的都只是排序前最右边的k。
         * <p>
         * 此外，当某个数是子数组中最小数（排序后在最左边）时也不会有贡献。
         * 考虑这种情况有多少呢？其实每个子数组都会有一个最小数，而我们考虑这个最小数时其进行了贡献计算，所以减去子数组个数即可。
         */
        public int sumImbalanceNumbers(int[] nums) {
            int n = nums.length;
            int ans = 0;
            int[] div = new int[n + 1]; // div在两次循环中分别用于标记目前为止，num在左边、右边最后一次出现的位置
            int[] vis = new int[n + 1]; // vis用来标记计算num在子数组中贡献时，左边界的位置。
            Arrays.fill(div, -1);
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                div[num] = i;
                vis[i] = div[num - 1];
            }
            Arrays.fill(div, n);
            for (int i = n - 1; i >= 0; i--) {
                int num = nums[i];
                ans += (i - vis[i]) * (Math.min(div[num - 1], div[num]) - i); // 左边界距离乘以右边界距离
                div[num] = i;
            }
            return ans - n * (n + 1) / 2; // 减去子数组个数
        }

        /**
         * 枚举 + 滑动窗口：O(n^2)
         * <p>
         * 第一次遍历以i开头，第二次遍历以j结尾，得到所有子数组组合。<br>
         * cnt统计每次子数组的个数，在第二次遍历时又共通性。<br>
         * 用hash统计每次出现出现的数，当j次出现数已经出现过，则不这次子数组的不平衡数=上一个子数组的不平衡数。
         * 再统计nums[j]+1、nums[j]-1是否出现过？当都没出现过时，考虑[2,7]中插入5，本身cnt=1插入5后cnt+1=2，
         * 于是可以总结出i开头的子数组j每往后移动一位新增一个数，cnt最多+1。<br>
         * 但是当nums[j]+1、nums[j]-1出现过时，分别-1。
         * <p>
         */
        public int sumImbalanceNumbers_Sliding(int[] nums) {
            int n = nums.length;
            int ans = 0;
            Set<Integer> hash = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                hash.clear();
                hash.add(nums[i]);
                for (int j = i + 1; j < n; j++) {
                    if (!hash.contains(nums[j])) {
                        cnt += 1 - (hash.contains(nums[j] + 1) ? 1 : 0) - (hash.contains(nums[j] - 1) ? 1 : 0);
                        hash.add(nums[j]);
                    }
                    ans += cnt; // 每次循环计算的是这个子数组加上nums[j]后不平衡数个数
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
