//给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。 
//
// 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。 
//
// 返回数组能分成的最多块数量。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [4,3,2,1,0]
//输出: 1
//解释:
//将数组分成2块或者更多块，都无法得到所需的结果。
//例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
// 
//
// 示例 2: 
//
// 
//输入: arr = [1,0,2,3,4]
//输出: 4
//解释:
//我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
//然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
// 
//
// 
//
// 提示: 
//
// 
// n == arr.length 
// 1 <= n <= 10 
// 0 <= arr[i] < n 
// arr 中每个元素都 不同 
// 
//
// Related Topics 栈 贪心 数组 排序 单调栈 👍 310 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;769
 * <p>
 * Name：最多能完成排序的块
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        Solution solution = new MaxChunksToMakeSorted().new Solution();
        System.out.println(solution.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

/*
        // 双指针
        public int maxChunksToSorted(int[] arr) {
            int fast = 0, slow = 0;
            int ans = 0;
            while (++fast <= arr.length) {
                boolean flag = true;
                for (int i = slow; i < fast; i++) {
                    if (arr[i] >= fast || arr[i] < slow) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans++;
                    slow = fast;
                }
            }
            return ans;
        }
*/

        /**
         * 前缀和：因为题目限制了数组为0 ~ n-1所以不可能发生 0+3 = 1+2这种Bug
         */
        public int maxChunksToSorted(int[] arr) {
            int ret = 0;
            int vSum = 0;
            int iSum = 0;
            for (int i = 0; i < arr.length; i++) {
                vSum += arr[i];
                iSum += i;
                if (vSum == iSum) ret++;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}