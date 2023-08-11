//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11390 👎 0


/*
 * Id：1
 * Name：两数之和
 * Date：2021-06-22 14:37:26
 */
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //暴力
        public int[] twoSumForce(int[] nums, int target) {
            List<Integer> ary = Arrays.stream(nums).boxed().collect(Collectors.toList());
            for (int i = 0; i < ary.size(); i++) {
                int n = ary.get(i);
                int j = 0;
                j = ary.lastIndexOf(target - n);
                if (j != i && j != -1) {
                    return new int[]{j, i};
                }
            }
            return new int[0];
        }

        //哈希表 O(1)
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hash.containsKey(target - nums[i])) {
                    return new int[]{hash.get(target - nums[i]), i};
                }
                hash.put(nums[i], i);
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}