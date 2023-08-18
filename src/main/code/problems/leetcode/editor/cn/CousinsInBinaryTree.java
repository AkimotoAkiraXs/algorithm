//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 222 👎 0


/*
 * Id：993
 * Name：二叉树的堂兄弟节点
 * Date：2021-06-22 15:15:12
 */
package problems.leetcode.editor.cn;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class CousinsInBinaryTree {

    public static void main(String[] args) {
        Solution solution = new CousinsInBinaryTree().new Solution();
        System.out.println("Hello world");
    }

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

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List recursion(TreeNode root, int parentNum, int num, int degree) {
            if (num == root.val) {
                List<Integer> res = new ArrayList<>();
                res.add(degree);
                res.add(parentNum);
                return res;
            }
            if (root.left != null) {
                List listLeft = recursion(root.left, root.val, num, degree + 1);
                if (listLeft != null) {
                    return listLeft;
                }
            }
            if (root.right != null) {
                List rightList = recursion(root.right, root.val, num, degree + 1);
                if (rightList != null) {
                    return rightList;
                }
            }
            return null;
        }

        public boolean isCousins(TreeNode root, int x, int y) {
            List listX = recursion(root, root.val, x, 0);
            List listY = recursion(root, root.val, y, 0);
            if (listX.size() == 0 || listY.size() == 0 || listX.get(0) != listY.get(0) || listX.get(1) == listY.get(1)) {
                return false;
            } else {
                return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 