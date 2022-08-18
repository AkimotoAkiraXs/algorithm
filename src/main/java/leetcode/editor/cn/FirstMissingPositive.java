//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 1564 👎 0


package leetcode.editor.cn;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Id：&emsp;&emsp;41
 * <p>
 * Name：缺失的第一个正数
 *
 * @author Yuri
 * @since 2022-08-18 09:26:17
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        solution.firstMissingPositive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 20});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // TreeMap偷鸡
        public int firstMissingPositive(int[] nums) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int num:nums) map.put(num, 0);
            Set<Integer> integers = map.keySet();
            int k = 1;
            for (Integer num : integers) {
                if (num == k) k++;
                else if (num > 0) return k;
            }
            return k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}