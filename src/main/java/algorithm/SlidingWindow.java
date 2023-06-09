package algorithm;

/**
 * 滑动窗口
 * <p>
 * 滑动窗口是数组/字符串问题中常用的抽象概念。窗口通常是指在数组/字符串中由开始和结束索引定义的一系列元素的集合，即闭区间[i,j]。
 * 而滑动窗口是指可以将两个边界向某一方向「滑动」的窗口
 *
 * @author Yuri
 * @since 2023/6/7 14:10
 */


public class SlidingWindow {

    public static void main(String[] args) {

    }

    /**
     * 滑动窗口模板问题，求几个不重叠子数组的最大和
     * <p>
     * {@link leetcode.editor.cn.MaximumSumOf3NonOverlappingSubarrays Lc689 三个无重叠子数组的最大和}
     * <p>
     * {@link leetcode.editor.cn.MaximumSumOfTwoNonOverlappingSubarrays Lc1031 两个无重叠子数组的最大和}
     */
    class MaximumSumOfSomeSubarrys {
        // 单个子数组最大和：向左移动，新增左值减去右值，取最大
        public int[] maxSumOfOneSubarray(int[] nums, int k) {
            int[] ans = new int[1];
            int sum1 = 0, maxSum1 = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum1 += nums[i];
                if (i >= k - 1) {
                    if (sum1 > maxSum1) {
                        maxSum1 = sum1;
                        ans[0] = i - k + 1;
                    }
                    sum1 -= nums[i - k + 1];
                }
            }
            return ans;
        }

        // 两个无重叠子数组的最大和
        public int[] maxSumOfTwoSubarrays(int[] nums, int k) {
            int[] ans = new int[2];
            int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
            int sum2 = 0, maxSum12 = 0;
            for (int i = k; i < nums.length; ++i) {
                sum1 += nums[i - k];
                sum2 += nums[i];
                if (i >= k * 2 - 1) {
                    if (sum1 > maxSum1) {
                        maxSum1 = sum1;
                        maxSum1Idx = i - k * 2 + 1;
                    }
                    if (maxSum1 + sum2 > maxSum12) {
                        maxSum12 = maxSum1 + sum2;
                        ans[0] = maxSum1Idx;
                        ans[1] = i - k + 1;
                    }
                    sum1 -= nums[i - k * 2 + 1];
                    sum2 -= nums[i - k + 1];
                }
            }
            return ans;
        }

        // 三个无重叠子数组的最大和
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int[] ans = new int[3];
            int n = nums.length;
            // maxOfOne：第一个数组的最大值；sumOfOne：滑动时第一个数组的和；maxOfOneIndex：第一个数组得到最大值时的起始坐标
            int maxOfOne = 0, sumOfOne = 0, maxOfOneIndex = 0;
            // maxOfOneTwo1Index：当两个数组在某段取得最大值时第一个数组的起始坐标；maxOfOneTwo2Index：...第二个数组的起始坐标
            int sumOfTwo = 0, maxOfOneTwo = 0, maxOfOneTwo1Index = 0, maxOfOneTwo2Index = 0;
            int sumOfThree = 0, maxOfTwoThree = 0;
            for (int i = 0; i < n - 2 * k; i++) {
                sumOfOne += nums[i];
                sumOfTwo += nums[i + k];
                sumOfThree += nums[i + 2 * k];
                if (i >= k - 1) {
                    if (sumOfOne > maxOfOne) {
                        maxOfOne = sumOfOne;
                        maxOfOneIndex = i - k + 1;
                    }
                    if (sumOfTwo + maxOfOne > maxOfOneTwo) {
                        maxOfOneTwo = sumOfTwo + maxOfOne;
                        maxOfOneTwo1Index = maxOfOneIndex;
                        maxOfOneTwo2Index = i + 1;
                    }
                    if (sumOfThree + maxOfOneTwo > maxOfTwoThree) {
                        maxOfTwoThree = sumOfThree + maxOfOneTwo;
                        ans[0] = maxOfOneTwo1Index;
                        ans[1] = maxOfOneTwo2Index;
                        ans[2] = i + k + 1;
                    }
                    sumOfOne -= nums[i - k + 1];
                    sumOfTwo -= nums[i + 1];
                    sumOfThree -= nums[i + k + 1];
                }
            }
            return ans;
        }
    }
}
