//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 662 👎 0


/*
 * Id：145
 * Name：二叉树的后序遍历
 * Date：2021-09-03 15:06:41
 */
package problems.leetcode.editor.cn;

import model.TreeNode;

import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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

        Stack<Integer> ans = new Stack<>();

        private void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            dfs(node.right);
            ans.add(node.val);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            dfs(root);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 