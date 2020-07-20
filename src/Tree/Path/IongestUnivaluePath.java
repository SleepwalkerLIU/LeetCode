package Tree.Path;

import Tree.TreeNode;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 二叉树问题多可以使用递归的方法解决。
 */
public class IongestUnivaluePath {
    int ret = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ret;
    }

    /**
     * 用递归函数返回以递归的根节点所在的最长路径。用全局变量保存最大值。
     * 对根结节点，递归遍历左子树和右子树，若根节点的值和左子树值相等，即可在左子树递归返回值上加1作为当前值
     * 因为路径上可以加上根节点，长度加一。
     * 递归函数返回值为根节点通过左子树、右子树中路径的较大值。
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if ((root == null)) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int ansleft = 0, ansright = 0;
        if (root.left != null && root.left.val == root.val) {
            ansleft = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            ansright = right + 1;
        }
        ret = Math.max(ret, ansleft + ansright);
        return Math.max(ansleft, ansright);
    }
}
