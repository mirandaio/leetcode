/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if(root == null)
            return null;

        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        root.left = null;
        root.right = left;
        TreeNode last = root;

        while(last.right != null)
            last = last.right;

        last.right = right;
        return root;
    }
}
