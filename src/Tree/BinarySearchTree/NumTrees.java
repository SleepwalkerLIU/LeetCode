package Tree.BinarySearchTree;

import Tree.TreeNode;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees {

    /**
     * 动态规划。
     * 定义数组dp，dp[i]代表以1..i为节点组成的二叉搜索树有多少。1..n为节点，
     * 选择其中一个节点j作为根节点，可以构成二叉搜索树的个数是由0..j-1构成的左子树的个数乘以j+1..n构成的右子树的个数。
     * 构成二叉搜索树的个数与树中的值无关只与节点个数有关，所以可以自底向上的计算。
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
