//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4634 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;15
 * <p>
 * Name：三数之和
 *
 * @author Yuri
 * @since 2022-04-13 16:41:49
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] ints = {-1, 0, 0, 0, 0, 0, 0, 1};
        solution.threeSum(ints);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for (int x = 0; x < n; x++) {
                if (x > 0 && nums[x - 1] == nums[x]) {
                    continue;
                }
                int z = n - 1;
                for (int y = x + 1; y < n; y++) {
                    if (y > x + 1 && nums[y] == nums[y - 1]) {
                        continue;
                    }
                    while (nums[x] + nums[y] + nums[z] > 0 && y < z) {
                        z--;
                    }
                    if (y == z) {
                        break;
                    }
                    if (nums[x] + nums[y] + nums[z] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[x]);
                        list.add(nums[y]);
                        list.add(nums[z]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}