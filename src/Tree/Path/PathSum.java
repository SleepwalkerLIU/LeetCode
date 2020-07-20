package Tree.Path;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root != null) {
            backtrack(ret, new ArrayList<>(), root, sum);
        }
        return ret;
    }

    public void backtrack(List<List<Integer>> ret, List<Integer> curr, TreeNode root, int sum) {
        //定义满足条件
        if (root.left == null && root.right == null && root.val == sum) {
            curr.add(root.val);
            ret.add(new ArrayList<>(curr));
            curr.remove(curr.size());
        }
        if (root.left != null) {
            curr.add(root.val);//加入当前
            backtrack(ret, curr, root.left, sum - root.val);//回溯
            curr.remove(curr.size()-1);
        }
        if (root.right != null) {
            curr.add(root.val);
            backtrack(ret, curr, root.right, sum - root.val);
            curr.remove(curr.size()-1);//去掉当前
        }
    }
}
