// Given an array of integers preorder, which represents the preorder traversal
// of a BST (i.e., binary search tree), construct the tree and return its root.
//
// It is guaranteed that there is always possible to find a binary search tree 
// with the given requirements for the given test cases.
//
// A binary search tree is a binary tree where for every node, any descendant 
// of Node.left has a value strictly less than Node.val, and any descendant of Node.
// right has a value strictly greater than Node.val.
//
// A preorder traversal of a binary tree displays the value of the node first, 
// then traverses Node.left, then traverses Node.right.
//
// 
// Example 1: 
// 
// 
// Input: preorder = [8,5,1,7,10,12]
// Output: [8,5,10,1,7,null,12]
// 
//
// Example 2: 
//
// 
// Input: preorder = [1,3]
// Output: [1,null,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 100 
// 1 <= preorder[i] <= 1000 
// All the values of preorder are unique. 
// 
//
// 👍 281 👎 0

package problems.leetcode.editor.cn;

import model.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;1008
 * <p>
 * Name：Construct Binary Search Tree from Preorder Traversal
 *
 * @author Yuri
 * @since 2024-02-21 10:42:18
 */

public class ConstructBinarySearchTreeFromPreorderTraversal {

    public static void main(String[] args) {
        Solution solution = new ConstructBinarySearchTreeFromPreorderTraversal().new Solution();

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

    /**
     * 二叉搜索树的中序遍历是有序的，所以可以排序获取中序遍历然后把问题转换为
     * {@link ConstructBinaryTreeFromPreorderAndInorderTraversal Lc105 从前序与中序遍历序列构造二叉树}
     * <p>
     * O(nlogn)
     */
    class Solution {

        public TreeNode bstFromPreorder(int[] preorder) {
            int[] inorder = Arrays.stream(preorder).sorted().toArray();
            return buildTree(preorder, inorder);
        }

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
    // leetcode submit region end(Prohibit modification and deletion)

}