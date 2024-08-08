// Given a binary tree with the following rules:
//
// 
// root.val == 0 
// If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 *
// x + 1 
// If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2
// * x + 2 
// 
//
// Now the binary tree is contaminated, which means all treeNode.val have been 
// changed to -1.
//
// Implement the FindElements class: 
//
// 
// FindElements(TreeNode* root) Initializes the object with a contaminated 
// binary tree and recovers it.
// bool find(int target) Returns true if the target value exists in the 
// recovered binary tree.
// 
//
// 
// Example 1: 
// 
// 
// Input
//["FindElements","find","find"]
//[[[-1,null,-1]],[1],[2]]
// Output
//[null,false,true]
// Explanation
// FindElements findElements = new FindElements([-1,null,-1]);
// findElements.find(1); // return False
// findElements.find(2); // return True
//
// Example 2: 
// 
// 
// Input
//["FindElements","find","find","find"]
//[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
// Output
//[null,true,true,false]
// Explanation
// FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
// findElements.find(1); // return True
// findElements.find(3); // return True
// findElements.find(5); // return False
//
// Example 3: 
// 
// 
// Input
//["FindElements","find","find","find","find"]
//[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
// Output
//[null,true,false,false,true]
// Explanation
// FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
// findElements.find(2); // return True
// findElements.find(3); // return False
// findElements.find(4); // return False
// findElements.find(5); // return True
// 
//
// 
// Constraints: 
//
// 
// TreeNode.val == -1 
// The height of the binary tree is less than or equal to 20 
// The total number of nodes is between [1, 10⁴] 
// Total calls of find() is between [1, 10⁴] 
// 0 <= target <= 10⁶ 
// 
//
// 👍 79 👎 0

package problems.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import model.TreeNode;

/**
 * Id：&emsp;&emsp;1261
 * <p>
 * Name：Find Elements in a Contaminated Binary Tree
 *
 * @author Yuri
 * @since 2024-08-08 16:46:56
 */

public class FindElementsInAContaminatedBinaryTree {

    public static void main(String[] args) {

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
    class FindElements {

        Set<Integer> hash = new HashSet<>();

        public FindElements(TreeNode root) {
            root.val = 0;
            dfs(root);
        }

        private void dfs(TreeNode node) {
            hash.add(node.val);
            if (node.left != null) {
                node.left.val = node.val * 2 + 1;
                dfs(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val * 2 + 2;
                dfs(node.right);
            }
        }

        public boolean find(int target) {
            return hash.contains(target);
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
// leetcode submit region end(Prohibit modification and deletion)

}