package Tree.Path;

import Tree.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 */
public class MaxPathSum {
    int ret = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ret;
    }

    /**
     * 使用递归函数返回经过参数节点的最大路径和
     * 递归计算左子树和右子树的最大路径和。
     * 若子树的最大路径和是大于0的，那么子树对经过根的最大路径和是有增益的，把他加到参数节点的值中，与全局最大值比较。
     * 递归函数的返回值为，参数节点值，参数节点值+左子树递归值，参数节点值+右子树递归值中的最大值。
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int curr = root.val;
        if (left > 0) {
            curr += left;
        }
        if (right > 0) {
            curr += right;
        }
        ret = Math.max(ret, curr);
        return Math.max(root.val, Math.max(left + root.val, right + root.val));
    }
}
