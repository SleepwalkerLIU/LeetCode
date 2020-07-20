package Tree.Build;

import Tree.TreeNode;

/**
 * 前序遍历第一个值即为当前树的根节点，在中序遍历中找到该根节点，左边为左子树，右边为右子树，递归构造，
 * 此时，前序遍历数组的分割由中序遍历确定的左右子树大小来分割。
 */
public class BuildTreePreIn {
    public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int prel, int prer, int[] inorder, int inl, int inr) {
        if (prel > prer) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prel]);
        int index = 0;
        for (int i = inl; i <= inr; i++) {
            if (inorder[i] == preorder[prel]) {
                index = i;
                break;
            }
        }

        root.left = dfs(preorder, prel+1, prel+index-inl, inorder, inl, index-1);
        root.right = dfs(preorder, prel+index-inl+1, prer, inorder, index+1, inr);
        return root;
    }

}
