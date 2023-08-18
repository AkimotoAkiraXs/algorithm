//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 1020 👎 0


package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Id：&emsp;&emsp;40
 * <p>
 * Name：组合总和 II
 *
 * @author Yuri
 * @since 2022-07-06 10:28:32
 */
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] numbers;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            numbers = candidates;
            vis = new boolean[numbers.length];
            traceBack(0, target, new ArrayList<>());
            return ans;
        }

        void traceBack(int i, int target, List<Integer> nums) {
            if (target == 0) {
                ans.add(new ArrayList<>(nums));
                return;
            }
            for (; i < numbers.length; i++) {
                if (i > 0 && numbers[i] == numbers[i - 1] && !vis[i - 1]) continue;
                if (numbers[i] > target) break;
                nums.add(numbers[i]);
                vis[i] = true;
                traceBack(i + 1, target - numbers[i], nums);
                nums.remove(nums.size() - 1);
                vis[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}