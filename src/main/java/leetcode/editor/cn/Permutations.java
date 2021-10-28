//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1601 👎 0


/*
 * Id：46
 * Name：全排列
 * Date：2021-10-27 17:44:31
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        solution.permute(nums);
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int len;
        int[] n;
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            len = nums.length;
            n = nums;
            dfs(new ArrayList<>());
            return res;
        }

        void dfs(ArrayList<Integer> list) {
            if (list.size() == len) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (list.contains(n[i])) continue;
                list.add(n[i]);
                dfs(list);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 