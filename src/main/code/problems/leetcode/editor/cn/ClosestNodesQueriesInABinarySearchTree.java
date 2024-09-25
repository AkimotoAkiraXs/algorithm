// You are given the root of a binary search tree and an array queries of size n
// consisting of positive integers.
//
// Find a 2D array answer of size n where answer[i] = [mini, maxi]: 
//
// 
// mini is the largest value in the tree that is smaller than or equal to 
// queries[i]. If a such value does not exist, add -1 instead.
// maxi is the smallest value in the tree that is greater than or equal to 
// queries[i]. If a such value does not exist, add -1 instead.
// 
//
// Return the array answer. 
//
// 
// Example 1: 
// 
// 
// Input: root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2
//,5,16]
// Output: [[2,2],[4,6],[15,-1]]
// Explanation: We answer the queries in the following way:
//- The largest number that is smaller or equal than 2 in the tree is 2, and 
// the smallest number that is greater or equal than 2 is still 2. So the answer for
// the first query is [2,2].
//- The largest number that is smaller or equal than 5 in the tree is 4, and 
// the smallest number that is greater or equal than 5 is 6. So the answer for the
// second query is [4,6].
//- The largest number that is smaller or equal than 16 in the tree is 15, and 
// the smallest number that is greater or equal than 16 does not exist. So the
// answer for the third query is [15,-1].
// 
//
// Example 2: 
// 
// 
// Input: root = [4,null,9], queries = [3]
// Output: [[-1,4]]
// Explanation: The largest number that is smaller or equal to 3 in the tree
// does not exist, and the smallest number that is greater or equal to 3 is 4. So the
// answer for the query is [-1,4].
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁵]. 
// 1 <= Node.val <= 10⁶ 
// n == queries.length 
// 1 <= n <= 10⁵ 
// 1 <= queries[i] <= 10⁶ 
// 
//
// 👍 79 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import model.TreeNode;

/**
 * Id：&emsp;&emsp;2476
 * <p>
 * Name：Closest Nodes Queries in a Binary Search Tree
 *
 * @author Yuri
 * @since 2024-09-25 14:43:47
 */

public class ClosestNodesQueriesInABinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new ClosestNodesQueriesInABinarySearchTree().new Solution();

        int[] nums = {6, 2, 13, 1, 4, 9, 15, 14};
        solution.bs_max(nums, 16);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<Integer> list = new ArrayList<>();
            dfs(list, root);
            int[] nums = list.stream().mapToInt(i -> i).sorted().toArray();
            List<List<Integer>> ans = new ArrayList<>();
            for (int q : queries) ans.add(List.of(bs_max(nums, q), bs_min(nums, q)));
            return ans;
        }

        // 大于等于k的最小值
        private int bs_min(int[] nums, int k) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int m = l + r >> 1;
                if (nums[m] < k) l = m + 1;
                else r = m - 1;
            }
            return l == nums.length ? -1 : nums[l];
        }

        // 小于等于k的最大值
        private int bs_max(int[] nums, int k) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int m = l + r >> 1;
                if (nums[m] > k) r = m - 1;
                else l = m + 1;
            }
            return r == -1 ? -1 : nums[r];
        }

        private void dfs(List<Integer> list, TreeNode node) {
            if (node != null) {
                list.add(node.val);
                dfs(list, node.left);
                dfs(list, node.right);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}