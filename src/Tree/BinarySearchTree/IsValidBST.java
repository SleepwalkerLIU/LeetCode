package Tree.BinarySearchTree;

import Tree.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class IsValidBST {
    /**
     * 利用二叉搜索树的性质，中序遍历为一个递增序列。
     * 使用迭代方法中序遍历二叉树，不满足递增条件则返回false。
     * @param root
     * @return
     */
    public boolean isValidVST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double pre = -Double.MAX_VALUE;
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val <= pre) {
                return false;
            }
            pre = curr.val;
            curr = curr.right;
        }
        return true;
    }
}
