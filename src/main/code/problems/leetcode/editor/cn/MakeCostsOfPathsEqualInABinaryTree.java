// You are given an integer n representing the number of nodes in a perfect
// binary tree consisting of nodes numbered from 1 to n. The root of the tree is node 1
// and each node i in the tree has two children where the left child is the node 2
//* i and the right child is 2 * i + 1. 
//
// Each node in the tree also has a cost represented by a given 0-indexed 
// integer array cost of size n where cost[i] is the cost of node i + 1. You are allowed
// to increment the cost of any node by 1 any number of times.
//
// Return the minimum number of increments you need to make the cost of paths 
// from the root to each leaf node equal.
//
// Note: 
//
// 
// A perfect binary tree is a tree where each node, except the leaf nodes, has 
// exactly 2 children.
// The cost of a path is the sum of costs of nodes in the path. 
// 
//
// 
// Example 1: 
// 
// 
// Input: n = 7, cost = [1,5,2,2,3,3,1]
// Output: 6
// Explanation: We can do the following increments:
//- Increase the cost of node 4 one time.
//- Increase the cost of node 3 three times.
//- Increase the cost of node 7 two times.
// Each path from the root to a leaf will have a total cost of 9.
// The total increments we did is 1 + 3 + 2 = 6.
// It can be shown that this is the minimum answer we can achieve.
// 
//
// Example 2: 
// 
// 
// Input: n = 3, cost = [5,3,3]
// Output: 0
// Explanation: The two paths already have equal total costs, so no increments
// are needed.
// 
//
// 
// Constraints: 
//
// 
// 3 <= n <= 10⁵ 
// n + 1 is a power of 2 
// cost.length == n 
// 1 <= cost[i] <= 10⁴ 
// 
//
// 👍 47 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;2673
 * <p>
 * Name：Make Costs of Paths Equal in a Binary Tree
 *
 * @author Yuri
 * @since 2024-02-28 11:07:04
 */

public class MakeCostsOfPathsEqualInABinaryTree {

    public static void main(String[] args) {
        Solution solution = new MakeCostsOfPathsEqualInABinaryTree().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class TreeNode {

            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode() {
            }

            public TreeNode(int[] nums) {
                TreeNode tree = new TreeNode();
                tree.val = nums[0];
                List<TreeNode> trees = new ArrayList<>();
                trees.add(tree);
                for (int i = 0; i < nums.length; ) {
                    TreeNode node = trees.remove(0);
                    ++i;
                    if (i < nums.length) {
                        node.left = new TreeNode();
                        node.left.val = nums[i];
                        trees.add(node.left);
                    }
                    ++i;
                    if (i < nums.length) {
                        node.right = new TreeNode();
                        node.right.val = nums[i];
                        trees.add(node.right);
                    }
                }
                this.val = tree.val;
                this.left = tree.left;
                this.right = tree.right;
            }
        }

        int ans, max;

        public int minIncrements(int n, int[] cost) {
            TreeNode root = new TreeNode(cost);
            max = dfsMax(root);
            ans = 0;
            dfs(root, 0);
            return ans;
        }


        private int dfs(TreeNode node, int sum) {
            if (node.left == null) return max - (node.val + sum);
            int leftVal = dfs(node.left, sum + node.val);
            int rightVal = dfs(node.right, sum + node.val);
            ans += Math.abs(leftVal - rightVal);
            return Math.min(leftVal, rightVal);
        }

        private int dfsMax(TreeNode node) {
            if (node == null) return 0;
            return Math.max(dfsMax(node.left), dfsMax(node.right)) + node.val;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}