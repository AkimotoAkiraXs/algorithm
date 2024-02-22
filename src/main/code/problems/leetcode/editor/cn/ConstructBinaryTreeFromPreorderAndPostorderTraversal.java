// Given two integer arrays, preorder and postorder where preorder is the
// preorder traversal of a binary tree of distinct values and postorder is the postorder
// traversal of the same tree, reconstruct and return the binary tree.
//
// If there exist multiple answers, you can return any of them. 
//
// 
// Example 1: 
// 
// 
// Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
// Output: [1,2,3,4,5,6,7]
// 
//
// Example 2: 
//
// 
// Input: preorder = [1], postorder = [1]
// Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// All the values of preorder are unique. 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// All the values of postorder are unique. 
// It is guaranteed that preorder and postorder are the preorder traversal and 
// postorder traversal of the same binary tree.
// 
//
// 👍 350 👎 0

package problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import model.TreeNode;

/**
 * Id：&emsp;&emsp;889
 * <p>
 * Name：Construct Binary Tree from Preorder and Postorder Traversal
 *
 * @author Yuri
 * @since 2024-02-22 11:36:24
 */

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();

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
        int[] preorder;
        int[] postorder;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            this.n = preorder.length;
            this.preorder = preorder;
            this.postorder = postorder;
            for (int i = 0; i < n; i++) map.put(postorder[i], i);
            return dfs(0, n, 0, n);
        }

        private TreeNode dfs(int preS, int preE, int postS, int postE) {
            if (preS == preE) return null;
            TreeNode root = new TreeNode(preorder[preS]);
            if (preS + 1 < preE) {
                int leftVal = preorder[preS + 1];
                int leftSize = map.get(leftVal) - postS + 1;
                root.left = dfs(preS + 1, preS + 1 + leftSize, postS, postS + leftSize);
                root.right = dfs(preS + 1 + leftSize, preE, postS + leftSize, postE - 1);
            }
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}