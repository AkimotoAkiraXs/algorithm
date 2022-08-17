//给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,3,1]
//输出：2
//解释：
//输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
//连续子数组里面拥有相同度的有如下所示：
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,2,3,1,4,2]
//输出：6
//解释：
//数组的度是 3 ，因为元素 2 重复出现 3 次。
//所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在 1 到 50,000 范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
//
// Related Topics 数组 哈希表 👍 428 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;697
 * <p>
 * Name：数组的度
 *
 * @author Yuri
 * @since 2022-08-16 16:56:10
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new DegreeOfAnArray().new Solution();
        solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int SIZE = 50000 + 10;

        public int findShortestSubArray(int[] nums) {
            int[] first = new int[SIZE];
            int[] dis = new int[SIZE];
            Arrays.fill(first, -1);

            Map<Integer, Long> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (first[num] == -1) {
                    dis[num] = 1;
                    first[num] = i;
                } else {
                    dis[num] = i - first[num] + 1;
                }
                map.put(num, map.getOrDefault(num, 0L) + 1);
            }
            List<Map.Entry<Integer, Long>> entries = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
            Map.Entry<Integer, Long> firstEntry = entries.get(0);
            int maxValue = Math.toIntExact(firstEntry.getValue());
            int ans = dis[firstEntry.getKey()];
            for (int i = 1; i < entries.size(); i++) {
                Map.Entry<Integer, Long> entry = entries.get(i);
                if (entry.getValue() == maxValue) {
                    ans = Math.min(dis[entry.getKey()], ans);
                } else break;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}