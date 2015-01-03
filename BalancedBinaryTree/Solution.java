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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        int hleft = height(root.left);
        int hright = height(root.right);
        
        if(Math.abs(hleft - hright) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
