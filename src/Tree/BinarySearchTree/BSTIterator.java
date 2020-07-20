package Tree.BinarySearchTree;

import Tree.TreeNode;

import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.curr = root;
    }

    /**
     * 调用 next() 将返回二叉搜索树中的下一个最小的数。
     * 二叉树的中序遍历即可将二叉搜索树中的数递增输出，因此本题将中序遍历拆解，一次输出一个。
     * @return
     */
    public int next() {
        int ret = 0;
        if (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ret = curr.val;
            curr = curr.right;
        }
        return ret;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (curr != null || !stack.empty()) {
            return true;
        }
        return false;
    }
}
