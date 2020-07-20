package Tree.Build;

import Tree.TreeNode;

/**
 * 与前中一样可以递归构造，此时，后序遍历第一个值变为树的根，
 * 仍在inorder中搜索该根的位置，分为左右两子树递归构造
 */
public class BuildTreeInPos {
    public TreeNode buildTreeInPos(int[] inorder, int[] posorder) {
        return dfs(inorder, 0, inorder.length-1, posorder, 0, posorder.length-1);
    }

    public TreeNode dfs(int[] inorder, int inl, int inr, int[] posorder, int posl, int posr) {
        if (inl > inr) {
            return null;
        }
        TreeNode root = new TreeNode(posorder[posr]);
        int index = 0;
        for (int i = inl; i <= inr; i++) {
            if (inorder[i] == posorder[posl]) {
                index = i;
                break;
            }
        }

        root.left = dfs(inorder, inl, index-1, posorder, posl, posl+index-inl-1);
        root.right = dfs(inorder, index+1, inr, posorder, posl+index-inl, posr-1);
        return root;
    }
}
