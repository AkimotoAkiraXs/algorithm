//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 1183 👎 0


/*
 * Id：98
 * Name：验证二叉搜索树
 * Date：2021-08-25 13:57:17
 */
package leetcode.editor.cn;


import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        System.out.println("Hello world");
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
        List<Integer> list = new ArrayList<>();

//        法一：中序遍历二叉搜索树所得到的队列一定为有序
//        //中序遍历
//        void LDR(TreeNode treeNode) {
//            if (treeNode == null) return;
//            LDR(treeNode.left);
//            list.add(treeNode.val);
//            LDR(treeNode.right);
//        }
//
//        public boolean isValidBST(TreeNode root) {
//            LDR(root);
//            int lower = list.get(0);
//            for (int i = 1; i < list.size(); i++) {
//                if (lower >= list.get(i)) {
//                    return false;
//                }
//                lower = list.get(i);
//            }
//            return true;
//        }

        //法二：递归dfs
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode node, long lower, long upper) {
            if (node == null) {
                return true;
            }
            if (node.val <= lower || node.val >= upper) {
                return false;
            }
            return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}