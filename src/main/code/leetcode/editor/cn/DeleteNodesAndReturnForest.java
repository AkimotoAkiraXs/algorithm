// Given the root of a binary tree, each node in the tree has a distinct value.
//
// After deleting all nodes with a value in to_delete, we are left with a 
// forest (a disjoint union of trees).
//
// Return the roots of the trees in the remaining forest. You may return the 
// result in any order.
//
// 
// Example 1: 
// 
// 
// Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
// Output: [[1,2,null,4],[6],[7]]
// 
//
// Example 2: 
//
// 
// Input: root = [1,2,4,null,3], to_delete = [3]
// Output: [[1,2,4]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree is at most 1000. 
// Each node has a distinct value between 1 and 1000. 
// to_delete.length <= 1000 
// to_delete contains distinct values between 1 and 1000. 
// 
//
// Related Topics 树 深度优先搜索 数组 哈希表 二叉树 👍 249 👎 0

package leetcode.editor.cn;

import model.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;1110
 * <p>
 * Name：Delete Nodes And Return Forest
 *
 * @author Yuri
 * @since 2023-05-30 11:41:24
 */


public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Solution solution = new DeleteNodesAndReturnForest().new Solution();

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
        List<TreeNode> ans;
        Set<Integer> hash;

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            ans = new ArrayList<>();
            hash = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
            dfs(root, true);
            return ans;
        }

        private boolean dfs(TreeNode node, boolean head) {
            if (node == null) return false;
            boolean exist = hash.contains(node.val);
            if (head && !exist) ans.add(node);
            if (dfs(node.left, exist)) node.left = null;
            if (dfs(node.right, exist)) node.right = null;
            return exist;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
