//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 866 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * Id：&emsp;&emsp;90
 * <p>
 * Name：子集 II
 *
 * @author Yuri
 * @since 2022-06-29 15:16:41
 */
public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        List<List<Integer>> lists = solution.subsetsWithDup(new int[]{4, 4, 4, 1, 4});
        System.out.println(lists.toString());
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            ans.add(new ArrayList<>());
            Arrays.sort(nums);
            for (int num : nums) {
                handle(num);
            }
            return ans;
        }

        void handle(int n) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(ans.get(i));
                newList.add(n);
                if (!set.contains(newList)) {
                    set.add(newList);
                    ans.add(newList);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}