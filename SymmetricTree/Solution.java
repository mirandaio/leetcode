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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        if(root.left == null || root.right == null)
            return false;

        TreeNode tmp = root.left.right;
        root.left.right = root.right.right;
        root.right.right = tmp;

        return root.left.val == root.right.val && 
            isSymmetric(root.left) && isSymmetric(root.right);
    }
}
