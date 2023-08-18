//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// Related Topics 数组 数学 字符串 排序 👍 217 👎 0

package problems.leetcode.editor.cn;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;539
 * <p>
 * Name：最小时间差
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class MinimumTimeDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumTimeDifference().new Solution();
        solution.findMinDifference(Lists.newArrayList(
                "00:00", "23:59", "01:01"
        ));
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 注意使用：鸽巢原理（抽屉原理），因为时间可能数只有24*60，所以当size大于该数量则可以判定肯定会有重复的数，直接返回0即可
     */
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int size = timePoints.size();
            int tot = 24 * 60;
            if (size > tot) return 0;
            timePoints = timePoints.stream().sorted((a, b) -> {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) return a.charAt(i) - b.charAt(i);
                }
                return 0;
            }).collect(Collectors.toList());
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                String x = timePoints.get((i - 1 + size) % size);
                String y = timePoints.get(i);
                int temp = (y.charAt(0) - x.charAt(0)) * 10 * 60;
                temp += (y.charAt(1) - x.charAt(1)) * 60;
                temp += (y.charAt(3) - x.charAt(3)) * 10;
                temp += (y.charAt(4) - x.charAt(4));
                temp = Math.abs(temp);
                ans = Math.min(ans, Math.min(tot - temp, temp));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}