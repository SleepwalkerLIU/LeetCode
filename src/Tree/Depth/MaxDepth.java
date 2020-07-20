package Tree.Depth;

import Tree.TreeNode;

/*
给定一个二叉树，找出其最大深度。
 */
public class MaxDepth {
    /**
     * 递归，返回左右子树最大高度加一。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
