package Tree.Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历定义：先左子树，后右子树，再根节点。
 */
public class PostorderTraversal {
    /**
     *递归解法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecusive(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        postorder(root, ret);
        return ret;
    }

    /**
     * 递归
     * @param root
     * @param list
     */
    public void postorder(TreeNode root, List<Integer> list) {
        if (root ==null) {
            return;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    /**
     * 迭代解法的难点在于，由于后序遍历是左右根的顺序，当从栈里拿出根节点时需判断此时其右子树是否已经遍历完成。
     * 在这里我们使用一个标记，当一棵子树遍历完成时，记录下他的根节点，作为根节点右子树遍历完成的依据。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalIterate(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode r = null;//记录遍历过的右子树
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            // 判断右子树是否遍历完成
            if (curr.right == null || curr.right == r) {
                ret.add(curr.val);
                r = curr;
                curr = null;
                stack.pop();
            } else {
                curr = curr.right;
            }
        }
        return ret;
    }
}
