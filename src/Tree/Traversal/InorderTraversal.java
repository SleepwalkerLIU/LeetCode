package Tree.Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历定义：先左子树，后根节点，再右子树。
 */
public class InorderTraversal {
    /**
     * 树的遍历列表
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorder(root, ret);
        return ret;
    }

    /**
     * 递归
     * @param root
     * @param list
     */
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 迭代解法使用栈，因为其序为左中右，所以将左子树一直压栈直到为空，开始出栈，出栈的即为根节点，加入解中，同时开始遍历右子树。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIterate(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ret.add(curr.val);
            curr = curr.right;
        }
        return ret;
    }
}
