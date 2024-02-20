// Given two integer arrays preorder and inorder where preorder is the preorder
// traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
//
// 👍 2218 👎 0

package problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import model.TreeNode;

/**
 * Id：&emsp;&emsp;105
 * <p>
 * Name：Construct Binary Tree from Preorder and Inorder Traversal
 *
 * @author Yuri
 * @since 2024-02-20 10:32:46
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        System.out.println(solution.buildTree(new int[]{3, 9, 8, 20, 15, 7}, new int[]{9, 8, 3, 15, 20, 7}));
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

    // 灵神写法，不动原数组，以四个数分别控制左右子树的开始和结束
    class Solution {

        int[] preorder;
        int[] inorder;
        Map<Integer, Integer> map = new HashMap<>();
        int n;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            n = preorder.length;
            for (int i = 0; i < n; i++) map.put(inorder[i], i);
            return build(0, n, 0, n);
        }

        public TreeNode build(int ps, int pe, int is, int ie) {
            if (ps == pe) return null;
            TreeNode treeNode = new TreeNode(preorder[ps]);
            int leftSize = map.get(preorder[ps]) - is; // 左子树长度
            treeNode.left = build(ps + 1, ps + 1 + leftSize, is, is + leftSize);
            treeNode.right = build(ps + leftSize + 1, pe, is + leftSize + 1, ie);
            return treeNode;
        }

    }

    // 这个写法强行截取子数组传入递归函数，比较耗时
    class Solution_self {

        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
            return build(preorder, inorder);
        }

        private TreeNode build(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;
            int root = preorder[0];

            TreeNode treeNode = new TreeNode(root);
            if (preorder.length > 1) {
                int rootIndex = -1;
                for (int i = 0; i < inorder.length; i++) {
                    if (inorder[i] == root) {
                        rootIndex = i;
                        break;
                    }
                }
                int i = 1;
                while (i < preorder.length && map.get(preorder[i]) < map.get(root)) i++;
                treeNode.left = build(Arrays.copyOfRange(preorder, 1, i),
                    Arrays.copyOfRange(inorder, 0, rootIndex));
                treeNode.right = build(Arrays.copyOfRange(preorder, i, preorder.length),
                    Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
            }
            return treeNode;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}