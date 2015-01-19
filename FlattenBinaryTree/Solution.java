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

        if(root.left == null) {
            root.right = flattenHelper(root.right);
        } else {
            TreeNode left = flattenHelper(root.left);
            root.left = null;
            TreeNode leftEnd = left;

            while(leftEnd.right != null)
                leftEnd = leftEnd.right;

            leftEnd.right = flattenHelper(root.right);
            root.right = left;
        }

        return root;
    }
}
