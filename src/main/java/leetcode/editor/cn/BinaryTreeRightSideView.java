//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 531 👎 0


/*
 * Id：199
 * Name：二叉树的右视图
 * Date：2021-09-08 09:23:16
 */
package leetcode.editor.cn;

import model.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        Integer[] integers = new Integer[]{1, 2, 3, null, 5, null, 4};
        TreeNode root = new TreeNode(integers);
        solution.rightSideView(root);
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
        Map<Integer, Integer> map = new HashMap<>();

        void dfs(TreeNode node, int depth) {
            if (node == null) return;

            dfs(node.right, depth + 1);
            dfs(node.left, depth + 1);
            map.computeIfAbsent(depth, k -> node.val);
        }

        public List<Integer> rightSideView(TreeNode root) {
            dfs(root, 0);
            return new LinkedList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 