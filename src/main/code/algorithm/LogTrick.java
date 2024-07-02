package algorithm;

import java.util.ArrayList;
import problems.leetcode.editor.cn.SmallestSubarraysWithMaximumBitwiseOr;

/**
 * 用于求解子数组中与、或问题
 * <p>
 * 因为与、或只会让一个数不变或减少（增加）二进制中的某几个位置的1。
 * 所以在子数组与或问题中，我们可以把从某位置开始为左端点，到数组末尾的与或值全部记录下来（经过去重不会超过30个值2^29 < 10^9 < 2^30）。
 *
 * @author Yuri
 * @since 2024/7/2 14:55
 */


public class LogTrick {

    /**
     * 给定一个数组，求i位置为左端点的子数组或值最大时的最小长度。
     *
     * @see SmallestSubarraysWithMaximumBitwiseOr Lc.2411 按位或最大的最小子数组长度
     */
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        var ors = new ArrayList<int[]>(); // 按位或的值、右端点位置，都一定是由大到小
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ors.add(new int[]{0, i});
            int k = 0;
            for (var or : ors) {
                or[0] |= nums[i];
                if (ors.get(k)[0] == or[0]) ors.get(k)[1] = or[1];
                else ors.set(++k, or);
            }
            ors.subList(k + 1, ors.size()).clear();
            ans[i] = ors.get(0)[1] - i + 1; // 左端点到右端点的距离
        }
        return ans;
    }
}
