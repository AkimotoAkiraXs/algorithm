//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 538 👎 0


/*
 * Id：99
 * Name：恢复二叉搜索树
 * Date：2021-08-26 09:50:04
 */
package leetcode.editor.cn;

import model.TreeNode;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new RecoverBinarySearchTree().new Solution();
        Integer[] nums = new Integer[]{1, 3, null, null, 2};
        TreeNode treeNode = new TreeNode(nums);
        solution.recoverTree(treeNode);
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
        //思路一：中序遍历二叉搜索树 找出不符合 顺序排列的点 交换 重构二叉搜索树
//        List<Integer> list = new ArrayList<>();
//        int a = -1, b = -1;
//        int k = 0;
//        void LDR(TreeNode treeNode) {
//            if (treeNode == null) return;
//            LDR(treeNode.left);
//            list.add(treeNode.val);
//            LDR(treeNode.right);
//        }
//
//        void LDR2(TreeNode treeNode) {
//            if (treeNode == null) return;
//            LDR2(treeNode.left);
//            if (list.get(k) != treeNode.val) {
//                treeNode.val = list.get(k);
//            }
//            k++;
//            LDR2(treeNode.right);
//        }
//
//        public void recoverTree(TreeNode root) {
//            LDR(root);
//            for (int i = 0; i < list.size() - 1; i++) {
//                if (list.get(i) > list.get(i + 1)) {
//                    if (a == -1) a = i;
//                    else {
//                        b = i+1;
//                        break;
//                    }
//                }
//            }
//            if (b == -1) {
//                Collections.swap(list, a, a + 1);
//            } else {
//                Collections.swap(list, a, b);
//            }
//            if (a != -1) LDR2(root);
//        }

        //法2：隐式中序遍历
//        public void recoverTree(TreeNode root) {
//            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
//            TreeNode x = null, y = null, pred = null;
//
//            while (!stack.isEmpty() || root != null) {
//                while (root != null) {
//                    stack.push(root);
//                    root = root.left;
//                }
//                root = stack.pop();
//                if (pred != null && root.val < pred.val) {
//                    y = root;
//                    if (x == null) {
//                        x = pred;
//                    } else {
//                        break;
//                    }
//                }
//                pred = root;
//                root = root.right;
//            }
//            swap(x, y);
//        }
//
//        public void swap(TreeNode x, TreeNode y) {
//            int tmp = x.val;
//            x.val = y.val;
//            y.val = tmp;
//        }

        //法3 Morris 中序遍历
        public void recoverTree(TreeNode root) {
            TreeNode x = null, y = null, pred = null, predecessor = null;

            while (root != null) {
                if (root.left != null) {
                    // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }

                    // 让 predecessor 的右指针指向 root，继续遍历左子树
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    }
                    // 说明左子树已经访问完了，我们需要断开链接
                    else {
                        if (pred != null && root.val < pred.val) {
                            y = root;
                            if (x == null) {
                                x = pred;
                            }
                        }
                        pred = root;

                        predecessor.right = null;
                        root = root.right;
                    }
                }
                // 如果没有左孩子，则直接访问右孩子
                else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    root = root.right;
                }
            }
            swap(x, y);
        }

        public void swap(TreeNode x, TreeNode y) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 