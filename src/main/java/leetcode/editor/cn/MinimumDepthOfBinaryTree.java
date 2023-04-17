//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 570 👎 0


/*
 * Id：111
 * Name：二叉树的最小深度
 * Date：2021-08-30 16:26:16
 */
package leetcode.editor.cn;

import model.TreeNode;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        Integer[] s = new Integer[]{-9, -3, 2, null, 4, 4, 0, -6, null, -5};
        int n = solution.minDepth(new TreeNode(s));
        System.out.println(n);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
        int min = Integer.MAX_VALUE;
        void dfs(TreeNode node, int depth) {
            if (node == null) return;
            if (node.left == null && node.right == null) {
                min = Math.min(depth + 1, min);
                return;
            }
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            dfs(root, 0);
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 