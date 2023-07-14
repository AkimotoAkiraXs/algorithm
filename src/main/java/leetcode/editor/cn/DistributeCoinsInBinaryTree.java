// You are given the root of a binary tree with n nodes where each node in the
// tree has node.val coins. There are n coins in total throughout the whole tree.
//
// In one move, we may choose two adjacent nodes and move one coin from one 
// node to another. A move may be from parent to child, or from child to parent.
//
// Return the minimum number of moves required to make every node have exactly 
// one coin.
//
// 
// Example 1: 
// 
// 
// Input: root = [3,0,0]
// Output: 2
// Explanation: From the root of the tree, we move one coin to its left child,
// and one coin to its right child.
// 
//
// Example 2: 
// 
// 
// Input: root = [0,3,0]
// Output: 3
// Explanation: From the left child of the root, we move two coins to the root [
// taking two moves]. Then, we move one coin from the root of the tree to the right
// child.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= n <= 100 
// 0 <= Node.val <= n 
// The sum of all Node.val is n. 
// 
//
// 👍 404 👎 0

package leetcode.editor.cn;

import model.TreeNode;

/**
 * Id：&emsp;&emsp;979
 * <p>
 * Name：Distribute Coins in Binary Tree
 *
 * @author Yuri
 * @since 2023-07-14 10:44:21
 */


public class DistributeCoinsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DistributeCoinsInBinaryTree().new Solution();

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

        int ans = 0;

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return ans;
        }

        // 每次向下左右搜索，把最后多的硬币或者少的硬币汇总放在父节点
        int dfs(TreeNode node) {
            if (node == null) return 0;
            int coin = node.val;
            int left = dfs(node.left);
            coin += left;
            int right = dfs(node.right);
            coin += right;
            ans += Math.abs(left) + Math.abs(right);
            return coin - 1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
