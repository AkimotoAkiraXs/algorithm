package algorithm.tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * mirror遍历算法 该算法能将遍历空间复杂度降为 O(1) <br/>
 * 整体思路为：通过将当前结点的左子节点的最右子节点指向当前结点，形成一条能遍历整棵树的线路 <br/>
 *
 * @author Yuri
 * @see <a href="https://blog.csdn.net/qq_38684427/article/details/107708469">二叉树遍历</a>
 * @since 2021/8/27 14:59
 */

public class MirrorTraversing {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        MirrorInOrder.mirrorInOrder(root);
    }
}

//伪代码
class MirrorPseudoCode {
    public static void mirrorPseudoCode(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            // 左子树不为空
            if (cur.left != null) {
                // 向左走，目的是遍历完左子树
                TreeNode rightMost = cur.left;
                // 找到rightMost
                while (rightMost.right != null && rightMost.right != cur)
                    rightMost = rightMost.right;
                // 查看right指针是否被修改过来
                if (rightMost.right == null) {
                    rightMost.right = cur;
                    cur = cur.left;
                    // 如果没有被修改过，那么说明这个左子树没有遍历完，continue会使得最下面的cur向右移动执行不到，因为我们不希望想右走，左边子树还没有遍历完呢
                    continue;
                }
                // 修改过了，这是第二次到了该节点，我们需要将节点的指针修改回来。
                rightMost.right = null;
            }
            // 如果访问过了，向右走
            cur = cur.right;
        }
    }
}

//先序遍历
class MirrorPreOrder {
    public static void mirrorPreOrder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode rightMost = cur.left;
                while (rightMost.right != null && rightMost.right != cur) rightMost = rightMost.right;
                if (rightMost.right == null) {
                    System.out.println(cur.val);
                    rightMost.right = cur;
                    cur = cur.left;
                    continue;
                }
                rightMost.right = null;
            } else {
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }
}

//中序遍历
class MirrorInOrder {
    public static void mirrorInOrder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode rightMost = cur.left;
                while (rightMost.right != null && rightMost.right != cur) rightMost = rightMost.right;
                if (rightMost.right == null) {
                    rightMost.right = cur;
                    cur = cur.left;
                    continue;
                }
                rightMost.right = null;
            }
            System.out.println(cur.val);
            cur = cur.right;
        }
    }
}

class PostOrderTraversal {
    // 代码来自leetCode二叉树后序遍历
    public List<Integer> postOrderTraversal(TreeNode root) {
        TreeNode cur = root;
        ArrayList<Integer> res = new ArrayList<>();
        while (cur != null) {
            TreeNode rightMost = cur.left;
            if (rightMost != null) {
                while (rightMost.right != null && rightMost.right != cur)
                    rightMost = rightMost.right;
                if (rightMost.right == null) {
                    rightMost.right = cur;
                    cur = cur.left;
                    continue;
                }
                rightMost.right = null;
                function(cur.left, res);
            }
            cur = cur.right;
        }
        function(root, res);
        return res;
    }

    public void function(TreeNode node, ArrayList<Integer> res) {
//        先逆序整个右边界
        TreeNode tail = reverseEdge(node);
        TreeNode cur = tail;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.right;
        }
//        翻转回来
        reverseEdge(tail);
    }

    public TreeNode reverseEdge(TreeNode node) {
        TreeNode pre = null;
        TreeNode next;
        while (node != null) {
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}


