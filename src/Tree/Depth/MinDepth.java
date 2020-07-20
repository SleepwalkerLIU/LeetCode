package Tree.Depth;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 */
public class MinDepth {
    /**
     * 层序遍历，返回第一个左右子树都为null的节点深度。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size > 0) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return level;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                size--;
            }
        }
        return level;
    }
}
