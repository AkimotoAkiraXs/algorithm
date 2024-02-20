package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuri
 * @since 2021/8/26 14:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode(Integer[] nums) {
        if (nums == null) {
            return;
        }
        TreeNode tree = new TreeNode();
        tree.val = nums[0];
        List<TreeNode> trees = new ArrayList<>();
        trees.add(tree);
        for (int i = 0; i < nums.length; ) {
            TreeNode node = trees.remove(0);
            ++i;
            if (i < nums.length && nums[i] != null) {
                node.left = new TreeNode();
                node.left.val = nums[i];
                trees.add(node.left);
            }
            ++i;
            if (i < nums.length && nums[i] != null) {
                node.right = new TreeNode();
                node.right.val = nums[i];
                trees.add(node.right);
            }
        }
        this.val = tree.val;
        this.left = tree.left;
        this.right = tree.right;
    }

    private TreeNode createTree(int index, Integer[] nums) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }
        return new TreeNode(nums[index], createTree((index + 1) * 2 - 1, nums), createTree((index + 1) * 2, nums));
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(new Integer[]{3,4,5,1,2});
        TreeNode b = new TreeNode(new Integer[]{4,1,2});
        boolean equals = a.left.equals(b);
        System.out.println("ans:" + equals);
    }
}
