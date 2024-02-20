// Given two integer arrays inorder and postorder where inorder is the inorder
// traversal of a binary tree and postorder is the postorder traversal of the same
// tree, construct and return the binary tree.
//
// 
// Example 1: 
// 
// 
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
// Input: inorder = [-1], postorder = [-1]
// Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder and postorder consist of unique values. 
// Each value of postorder also appears in inorder. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// postorder is guaranteed to be the postorder traversal of the tree. 
// 
//
// 👍 1173 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import model.TreeNode;

/**
 * Id：&emsp;&emsp;106
 * <p>
 * Name：Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author Yuri
 * @since 2024-02-20 15:49:59
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();

        solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
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

        int n;
        int[] inorder;
        int[] postorder;
        Map<Integer, Integer> map = new HashMap<>();
        // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            n = postorder.length;
            this.inorder = inorder;
            this.postorder = postorder;
            for (int i = 0; i < n; i++) map.put(inorder[i], i);
            return build(0, n, 0, n);
        }

        public TreeNode build(int is, int ie, int ps, int pe) {
            if (ps == pe) return null;
            int val = postorder[pe - 1];
            TreeNode root = new TreeNode(val);
            int leftSize = map.get(val) - is;
            root.left = build(is, is + leftSize, ps, ps + leftSize);
            root.right = build(is + leftSize + 1, ie, ps + leftSize, pe - 1);
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}