package Tree.BinarySearchTree;

import Tree.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return  dfs(nums, 0, nums.length-1);
    }

    /**
     * 因为需要构建平衡的二叉搜索树，构建树时，选择数组最中间的数作为根节点，左右子树递归计算。
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }
}
