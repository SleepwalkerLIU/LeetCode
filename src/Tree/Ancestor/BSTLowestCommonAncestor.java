package Tree.Ancestor;

import Tree.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class BSTLowestCommonAncestor {
    /**
     * 可以利用二叉搜索树的性质，知道p和q是否都在二叉树的左子树或右子树上，若是则递归求解左子树或右子树，否则当前根节点即为结果。
     * @param root
     * @param a
     * @param b
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root.val > a.val && root.val > b.val) {
            return lowestCommonAncestor(root.left, a, b);
        } else if (root.val < a.val && root.val < b.val) {
            return lowestCommonAncestor(root.right, a, b);
        } else {
            return root;
        }

    }
}
