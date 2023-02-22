// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
// 复的三元组。
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [-1,0,1,2,-1,-4]
// 输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
// 输入：nums = []
// 输出：[]
// 
//
// 示例 3： 
//
// 
// 输入：nums = [0]
// 输出：[]
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
        int[] ints = {1, 2, -2, -1};
        solution.threeSum(ints);
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 灵神的优雅代码
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
                if (nums[i] + nums[n - 1] + nums[n - 2] < 0) continue; // 优化一
                if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break; // 优化二
                int j = i + 1, k = n - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] > 0) k--;
                    else if (nums[i] + nums[j] + nums[k] < 0) j++;
                    else {
                        ans.add(List.of(nums[i], nums[j], nums[k]));
                        for (++j; j < k && nums[j] == nums[j - 1]; j++) ;
                        for (--k; j < k && nums[k] == nums[k + 1]; k--) ;
                    }
                }
            }
            return ans;
        }

        // 固定第一位，二三位双指针写法
        public List<List<Integer>> threeSum_(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
                int r = n - 1;
                for (int l = i + 1; l < r; l++) {
                    if (l > i + 1 && nums[l] == nums[l - 1]) continue; // 去重
                    while (l < r && nums[l] + nums[r] > -nums[i]) r--;
                    if (l < r && nums[l] + nums[r] == -nums[i]) ans.add(List.of(nums[i], nums[l], nums[r]));
                }
            }
            return ans;
        }

        // 排序+双指针
        public List<List<Integer>> threeSum__(int[] nums) {
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
// leetcode submit region end(Prohibit modification and deletion)

}