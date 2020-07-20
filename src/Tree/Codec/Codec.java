package Tree.Codec;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    /**
     * Encodes a tree to a single string
     * @param root
     * @return
     */
    public String serialize(Tree.TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<Tree.TreeNode> queue = new LinkedList<>();
        if (root != null) {
            sb.append(root.val);
            sb.append(",");
            queue.offer(root);
        } else {
            return null;
        }
        while (!queue.isEmpty()) {
            Tree.TreeNode p = queue.poll();
            if (p.left == null) {
                sb.append("#,");
            } else {
                sb.append(p.left.val);
                sb.append(",");
                queue.offer(p.left);
            }
            if (p.right == null) {
                sb.append("#,");
            } else {
                sb.append(p.right.val);
                sb.append(",");
                queue.offer(p.right);
            }
        }
        return sb.toString();
    }

    /**
     * Decodes your encoded data to tree
     * @param data
     * @return
     */
    public Tree.TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] arr = data.split(",");
        Queue<Tree.TreeNode> queue = new LinkedList<>();
        Tree.TreeNode root = new Tree.TreeNode(Integer.valueOf(arr[0]));
        queue.offer(root);
        int index = 1;
        while(!queue.isEmpty()) {
            Tree.TreeNode curr = queue.poll();
            if(arr[index++].equals("#")) {
                curr.left = null;
            } else {
                curr.left = new Tree.TreeNode(Integer.valueOf(arr[index-1]));
                queue.offer(curr.left);
            }
            if(arr[index++].equals("#")) {
                curr.right = null;
            } else {
                curr.right = new TreeNode(Integer.valueOf(arr[index-1]));
                queue.offer(curr.right);
            }
        }
        return root;
    }
}
