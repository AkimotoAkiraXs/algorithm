//////给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//////
////// 
//////
////// 示例 1： 
//////
////// 
//////输入：nums = [1,1,2]
//////输出：
//////[[1,1,2],
////// [1,2,1],
////// [2,1,1]]
////// 
//////
////// 示例 2： 
//////
////// 
//////输入：nums = [1,2,3]
//////输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
////// 
//////
////// 
//////
////// 提示： 
//////
////// 
////// 1 <= nums.length <= 8 
////// -10 <= nums[i] <= 10 
////// 
////// Related Topics 数组 回溯 👍 1111 👎 0
////
//


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;47
 * <p>
 * Name：全排列 II
 *
 * @author Yuri
 * @since 2022-07-04 14:01:27
 */
public class PermutationsIi {

    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int len;
        boolean[] vis;
        int[] numbers;
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            numbers = nums;
            len = nums.length;
            vis = new boolean[len];
            dfs(new ArrayList<>());
            return ans;
        }

        // i > 0 && numbers[i] == numbers[i-1] && !vis[i-1] 当前数和前面的数相同时，如果前面数未标记则说明是经过回溯，跳过避免重复
        void dfs(List<Integer> list) {
            if (list.size() == len) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (vis[i] || (i > 0 && numbers[i] == numbers[i-1] && !vis[i-1])) continue;
                list.add(numbers[i]);
                vis[i] = true;
                dfs(list);
                vis[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}